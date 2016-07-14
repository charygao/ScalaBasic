package github.gmle.hello

import scala.io.StdIn
import scala.util.control.Breaks

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-18.
  */
object ScalaArgs {

  def main(args: Array[String]) {

/*
    for (arg <- args){
      println(arg)
    }
*/

    doWhile()

  }

  def doWhile(){
   var line = ""
  	  do {
  		  line = readLine("请输入...\n")

        if (line.equals("0")){
          Breaks.break()
        }



  		  println("Read: " + line)
  	  }
      while (line != "")
  }
}
