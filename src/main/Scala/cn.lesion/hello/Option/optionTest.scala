package cn.lesion.hello.Option

import junit.framework.TestCase
import org.junit.Test
import org.scalatest.Suite


/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-9-1 .
  */
class optionTest extends TestCase{

  val capitals = Map("france" -> "paris", "japan" -> "tokyo")

  def test1() {
    val a = capitals get "france"
    val b = capitals get "a"
    println(a)
    println(b)
  }



}
