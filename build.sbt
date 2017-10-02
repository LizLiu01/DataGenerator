
name := "DataGenerator"

version := "1.0"

scalaVersion := "2.11.7"


libraryDependencies += "org.apache.spark" %% "spark-core"  % "2.0.0" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql"  % "2.0.0" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-mllib"  % "2.0.0" % "provided"
libraryDependencies += "com.databricks" %% "spark-csv" % "1.5.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"
libraryDependencies += "joda-time" % "joda-time"  % "2.9.4"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"

