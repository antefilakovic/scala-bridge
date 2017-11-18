package dev.afilakovic

import dev.afilakovic.models.Deck

object Main extends App {
  val deck = new Deck()

  deck.shuffle()

  var hands = deck.deal()

  hands.foreach(hand => println(s"${hand.cards} -> ${hand.value()}"))
}
