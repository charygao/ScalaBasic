package cn.lesion.hello.start

import scala.beans.BeanProperty
import scala.tools.nsc.doc.model.Public


/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/6.
  */
object beansTest {
  def main(args: Array[String]): Unit = {
    var d = new dog
    println(d.age)
    d.age=10
    d.name="abc"
    println(d.age)
    println(d.name)
  }

}

class dog(){

  //注解：BeanProperty 生成 JavaBeans 的 getter和setter方法
  @BeanProperty
  var name: String = _

  @BeanProperty
  var age: Int = _

}

