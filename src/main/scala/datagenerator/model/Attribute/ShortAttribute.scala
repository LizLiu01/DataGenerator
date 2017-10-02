package datagenerator.model.Attribute

import org.apache.spark.sql.types.{ShortType, StructField}

class ShortAttribute(val name: String, min: Short, max: Short) extends Attribute with Serializable {

  type DataType = Short

  def schema: StructField = StructField(name, ShortType)

  def transform(input: Double): DataType = {
    val diff = max - min
    (min + scala.math.round(input * diff)).toShort
  }
}
