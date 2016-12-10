package cn.lesion.hello.start.file

import scala.io.{BufferedSource, Source}

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/9.
  */
class test1 {

  val file: BufferedSource = Source.fromFile("/Users/lele/Documents/Codes/Idear-Codes/ScalaBasic/src/main/resources/log/log1.log","utf-8")
  //如果对file进行迭代，会变成字符迭代

  //生成一个迭代器
  val lines: Iterator[String] = file.getLines()

  //将文件读取为一个字符串
  val str = file.mkString

  val arr: Array[String] = lines.toArray

  def getTest(): Unit =for (line <- arr) {
    println(line)

    println(lines)
  }

}


object test{

  /**
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {

    val a = new test1
//    println(a.getTest())
    a.getTest()
  }
}