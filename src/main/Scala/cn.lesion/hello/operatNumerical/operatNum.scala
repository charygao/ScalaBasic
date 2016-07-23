package cn.lesion.hello.operatNumerical

import org.joda.time.DateTime

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-7-17 .
  *
  * 说明：
  * Scala所有的数值都是对象，包括Byte、Char、Double、Float、Int、Long和Short
  *
  *
  */


object operatNum extends App {

  override def main(args: Array[String]): Unit = {

    """
      |获取内建数值类型的数值范围
    """.stripMargin

    println("Short类型最小值为：" + Short.MinValue + "; 最大值为" + Short.MaxValue)
    println("Int类型最小值为：" + Int.MinValue + "; 最大值为" + Int.MaxValue)
    println("Float类型最小值为：" + Float.MinValue + "; 最大值为" + Float.MaxValue)

    """
      |数值型类库
      |数学运算能力比较强的类库：Spire，ScalaLab
      |
      |日期类型：
      |Java：Joda Time。nscala-time对 JodaTime进行封装
      |
    """.stripMargin

    println(DateTime.now())


    """
      |问题：把一个字符串转换成Scala的数值类型
      |决绝办法：使用String的 " to× " 方法
      |
      |如果类型不符合，则有可能会抛出 NumberFormatExcepetion异常
    """.stripMargin

    val charStr = "100"

    println("Int:" + charStr.toInt)
    println("Long:" + charStr.toLong)
    println("Short" + charStr.toShort)
    println("Float:" + charStr.toFloat)
    println("Double:" + charStr.toDouble)
    println("Byte:" + charStr.toByte)
  }

}
