package github.gmle.hello

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-19.
  */
object ScalaArray {

  def main(args: Array[String]) {

    //val arrNums: Array[Int] = Array(1, 2, 3, 4, 5)
    val arrNums = Array(1, 2, 3, 4, 5)

    //val arrStrs: Array[String] = Array("a", "b", "c", "d", "e")
    val arrStrs = Array("a", "b", "c", "d", "e")

    for (arrNum <- arrNums) {
      println(arrNum)
    }




  }

}
