package coderwars

import org.scalatest.{FlatSpec, Matchers}

// From http://adventofcode.com/day/5
//  --- Day 5: Doesn't He Have Intern-Elves For This? ---
//
//  Santa needs help figuring out which strings in his text file are naughty or nice.
//
//    A nice string is one with all of the following properties:
//
//    1. It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
//    2. It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
//    3. It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
//    For example:
//
//    ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...), and none of the disallowed substrings.
//    aaa is nice because it has at least three vowels and a double letter, even though the letters used by different rules overlap.
//    jchzalrnumimnmhp is naughty because it has no double letter.
//    haegwjzuvuyypxyu is naughty because it contains the string xy.
//    dvszwmarrgswjxmb is naughty because it contains only one vowel.
//    How many strings are nice?
//
//    def nice(xs: List[String]): Int = ???

class StringConditionsSpec extends FlatSpec with Matchers{
  val oneChar = "a"
  val threeSameVowelsShort = "aaa"
  val threeSameVowelsLong = "abcdefghi"
  val twoDifferentVowels = "ae"
  val doubleSameCharLong = "abcddefgh"
  val doubleSameCharShort = "xx"
  val forbiddenPair = "xy"
  val forbiddenPairTwice = "pqrstuvwxy"
  val startOfTwoForbiddenParis = "px"
  val emptyString = ""
  val validStringOne = "ugknbfddgicrmopn"
  val validStringTwo = "iii"
  val invalidStringOne = "jchzalrnumimnmhp"
  val invalidStringTwo = "haegwjzuvuyypxyu"
  val invalidStringThree = "dvszwmarrgswjxmb"

  "hasThreeVowels" should "return true if three vowels are present" in {
    StringConditions.hasThreeVowels(threeSameVowelsShort) shouldBe true
    StringConditions.hasThreeVowels(threeSameVowelsLong) shouldBe true
  }

  it should "return false if there are two vowels or less" in {
    StringConditions.hasThreeVowels(oneChar) shouldBe false
    StringConditions.hasThreeVowels(twoDifferentVowels) shouldBe false
    StringConditions.hasThreeVowels(doubleSameCharLong) shouldBe false
    StringConditions.hasThreeVowels(doubleSameCharShort) shouldBe false
  }

  "hasDoubleOccurrence" should "return true if a character is repeated" in {
    StringConditions.hasDoubleOccurrence(doubleSameCharLong) shouldBe true
    StringConditions.hasDoubleOccurrence(doubleSameCharShort) shouldBe true
  }

  it should "return false if no characters are repeated" in {
    StringConditions.hasDoubleOccurrence(oneChar) shouldBe false
    StringConditions.hasDoubleOccurrence(threeSameVowelsLong) shouldBe false
    StringConditions.hasDoubleOccurrence(twoDifferentVowels) shouldBe false
  }

  "hasForbiddenChars" should "return true if a forbidden pair of chars is found" in {
    StringConditions.hasForbiddenChars(forbiddenPair) shouldBe true
    StringConditions.hasForbiddenChars(forbiddenPairTwice) shouldBe true
    StringConditions.hasForbiddenChars(threeSameVowelsLong) shouldBe true
  }

  it should "return false if there are no forbidden paris, or no characters" in {
    StringConditions.hasForbiddenChars(emptyString) shouldBe false
    StringConditions.hasForbiddenChars(threeSameVowelsShort) shouldBe false
    StringConditions.hasForbiddenChars(doubleSameCharShort) shouldBe false
    StringConditions.hasForbiddenChars(startOfTwoForbiddenParis) shouldBe false
  }

  "nice" should "return a zero result if there are no strings" in {
    StringConditions.nice(List.empty[String]) shouldBe 0
  }

  it should "count strings which meet the three criteria" in {
    val allValid = List(validStringOne,validStringTwo)
    StringConditions.nice(allValid) shouldBe 2
  }

  it should "not count strings which violate any of the criteria" in {
    val allInvalid = List(invalidStringOne, invalidStringTwo, invalidStringThree)
    StringConditions.nice(allInvalid) shouldBe 0
  }
}
