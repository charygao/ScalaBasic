package cn.lesion.spark.scala.mySpark

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-18.
  */

import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.hive.HiveContext


/** Computes an approximation to pi */
object SparkSql {
  case class aujp(title:String,date:String,time:String,open:String,high:Int)
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Pi").setMaster("local[*]")
    val spark = new SparkContext(conf)
    val sqlContext=new SQLContext(spark)
    val hiveContext=new HiveContext(spark)
    val rddaujp = spark.textFile("hdfs://love:9000/Data/test/AUDJPY.WordCount").map(_.split(",")).map(au => aujp(au(0),au(1),au(2),au(3),au(4).trim.toInt))

//    val peopleSchema = sqlContext.createSchemaRDD(rddaujp)

    val aujpScemo = sqlContext.cacheTable("aujp")

//    aujpScemo.registerTempTable("aujp")
    hiveContext.table("aujp")

    hiveContext.sql("SELECT * FROM aujp WHERE age = 20010102").map(t => "TICKER: " + t(0)).collect().foreach(println)

    spark.stop()
  }
}

// scalastyle:on println
