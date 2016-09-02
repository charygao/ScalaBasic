package cn.lesion.spark.scala.sparkSql

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-9-2 .
  */
object sqlTest {
  val conf = new SparkConf().setAppName("Spark Pi").setMaster("local[*]")
  val spark = new SparkContext(conf)
  val sqlContext = new org.apache.spark.sql.SQLContext(spark)


}
