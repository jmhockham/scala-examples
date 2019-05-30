import java.io

/**
  * Dumping ground for testing for loops
  */
object ForTesting extends App {

  val xValues = 1 to 4
  val yValues = 1 to 2

  private val tuples: Seq[(Int, Int)] = for {
    x <- xValues
    y <- yValues
  } yield (x, y)

  //Vector((1,1), (1,2), (2,1), (2,2), (3,1), (3,2), (4,1), (4,2))
  println(tuples)

  private val maybeTuple = tuples.find { case (a, b) => a >= 4 }
  private val tupleTest: (Int, Int) = maybeTuple.getOrElse((0,0))
  private val seqOpt: Seq[Option[Int]] = for {
    x <- xValues
    opt <- Some(x)
  } yield Some(opt)

  val seqOptWithNone: Seq[Option[Int]] = seqOpt ++ Seq(None)

  val seqOpt2: Seq[Int] = seqOptWithNone.flatMap { x =>
    val i = x.getOrElse(0)
    Some(i)
  }.sorted
//  }.sortWith((first,second) => first<second)

  private val seqMixed: Seq[Any] = Seq("", Some(132), "", None)
  val seqStuff: Seq[Int] = seqMixed.collect {
    case Some(x:Int) => x
  }

  println(s"seqOpt: ${seqOpt.mkString(",")}")
  println(s"seqOpt2: ${seqOpt2.mkString(",")}")
  println(s"seqOptWithNone: ${seqOptWithNone.mkString(",")}")

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
