package cn.lesion.spark.scala.hbase.myHbase


import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.{HColumnDescriptor, HTableDescriptor, TableName, HBaseConfiguration}
import org.apache.hadoop.hbase.client.ConnectionFactory

/**
  * Created in Intellij IDEA .
  * Author: lele .
  * Date: 16-8-27 .
  */
object OperateHBase {

  """
    |zkAddress:zookeeper的地址（ip/主机名）
    |tableName:表名称
    |columnFamilies:表中的列簇（单个或多个）
    |
    |该类并不会删除已经存在的表
  """.stripMargin

  def createTable(zkAddress: String, tableName: String, columnFamilies: String*): Unit = {
    //创建HBase的配置文件
    val hbConf = HBaseConfiguration.create()

    //    val hbConf: Configuration = Configuration

    //设置HBase的属性
    hbConf.set("hbase.zookeeper.property.clientPort", "2181")
    hbConf.set("hbase.zookeeper.quorum", zkAddress)

    //创建HBase的连接对象并传入配置文件
    val conn = ConnectionFactory.createConnection(hbConf)

    //从Connection获得Admin对象。
    val admin = conn.getAdmin

    //准备操作数据库

    //设置操作的表名称：
    val table = TableName.valueOf(tableName)

    //创建表
    val tableDescr = new HTableDescriptor(table)

    //添加表的列簇
    for (columnFamily <- columnFamilies) {

      //Array转Set
      val set4ColumnFamilies = columnFamilies.toSet

      //利用set集合中， value不可重复作为判断依据
      if (set4ColumnFamilies.size != columnFamilies.size)
        println("列簇名字重复,请重新指定。")
      sys.exit(0)
      tableDescr.addFamily(new HColumnDescriptor(columnFamily.getBytes))
    }

    println("创建表：" + table.toString)

    //若存在，禁用并删除
    if (admin.tableExists(table)) {
      println("该表已经存在！")

      //关闭连接
      conn.close()
      sys.exit(1)
    }

    //建表
    admin.createTable(tableDescr)

    if (admin.tableExists(table)) {
      println("创建成功！")
    }

    conn.close()
  }

  def main(args: Array[String]) {
    createTable("localhost", "table", "column1", "column2")
  }

}
