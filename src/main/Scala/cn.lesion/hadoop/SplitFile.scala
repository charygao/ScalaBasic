package cn.lesion.hadoop

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-8-10 .
  */
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io.{LongWritable, NullWritable, IntWritable, Text}
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs
import org.apache.hadoop.mapreduce.{Job,InputFormat,OutputFormat}
import org.apache.hadoop.mapreduce.Mapper
import org.apache.hadoop.mapreduce.lib.input.{TextInputFormat, FileInputFormat}
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat
import org.apache.hadoop.util.GenericOptionsParser
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat

/**
  * https://hadoop.apache.org/docs/r2.2.0//api/org/apache/hadoop/mapred/lib/MultipleOutputs.html
  */

// This class performs the map operation, translating raw input into the key-value
// pairs we will feed into our reduce operation.
class SplitMapper extends Mapper[Object,Text,Text,Text] {
  //https://github.com/rystsov/learning-hadoop/blob/master/src/main/java/com/twitter/rystsov/mr/MultipulOutputExample.java

  //var multipleOutputs :MultipleOutputs = null
  private var multipleOutputs: MultipleOutputs[Text, Text] = _

  @throws(classOf[java.io.IOException])
  @throws(classOf[java.lang.InterruptedException])
  override
  protected def setup(context:Mapper[Object, Text, Text, Text]#Context)  {
    //pattern = Pattern.compile("^http://([^/]+).+$")
    multipleOutputs = new MultipleOutputs(context)
    println("SetUp Ok ......................")
  }


  override
  def map(key:Object, value:Text, context:Mapper[Object,Text,Text,Text]#Context) = {
    //var conf :Configuration  = context.getConfiguration()
    //var splitkeys  = conf.get("splitkeys")

    val keys = "26/Jan/2015,27/Jan/2015".split(",")
    //var keys =
    val word = new Text

    val line = value.toString
    for (key <-  keys) {

      word.set(key)
      if (line.contains(key)) {
        val mkey: String = key.toString.replace("/", "")
        context.write(word, value)
        multipleOutputs.write(mkey,
          word,
          value)
      }
    }
  }


  @throws(classOf[java.io.IOException])
  @throws(classOf[InterruptedException])
  override
  protected def cleanup( context:Mapper[Object,Text,Text,Text]#Context){
    multipleOutputs.close()
  }
}

/***
class MutiFIleReducer extends Reducer[Text,Text,Text,Text] {

  override
  def reduce(key:Text, values:java.lang.Iterable[Text], context:Reducer[Text,Text,Text,Text]#Context) = {
    for (value <- values) {
      context.write(key, value)
    }
  }
}
  ***/



// This class configures and runs the job with the map and reduce classes we've
// specified above.
object SplitFile {

  def main(args:Array[String]):Int = {
    val conf = new Configuration()
    val otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs
    val usage =
      """
        |Usage: FileSplit <inputdir> <outdir> <tmpdir> <keeyoriginfile>[<key1> <key2> <key3> key4>...]
        |inputdir is a file or dir
        |outputdir is a dir need not blank
        |tmpdir use for tmp
        |keeyoriginfile is a bool
      """
    print("\n\n")
    print(args.toString)
    print(otherArgs)
    println()
    if (args.length < 5) {
      print(usage)
      return 2
    }
    val job = new
        Job(conf, "com.timger.tools.SplitFile")
    job.setJarByClass(classOf[SplitMapper])
    job.setMapperClass(classOf[SplitMapper])

    //job.setCombinerClass(classOf[IntSumReducer])
    //job.setReducerClass(classOf[MutiFIleReducer])

    job.setOutputKeyClass(classOf[Text])
    job.setInputFormatClass(classOf[TextInputFormat])

    val inputdir = new Path(otherArgs(0))
    val outputdir = new Path(otherArgs(1))
    val tmpdir = new Path(otherArgs(2))
    val keeyoriginfile :String= otherArgs(3)
    val splitkeys :Array[String]= otherArgs.slice(4, otherArgs.length)
    val keys = splitkeys.mkString(",")
    val test_str :String =
      """
        |input: %s
        |output: %s
        |tmpdir: %s
        |keys: %s
      """.format(inputdir, outputdir, tmpdir, keys)
    print(test_str)
    //onf.set("splitkeys", keys)
    print(splitkeys)

    // val TextOutputFormatClass = classOf[TextOutputFormat].asInstanceOf[Class[T] forSome {type T <: OutputFormat[String, String]}]

    for (key <- splitkeys) {
      val mkey  :String = key.toString.replace("/",  "")
      print(mkey)


      MultipleOutputs.addNamedOutput(job, mkey,
        classOf[TextOutputFormat[Text,Text]],
        classOf[Text],
        classOf[Text])
    }

    //job.setNumReduceTasks(splitkeys.length)
    job.setNumReduceTasks(0)

    job.setOutputValueClass(classOf[Text])
    FileInputFormat.addInputPath(job, inputdir)
    FileOutputFormat.setOutputPath(job, tmpdir)

    //job.setOutputFormatClass(classOf[MyMultipleOutputFormat])

    //job.setOutputFormatClass(classOf[CustomMultipleTextOutputFormat])


    //LazyOutputFormat.setOutputFormatClass(conf,  classOf[MyMultipleOutputFormat])
    if (job.waitForCompletion(true)) 0 else 1
  }

}
