package datagenerator.model.Dimension

import datagenerator.model.Attribute.{Attribute, AutoNumeric}
import org.apache.spark.mllib.random.RandomRDDs
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.sql.types._
import datagenerator.misc.SparkUtil._

class Dimension(name: String, numberOfRows: Long, numberOfPartitions: Int, val attributes: Attribute*) extends Serializable{

  /**
    * Function to convert dimension to dataframe
    * @return
    */

  def toDataFrame: DataFrame = {
    val partNo = (numberOfRows / numberOfRows).toInt

    val seed = if (config.hasPath("datagenerator.seed")) config.getInt("datagenerator.seed") else 0

    val generationNumber = numberOfRows * attributes.size

    val randomNumbers = RandomRDDs.uniformRDD(spark.sparkContext, generationNumber, partNo, seed)

    val size = attributes.size

    val randomMatrix = randomNumbers.mapPartitions{case iter => iter.grouped(size)}

    val randomMatrixWithId: RDD[(Seq[Double], Long)] = randomMatrix.zipWithIndex

    val rowRdd = randomMatrixWithId.map{row =>
      val zippedRow = attributes.zip(row._1)
      Row(zippedRow.map{field =>
          field._1 match {
          case _:AutoNumeric => (row._2 + 1).asInstanceOf[field._1.DataType]
          case _ => field._1.transform(field._2)
        }
      }:_*)
    }

    val schema: StructType = StructType(attributes.map(_.schema).toArray)

    spark.createDataFrame(rowRdd, schema)
  }
}



