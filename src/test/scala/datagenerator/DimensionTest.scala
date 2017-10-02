package datagenerator

import datagenerator.model.Attribute._
import datagenerator.model.Dimension.Dimension
import org.scalatest.{FlatSpec, GivenWhenThen}

class DimensionTest extends FlatSpec with GivenWhenThen {

  "A generated dimension with four attributes" should "return ten rows" in {

    Given("the parameters numberOfRows 10 and numberOfPartitions 1")
    val numberOfRows = 10
    val numberOfPartitions = 1

    When("getting converting the dimension to dataframe")
    val dim = new Dimension("dimensionTest", numberOfRows, numberOfPartitions,
      new LongAttribute("attribute1", 1L, 1000000L) with AutoNumeric,
      new IntAttribute("attribute2", 1, 1000),
      new StringAttribute("attribute3", 10),
      new DoubleAttribute("attribute4", 0.5, 100.0)
    )

    val df = dim.toDataFrame

    Then("ensure that 10 rows are counted")
    assert(df.count === 10)

    And("the dataframe contains four columns")
    val columns = df.columns
    assert(columns.length === 4)

    And("the dataframe has only one partition")
    val numPartitions = df.rdd.partitions.length
    assert(numPartitions === 1)
  }



}
