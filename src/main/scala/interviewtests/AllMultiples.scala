package interviewtests

//print multiplication tables up til the number provided
object AllMultiples extends App {

  def numbersForAMultiple(multiple: Int) = {
    for(i <- 1 to 12) yield i * multiple
  }

  def loopThroughMultiples(upperLimit: Int) = {
    for(i <- 1 to upperLimit) yield numbersForAMultiple(i)
  }

  def doAllMultiples(upperLimit: Int) = {
    for {
      multiple <- 1 to upperLimit
      number <- 1 to 12
    } yield multiple * number
  }

  println(loopThroughMultiples(4))
  println(doAllMultiples(4))
}
