package E4.exercise2

import E4.Setup.rddStation
import org.apache.spark.HashPartitioner

object Exercise2 {
  def main(args: Array[String]): Unit = {
    val p = new HashPartitioner(8)

    // Consider the following commands to transform the Station RDD:
/*
//  se era già configurato
    val rddS1 = rddStation.partitionBy(p).keyBy(x => x.usaf + x.wban).cache()
    val rddS2 = rddStation.partitionBy(p).cache().keyBy(x => x.usaf + x.wban)*/
    val rddS3 = rddStation.keyBy(x => x.usaf + x.wban).partitionBy(p).cache()
    val rddS4 = rddStation.keyBy(x => x.usaf + x.wban).cache().partitionBy(p)
    // Which of these options is better? And why?
  }
}
