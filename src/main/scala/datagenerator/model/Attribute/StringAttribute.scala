package datagenerator.model.Attribute

import org.apache.commons.lang.RandomStringUtils
import org.apache.spark.sql.types.{StringType, StructField}


class StringAttribute(val name: String, textSize: Int) extends Attribute with Serializable {

  type DataType = String

  def schema: StructField = StructField(name, StringType)

  def transform(input:Double): DataType = RandomStringUtils.randomAlphanumeric(textSize)

}