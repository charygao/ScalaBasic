package cn.lesion.spark.scala.mySpark

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-18.
  */

import org.apache.spark._

object SparkWordCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark WordCount").setMaster("local[*]")
    val spark = new SparkContext(conf)

    //读取HDFS文件并检测单词 “AUDJPY”
    val file = spark.textFile("hdfs://love:9000/Data/test/AUDJPY.txt").filter(_.contains("AUDJPY"))

    //对单词进行计数
    println("Result =  " + file.count)

    spark.stop()
  }
}

