package cn.lesion.spark.scala.sparkSql

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-9-2 .
  */

import org.apache.spark.sql.Row
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.types.{StringType, StructField, StructType}



object SparkSql {
  def main(args : Array[String]) : Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("sql")
    val sc = new SparkContext(conf)

    val hive = new HiveContext(sc)


    val rddPeople = sc.textFile("hdfs://love:9000/Data/test/out.txt")

    val schemaString = "name age"
    val schema = StructType(schemaString.split(" ").map(fieldName => StructField(fieldName, StringType, nullable = true)))

    //数据分割符
    val rowRDD = rddPeople.map(_.split("    ")).map(p => Row(p(0), p(1)))
    val people = hive.createDataFrame(rowRDD, schema)

    people.registerTempTable("People")

//    val peopleNames = hive.sql("SELECT name FROM People")
//    peopleNames.map(t => "Name: " + t(0)).collect().foreach(println)

    val peoplemsg = hive.sql("select count(*) from People where age = 99")

    peoplemsg.collect().foreach(println)

    sc.stop()

  }
}
