package example.retail

import datagenerator.model.Attribute._
import datagenerator.model.Dimension.Dimension
import datagenerator.misc.SparkUtil._

class Fact {
  def main(args: Array[String]) {
    val numberOfRows = 100000000
    val numberOfPartitions = 1000

    val dim = new Dimension("fact", numberOfRows, numberOfPartitions,
      new IntAttribute("transactionId", 1, 1000000),
      new IntAttribute("productId", 1, 50000),
      new IntAttribute("storeId", 1, 500),
      new IntAttribute("customerId", 1, 500000),
      new DoubleAttribute("quantity", 0.5, 50.0)
    )

    val df = dim.toDataFrame

    df.write.format("parquet").save(config.getString("example.retail.fact"))
  }
}