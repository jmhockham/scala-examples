package interviewtests

import scala.annotation.tailrec

/*
Write a function that takes a list and an integer and returns a list with up to the n-th element in the list.
 In case of the integer being bigger than the size of the list, return the original list.
For example:
take(["apple", "pear", "lemon", "orange"], 2)
# ["apple", "pear"]

Imagine the list was circular. So in the above example, apple would follow orange:
take(["apple", "pear", "lemon", "orange"], 5)
# ["apple", "pear", "lemon", "orange", "apple"]
 */
object OvoTest extends App {

  @tailrec
  def takeStuff(strList: List[String], limit: Int, results: List[String] = List.empty, index: Int = 0): List[String] = {

    val indexUpd = if(index>=strList.size) 0 else index

    if(results.size>=limit){
      results
    } else {
      takeStuff(strList, limit, results ++ List(strList(indexUpd)),indexUpd+1)
    }

  }

  def takeStuffIter(strList: List[String], limit: Int) = {
    var sb:List[String] = List.empty
    var index = -1
    var count = 0
    while(count<=strList.size){
      index = if(index>=strList.size-1) 0 else index+1
      val str = strList(index);
      sb = sb ++ List(str)
      count = count+1
    }
    sb
  }

  println(takeStuff(List("apple", "pear", "lemon", "orange"),5))
  println(takeStuffIter(List("apple", "pear", "lemon", "orange"),5))

}

/*
Original code, warts and all. Had to write this in a rush, hence why it's rubbish

object OvoTestMain extends App {

  @tailrec
  def recurLoop(strList: List[String], limit: Int, results: List[String] = List.empty, index: Int= -1): List[String] = {

    val updatedIndex = if(index >1 && index>=strList.size-1) 0 else index +1

    if(results.size>=limit){
      results
    }
    else {
      val str = strList(updatedIndex)
      recurLoop(strList, limit, results ++ List(str), updatedIndex)
    }
  }

  println(recurLoop(List("apple", "pear", "lemon", "orange"),5).mkString(", "))

}

 */
