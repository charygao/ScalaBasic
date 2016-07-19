package cn.lesion.hello.operatString

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


  """
    |创建一个Regex对象最简单的方法就是在一个String上调用 .r 方法。
    |另一个办法就是引入Regex类，创建一个Regex实例，然后用这个实例做相同的事情。
    |见 ： RegexTest.scala
  """.stripMargin

  //字符串查找模式：正则表达式匹配
  val worldPatten = "l+".r
  val match1 = worldPatten.findFirstIn(hello)
  //返回一个迭代器
  val matchs = worldPatten.findAllIn(hello)
//  val matchs = worldPatten.findAllIn(hello).toArray

  //找到第一个匹配并返回
  println(match1)
  //返回一个迭代器，如果没有找到任何结果，则会返回一个空的迭代器，不会为null，如果希望返回值为Array，在fundAllIn后加入 .toArray方法
  //toList,toSeq,toVector也可以这样用
  println(matchs)
  //迭代
  matchs.foreach(println)


  """
    |字符串中的替换模式：
    |参阅：
    |   StringOps类
    |   Regex类
    |问题：用正则变大事陪陪一段字符串然后替换他们
    |方法：因为String不可便，不可以在他上面直接操作，
    |      但是可以直接创建一个新的String，而这个String包含了替换后的内容，
  """.stripMargin

  //替换所有的数字为 ”x“。
  val address = "123 Main Street Suite 101"
  println("替换address：" + address.replaceAll("[0-9]", "x"))

  val regex = "[0-9]".r
  val newAddress = regex.replaceAllIn(address,"x")
  println("替换newAddress：" + newAddress)


  """
    |问题：抽取String中的模式匹配的部分
    |方法：定义正则表达式，在他们周围加上括号，可以当做“正则表达式组”使用。
  """.stripMargin

  //Defining the desired mode
  val pattern = "([0-9]+) ([a-z]+)".r
  // Sets num to "99", item to "bottles"
  val pattern(num, item) = "99 bottles"
  //print
  for (pattern(num, item) <- pattern.findAllIn("99 bottles, 98 bananas"))
    printf("%d,%s\n", num.toInt, item)

  """
    |访问字符串中的一个字符
    |
    |问题：得到字符串中指定位置的一个字符
    |解决办法：
    |   1、Java Api
    |     "hello".charAt(0) -> h
    |   2、Scala Api
    |     "hello"(0)  -> h
  """.stripMargin

  println(hello.charAt(0))
  println(hello(0))
  //hello.apply(0)


  """
    |隐式转换关键字 implicit 的应用
    |隐式转换函数是指在同一个作用域下面，一个给定输入类型并自动转换为指定返回类型的函数，
    |这个函数和函数名字无关，和入参名字无关，只和入参类型以及返回类型有关。
    |注意是同一个作用域。
  """.stripMargin
  //在String类中添加自定义的方法
  //定义隐式转换的类和方法

  //隐式转换      函数名   参数 参数类型 返回类型   函数的操作
  //implicit def increment(s: String):String = s.map(c => (c+1).toChar)

  def display(input:String):Unit = println(input)
  implicit def typeCon(input:Int):String = input.toString
  implicit def typeCon(input:Boolean):String = if(input) "true" else "false"
  //  implicit def booleanTypeConvertor(input:Boolean):String = if(input) "true" else "false"

  //返回其他类型:类型转换
  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)
    def decrement = s.map(c => (c - 1).toChar)
    def hideAll: String = s.replaceAll(".", "*")
    def plusOne = s.toInt + 1
    def asBoolen = s match {
      case "0" | "zero" | "" | " " => false
      case  _=> true
    }
  }

  println("1".plusOne)
  println("hei.hei.hei".hideAll)
  println("0".asBoolen)
  println("1".asBoolen)
  println("one".asBoolen)

}