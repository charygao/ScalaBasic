package cn.lesion.hello.Training

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-20.
  */
object ScalaFor {

  def one(): Unit = {

    for (i <- 1 to 10; j <- 1 to 10
         if i != j) {
      println(100 * i * j)
    }

  }

  def two(): Unit = {
    for (i <- 1 to 40) {
      if (i >= 10)
        if (i % 2 != 2)
          if (i <= 20)
            println(i)
    }
  }

  //99乘法表
  def makeTable() = {
    val table = for (row <- 1 to 9) yield {
      for (col <- 1 until 10) yield {
        val line = (row * col).toString
        val spaces = " " * (4 - line.length)
        (line + spaces).mkString
      }
    }
    table.mkString("\n")
  }



  def main(args: Array[String]) {
    println(makeTable())
  }

}
