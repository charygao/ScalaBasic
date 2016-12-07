package cn.lesion.hello.start

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 2016/12/5.
  */
object lazyValue {

  def sig_num(x: Double): String = {
    if (x.signum == 1) x + "是正数"
    else if (x.signum == -1) x + "是负数"
    else "这个数是0"
  }

  def test1(){
    for (i <- 0 to 10)
      println(10 - i)

    for (i <- 0 to 10; from = 10 - i)
      println(from)
  }

//  x=y=1
  def test2(a:Int): Unit = {
    var x = 1
    var y = 1
    println(x=y=1)

  }

//  打印一个从n到0的数字
  def countdown(n: Int) {
    for (i <- 0 to n; from = n - i) print(from + " ")
  }


  def product1(words:String):BigInt = {
    var sum:BigInt = 1
    val length = words.length
    for(word <- 0 until length){
      sum = sum * words(word).toLong
    }
    sum
  }
  def product2(words:String):BigInt = {
    var sum:BigInt = 0
    sum = words.map(_.toLong).product
    sum
  }

  def execise(x:Double,n:Int): BigDecimal ={
    if(n == 0){
      1
    }else if (n < 0){
      1/execise(x,-1*n)
    }else if (n % 2 == 1){
      x*execise(x,n-1)
    }else{
      execise(x,n/2)*execise(x,n/2)
    }
  }

  def main(args: Array[String]): Unit = {

    //只有在首次取值的时候才会被初始化
    lazy val a = 1
    println(a)


    println(sig_num(0))
    println(sig_num(3))
    println(sig_num(-2.8))

  }

}
