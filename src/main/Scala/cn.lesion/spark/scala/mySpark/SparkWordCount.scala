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
    //将数据缓存到内存（数据量大的时候，内存不足会造成内存溢出）
    val file = spark.textFile("hdfs://love:9000/Data/test/webrank.txt").cache()
    //执行过滤。
//      .filter(_.contains("AUDJPY"))

    //统计所有单词
    println("Result =  " + file.count)

    spark.stop()
  }
}

