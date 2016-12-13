package cn.lesion.hello.start.traitTest

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/11.
  */
trait logger {
  val name = "tom"
  val age = 12
}

trait mylog extends logger{
  this:Exception =>
    def log(): Unit ={
      println("abc")
    }
  def log2(): Unit ={
    println("abc")
  }
}
