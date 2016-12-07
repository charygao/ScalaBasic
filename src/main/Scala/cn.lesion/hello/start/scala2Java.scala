package cn.lesion.hello.start

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/6.
  */

import scala.collection.JavaConversions._
import scala.collection.mutable._

object scala2Java {

  def main(args: Array[String]): Unit = {

    val command = ArrayBuffer("ls","/Library/")
    val processBuilder = new ProcessBuilder(command)
    processBuilder.start()


  }


}
