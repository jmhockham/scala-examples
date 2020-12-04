package interviewtests

import scala.annotation.tailrec

//fibo seq (up to a specified limit), outputted as a list
object FiboList extends App {

  def fiboStream(limit: Int) = {
    lazy val fibo: Stream[BigInt] = 0 #:: fibo.scanLeft(BigInt(1))(_+_)
    fibo.take(limit).toList
  }

  @tailrec
  def fibList(limit: Int, current: BigInt = BigInt(0), next: BigInt = BigInt(1), result: List[BigInt] = List(0)): List[BigInt] = {
    if(result.size>=limit){
      result
    } else {
      fibList(limit, next, current + next, result ++ List(next))
    }
  }

  println(fiboStream(10).mkString(", "))
  println(fibList(10).mkString(", "))

}
