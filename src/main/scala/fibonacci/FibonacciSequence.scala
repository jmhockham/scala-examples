package fibonacci

import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.immutable.Stream.Empty.scanLeft

object FibonacciSequence extends App {

  fiboRecur(20)
  println(fiboStream(5).mkString(","))

  // see https://stackoverflow.com/questions/9864497/generate-a-sequence-of-fibonacci-number-in-scala
  // and (if you can withstand the ego) http://www.luigip.com/?p=200
  def fiboStream(iterations: Int) = {
    lazy val fibo: Stream[Int] = 0 #:: fibo.scanLeft(1)(_+_)
    fibo take iterations toList
  }

  @tailrec
  def fiboRecur(iterations: Int, firstNo: Int = 0, nextNo:Int = 1): Unit = {
    if (iterations<=0){
      println("fibRecur finished")
    }
    else {
      if(firstNo==0){
        if(iterations>1){
          println(s"$firstNo")
          println(s"$nextNo")
        } else{
          println(s"$firstNo")
        }
      }
      else{
        println(s"$nextNo")
      }
      val firstNoUpd = nextNo
      val nextNoUpd = if (firstNo==0) 1 else firstNo + nextNo
      val iterationsUpd = if(firstNo==0) iterations-2 else iterations-1
      fiboRecur(iterationsUpd, firstNoUpd, nextNoUpd)
    }

  }

}
