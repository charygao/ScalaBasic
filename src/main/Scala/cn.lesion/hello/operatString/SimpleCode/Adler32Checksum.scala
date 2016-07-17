package cn.lesion.hello.operatString.SimpleCode

/**
  * Created in Intellij IDEA .
  * Author: e.le.lee .
  * Date: 16-7-15 .
  *
  * Adler32校验
  * Adler32:保护数据防止意外更改的算法
  * Java工具类：java.util.zip.Adler32
  *
  */
object Adler32Checksum {

  val MOD_ADLER = 65521

  def main(args: Array[String]) {
    val sum = adler32sum("string")
    printf("checksum (int)  = %d\n ", sum)
    printf("checksum (hex)  = %s\n ", sum.toHexString)
  }

  def adler32sum(s: String): Int = {
    var a = 1
    var b = 0
    s.getBytes.foreach { char =>
      a = (char + a) % MOD_ADLER
      b = (b + a) % MOD_ADLER
    }
    b * 65536 + a //or (b< 16) +a
  }

}
