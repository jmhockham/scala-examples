package guardian_tests

import scala.io.StdIn

object GameOfLife extends App {

  awaitInput

  @scala.annotation.tailrec
  def awaitInput: Unit = {
    println("type q to quit")
    val input: String = StdIn.readLine()
    if (input == "q"){
      println("quitting")
    }
    else {
      awaitInput
    }
  }

}
