package cn.lesion.hello

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-9-2 .
  */

import java.io.FileWriter
import java.util.Date

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

    for (i <- 1 to 10000000) {
//      println(randomInt(10) + "," + randomInt(100) + "," + randomInt(1000) + "," + Charactor.createChinese1() + "," + Charactor.createChinese2()+ "," + Charactor.createChinese3()+ "," + Charactor.createChinese4() + "," +new Date  + "\n")

      val out = new FileWriter("./out.txt", true)

//      out.write(Charactor.createChinese() + "," +randomInt(100) + "\n")
      out.write(randomInt(10) + "," + randomInt(100) + "," + randomInt(1000) + "," + Charactor.createChinese1() + "," + Charactor.createChinese2()+ "," + Charactor.createChinese3()+ "," + Charactor.createChinese4() + "," +new Date  + "\n")

      out.close()

    }

  }
}
