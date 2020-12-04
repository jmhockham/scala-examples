package interviewtests

import scala.collection.immutable.HashSet

/*

    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

    Bonus: Can you do this in one pass?
    ^ Apparently: "Putting elements to HashSet and looking up for K-element... It will make O(N) solution."

 */
object CombinationsIteration extends App {

  def combinationsAddUpTo(intList: List[Int], numberToCheck: Int) = {
    intList.combinations(2).filter(x => x.reduce(_+_) == numberToCheck)
  }

  println(combinationsAddUpTo(List(10,15,3,7),17).mkString(","))

}
