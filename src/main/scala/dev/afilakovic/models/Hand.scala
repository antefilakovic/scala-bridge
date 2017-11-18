package dev.afilakovic.models

import dev.afilakovic.Constants

class Hand(val cards: List[Card]) {
  def value(): Int = cards.map(card => Constants.denominationsAndValues.getOrElse(card.denomination, 0)).sum
}
