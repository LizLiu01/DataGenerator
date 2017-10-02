package datagenerator.model.Attribute

import org.apache.spark.sql.types.{LongType, StructField}

class LongAttribute(val name: String, min: Long, max: Long) extends Attribute with Serializable {

  type DataType = Long

  def schema: StructField = StructField(name, LongType)

  def transform(input:Double): DataType = {
    val diff = max - min
    scala.math.round(min + (input * diff))
  }

}