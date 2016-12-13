package cn.lesion.hello.start.processTest

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/10.
  */

import sys.process._

object sh {

  def main(args: Array[String]): Unit = {
    "ls -l /" #| "ls" !

  }



}
