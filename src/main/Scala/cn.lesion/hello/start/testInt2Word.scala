package cn.lesion.hello.start

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/3.
  */
object testInt2Word {
  def main(args: Array[String]): Unit = {

//    testWord()

    yiledTest()
  }

  def yiledTest():Unit = {
    val list = for (i <- 1 to 5) yield i*2
    println(list)
    //Vector(2, 4, 6, 8, 10)

  }

  def testWord(): Unit ={
    val zi = scala.math.BigInt(scala.util.Random.nextInt).toString(36)
    println(zi)

    //util & to

    //包括3
    for (i <- 0 to 3) {
      println(i)
    }

    println("-----------")

    //不包括3
    for (i <- 0 until 3) {
      println(i)
    }
  }

}
