package primes

import org.scalatest.{FlatSpec, Matchers}

class PrimeSieveSpec extends FlatSpec with Matchers {

  "findPrimes" should "return a sequence of primes" in {

    //primes up to >=1 && <=30
    //2, 3, 5, 7, 11, 13, 17, 19, 23, 29
    val expectedResult = Seq(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    val actualResult = PrimeSieve.findPrimes(30)
    actualResult shouldBe expectedResult

  }

}
