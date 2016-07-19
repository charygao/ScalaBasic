package cn.lesion.spark.scala.mySpark

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-18.
  */

import org.apache.spark._

object SparkonePlueOne {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Pi").setMaster("local[*]")
    val spark = new SparkContext(conf)

    val count = 1+1

    println("1+1 = " +  count )
    spark.stop()

  }
}
