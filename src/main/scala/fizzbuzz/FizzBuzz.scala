package fizzbuzz

/**
  * Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of
  * the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and
  * five print “FizzBuzz”.
  *
  * We didn't have to do this in two functions, bt it makes TDD a lot easier to break things into small components.
  * Hence we've split the problem into it's component parts, and constructed our tests around that.
  */
object FizzBuzz {

  /**
    * Creates a sequence of strings - on every index position that is divisible by three text will contain "Fizz" (eg 3,
    * 6, 9), on every index divisible by 5 it will contain "Buzz" (eg 5, 10), and on indexes which are divisible by both
    * 3 & 5 it'll contain "FizzBuzz" (eg 15, 30). For any index that doesn't match these criteria, it'll be an
    * empty string.
    *
    * The reason we're outputting a seq is so that it's easy to test. Otherwise for this trivial example we'd just
    * output to the console
    *
    * @param n the number of entries, must be a natural number
    * @return the seq of string results
    */
  def getFizzBuzzSeq(n: Int): Seq[String] = {
    n match {
      case number if (number <= 0) => Seq.empty
      case _ =>
        for (i <- 1 to n)
          yield getFizzBuzzString(i)
    }
  }

  /**
    * Creates a string based on the fizzbuzz logic - if n is divisible by three then return "Fizz", if it's divisible
    * by 5 return "Buzz", if it's divisible by both 3 & 5 then "FizzBuzz". Empty strings are returned inn other cases.
    *
    * @param n the number to test
    * @return a string which is "","Fizz","Buzz", or "FizzBuzz"
    */

  def getFizzBuzzString(n: Int): String = {
    n match {
      case number if (number <= 0) => ""
      case _ => "" + (if (n % 3 == 0) "Fizz" else "") + (if (n % 5 == 0) "Buzz" else "")
    }
  }
}
