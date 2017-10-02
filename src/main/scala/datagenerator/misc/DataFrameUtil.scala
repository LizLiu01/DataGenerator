package datagenerator.misc

import org.apache.spark.sql._
import org.apache.spark.sql.types.{LongType, StructField, StructType}


object DataFrameUtil {

  /**
    * Zip function for dataframes
    * @param df dataframe
    * @param offset offset from start or end column
    * @param colName column name
    * @param inFront should the column be offset from the first or the last column
    * @return
    */

  def dfZipWithIndex(df: DataFrame, offset: Int = 1, colName: String = "Id", inFront: Boolean = true) : DataFrame = {

    val rddRows = df.rdd.zipWithIndex.map(ln =>
      Row.fromSeq(
        (if (inFront) Seq(ln._2 + offset) else Seq())
          ++ ln._1.toSeq ++
          (if (inFront) Seq() else Seq(ln._2 + offset))
      )
    )

    val schema = StructType(
      (if (inFront) Array(StructField(colName,LongType,false)) else Array[StructField]())
        ++ df.schema.fields ++
        (if (inFront) Array[StructField]() else Array(StructField(colName, LongType, false)))
    )

    df.sparkSession.createDataFrame(rddRows, schema)
  }
}
