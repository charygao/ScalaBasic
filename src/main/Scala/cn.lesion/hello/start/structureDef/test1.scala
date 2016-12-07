//package cn.lesion.hello.start.structureDef


package cn {
  package lesion {
    package hello {
      package start {
        package structureDef {
          /**
            * Created for Intellij IDEA.
            * Author:e.le.lee.
            * Date: 2016/12/7.
            */
          class test1 {

            var name:String = ""
            var age:Int = 0

            def this(name: String){
              this()
              this.name = name
            }

            def this(name:String,age:Int){
              this(name)
              this.age = age
            }

          }

        }

      }

    }

  }

}
