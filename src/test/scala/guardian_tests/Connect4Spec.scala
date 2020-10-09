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
    val game = new Connect4()
    game.addToken(1,1, Red)
    game.addToken(1,2, Red)
    game.addToken(1,3, Red)
    game.checkVertical(Token(1,1,Red)) shouldBe false

    game.addToken(1,4, Red)
    game.checkVertical(Token(1,1,Red)) shouldBe true
  }

  it should "checkHorizontal" in {
    val game = new Connect4()
    game.addToken(1,1, Red)
    game.addToken(2,1, Red)
    game.addToken(3,1, Red)
    game.checkHorizontal(Token(1,1,Red)) shouldBe false

    game.addToken(4,1, Red)
    game.checkHorizontal(Token(1,1,Red)) shouldBe true
  }

  it should "checkDiagonal" in {

  }

}
