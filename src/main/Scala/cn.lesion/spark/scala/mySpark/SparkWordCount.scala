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

    //获取当前项目根目录
    val filePath=System.getProperty("user.dir")

    print(filePath)

    //将数据缓存到内存（数据量大的时候，内存不足会造成内存溢出）
    val file = spark.textFile("hdfs://love:9000/Data/test/webrank.txt").cache()
    //执行过滤。
//      .filter(_.contains("AUDJPY"))

    //存储到本地之前先删除目录下的结果
    //将结果存储到本地
    file.saveAsTextFile(filePath + "/Test/WordCount")

    file.flatMap(line => line.split(" ")) //分割
      .map(data => (data,1))              //统计value为1的单词（映射为key-value对）
      .reduceByKey(_+_)                   //对同一个a第n次的数据进行聚集，统计单词个数
//      .foreach(println)                   //输出。

    //统计所有单词个数
    println("Result =  " + file.count)

    spark.stop()
  }
}