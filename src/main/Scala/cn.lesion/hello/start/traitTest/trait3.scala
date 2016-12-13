package cn.lesion.hello.start.traitTest

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/11.
  */
trait trait3 {
  val name = "tom"
  val age = 12
}

class person(){
  val goods = "mianbao"
  val goodNum = 10
}


trait trait4 extends person{
  val cluster = "jerry"
}

class res extends trait4() with trait3{

  override val goods: String = "niunai"
  override val goodNum: Int = 10
  override val name: String = "jerrt"
//  override val age: Int = _

}