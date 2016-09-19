package cn.lesion.hello.operatString.SimpleCode

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-7-17 .
  * 字符串连接
  */
object ConcatString {

  val str1 = "gmle."
  val str2 = "github.io"

  def main(args: Array[String]) {
    print("方法1：" + str1.concat(str2))
    println("方法2：" + str1+str2)
  }

}
