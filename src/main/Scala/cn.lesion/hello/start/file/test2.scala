package cn.lesion.hello.start.file

import java.io.File

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/10.
  */


object test2{
  def main(args: Array[String]): Unit = {

    val files = new File("/Library/")

    for (file <- files.listFiles()) println(file)
  }
}