package cn.lesion.spark.scala.mySpark

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-18.
  */

import org.apache.spark._

object SparkCache {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Test").setMaster("local[*]")
    val spark = new SparkContext(conf)

    val file = spark.textFile("hdfs://love:9000/Data/sourceData/sogouNews_mini.dat")

    //缓存RDD到内存中，可在 127.0.0.1:4040 中看到缓存的任务。
    //file.cache后，并不会马上进行缓存。Action操作触发之后再回执行cache
    file.cache()

    val lists:List[String] = ()


    //释放缓存
//    file.unpersist()

    println("Result:" + file.count())


  }
}

