package cn.lesion.hello.start

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-18.
  */
object HelloScala {

  def main(args: Array[String]) {
    factorial(4)
  }

  """
    |阶乘
  """.stripMargin
  def factorial(n: Int): Unit = {
    println(1 to n reduceLeft(_*_))
  }

  """
    |斐波那契数列
  """.stripMargin
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }


}
