package cn.lesion.hello.spider

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-9-1 .
  */

import scala.collection.mutable
import scala.io.Source

object Main {
  def main(args: Array[String]) {

    new Spider("https://www.baidu.com")

  }

  class Spider(url:String){
    val queue = new mutable.Queue[String]()
    var depth = 0

    queue.enqueue(url)
    while (queue.nonEmpty) {

      val urlStr = queue.dequeue()
      val result = Source.fromURL(urlStr)
      val lines = result.getLines()

      //判断标签
      val regex = """<title>(.*?)</title>""".r
      var string = ""
      for (s <- lines) {
        string += s
        string += "\r\n"
      }

      val finalArray = regex.findAllIn(string)
      for (m <- finalArray)
        println(m)
    }
  }

}

