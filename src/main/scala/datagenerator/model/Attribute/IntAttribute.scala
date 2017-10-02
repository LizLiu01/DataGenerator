package datagenerator.model.Attribute

import org.apache.spark.sql.types.{IntegerType, StructField}

class IntAttribute(val name: String, min: Int, max: Int) extends Attribute with Serializable {

  type DataType = Int

  def schema: StructField = StructField(name, IntegerType)

  def transform(input:Double): DataType = {
    val diff = max - min
    min + scala.math.round(input * diff).toInt
  }

}
