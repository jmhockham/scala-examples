package guardian_tests

import org.scalatest.{FlatSpec, Matchers}

class BlackJackExampleSpec extends FlatSpec with Matchers {

  "populateDeck" should "create a deck of cards" in {

  }

  "removeCard" should "remove a card from a deck" in {
    val deck = List(Card("Hearts",1),Card("Spades",1))
    new DeckHandler(deck).removeCardFromDeck(Card("Hearts",1)) shouldBe List(Card("Spades",1))
  }

  it should "return an un-altered deck if the card doesn't exist" in {
    val deck = List(Card("Hearts",1),Card("Spades",1))
    new DeckHandler(deck).removeCardFromDeck(Card("Clubs",1)) shouldBe deck
  }

  "drawCard" should "draw a random card from a populated deck" in {

  }

}
