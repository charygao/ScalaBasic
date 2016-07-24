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

//    println("Int:" + charStr.toInt)
    println("Long:" + charStr.toLong)
    println("Short" + charStr.toShort)
    println("Float:" + charStr.toFloat)
    println("Double:" + charStr.toDouble)
    println("Byte:" + charStr.toByte)


    """
      |scala 中的 toInt 不支持传入进制，为了解决这个问题，可以使用java.lang.Integer 类中的 parseInt方法
    """.stripMargin

    println(Integer.parseInt("2",10))
    println(Integer.parseInt("8",10))
    println(Integer.parseInt("10",10))
    println(Integer.parseInt("16",10))
/*

    //如果喜欢隐式转换，可以创建隐式转换类来解决这个问题
    implicit class String2Int(str: String){
      def toInt(radix :Int) = Integer.parseInt(str, radix)
    }

    println(String2Int(charStr).toString)

*/

    //
    """
      |java代码调用这个方法时，这个注解式异常是必须的。
      |但是在Scala中，通常使用Option/Some/None来解决问题。
    """.stripMargin
//    @throws(classOf[NumberFormatException])
//    def toInt(s: String) = s.toInt

    def toInt(strAbc: String): Option[Int] ={
      try{
        Some(strAbc.toInt)
      }catch {
        case e: NumberFormatException => None
      }
    }

    //根据需要通过多种方式调用toInt方法，其中一种就是通过getOrElse：
    println(toInt("1").getOrElse(0)) //1
    println(toInt("2").getOrElse(0)) //0

    println(toInt(charStr).getOrElse())





  }

}
