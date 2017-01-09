package cn.lesion.hadoop

import java.io.FileNotFoundException

import org.apache.hadoop.conf._
import org.apache.hadoop.fs._

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-8-9 .
  */
object Scala4Hdfs {

  def status(fileSystem: FileSystem, path: String) = {
    println("list path:" + path)
    val fs = fileSystem.listStatus(new Path(path))
    val listPath = FileUtil.stat2Paths(fs)
    for (p <- listPath) {
      println(p)
    }
    println("----------------------------------------")
  }

  def delete(fileSystem: FileSystem, filePath:String): Unit = {

    println("delete path:" + filePath)

    try{
      fileSystem.delete(new Path(filePath), true)
    }catch{
      case ex:FileNotFoundException => println("HDFS中没有这个文件。" + ex)
      case ex:PathIOException => println("没有这个目录。" + ex)
//      case ex:NullPointerException => println("找不到。" + ex)
    }
  }

  def main(args: Array[String]) {
    val conf = new Configuration()

    //指定配置文件
    conf.addResource("Hadoop/core-site.xml")
    //添加配置
    //    conf.set("fs.defaultFS","hdfs://love:9000")

    println(conf) //Configuration: core-default.xml, core-site.xml
    val fileSystem = FileSystem.get(conf)
    status(fileSystem, "/")

//  delete(fileSystem,"/out.txt")

  }
}