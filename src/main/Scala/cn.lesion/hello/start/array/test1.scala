package cn.lesion.hello.start.array

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/5.
  */
object test1 {

  //定长数组，十个整数的数组，所有元素初始化为0
  val array1 = new Array[Int](10)

  //定长数组，十个字符串的数组，所有元素初始化为null
  val array2 = new Array[String](10)

  //长度为2的Array，类型（String）是推断出来的，并且已经提供初始值就不需要new
  val array3 = Array("hello","world")

  //数组操作和读取
  //使用小括号  '()' 来读取数组中的元素
  val array4: Unit = array3(0) = "Hello"

  def main(args: Array[String]): Unit = {
    println("array1 = " + array1)
    println("array2 = " + array2)
    println("array3 = " + array3)
    println("array4 = " + array4)

    //array1
    print("Array1 = (")
    for (array <- array1)
      print((array.toString + ",").substring(0,(array.toString + ",").length-1))
    print(")")

    println
    println("-----------------------------")

    //array2
    print("Array2 = (")
    for (array <- array2)
      print((array + ",").substring(0,(array + ",").length-1))
    print(")")

    println
    println("-----------------------------")

    //array3
    print("Array2 = (")
    for (array <- array3)
      print((array.toString + ",").substring(0,(array.toString + ",").length-1))
    print(")")


  }


}
