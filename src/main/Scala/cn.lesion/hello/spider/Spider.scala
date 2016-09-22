package cn.lesion.hello.spider

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-9-1 .
  */
import scala.collection.mutable
import scala.io.Source
import scala.util.matching.Regex.MatchIterator

object Spider {
  def main(args: Array[String]) {

    val spider = new Spider
    var url = "www.baidu.com"


    var page:Int = 0
      while (page <= 13){
        //      http://date.jobbole.com/page/2/
        page=page+1
        println("当前页数" + page)
        url = "http://date.jobbole.com/page/"+page+"/"
          spider.soa(url)

      }
  }

  class Spider() {
    def soa(url: String): Unit ={
      val queue = new mutable.Queue[String]()
      var depth = 0

      queue.enqueue(url)
      while (queue.nonEmpty) {

        val urlStr = queue.dequeue()
        val result = Source.fromURL(urlStr)
        val lines = result.getLines()

        //判断标签
        val regex =
        "http://date.jobbole.com/([0-9]*)/".r
        var string = ""
        for (s <- lines) {
          string += s
          string += "\r\n"
        }

        val finalArray = regex.findAllIn(string)
        val set = finalArray.toSet
        var jetSet:MatchIterator = finalArray
        for (m <- set){
          //        var set = Set[String] = Set()

          //        Set set = new Set[String]
          println(m)
        }
      }
    }
  }
}

