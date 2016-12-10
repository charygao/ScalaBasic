package cn.lesion.hello.start

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/8.
  */

class Person(val name:String){

}
class anonymous(codeName:String,age:Int) extends Person(codeName){

  override
    val name:String = "xxx"

  def meet(p:Person{def greeting:String}): Unit ={
    println("p.greeting")
  }
}

object test{
  def main(args: Array[String]): Unit = {
//    println(new anonymous.meet("tom",12))
    val x = new anonymous("tom",12)
    x.meet(new Person("tom"){
      def greeting:String="hello"
    })
  }
}