import scala.collection.immutable.HashMap
import scala.collection.mutable

/**
  * Dumping ground for collections testing
  */

object CollectionsTesting extends App {

  //doing a diff
  private val testList = List("a", "a", "h")
  private val diffList: List[String] = testList diff List("x","a")
  println(s"diff: $diffList")

  //doing an intersect
  private val intersectList: List[String] = testList intersect List("a", "a", "x")
  println(s"intersect: $intersectList")

  //filling a list
  private val fourThrees = List.fill(4)(3)

  //reduceLeft
  private val total: Int = fourThrees reduceLeft ((prevTotal, nextNumber) => prevTotal + nextNumber)
  println(s"reduceLeft: $total")

  //reduce is MOSTLY the same as reduceLeft, except the order is unspecified (depends on the collection)
  private val totalReduced = fourThrees reduce ((prevTotal, nextNumber) => prevTotal + nextNumber)
  println(s"reduce: $totalReduced")

  //foldLeft
  private val totalFolded: Int = fourThrees.foldLeft(10)((prevTotal, nextNumber) => prevTotal + nextNumber)
  println(s"foldLeft: $totalFolded")

  //dropping something
  println("droped letter: " + testList.drop(1))

  //filling a matrix/grid
  private val grid: List[List[Int]] = List.fill(6)(List(4))

  //creating a range
  val ints = 1 to 4

  //using yield with a range
  private val factorFourList: List[Int] = (
    for {
      a <- ints
    } yield a * 4
  ).toList

  println("list of fours: " + factorFourList)

  //using collect
  val mixedList: List[Any] = factorFourList ++ "four"
  private val sanitizedList: List[Int] = mixedList.collect {
    case i: Int if i == 4 => i
  }
  println("sanitizedList: " + sanitizedList)


  val setOne: Set[String] = Set("1", "2", "3")
  val setTwo: Set[String] = Set("2", "4", "6")
  val setThree: Set[String] = Set("8", "4", "2")

  //multiple intersects on several sets
  private val setCommonElems: Set[String] = setOne intersect setTwo intersect setThree
  //we get Set("2")
  println(s"setCommonElems ${setCommonElems.mkString(",")}")

  //retain with a set (only for mutable as it modifies existing collection; use filter or intersect for immutable)
  val setMutable: mutable.Set[String] = mutable.Set("1", "2", "3")
  setMutable.retain(setTwo.contains)
  println(s"setMutable ${setMutable.mkString(",")}")

  //and the immutable filter & intersect versions
  val setImmutable: Set[String] = Set("1","2","3")
  val setImmFiltered = setImmutable.filter(setThree.contains)
  val setImmIntersect = setImmutable.intersect(setThree)
  println(s"setImmFiltered ${setImmFiltered.mkString(",")}")
  println(s"setImmIntersect ${setImmIntersect.mkString(",")}")

  //check which elems are in all sets
  val firstSet = setOne
  val otherSets = List(setTwo, setThree)
  private val elemsInAllSets: Set[String] = otherSets.flatMap(x => x.intersect(firstSet)).toSet
  println(s"elemsInAllSets ${elemsInAllSets.mkString(",")}")

  //do a count of the number of entries for each of the three sets (uses mutable)
  private val seqSets: Seq[Set[String]] = Seq(setOne, setTwo, setThree)
  val mapCounts = new mutable.HashMap[String, Int]()
  seqSets.flatten.map { elem =>
      val count = mapCounts.getOrElseUpdate(elem, 0)
      mapCounts.put(elem, count + 1)
  }
  println(s"mapCounts ${mapCounts.mkString(",")}")

  //do a count of elems for the previous sets, but immutable
  private val countsOfElems: Map[String, Int] = HashMap(
    {
      for {
        s <- seqSets
        elem <- s
      } yield {
        val noOfEntries = seqSets.map(s => s.count(_ == elem)).reduceLeft((currentNum, nextNum) => currentNum + nextNum)
        elem -> noOfEntries
      }
    }: _*)
  println(s"countsOfElems: ${countsOfElems.mkString(",")}")

  val listOptions: List[Option[Int]] = List(Some(1), None, Some(2))
  //can just flatten to get rid of option wrapper (somes/nones) in a collection
  val noOptList: List[Int] = listOptions.flatten.map { x => x+1 }
  //flatMap maps THEN flattens, so it's better if you want to fiddle with internals/wrappers first
  val noOptList2: List[Int] = listOptions.flatMap{ option =>
      option match {
        case Some(number: Int) => Some(number+1)
        case None => None
      }
  }
  println("noOptList: "+noOptList.mkString(","))
  println("noOptList2: "+noOptList2.mkString(","))

  //print duplicates in a list with their count
  //example input: List(1,1,1,2,3,4,5,5,6,100,101,101,102) Should print: List((1,3), (5,2), (101,2))
  //https://stackoverflow.com/questions/42029053/scala-collect-function

  def listDuplicates(listContainingDupes: List[Int]): List[(Int,Int)] = {
    listContainingDupes.groupBy(identity)
      .collect{ case(number, listOfDuplicates) if listOfDuplicates.size>=2 => (number, listOfDuplicates.size) }
      .toList
      .sortBy(_._1)
  }

  println(s"listDuplicates: ${listDuplicates(List(1,1,1,2,3,4,5,5,6,100,101,101,102))}")

}
