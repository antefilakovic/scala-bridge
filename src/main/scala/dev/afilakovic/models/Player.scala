package dev.afilakovic.models

class Player(val name: String) {
  var hands : Array[Hand] = Array[Hand]()

  def addHand(hand : Hand) : Unit = hands = hands :+ hand
}
