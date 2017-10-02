package datagenerator.model.Hierarchy

import org.apache.spark.sql.{DataFrame, SparkSession}
import datagenerator.misc.DataFrameUtil._

/**
  * Class for generating hierarchical columns as dataframes
  * @param levels defines the hierarchical levels of the dataframe111
  * @return
  */

class Hierarchy(levels: HierarchyLevel*) {

  def toDataFrame: DataFrame = {
    val dataFrames = levels.map(_.toDataFrame)

    // For cross joins to work on dataframes, spark.sql.crossJoin.enabled = "true"
    val crossJoinedDataFrames = dataFrames.tail.foldLeft(dataFrames.head)((df1, df2) => df1 join df2)

    dfZipWithIndex(crossJoinedDataFrames)
  }

}