package datagenerator.model.Attribute

import org.apache.spark.sql.types.{DoubleType, StructField}

class DoubleAttribute(val name: String, min: Double, max: Double) extends Attribute with Serializable {

  type DataType = Double

  def schema: StructField = StructField(name, DoubleType)

  def transform(input: Double): DataType = {
    val diff = max - min
    min + (input * diff)
  }

}
