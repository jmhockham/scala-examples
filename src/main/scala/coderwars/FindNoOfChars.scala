package coderwars

import scala.annotation.tailrec
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

object FindNoOfChars {

  def findNumberOfChars(charsToFind: HashSet[Char], str: String): Map[Char,Int] = {
    findNumberOfCharsRecur(charsToFind, str, HashMap.empty[Char,Int])
  }

  @tailrec
  private def findNumberOfCharsRecur(charsToFind: HashSet[Char], remainingChars: String, results: Map[Char,Int]): Map[Char,Int] = {
    if(remainingChars.isEmpty){
      results
    } else {
      val charToExamine = remainingChars.head
      val updatedMap: Map[Char, Int] = updateMapIfCharValid(charToExamine, charsToFind, results)
      findNumberOfCharsRecur(charsToFind, remainingChars.tail, updatedMap)
    }

  }

  private def updateMapIfCharValid(charToExamine: Char, charsToFind: HashSet[Char], results: Map[Char, Int]) = {
    if (charsToFind.contains(charToExamine)) {
      results + (charToExamine -> (results.getOrElse(charToExamine, 0) + 1))
    } else results
  }

  def hasSameNumberOfChars(charsToFind: HashSet[Char], str: String): Boolean = {
    val results = findNumberOfChars(charsToFind,str)
    if(results.isEmpty)
      true
    else
      false
  }

}
