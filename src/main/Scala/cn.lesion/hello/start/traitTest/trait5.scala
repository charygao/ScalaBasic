package cn.lesion.hello.start.traitTest

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/14.
  */
trait trait5 {
  def log(msg: String){}
}

class Dog extends trait5{
  def run(): Unit ={
    log("xxx")
  }
}

trait trait5s extends trait5{
  override def log(msg: String): Unit = super.log(msg)
}

object start{
  def main(args: Array[String]): Unit = {
    val x = new Dog() with trait5s
    x.run()
  }
  val arr: Array[String] = Array("a","b","c").map(_ + "00")
}