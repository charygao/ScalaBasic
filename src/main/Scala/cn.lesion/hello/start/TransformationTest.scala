package cn.lesion.hello.start

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/1.
  */
object TransformationTest {
  def main(args: Array[String]): Unit = {
//    val b = BigInt(1294710293337L)
    val b = BigDecimal(1294710293337L)
    //支持所有普通数值操作符

    //普通数值类型
    Double.PositiveInfinity
    Double.NegativeInfinity

    //测试是否可以转换类型：
    println(b.isValidByte)
    println(b.isValidChar)
    println(b.isValidDouble)
    println(b.isValidFloat)
    println(b.isValidShort)
    println(b.isValidLong)
    println(b.isValidInt)

    println(Double.MaxValue>Long.MaxValue)

  }

}
