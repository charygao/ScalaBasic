package cn.lesion.spark.scala.mySpark

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-18.
  */

import org.apache.spark._

object SparkTest {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Test").setMaster("local[*]")
    val spark = new SparkContext(conf)

    //读取HDFS文件
    val file = spark.textFile("hdfs://love:9000/Data/test/webrank.txt")

    //读取本地序列并转化为RDD
    val text = spark.parallelize(Seq("a" , "b" , "c" , "d"))

    //RDD转换并过滤
    val filterRDD = file.filter(_.contains("2"))

    val wordNum = file.map(line => line.split(",").size).collect()
    println(wordNum)

    //取第一行的一个元素
//    val test = file.first()
    //查看数据的样例
    val test = file.take(5)
    println(test)

    val fileter = file.filter(_.contains("10"))
    println(fileter)


    //文件的行数
    println("Result =  " + file.count)

    spark.stop()
  }
}

