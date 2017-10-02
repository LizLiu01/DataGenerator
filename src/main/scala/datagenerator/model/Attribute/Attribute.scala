package datagenerator.model.Attribute

import org.apache.spark.sql.types._

/**
  * Every column in the final dataframe is represented as an attribute
  */

trait Attribute {
  type DataType

  val name: String

  def schema: StructField

  /**
    * Transforms a random number between 0 and 1 to a DataType
    * @param input
    * @return
    */

  def transform(input:Double): DataType
}

// Marker trait used to identify autonumeric attributes. Only works for Long attributes

trait AutoNumeric



