package coderwars

import scala.annotation.tailrec

/*
   We have a system to transfer information from one place to another. This system
   involves transferring only list of digits greater than 0 (1-9). In order to decipher
   the message encoded in the list you need to have a dictionary that will allow
   you to do it following a set of rules:
      > Sample incoming message: (​1,2,3,7,3,2,3,7,2,3,4,8,9,7,8)
      > Sample dictionary (​23->‘N’,234->‘ ’,89->‘H’,78->‘Q’,37 ->‘A’)
    - Iterating from left to right, we try to match sublists to entries of the map.
      A sublist is a sequence of one or more contiguous entries in the original list,
      eg. the sublist (1, 2) would match an entry with key 12, while the sublist (3, 2, 3)
      would match an entry with key 323.
    - Whenever a sublist matches an entry of the map, it’s replaced by the entry value.
      When that happens, the sublist is consumed, meaning that its elements can’t be used
      for another match. The elements of the mapping however, can be used as many times as needed.
    - If there are two possible sublist matches, starting at the same point, the longest one
      has priority, eg 234 would have priority over 23.
    - If a digit does not belong to any matching sublist, it’s output as is.

   Following the above rules, the message would be: “1N73N7 HQ”
   Check the tests for some other (simpler) examples.
 */

object StringSubstitution {
  def subs(encodedMsg: List[Int], subMap: Map[Int, Char]): String = {
    val str = encodedMsg.mkString
    subRecur(str.head.toString, str.tail, subMap)
  }

  @tailrec
  private def subRecur(currentStr: String, remainingStr: String, subs: Map[Int, Char]): String = {
    (currentStr, remainingStr) match {/*case (current, remaining) if current.length < 2 =>
        subRecur(current + remaining.head, remaining.tail, subs)*/
      case (current, remaining) if findSubInStr(current, subs).nonEmpty =>
        val tupleData = findSubInStr(current, subs).head
        val transformedResult = current.substring(0, tupleData._1) + tupleData._3
        subRecur(transformedResult, remaining, subs)
      case (_, remaining) if remaining.isEmpty =>
        currentStr
      case (current, remaining) =>
        subRecur(current + remaining.head, remaining.tail, subs)
    }
  }

  def findSubInStr(str: String, subs: Map[Int, Char]): Option[(Int, Int, Char)] = {
    subs.keys.map { keyInt =>
      val key = keyInt.toString
      val keyIndex = str.indexOf(key)
      (keyIndex, keyIndex + key.length, subs.get(keyInt).head)
    }.find { case (index, _, _) => index >= 0 }
  }


}
