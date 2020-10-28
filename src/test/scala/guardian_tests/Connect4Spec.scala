package guardian_tests

import org.scalatest.{FlatSpec, Matchers}

class Connect4Spec extends FlatSpec with Matchers {

  behavior of "Connect4Spec"

  it should "addToken" in {
    val game = new Connect4()
    game.addToken(1,1, Red)
    game.addToken(1,2, Yellow)
    game.addToken(1,3, Red)
    game.addToken(1,4, Red)
    game.allTokens.size shouldBe 4
    game.allTokens.head shouldBe Token(1,1,Red)
    game.allTokens(1) shouldBe Token(1,2,Yellow)
  }

  it should "checkVertical" in {
    //check going up
    val game = new Connect4()
    game.addToken(1,1, Red)
    game.addToken(1,2, Red)
    game.addToken(1,3, Red)
    game.checkVertical(Token(1,1,Red)) shouldBe false

    game.addToken(1,4, Red)
    game.checkVertical(Token(1,1,Red)) shouldBe true

    //check going down
    val game2 = new Connect4()
    game2.addToken(1,4, Red)
    game2.addToken(1,3, Red)
    game2.addToken(1,2, Red)
    game2.checkVertical(Token(1,4,Red)) shouldBe false

    game2.addToken(1,1, Red)
    game2.checkVertical(Token(1,4,Red)) shouldBe true
  }

  it should "checkHorizontal" in {
    //check going right
    val game = new Connect4()
    game.addToken(1,1, Red)
    game.addToken(2,1, Red)
    game.addToken(3,1, Red)
    game.checkHorizontal(Token(1,1,Red)) shouldBe false

    game.addToken(4,1, Red)
    game.checkHorizontal(Token(1,1,Red)) shouldBe true

    //check going left
    val game2 = new Connect4()
    game2.addToken(4,1, Red)
    game2.addToken(3,1, Red)
    game2.addToken(2,1, Red)
    game2.checkHorizontal(Token(4,1,Red)) shouldBe false

    game2.addToken(1,1, Red)
    game2.checkHorizontal(Token(1,1,Red)) shouldBe true
  }

  it should "checkDiagonal" in {
    //check bot left to top right
    val game = new Connect4()
    game.addToken(1,1, Red)
    game.addToken(2,2, Red)
    game.addToken(3,3, Red)
    game.checkDiagonal(Token(1,1,Red)) shouldBe false

    game.addToken(4,4, Red)
    game.checkDiagonal(Token(1,1,Red)) shouldBe true

    //check top left to bot right
    val game2 = new Connect4()
    game2.addToken(1,4, Red)
    game2.addToken(2,3, Red)
    game2.addToken(3,2, Red)
    game2.checkDiagonal(Token(1,4,Red)) shouldBe false

    game2.addToken(4,1, Red)
    game2.checkDiagonal(Token(1,4,Red)) shouldBe true

    //check bot right to top left
    val game3 = new Connect4()
    game3.addToken(4,1, Red)
    game3.addToken(3,2, Red)
    game3.addToken(2,3, Red)
    game3.checkDiagonal(Token(4,1,Red)) shouldBe false

    game3.addToken(1,4, Red)
    game3.checkDiagonal(Token(4,1,Red)) shouldBe true

    //check top right to bot left
    val game4 = new Connect4()
    game4.addToken(4,4, Red)
    game4.addToken(3,3, Red)
    game4.addToken(2,2, Red)
    game4.checkDiagonal(Token(1,1,Red)) shouldBe false

    game4.addToken(1,1, Red)
    game4.checkDiagonal(Token(4,4,Red)) shouldBe true
  }

  it should "checkWin" in {
    //check going up
    val game = new Connect4()
    game.addToken(1,1, Red)
    game.addToken(1,2, Red)
    game.addToken(1,3, Red)
    game.checkWin(Token(1,1,Red)) shouldBe false

    game.addToken(1,4, Red)
    game.checkWin(Token(1,1,Red)) shouldBe true

    //check going left
    val game2 = new Connect4()
    game2.addToken(4,1, Red)
    game2.addToken(3,1, Red)
    game2.addToken(2,1, Red)
    game2.checkWin(Token(4,1,Red)) shouldBe false

    game2.addToken(1,1, Red)
    game2.checkWin(Token(1,1,Red)) shouldBe true

    //check bot right to top left
    val game3 = new Connect4()
    game3.addToken(4,1, Red)
    game3.addToken(3,2, Red)
    game3.addToken(2,3, Red)
    game3.checkWin(Token(4,1,Red)) shouldBe false

    game3.addToken(1,4, Red)
    game3.checkWin(Token(4,1,Red)) shouldBe true
  }

}
