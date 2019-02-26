import scala.collection.immutable

object ForTesting extends App {

  val xValues = 1 to 4
  val yValues = 1 to 2

  private val tuples: immutable.IndexedSeq[(Int, Int)] = for {
    x <- xValues
    y <- yValues
  } yield (x, y)

  //Vector((1,1), (1,2), (2,1), (2,2), (3,1), (3,2), (4,1), (4,2))
  println(tuples)

  val nums = tuples.map{ case (xValue, yValue) =>
    List(xValue)
  }.distinct.toList
//  val nums = List(List(1), List(2), List(3), List(4), List(5))

  val result = for {
    numList ← nums
    num ← numList
    if num % 2 == 0
    if num > 1
  } yield num

//  result shouldBe List(2, 4)
  println(result)

  // Which is the same as
  private val lintIntOne: List[Int] = nums.flatMap(numList ⇒ numList).filter(_ % 2 == 0)
  println(lintIntOne) //should be(result)

  // or the same as
  private val listIntsTwo: List[Int] = nums.flatten.filter(_ % 2 == 0)
  println(listIntsTwo) //should be(result)
}
