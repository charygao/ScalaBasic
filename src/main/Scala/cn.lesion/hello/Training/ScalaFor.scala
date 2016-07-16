package cn.lesion.hello.Training

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-20.
  */
object ScalaFor {

  def main(args: Array[String]) {

    for (i <- 1 to 10; j <- 1 to 10
      if i != j) {
      println(100*i*j)
    }

  }


}
