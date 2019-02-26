object IterExamples extends App {

  println("doSliding(getList sliding 3)")
  doSliding(getList sliding 3)
  println("doSliding(getList sliding(3,3))")
  doSliding(getList sliding(3,3))
  println("doSlidingFunc(getList sliding)")
  doSlidingFunc(getList sliding)

  private def doSlidingExample1(): Unit = {
    val list = getList
    val it = list sliding 3
    println(it.next())
    println(it.next())
    println(it.next())
  }

  private def doSlidingExample2 = {
    val list = getList
    val it: Iterator[List[Int]] = list sliding(3,3)
    println(it.next())
    println(it.next())
    println(it.next())
  }

  private def doSliding(it: Iterator[List[Int]]): Unit = {
    println(it.next())
    println(it.next())
    println(it.next())
  }

  def doSlidingFunc(f:(Int)=>Iterator[List[Int]]) = {
    val it = f(3)
    println(it.next())
    println(it.next())
    println(it.next())
  }

  private def getList = {
    List(3, 5, 9, 11, 15, 19, 21, 24, 32)
  }
}
