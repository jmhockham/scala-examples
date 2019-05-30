package guardian_tests

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object BlackJackExample {

  val rnd = new scala.util.Random



}

class Deck {

  val rnd = new scala.util.Random
  var cards: ListBuffer[Card] = populateDeck
  val uniqueCards = mutable.Set.empty

  def populateDeck: ListBuffer[Card] = {
    val numSeq = 1 to 13
    val suites = Seq("Spades","Clubs","Diamonds","Hearts")
    val cards: Seq[Card] = for {
      number <- numSeq
      suites <- suites
    } yield Card(suites, number)
    cards.to[ListBuffer]
  }

  def drawCard: Card = {
    val index = rnd.nextInt(cards.size)
    val card = cards(index)
    cards = cards.filterNot(_==card)
    card
  }


}

case class Card (suite: String, value: Int)
