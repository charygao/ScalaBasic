package cn.lesion.hello.start.variableLengthArgs

import scala.collection.immutable.Range.Inclusive
import scala.runtime.Nothing$

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/5.
  */
object VariableArgument4Scala {

  def ArgumentsInfo( args:String* ): Unit = {
    var i : Int = 0
    for( arg <- args ){
      println("Arg value[" + i + "] = " + arg )
      i = i + 1
    }
  }

  def main(args: Array[String]) {
    ArgumentsInfo("Hello", "Scala", "Python")
  }

}
