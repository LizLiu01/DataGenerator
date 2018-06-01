# DataGenerator

Data generator for performance testing. It can generate different types of data warehouse topologies that can be used to
test Spark SQL applications.

## Example

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

        df.write.format("parquet").save("s3://bucket/retail/fact.parquet")

Then create the assembly

    sbt assembly

Upload to cluster and run using spark-submit
# Development of feature 1 don 
