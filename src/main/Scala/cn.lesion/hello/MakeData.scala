package cn.lesion.hello

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-9-2 .
  */

import java.io.FileWriter

import scala.util.Random
import cn.lesion.util.Charactor

object MakeData {
  val dataTxt = "test/people.txt"

  """
    |num:产生的随机数个数
    |within：在某个数之内产生随机数
  """.stripMargin

  def randomInt(within: Int): String = {


    val numbers = new Random()
    val int = numbers.nextInt(within)

    int.toString
  }

  def main(args: Array[String]) {

    for (i <- 1 to 1000000) {
      println(Charactor.createChinese() + "    " +randomInt(100))

      val out = new FileWriter("./out.txt", true)

      out.write(Charactor.createChinese() + "    " +randomInt(100) + "\n")

      out.close()

    }

  }
}
