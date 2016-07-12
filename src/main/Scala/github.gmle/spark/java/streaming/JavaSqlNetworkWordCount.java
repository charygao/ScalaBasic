/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package github.gmle.spark.java.streaming;

import java.util.regex.Pattern;

import com.google.common.collect.Lists;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.Time;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

/**
 * Use DataFrames and SQL to count words in UTF8 encoded, '\n' delimited text received from the
 * network every second.
 *
 * Usage: JavaSqlNetworkWordCount <hostname> <port>
 * <hostname> and <port> describe the TCP server that Spark Streaming would connect to receive data.
 *
 * To run this on your local machine, you need to first run a Netcat server
 *    `$ nc -lk 9999`
 * and then run the example
 *    `$ bin/run-example org.apache.spark.examples.streaming.JavaSqlNetworkWordCount localhost 9999`
 */

public final class JavaSqlNetworkWordCount {
  private static final Pattern SPACE = Pattern.compile(" ");

  public static void main(String[] args) {
    if (args.length < 2) {
      System.err.println("Usage: JavaNetworkWordCount <hostname> <port>");
      System.exit(1);
    }

    StreamingExamples.setStreamingLogLevels();

    // Create the context with a 1 second batch size
    SparkConf sparkConf = new SparkConf().setAppName("JavaSqlNetworkWordCount");
    JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(1));

    // Create a JavaReceiverInputDStream on target ip:port and count the
    // words in input stream of \n delimited text (eg. generated by 'nc')
    // Note that no duplication in storage level only for running locally.
    // Replication necessary in distributed scenario for fault tolerance.
    JavaReceiverInputDStream<String> lines = ssc.socketTextStream(
        args[0], Integer.parseInt(args[1]), StorageLevels.MEMORY_AND_DISK_SER);
    JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
      @Override
      public Iterable<String> call(String x) {
        return Lists.newArrayList(SPACE.split(x));
      }
    });

    // Convert RDDs of the words DStream to DataFrame and run SQL query
    words.foreachRDD(new Function2<JavaRDD<String>, Time, Void>() {
      @Override
      public Void call(JavaRDD<String> rdd, Time time) {
        SQLContext sqlContext = JavaSQLContextSingleton.getInstance(rdd.context());

        // Convert JavaRDD[String] to JavaRDD[bean class] to DataFrame
        JavaRDD<JavaRecord> rowRDD = rdd.map(new Function<String, JavaRecord>() {
          public JavaRecord call(String word) {
            JavaRecord record = new JavaRecord();
            record.setWord(word);
            return record;
          }
        });
        DataFrame wordsDataFrame = sqlContext.createDataFrame(rowRDD, JavaRecord.class);

        // Register as table
        wordsDataFrame.registerTempTable("words");

        // Do word count on table using SQL and print it
        DataFrame wordCountsDataFrame =
            sqlContext.sql("select word, count(*) as total from words group by word");
        System.out.println("========= " + time + "=========");
        wordCountsDataFrame.show();
        return null;
      }
    });

    ssc.start();
    ssc.awaitTermination();
  }
}

/** Lazily instantiated singleton instance of SQLContext */
class JavaSQLContextSingleton {
  static private transient SQLContext instance = null;
  static public SQLContext getInstance(SparkContext sparkContext) {
    if (instance == null) {
      instance = new SQLContext(sparkContext);
    }
    return instance;
  }
}
