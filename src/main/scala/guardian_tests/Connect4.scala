package guardian_tests

import scala.annotation.tailrec
import scala.collection.mutable

class Connect4(xAxisLength: Int = 6, yAxisLength: Int = 6, winningLineLength: Int = 4) {

  var allTokens: mutable.ListBuffer[Token] = mutable.ListBuffer.empty[Token]

  def addTokenAnywhere(xPos: Int, yPos: Int, colour: Colour): mutable.ListBuffer[Token] = {
    val tokenExists = allTokens.contains(Token(xPos,yPos,colour))
    if(!tokenExists){
      allTokens += Token(xPos,yPos,colour)
    }
    else {
      allTokens
    }
  }

  /**
    * Adds a token to the vertical game board. "Gravity" causes the token to drop to the lowest possible y axis
    * @param xPos the x axis that we're adding the token
    * @param colour the colour of the token
    * @return the list of all tokens. Will be +1 if the addition was successful
    */
  def addToken(xPos: Int, colour: Colour): mutable.ListBuffer[Token] = {
    //find all the tokens at this X axis
    if(0 to xAxisLength contains xPos){
      val existingTokens = allTokens.filter(t => t.x == xPos)
      //get the next available yPos
      val nextYPos = if (existingTokens.nonEmpty) existingTokens.maxBy(_.y).y + 1 else 1
      if(0 to yAxisLength contains nextYPos){
        addTokenAnywhere(xPos, nextYPos, colour)
      }
      else{
        allTokens
      }
    }
    else{
      allTokens
    }
  }

  /**
    * Function to check if there's a win condition or not
    * @return a boolean denoting if any of the tokens have 4 of the same colour in a line
    */
  def checkWin(): Boolean = {
    allTokens.exists(checkWin)
  }

  /**
    * Convenience function; checks all the winning conditions for a given token
    * @param t - the token to check
    * @return a boolean denoting whether there's a win condition
    */
  def checkWin(t: Token): Boolean = {
    checkVertical(t) || checkHorizontal(t) || checkDiagonal(t)
  }

  /**
    * Given a position, see if the vertical (up/down) cells match the colour
    * @param token the token to check
    * @return a boolean denoting whether or not there are [winningLineLength] same-colour tokens in a vertical line
    */
  def checkVertical(token: Token): Boolean = {
    val tokenExists = allTokens.contains(token)
    if(!tokenExists){
      false
    }
    else {
      //we -1 on the counts, so that we don't count the current token
      val downCount = countContiguousCells(None,Some(true),0,token) -1
      val upCount = countContiguousCells(None,Some(false),0,token) -1
      (1 + upCount + downCount) >= winningLineLength
    }
  }

  /**
    * Given a position, see if the horizontal cells match the colour
    * @param token the token to check
    * @return a boolean denoting whether or not there are [winningLineLength] same-colour tokens in a horizontal line
    */
  def checkHorizontal(token: Token): Boolean = {
    val tokenExists = allTokens.contains(token)
    if(!tokenExists){
      false
    }
    else {
      //we -1 on the counts, so that we don't count the current token
      val leftCount = countContiguousCells(Some(true),None,0,token) -1
      val rightCount = countContiguousCells(Some(false),None,0,token) -1
      (1 + leftCount + rightCount) >= winningLineLength
    }
  }

  /**
    * Given a position, check the diagonal cells match the colour
    * @param token - the token to check
    * @return a boolean denoting whether or not there are [winningLineLength] same-colour tokens in a diagonal line
    */
  def checkDiagonal(token: Token): Boolean = {
    val tokenExists = allTokens.contains(token)
    if(!tokenExists){
      false
    }
    else{
      //we -1 on the counts, so that we don't count the current token
      val downLeftCount = countContiguousCells(Some(true),Some(true),0,token) -1
      val upLeftCount = countContiguousCells(Some(true),Some(false),0,token) -1
      val downRightCount = countContiguousCells(Some(false),Some(true),0,token) -1
      val upRightCount = countContiguousCells(Some(false),Some(false),0,token) -1
      (1 + downLeftCount + upLeftCount + downRightCount + upRightCount) >= winningLineLength
    }
  }

  @tailrec
  private final def countContiguousCells(decrementXPos: Option[Boolean], decrementYPos: Option[Boolean], currentCount: Int, token: Token): Int = {
    val tokenExists = allTokens.contains(token)
    if (!tokenExists) {
      currentCount
    }
    else{
      val newXPos = decrementXPos match {
        case Some(true) => token.x-1
        case Some(false) => token.x+1
        case None => token.x
      }
      val newYPos = decrementYPos match {
        case Some(true) => token.y-1
        case Some(false) => token.y+1
        case None => token.y
      }
      val nextPotentialToken = Token(newXPos,newYPos,token.colour)
      countContiguousCells(decrementXPos, decrementYPos, currentCount+1, nextPotentialToken)
    }
  }

}

object Connect4 extends App {
  /*
  val t = Token(1,1,Yellow)

  val allTokens = List(t)

  allTokens.foreach {
    case Token(_, _, Yellow) => println("found a yellow")
    case Token(_, _, Red) => println("found a red")
    case _ => throw new UnexpectedException("No red/yellow tokens in the list!")
  }
  */
}

trait Colour
object Red extends Colour
object Yellow extends Colour

case class Token(x: Int, y: Int, colour: Colour)
