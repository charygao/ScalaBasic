package github.gmle.hello

/**
  * Created for Intellij IDEA.
  * Author:e.le.lee.
  * Date: 16-6-19.
  */
object ScalaMap {

  def main(args: Array[String]) {

    val numbers = Map(
      "a" -> 1,
      "b" -> 2,
      "c" -> 3,
      "d" -> 4,
      "e" -> 5
    )

    for ((k,v) <- numbers) {
      println("name:" + k + ",age:" + v)
    }

    for ((key,_) <- numbers) {
      println("key:" + key)
    }

  }

}
