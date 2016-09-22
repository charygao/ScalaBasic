package cn.lesion.hello.operatString.SimpleCode

import scala.util.matching.Regex

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-7-16 .
  */
object RegexTest {

  val address = "123 Spider Street Suite 101"
  val noAddress = "No Address in this String"

  def main(args: Array[String]) {
    val numPatten = new Regex("[0-9]+")

    //查找第一位
    val match1 = numPatten.findFirstIn(address)
    val match2 = numPatten.findFirstIn(noAddress)
    println("查找address第一位 : " + match1)
    println("查找noAddress第一位 : " + match2)
    //Option[String] = Some(123)
    //处理Option：
    """
      |Option相当于一个容器，一个包含了 0 或者 一个值 的容器
      |在findFirstIn中，如果成功，字符串”123“以 Some（123）作为返回值，就像示例中所给出的。
      |如果没有匹配到，则会返回一个 None 。
      |
      |一个Option[String]类型的方法 返回结果：
      |    1、Some[String]。
      |    2、None
      |使用Option有如下场景：
      |    1、在值上地啊用getOrElse。
      |    2、在匹配表达式中使用Option
      |    3、在foreach循环中使用Option
    """.stripMargin

    //查找所有
    val matchs = numPatten.findAllIn(address)
    matchs.foreach{e =>
      println(s"查找所有：found some matchs:$e")
    }
  }

}
