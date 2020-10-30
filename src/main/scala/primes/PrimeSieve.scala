package primes

import scala.collection.mutable

/*

  shamelessly stolen from https://medium.com/coding-with-clarity/functional-vs-iterative-prime-numbers-in-scala-7e22447146f0

  //iterative
  def primesIterative(end: Int): List[Int] = {
    val primeIndices = mutable.ArrayBuffer.fill((end + 1) / 2)(1)

    val intSqrt = Math.sqrt(end).toInt
    for (i <- 3 to end by 2 if i <= intSqrt) {
      for (nonPrime <- i * i to end by 2 * i) {
        primeIndices.update(nonPrime / 2, 0)
      }
    }

    (for (i <- primeIndices.indices if primeIndices(i) == 1) yield 2 * i + 1).tail.toList
  }

  OR

  //functional
  def calculatePrimesStream(end: Int): List[Int] = {
    val odds = Stream.from(3, 2).takeWhile(_ <= Math.sqrt(end).toInt)
    val composites = odds.flatMap(i => Stream.from(i * i, 2 * i).takeWhile(_ <= end))
    Stream.from(3, 2).takeWhile(_ <= end).diff(composites).toList
  }


  from wikipedia
  Input: an integer n > 1.

   Let A be an array of Boolean values, indexed by integers 2 to n,
   initially all set to true.

   for i = 2, 3, 4, ..., not exceeding √n:
     if A[i] is true:
       for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n:
         A[j] := false.

   Output: all i such that A[i] is true.

  */

object PrimeSieve extends App {

  def findPrimes(endNumber: Int) = {

    endNumber match {
      case number if number < 3 && number > 0 => List(1)
      case number if number <0 => List.empty[Int]
      case _ =>
        val primeIndices = mutable.ArrayBuffer.fill((endNumber + 1) / 2)(1)
        val intSqrt = Math.sqrt(endNumber).toInt

        for {
          i <- 3 to endNumber by 2 if i <= intSqrt
          nonPrime <- i * i to endNumber by 2 * i
        } yield primeIndices.update(nonPrime / 2, 0)

        val primes = for (i <- primeIndices.indices if primeIndices(i) == 1) yield 2 * i + 1
        primes
    }
  }

  println(findPrimes(50).mkString(", "))

}
