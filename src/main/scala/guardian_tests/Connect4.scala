package guardian_tests

import java.rmi.UnexpectedException

object Connect4 extends App {

  private val columns = 6
  private val rows = 7
  private val grid: List[List[Int]] = List.fill(columns)(List(rows))

  val t = Token(1,1,Yellow)

  List(t).foreach {
    case Token(_, _, Yellow) => println("found a yellow")
    case Token(_, _, Red) => println("found a red")
    case _ => throw new UnexpectedException("No red/yellow tokens in the list!")
  }

  def checkVertical() = {

  }

  def checkHorizontal() = {

  }

  def checkDiagonal() = {

  }

}

trait Colour
object Red extends Colour
object Yellow extends Colour

case class Token(x: Int, y: Int, colour: Colour)
