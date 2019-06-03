import java.io

import scala.collection.immutable

/**
  * Dumping ground for testing for loops
  */
object ForTesting extends App {

  //declaring ranges
  val xValues = 1 to 4
  val yValues = 1 to 2

  //creating tuples from the previous ranges
  private val tuples: Seq[(Int, Int)] = for {
    x <- xValues
    y <- yValues
  } yield (x, y)

  //Vector((1,1), (1,2), (2,1), (2,2), (3,1), (3,2), (4,1), (4,2))
  println(tuples)

  //using a find/case block to retrieve a tuple (an option as it may not find anything)
  private val maybeTuple = tuples.find { case (a, b) => a >= 4 }
  //use getOrElse on the option to return a tuple/default
  private val tupleTest: (Int, Int) = maybeTuple.getOrElse((0,0))
  //turning the seq of tuples into a seq of options
  private val seqOpt: Seq[Option[Int]] = for {
    x <- xValues
    opt <- Some(x)
  } yield Some(opt)

  //declare a seq with options, also containing a null
  val seqOptWithNone: Seq[Option[Int]] = seqOpt ++ Seq(None)

  //flatmap over the seq options, returning a seq of ints, and having it sorted
  val seqOpt2: Seq[Int] = seqOptWithNone.flatMap { x =>
    val i = x.getOrElse(0)
    Some(i)
  }.sorted
//  }.sortWith((first,second) => first<second)

  //declare a seq of mixed types, containing option[int]
  private val seqMixed: Seq[Any] = Seq("", Some(132), "", None)
  //from the mixed seq, get a seq of ints (from the options)
  val seqStuff: Seq[Int] = seqMixed.collect {
    case Some(x:Int) => x
  }

  println(s"seqOpt: ${seqOpt.mkString(",")}")
  println(s"seqOpt2: ${seqOpt2.mkString(",")}")
  println(s"seqOptWithNone: ${seqOptWithNone.mkString(",")}")

  //from the tuples, create a list from one value in the tuple (the "left" in this case)
  val nums: List[Int] = tuples.flatMap{ case (xValue, yValue) =>
    List(xValue)
  }.distinct.toList
//  val nums = List(List(1), List(2), List(3), List(4), List(5))

  val result = for {
    num ← nums
    if num % 2 == 0
    if num > 1
  } yield num

//  result shouldBe List(2, 4)
  println(result)

  //create a seq[list[int]] from the list[int]
  val seqListNums = Seq(nums)
  // flatMap (although it's unnecesary) over the collection, filter out odd numbers, and return a list
  private val lintIntOne: List[Int] = seqListNums.flatMap(numList ⇒ numList).filter(_ % 2 == 0).toList
  println(lintIntOne) //should be(result)

  // same again, but just using the flatten function
  private val listIntsTwo: List[Int] = seqListNums.flatten.filter(_ % 2 == 0).toList
  println(listIntsTwo) //should be(result)
}
