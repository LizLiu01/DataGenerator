package datagenerator.model.Hierarchy

import org.apache.commons.lang.RandomStringUtils
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row}
import datagenerator.misc.SparkUtil._

case class HierarchyLevel(name: String, depth: Int, textSize: Int){

  /**
    * Hierarchy levels are converted to dataframes before being cross-joined
    * @return
    */

  def toDataFrame: DataFrame = {
    val rows = (1 to depth).map(Row(_, RandomStringUtils.randomAlphanumeric(textSize)))

    val rowRdd = spark.sparkContext.parallelize(rows)

    val schema = StructType(Array(StructField(s"{$name}Id", IntegerType), StructField(name, StringType)))

    spark.createDataFrame(rowRdd, schema)
  }
}
