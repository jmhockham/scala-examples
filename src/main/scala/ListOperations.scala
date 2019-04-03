import scala.collection.immutable

object ListOperations extends App {

  private val testList = List("a", "a", "h")
  private val diffList: List[String] = testList diff List("a")
  println(s"diff: $diffList")

  private val intersectList: List[String] = testList intersect List("a", "a", "x")
  println(s"intersect: $intersectList")

  private val fourThrees = List.fill(4)(3)
  private val total: Int = fourThrees reduceLeft ((prevTotal, nextNumber) => prevTotal + nextNumber)
  println(s"reduceLeft: $total")

  private val totalFoldded: Int = fourThrees.foldLeft(10)((prevTotal, nextNumber) => prevTotal + nextNumber)
  println(s"foldLeft: $totalFoldded")

  println("droped letter: " + testList.drop(1))

  private val grid: List[List[Int]] = List.fill(6)(List(4))

  val ints = 1 to 4

  private val factorFourList: List[Int] = (
      for {
        a <- ints
      } yield a * 4
    ).toList

  println("list of fours: "+factorFourList)

  val mixedList: List[Any] = factorFourList ++ "four"
  private val sanitizedList: List[Int] = factorFourList.collect {
    case i: Int if i == 4 => i
  }
  println("sanitizedList: " + sanitizedList)


}
