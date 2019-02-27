import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object BlackJackExample {



  val rnd = new scala.util.Random
  val start = 1
  val end   = 21

//  getNumber

  private def getNumber = {
    start + rnd.nextInt((end - start) + 1)
  }



}

class Deck {

  val rnd = new scala.util.Random
  var cards: ListBuffer[Card] = populateDeck

  def populateDeck: ListBuffer[Card] = {
    val numSeq = 1 to 13
    val suites = Seq("Spades","Clubs","Diamonds","Hearts")
    val cards: Seq[Card] = for {
      number <- numSeq
      suites <- suites
    } yield Card(suites, number)
    cards.toList
  }

  def drawCard: Card = {
    val index = rnd.nextInt(cards.size)
    val card = cards(index)
    cards = cards.filterNot(_==card)
    card
  }


}

case class Card (suite: String, value: Int)