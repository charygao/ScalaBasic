package cn.lesion.hello.start.traitTest

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/11.
  */
trait trait2 {
  val name = "tom"
  val age = 12
}

class dog extends trait2(){

  override
    val name = "jerry"
  override
    val age: Int = 11

}
