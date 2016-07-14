package cn.lesion.hello

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-18.
  */
object HelloScala {

  def main(args: Array[String]) {

    val max = sum_of_square(1, 2)

    print(max)

  }

  def isMax1(x: Int, y: Int): Unit = {
    if (x < y) {
      print(y)
    } else {
      print(x)
    }
  }

  def isMax2(a: Int, b: Int): Unit = {
    if (a > b)
      print(a)
    else
      print(b)
  }

  def sum_of_square(x: Int, y: Int): Int = {
    def square(x: Int) =
      x * x
    square(x) + square(y)
  }


}
