package cn.lesion.hello.operatString.SimpleCode

import scala.collection.mutable

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-7-17 .
  */
object EditableString {

  /**
    * 创建可修改的字符串
    * @param args
    */
  def main(args: Array[String]) {

    val str = new mutable.StringBuilder

    str += 'a'
    str ++= " banana"
    println()

    println("str is : " + str.toString)

  }

}
