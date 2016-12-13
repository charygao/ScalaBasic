package cn.lesion.hello.start.traitTest

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/10.
  */
trait trait1 {

  val name = "tom"
  val age = 12

}


class cat() extends trait1 {

  def run (): Unit ={
    println(name + age)
  }

}

object startTest{
  def main(args: Array[String]): Unit = {
    var d = new cat
    d.run()
  }
}