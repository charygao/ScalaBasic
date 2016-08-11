package cn.lesion.hadoop

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-8-9 .
  */

import java.nio.file.FileSystem
import java.util._

import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.hadoop.io._
import org.apache.hadoop.mapred._

class Map extends MapReduceBase
  with Mapper[LongWritable, Text, Text, IntWritable] {
  private val one = {
    new IntWritable(1)
  }
  private val word = new Text()

  def map(key: LongWritable, value: Text,
          output: OutputCollector[Text, IntWritable],
          reporter: Reporter
         ) {

    val line = value.toString
    val tokenizer = new StringTokenizer(line)
    while (tokenizer.hasMoreTokens) {
      word.set(tokenizer.nextToken)
      output.collect(word, one)
    }
  }
}

class Reduce extends MapReduceBase
  with Reducer[Text, IntWritable, Text, IntWritable] {
  def reduce(key: Text, values: Iterator[IntWritable],
             output: OutputCollector[Text, IntWritable],
             reporter: Reporter
            ) {
    output.collect(key, new IntWritable(count(0, values)))

    def count(sum: Int, vs: Iterator[IntWritable]): Int =
      if (vs.hasNext)
        count(sum + vs.next.get, vs)
      else
        sum
  }
}

object WordCount {
  def main(args: Array[String]) {
    val conf = new JobConf(this.getClass)

    conf.setJobName("WordCount")
    conf.set("fs.defaultFS","hdfs://love:9000")
    conf.set("mapred.job.tracker","hdfs://love:9001")


    conf.setOutputKeyClass(classOf[Text])
    conf.setOutputValueClass(classOf[IntWritable])


    conf.setMapperClass(classOf[Map])
    conf.setCombinerClass(classOf[Reduce])
    conf.setReducerClass(classOf[Reduce])
    conf.setInputFormat(classOf[TextInputFormat])
    conf.setOutputFormat(classOf[TextOutputFormat[Text, IntWritable]])

    //hdfs://127.0.0.1/Data/word hdfs://tmp/out
    FileInputFormat.setInputPaths(conf, new Path("hdfs://love:9000/Data/word"))

    Scala4Hdfs.delete("hdfs://love:9000/out/*")

    FileOutputFormat.setOutputPath(conf, new Path("hdfs://love:9000/out/"))



    JobClient.runJob(conf)

  }
}