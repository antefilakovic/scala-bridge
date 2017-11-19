package dev.afilakovic.models

import dev.afilakovic.Constants

class Hand(val cards: List[Card]) {
  def value(): Int = cards.map(card => Constants.DENOMINATIONS_AND_VALUES.getOrElse(card.denomination, 0)).sum
  def distribution: String = cards.groupBy(_.suit).map(_._2.size).toList.sortWith(_ > _).mkString("-")
}
