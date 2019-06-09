package guardian_tests

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object BlackJackExample {


}

class DeckHandler(cards: List[Card] = DeckHandler.populateDeck) {

  val rnd = new scala.util.Random
  val uniqueCards = mutable.Set.empty

  def removeCardFromDeck(cardToRemove: Card) = {
    cards.filterNot(_==cardToRemove)
  }

  def drawCard(deckOfCards: List[Card]): Card = {
    val index = rnd.nextInt(cards.size)
    val card = cards(index)
//    cards = cards.filterNot(_==card)
    card
  }

}

object DeckHandler {
  def populateDeck: List[Card] = {
    val numSeq = 1 to 13
    val suites = Seq("Spades","Clubs","Diamonds","Hearts")
    val cards: Seq[Card] = for {
      number <- numSeq
      suites <- suites
    } yield Card(suites, number)
    cards.toList
  }
}

case class Card (suite: String, value: Int)
