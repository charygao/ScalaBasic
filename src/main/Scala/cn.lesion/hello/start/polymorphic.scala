package cn.lesion.hello.start

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016-12-01.
  */
object polymorphic {

  def findFirst [A](as: Array[A],p: A => Boolean): Int = {

    def loop(n: Int): Int =
      if (n >= as.length)
        -1
      else if (p(as(n)))
        n
      else
        loop(n + 1)
    loop(0)
  }
}
