package fibonacci

import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.immutable.Stream.Empty.scanLeft
import scala.collection.mutable

object FibonacciSequence extends App {

  println(fiboRecur(10).mkString(","))
  println(fiboStream(10).mkString(","))
  println(fiboIter(10).mkString(","))
  //fiboRecurInf(10)

  def fiboIter(iterations: Int) = {
    val numberRange = 2 until iterations
    val results = mutable.Stack(1,0)
    if(iterations<=2){
      results.reverse.take(iterations).toList
    }
    else {
      for{
        i <- numberRange
      } yield results.push(results.head + results.tail.head)
      results.reverse.toList
    }
  }

  // see https://stackoverflow.com/questions/9864497/generate-a-sequence-of-fibonacci-number-in-scala
  // and (if you can withstand the ego) http://www.luigip.com/?p=200
  def fiboStream(iterations: Int) = {
    lazy val fibo: Stream[BigInt] = 0 #:: fibo.scanLeft(BigInt(1))(_+_)
    fibo take iterations toList
  }

  @tailrec
  def fiboRecur(iterations: Int, firstNo: BigInt = 1, nextNo: BigInt = 1, results: List[BigInt] = List(0,1)): List[BigInt] = {
    if(results.size>=iterations){
      results.take(iterations)
    }
    else {
      val firstNoUpd = nextNo
      val nextNoUpd = firstNo + nextNo
      val resultsUpd = results ++ List(firstNoUpd)
      fiboRecur(iterations, firstNoUpd, nextNoUpd, resultsUpd)
    }
  }

  // a tail recur fibo that can go indefinitely, because it doesn't keep a stack (tailrec) and doesn't
  // create a collection for output
  @tailrec
  def fiboRecurInf(iterations: Int, firstNo: Int = 0, nextNo:Int = 1): Unit = {
    if (iterations<=0){
      println("fiboRecurInf finished")
    }
    else {
      if(firstNo==0){
        if(iterations<=1){
          println(s"$firstNo")
        } else {
          println(s"$firstNo")
          println(s"$nextNo")
        }
      }
      else{
        println(s"$nextNo")
      }
      val firstNoUpd = nextNo
      val nextNoUpd = if (firstNo==0) 1 else firstNo + nextNo
      val iterationsUpd = if(firstNo==0) iterations-2 else iterations-1
      fiboRecurInf(iterationsUpd, firstNoUpd, nextNoUpd)
    }

  }

}
