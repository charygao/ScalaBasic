package cn.lesion.hello.Training

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-20.
  */
object ScalaDef {

  def main(args: Array[String]) {

    def add1(x: Int) = x + 100
    val add2 = (y: Int) => y + 200

    println(add1(10))
    println(add2(10))


  }

}
