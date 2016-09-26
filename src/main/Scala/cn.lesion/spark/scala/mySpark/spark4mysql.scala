package cn.lesion.spark.scala.mySpark

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

/**
  * Created by root on 16-9-23.
  */
object spark4mysql {

  def main(args: Array[String]): Unit = {
/*

    val hiveContext = new HiveContext()

    val url="jdbc:mysql://192.168.1.9:3306/taob"
    val prop = new java.util.Properties
    prop.setProperty("user","root")
    prop.setProperty("password","root")
    val cnFlight = sqlContext.read.jdbc(url,"taobuser_bao",Array("country_code='CN'"),prop)
    val emaillist = cnFlight.groupBy("user")
    val sorted = emaillist.count().orderBy(desc("count"))
    sorted.show(10)
    sorter.write.jdbc(url,"abc".prop)
    val sc: SparkContext
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

*/

    val conf = new SparkConf().setAppName("Spark MYSQL").setMaster("local[*]")
    val spark = new SparkContext(conf)
    val sqlContext=new SQLContext(spark)
    val hiveContext=new HiveContext(spark)
    val url="jdbc:mysql://192.168.1.9:3306/taob"
    val prop = new java.util.Properties
    prop.setProperty("user","root")
    prop.setProperty("password","root")

    val cnFlight = sqlContext.read.jdbc(url,"taobuser_bao",prop)
//    val emaillist = cnFlight.groupBy("user").count().show()
    val emaillist = cnFlight.count()
    //取前十条
    cnFlight.select("id","user").head(10).foreach(println)

    println(emaillist)
//    val emaillist = cnFlight.select("user").where("id=10086")
//    val sorted = emaillist.count().orderBy(desc("count"))
//    val sorted = emaillist.count()
//    cnFlight.show(10)

  }

}
