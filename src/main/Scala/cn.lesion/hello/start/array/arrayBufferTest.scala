package cn.lesion.hello.start.array

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/6.
  */

import scala.collection.mutable._

object arrayBufferTest {

  def main(args: Array[String]): Unit = {

    var arrayBuffer = ArrayBuffer[Int]()

    arrayBuffer += 1
    println(arrayBuffer)
    arrayBuffer += 2
    println(arrayBuffer)
    arrayBuffer += 3
    println(arrayBuffer)

    arrayBuffer += (4,5,6)
    println(arrayBuffer)

    //追加数组，需要两个++
    arrayBuffer ++= Array(7,8,9)
    println(arrayBuffer)

    //移除最后N个元素
    arrayBuffer.trimEnd(3)
    println(arrayBuffer)

    //插入单个索引值的元素，在第 0 位 插入  0
    arrayBuffer.insert(0,0)
    println(arrayBuffer)

    //插入多个值
    arrayBuffer.insert(0, -3,-2,-1)
    println(arrayBuffer)

    //追加
    arrayBuffer.append(1,2,3,4)
    println(arrayBuffer)

    //
    var counttest = arrayBuffer.count(_ < 0)
    println(counttest)

    //删除区间
    arrayBuffer.remove(0)
    println(arrayBuffer)
    arrayBuffer.remove(0,2)
    println(arrayBuffer)

    //将数组缓冲区变为数组
    var arr = arrayBuffer.toArray

    //将数组变为数组缓冲区
    var arrBuffer = arr.toBuffer

    //遍历数组
    for (i <- arr) print(i)

    //反向遍历
    for (i <- arr.reverse) print(i)

    //数组变换:不修改原始数组，产生新数组
    var newarr = for (i <- arr) yield i*2
    println(newarr)
    var a = arr.filter(_ % 2 == 0)
    println(a.toBuffer)
    var b = a.map(_*2)
    println(b.toBuffer)

    //常见算法
    println(a.max)
    println(a.sum)
    println(a.sorted.toBuffer)

    //加入分隔符
    a.mkString(",")
    println(a)

    //多维数组
    val arrayma = Array.ofDim[String](3,4)
    println(arrayma)

    """
      | /: 左包含 (1,2,3) (3) (_ - _)
      |           结果 3 - 1 - 2 - 3 = -3
      | :\ 右包含 (1,2,3) (3) (_ - _)
      |           结果 3 - 3 - 2 - 1 = -3
      |
    """.stripMargin

  }

}
