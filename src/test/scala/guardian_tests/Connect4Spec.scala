package guardian_tests

import org.scalatest.{FlatSpec, Matchers}

class Connect4Spec extends FlatSpec with Matchers {

  behavior of "Connect4Spec"

  it should "addToken" in {
    val game = new Connect4()
    game.addTokenAnywhere(1,1, Red).size shouldBe 1
    game.addTokenAnywhere(1,2, Yellow).size shouldBe 2
    game.addTokenAnywhere(1,3, Red).size shouldBe 3
    game.addTokenAnywhere(1,4, Red).size shouldBe 4
    game.allTokens shouldBe List(Token(1, 1, Red), Token(1, 2, Yellow), Token(1, 3, Red), Token(1, 4, Red))
  }

  it should "checkVertical" in {
    //check going up
    val game = new Connect4()
    game.addTokenAnywhere(1,1, Red)
    game.addTokenAnywhere(1,2, Red)
    game.addTokenAnywhere(1,3, Red)
    game.checkVertical(Token(1,1,Red)) shouldBe false

    game.addTokenAnywhere(1,4, Red)
    game.checkVertical(Token(1,1,Red)) shouldBe true

    //check going down
    val game2 = new Connect4()
    game2.addTokenAnywhere(1,4, Red)
    game2.addTokenAnywhere(1,3, Red)
    game2.addTokenAnywhere(1,2, Red)
    game2.checkVertical(Token(1,4,Red)) shouldBe false

    game2.addTokenAnywhere(1,1, Red)
    game2.checkVertical(Token(1,4,Red)) shouldBe true
  }

  it should "checkHorizontal" in {
    //check going right
    val game = new Connect4()
    game.addTokenAnywhere(1,1, Red)
    game.addTokenAnywhere(2,1, Red)
    game.addTokenAnywhere(3,1, Red)
    game.checkHorizontal(Token(1,1,Red)) shouldBe false

    game.addTokenAnywhere(4,1, Red)
    game.checkHorizontal(Token(1,1,Red)) shouldBe true

    //check going left
    val game2 = new Connect4()
    game2.addTokenAnywhere(4,1, Red)
    game2.addTokenAnywhere(3,1, Red)
    game2.addTokenAnywhere(2,1, Red)
    game2.checkHorizontal(Token(4,1,Red)) shouldBe false

    game2.addTokenAnywhere(1,1, Red)
    game2.checkHorizontal(Token(1,1,Red)) shouldBe true
  }

  it should "checkDiagonal" in {
    //check bot left to top right
    val game = new Connect4()
    game.addTokenAnywhere(1,1, Red)
    game.addTokenAnywhere(2,2, Red)
    game.addTokenAnywhere(3,3, Red)
    game.checkDiagonal(Token(1,1,Red)) shouldBe false

    game.addTokenAnywhere(4,4, Red)
    game.checkDiagonal(Token(1,1,Red)) shouldBe true

    //check top left to bot right
    val game2 = new Connect4()
    game2.addTokenAnywhere(1,4, Red)
    game2.addTokenAnywhere(2,3, Red)
    game2.addTokenAnywhere(3,2, Red)
    game2.checkDiagonal(Token(1,4,Red)) shouldBe false

    game2.addTokenAnywhere(4,1, Red)
    game2.checkDiagonal(Token(1,4,Red)) shouldBe true

    //check bot right to top left
    val game3 = new Connect4()
    game3.addTokenAnywhere(4,1, Red)
    game3.addTokenAnywhere(3,2, Red)
    game3.addTokenAnywhere(2,3, Red)
    game3.checkDiagonal(Token(4,1,Red)) shouldBe false

    game3.addTokenAnywhere(1,4, Red)
    game3.checkDiagonal(Token(4,1,Red)) shouldBe true

    //check top right to bot left
    val game4 = new Connect4()
    game4.addTokenAnywhere(4,4, Red)
    game4.addTokenAnywhere(3,3, Red)
    game4.addTokenAnywhere(2,2, Red)
    game4.checkDiagonal(Token(1,1,Red)) shouldBe false

    game4.addTokenAnywhere(1,1, Red)
    game4.checkDiagonal(Token(4,4,Red)) shouldBe true
  }

  it should "checkWin" in {
    //check going up
    val game = new Connect4()
    game.addTokenAnywhere(1,1, Red)
    game.addTokenAnywhere(1,2, Red)
    game.addTokenAnywhere(1,3, Red)
    game.checkWin shouldBe false

    game.addTokenAnywhere(1,4, Red)
    game.checkWin shouldBe true

    //check going left
    val game2 = new Connect4()
    game2.addTokenAnywhere(4,1, Red)
    game2.addTokenAnywhere(3,1, Red)
    game2.addTokenAnywhere(2,1, Red)
    game2.checkWin shouldBe false

    game2.addTokenAnywhere(1,1, Red)
    game2.checkWin shouldBe true

    //check bot right to top left
    val game3 = new Connect4()
    game3.addTokenAnywhere(4,1, Red)
    game3.addTokenAnywhere(3,2, Red)
    game3.addTokenAnywhere(2,3, Red)
    game3.checkWin shouldBe false

    game3.addTokenAnywhere(1,4, Red)
    game3.checkWin shouldBe true
  }

  it should "addToken using gravity (tokens 'fall down' when slotted in)" in {
    val game = new Connect4()
    game.addToken(1, Red)
    game.addToken(1, Red).size shouldBe 2
    game.addToken(1, Red)
    game.addToken(1, Red).size shouldBe 4
    game.checkWin shouldBe true

    game.allTokens shouldBe List(Token(1, 1, Red), Token(1, 2, Red), Token(1, 3, Red), Token(1, 4, Red))

    game.addToken(3, Yellow)
    game.allTokens shouldBe List(Token(1, 1, Red), Token(1, 2, Red), Token(1, 3, Red), Token(1, 4, Red), Token(3, 1, Yellow))
  }

}
