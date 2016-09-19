package cn.lesion.hello.operatString.SimpleCode

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-7-17 .
  */
object FormatString {
  def main(args: Array[String]) {
    val floatVal = 12.456
    val intVal = 2000
    val stringVal = "我是呵呵!"

    val fs = printf("浮点型变量为 " + "%f, 整型变量为 %d, 字符串为 " + " %s", floatVal, intVal, stringVal)
    println(fs)
  }
}