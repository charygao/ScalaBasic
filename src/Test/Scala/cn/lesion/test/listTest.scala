package cn.lesion.test

/**
  * Created by root on 16-9-28.
  */
object listTest {

  def main(args: Array[String]): Unit = {
    val list = List(0 to 10,5)
    println(list)
    println(list.toSet)
    list.foreach(println)
  }

}
