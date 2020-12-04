package interviewtests
/*
Given an array of integers, return a new array such that each element at index i of the new array is the product of all
the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
object MulitiplesIteration extends App {

  def multiplesOfIndexes(intList: List[Int]): List[Int] = {
    intList.map { i =>
      intList.filterNot(number => number == i).reduceLeft(_*_)
    }
  }

  println(multiplesOfIndexes(List(1,2,3,4,5)).mkString(", "))
  println(multiplesOfIndexes(List(3,2,1)).mkString(", "))

}
