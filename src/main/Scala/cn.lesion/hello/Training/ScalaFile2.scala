package cn.lesion.hello.Training

import scala.io.Source

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-19.
  */
object ScalaFile2 {

  def main(args: Array[String]) {

    //    val file = Source.fromFile("/home/lele/Programs/Hexo/_config.yml")
    val file = Source.fromURL("http://spark.apache.org")

    for (line <- file.getLines()) {
      println(line)
    }

  }


}
