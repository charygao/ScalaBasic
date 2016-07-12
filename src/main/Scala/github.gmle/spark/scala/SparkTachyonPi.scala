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

// scalastyle:off println
package github.gmle.spark.scala

import scala.math.random

import org.apache.spark._
import org.apache.spark.storage.StorageLevel

/**
 *  Computes an approximation to pi
 *  This example uses Tachyon to persist rdds during computation.
 */
object SparkTachyonPi {
  def main(args: Array[String]) {
    val sparkConf = new SparkConf().setAppName("SparkTachyonPi")
    val spark = new SparkContext(sparkConf)

    val slices = if (args.length > 0) args(0).toInt else 2
    val n = 100000 * slices

    val rdd = spark.parallelize(1 to n, slices)
    rdd.persist(StorageLevel.OFF_HEAP)
    val count = rdd.map { i =>
      val x = random * 2 - 1
      val y = random * 2 - 1
      if (x * x + y * y < 1) 1 else 0
    }.reduce(_ + _)
    println("Pi is roughly " + 4.0 * count / n)

    spark.stop()
  }
}
// scalastyle:on println
