package coderwars

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.immutable.{HashMap, HashSet}
import scala.collection.mutable

/*
Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contain any char.

Examples input/output:

XO("ooxx") => true
XO("xooxx") => false
XO("ooxXm") => true
XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
XO("zzoo") => false

 */

// def findNumberOfChars(charsToFind: HashSet[Char], str: String): HashMap[Char,Int]

class FindNoOfCharsSpec extends FlatSpec with Matchers {

  val charsToFind = HashSet[Char]('x', 'o')

  "findNumberOfChars" should "find a given character" in {
    val expected = HashMap[Char, Int]('x' -> 1, 'o' -> 1)
    FindNoOfChars.findNumberOfChars(charsToFind, "xo") shouldBe expected
  }

  it should "" in {

  }

  "hasSameNumberOfChars" should "return true if none are present" in {
    FindNoOfChars.hasSameNumberOfChars(charsToFind,"abc") shouldBe true
  }

}
