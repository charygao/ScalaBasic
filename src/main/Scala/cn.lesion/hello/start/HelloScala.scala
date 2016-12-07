package cn.lesion.hello.start

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-18.
  */
object HelloScala {

  def main(args: Array[String]) {
//    factorial(4)
    readTest("abc")
  }

  """
    |阶乘
  """.stripMargin
  def factorial(n: Int): Unit = {
    println(1 to n reduceLeft(_*_))
  }

  def fac(n: Int): Int = {
    if (n<1)
      1
    else
      n*fac(n-1)
  }

  """
    |斐波那契数列
  """.stripMargin
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }


  def readTest(input: String): String = {

    val name = readLine("your name is ")
    name
  }

}
