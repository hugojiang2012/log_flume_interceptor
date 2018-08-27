
name := "log_demo"

version := "1.0"

scalaVersion := "2.10.5"


libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.6.3"
libraryDependencies += "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.6.3"

//Spark SQL 依赖
libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.6.3"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.3"

//增加阿里巴巴fastjson依赖
libraryDependencies += "com.alibaba" % "fastjson" % "1.1.41"

//增加hive的依赖
libraryDependencies += "org.apache.spark" % "spark-hive_2.10" % "1.5.1"

//增加flume的依赖
libraryDependencies += "org.apache.spark" % "spark-streaming-flume_2.10" % "1.6.3"

        