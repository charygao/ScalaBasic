package cn.lesion.training

/**
  * Created by root on 16-7-13.
  * 查看Predef源码
  */
object scala_StrOpe {

  def main(args: Array[String]): Unit = {
    println("Hello world")
  }


  //val hello = "Hello World !"
  val hello: String = "Hello World !"


  //打印字符串长度
  println(hello.length)

  //打印字符串
  println("打印字符串" + hello)

  //当做字符序列处理
  for (h <- hello) {
    println("字符序列处理 ： " + h)
  }

  //利用filter处理字符串
  val fileterResult = hello.filter(_ != 'l')
  println("利用filter处理字符串：过滤l：" + fileterResult)


  //向封闭类中添加方法
  val _helloOpr1 = hello.drop(2).take(2).capitalize
  val _helloOpr2 = hello.slice(2, 4).capitalize

  println("drop.take.capitalize : " + _helloOpr1)
  println("slice : " + _helloOpr2)

  //将字符串转换成大写
  println("将字符串转换成大写 ："+hello.toUpperCase())

  //忽略大小写比较
  val hello2 = "hello world !"
  val hello3 = Option
  println("hello3 = " + hello3)
  println(  hello.equalsIgnoreCase(hello2))

  //定义多个字符串
  //字符串可带单引号或双引号而不用转义
  val manyStr =
    """
      |aaa
      |bbb
      |ccc
    """.stripMargin

  //打印当前
  println(manyStr)
  //打印成为一行
  println(manyStr.replaceAll("\n", " "))

  //分割
  //split可以接受正则表达式作为参数，
  println(hello.split(" "))

  //字符串中插入变量：
  //s：进行字符串替换。
  val name:String = "小明"
  val age:Int = 20
  val weiget:Double = 200.00

  println(s" $name 今年$age 岁了, $weiget 公斤重")

  //raw：字符串前加入，内容中不转义
  println(raw"\\\\asdf\asd\fas\dfa\sdf\a\a")
  //可能是IDEA的bug
//  println(raw"\\\\asdf\asd\fas\dfa\sdf\a\")

  //在字符串中使用表达式
  println(s" ${name + "和小高"}今年${age + 1}岁了")


  //挨个处理字符串中的字符
  println(hello.map(c => c.toUpper))

  //使用Scala魔法代码来简化
  print(hello.map(_.toUpper))

  //使用for循环
  //将Hello中存有的字符串赋给c然后遍历c
  for (c <- hello) {
    println(c)
  }

  //yield：将map中的信息存到内存中
  for (c <- hello)yield {
    println(c.toUpper)
  }

  for (c <- hello if c !='l') {
    println(c)
  }

  //给map一个算法
  println(hello.map(c => (c.toByte+32).toChar))

  //或者
  def toLarge(c: Char): Char = (c.toByte+32).toChar

  //获取一个字符串中的有序集合字节：
  println(hello.getBytes())

  //字符串查找模式：正则表达式匹配
  val worldPatten = "[a_z]+".r
  println(worldPatten.findAllIn(hello))



}