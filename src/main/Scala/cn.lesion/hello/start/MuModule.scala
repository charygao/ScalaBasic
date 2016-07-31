package cn.lesion.hello.start

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-7-31 .
  *
  * Scala语言介绍。
  */

//一行注释
/*另一行注释*/
/**文档说明*/
object MuModule { // 生命一个单例对象，即同时声明一个类和它的唯一实例。
  def abs(n: Int): Int =  //abs方法接收一个integer并返回一个integer。
    if (n < 0) -n     //如果n小于0 返回 -n
    else n

  private def formatAbs(x: Int) = { // 一个私有方法只能被MyMould里的其他成员调用。
    val msg = "The abs value of %d is %d" //字符串里有两个占位符， %d代表数字。
    msg.format(x,abs(x)) //在字符串里将2个占位符分别替换为x和abs(x)。
  }

  def main(args: Array[String]) { //Unit类似于Java或C语言里的void。
    println(formatAbs(-42))
  }

}
