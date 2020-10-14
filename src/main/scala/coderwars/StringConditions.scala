package coderwars

import scala.annotation.tailrec

object StringConditions extends App {

  val vowels: Seq[Char] = Seq('a', 'e', 'i', 'o', 'u')
  val forbiddenCharPairs: Seq[String] = Seq("ab", "cd", "pq", "xy")

  println(s"""Acceptable words in the following list ["abc","aaee","eeyore"]: \n ${nice(List("abc","aaee","eeyore"))} """)

  def nice(xs: List[String]): List[(String, Boolean)] = {
    val results = xs.map { str =>
      val valid = hasThreeVowels(str) && hasDoubleOccurrence(str) && !hasForbiddenChars(str)
      (str, valid)
    }
    results
  }

  def hasThreeVowels(string: String): Boolean = {
    string.toLowerCase.count { char =>
      vowels.contains(char)
    } >= 3
  }

  def hasDoubleOccurrence(str: String): Boolean = {
    if (str.length < 2) {
      false
    }
    else {
      hasDoubleOccurrenceChecker(str.head, str.charAt(1), str.substring(2))
    }
  }

  @tailrec
  private def hasDoubleOccurrenceChecker(previousChar: Char, currentChar: Char, remainingChars: String): Boolean = {
    (previousChar, currentChar, remainingChars) match {
      case (prev, current, _) if prev == current => true
      case (_, _, remaining) if remaining.isEmpty => false
      case (_, current, remaining) => hasDoubleOccurrenceChecker(current, remaining.head, remaining.tail)
    }
  }

  def hasForbiddenChars(str: String) = {
    forbiddenCharPairs.exists { pair =>
      str.toLowerCase.contains(pair)
    }
  }

}
