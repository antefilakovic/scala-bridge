package dev.afilakovic.models

import dev.afilakovic.Constants

class Deck() {
  private var cards: List[Card] = Deck.createDeck()

  def shuffle(): Unit = cards = Deck.shuffle(cards)

  def deal() : List[Hand] = cards.grouped(13).map(new Hand(_)).toList

}

object Deck {
  private def createDeck(): List[Card] = (for (suit <- Constants.SUITS; denomination <- Constants.DENOMINATIONS_AND_VALUES.keys) yield Card(suit, denomination)).toList

  private def shuffle(cards: List[Card]) = util.Random.shuffle(cards)
}
