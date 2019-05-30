package coderwars

import scala.annotation.tailrec

object StringConditions {

  val vowels: Seq[Char] = Seq('a', 'e', 'i', 'o', 'u')
  val forbiddenCharPairs: Seq[String] = Seq("ab", "cd", "pq", "xy")

  def nice(xs: List[String]): Int = {
    xs.count { str =>
      hasThreeVowels(str) && hasDoubleOccurrence(str) && !hasForbiddenChars(str)
    }
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
