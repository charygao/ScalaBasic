package cn.lesion.hello.start

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/1.
  */
object multipleTest {


  """
    |最大公倍数
  """.stripMargin
  def gcdLoop (x: Long, y:Long) : Long ={
    var a=x
    var b=y
    while( a!=0) {
      val temp = a
      a=b % a
      b = temp
    }
    b
  }

  """
    |do-while循环
  """.stripMargin
  var line=""
  do {
    line = readLine()
    println("Read: " + line)
  } while (line !="")


  def multiTable1(): Unit = {
    for(row <- 1 to 9 ; col <- 1 to row){
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length())
      print(col + "*" + row + "=" + prod + padding)
      if(row == col) println()
    }
  }

  def multiTable2(): Unit = {
     (
       for (
          i <- 1 to 9;
          j <- 1 to i;
          ss = s"$j*$i=${i * j}\t"
        ) yield {
          if (j == i) s"$ss\n" else ss
        }
     ).foreach(print)
  }

  def main(args: Array[String]): Unit = {
    multiTable2()
  }

}
