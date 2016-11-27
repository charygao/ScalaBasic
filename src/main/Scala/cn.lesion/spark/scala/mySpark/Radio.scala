package cn.lesion.spark.scala.mySpark

import org.apache.spark._

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-18.
  *
  * 广播变量和累加器
  */


object Radio {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Radio BroadCast").setMaster("local[*]")
    val spark = new SparkContext(conf)

    val broadcastAlist = spark.broadcast("a","b","c","d","e")
    spark.parallelize(List("1","2","3","4","5")).map(x => broadcastAlist.value + x).collect()

    spark.stop()

  }
}