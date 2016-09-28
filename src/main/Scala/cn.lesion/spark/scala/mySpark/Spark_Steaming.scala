package cn.lesion.spark.scala.mySpark

/**
  * Created by root on 16-9-27.
  */


import org.apache.spark._
import org.apache.spark.streaming._

object Spark_Steaming {

  def main(args: Array[String]): Unit = {
    val spark = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")

    //创建 StreamContext 对象需要两个参数:
    //一个是 SparkConf 对象，一个是分块间隔时间。
    val ssc = new StreamingContext(spark, Seconds(2))
    val lines = ssc.socketTextStream("localhost", 9999)

    //数据分隔符
    val words = lines.flatMap(_.split(" "))

    val pairs = words.map(word => (word, 1))

    val wordCounts = pairs.reduceByKey(_ + _)

    wordCounts.print()

  }

}
