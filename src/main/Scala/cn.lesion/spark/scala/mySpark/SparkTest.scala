package cn.lesion.spark.scala.mySpark

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-18.
  */

import java.nio.file.Paths

import org.apache.spark._

object SparkTest {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Test").setMaster("local[*]")
    val spark = new SparkContext(conf)

    //读取HDFS文件并进行分片。
    val file = spark.textFile("hdfs://love:9000/data/sogou/freq/SogouLabDic.dic",10)

    //读取目录里的小文件并返回（文件名，内容）键值对。
    val files = spark.wholeTextFiles("hdfs://love:9000/data/test/")

    //读取本地序列并转化为RDD
    val text1 = spark.parallelize(Seq("a" , "b" , "c" , "d"))
    val text2 = spark.parallelize(List("a" , "b" , "c" , "d"))
    val text3 = spark.parallelize(Array("a" , "b" , "c" , "d"))
    //分片为3
    val text4 = spark.parallelize(List(1 to 10),3)

    //查询RDD的依赖关系
    println("debug:::" + text4.toDebugString) //MapPartitionsRDD[10] at filter at SparkTest.scala:43

    //RDD转换并过滤包含2的
    val filterRDD = file.filter(_.contains("2"))

    val wordNum = file.map(line => line.split(",").length).collect()
    println(wordNum)

    //取第一行的一个元素
    val test = file.first()

    //查看数据的样例
//    val test = file.take(5)




    println(test.getBytes("gbk"))


    val fileter = file.filter(_.contains("10"))
    println(fileter)

    //文件的行数
    println("Result =  " + file.count)

    spark.stop()
  }
}

