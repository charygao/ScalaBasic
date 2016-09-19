package cn.lesion.hello.Option


import junit.framework.TestCase


/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-9-1 .
  */
class optionTest extends TestCase{

  val capitals = Map(
    "france" -> "paris",
    "japan" -> "tokyo"
  )

  var a,b: Option[String] = None

  def test1() {

    try{
      a = capitals get "france"
      b = capitals get "a"
    }catch {
      case ex: NoSuchElementException => println("Missing file exception")
    }

    println(a)
    println(b)
  }



}
