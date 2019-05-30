package fizzbuzz

import org.scalatest.{FlatSpec, Matchers}

class FizzBuzzSpec extends FlatSpec with Matchers{

  "getFizzBuzzString" should "print out Fizz for multiples of 3" in {
    FizzBuzz.getFizzBuzzString(-1) shouldBe ""
    FizzBuzz.getFizzBuzzString(0) shouldBe ""
    FizzBuzz.getFizzBuzzString(2) shouldBe ""
    FizzBuzz.getFizzBuzzString(3) shouldBe "Fizz"
    FizzBuzz.getFizzBuzzString(4) shouldBe ""
  }

  it should "print out Buzz for multiples of 5" in {
    FizzBuzz.getFizzBuzzString(1) shouldBe ""
    FizzBuzz.getFizzBuzzString(5) shouldBe "Buzz"
    FizzBuzz.getFizzBuzzString(7) shouldBe ""
  }

  it should "print out FizzBuzz for multiples of both 3 and 5" in {
    FizzBuzz.getFizzBuzzString(15) shouldBe "FizzBuzz"
    FizzBuzz.getFizzBuzzString(30) shouldBe "FizzBuzz"
  }

  "getFizzBuzzSeq" should "create a seq that has Fizz for indexes divisible by 3" in {
    FizzBuzz.getFizzBuzzSeq(-1) shouldBe Seq.empty
    FizzBuzz.getFizzBuzzSeq(0) shouldBe Seq.empty
    val expected = Seq("","","Fizz","")
    FizzBuzz.getFizzBuzzSeq(4) shouldBe expected
  }

  it should "create a seq that has Buzz for indexes divisible by 5" in {
    val expected = Seq("","","Fizz","","Buzz","Fizz","","","Fizz","Buzz")
    FizzBuzz.getFizzBuzzSeq(10) shouldBe expected
  }

  it should "create a seq that has FizzBuzz for indexes divisible by both 3 and 5" in {
    val expected = Seq("","","Fizz","","Buzz","Fizz","","","Fizz","Buzz") ++
      Seq("","Fizz","","","FizzBuzz","","","Fizz","","Buzz") ++
      Seq("Fizz","","","Fizz","Buzz","","Fizz","","","FizzBuzz")
    FizzBuzz.getFizzBuzzSeq(30) shouldBe expected
  }

}
