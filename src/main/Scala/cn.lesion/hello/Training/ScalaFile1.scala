package cn.lesion.hello.Training

import java.io.File

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-19.
  */
object ScalaFile1 {

  def main(args: Array[String]) {

    try {
      val files = new File("/home/lele").listFiles()

      for (file <- files) {
        println(file)
      }
    } catch {
      case e : NullPointerException => print("找不到那个目录。\n错误信息："+ e.getMessage)
    }
  }


}
