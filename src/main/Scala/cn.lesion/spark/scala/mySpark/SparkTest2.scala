package cn.lesion.spark.scala.mySpark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 16-9-30.
  */
object SparkTest2 {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Spark Test").setMaster("local[*]")
    val spark = new SparkContext(conf)



    spark.stop()
  }

}
