package datagenerator.model.Attribute

import org.apache.spark.sql.types.{ByteType, StructField}

class ByteAttribute(val name: String, min: Byte, max: Byte) extends Attribute with Serializable {

  type DataType = Byte

  def schema: StructField = StructField(name, ByteType)

  def transform(input:Double): DataType = {
    val diff = max - min
    (min + scala.math.round(input * diff)).toByte
  }
}
