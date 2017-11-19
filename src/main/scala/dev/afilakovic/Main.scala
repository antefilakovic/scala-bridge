package dev.afilakovic

import dev.afilakovic.models.{Deck, Player}

import scala.io.StdIn

object Main extends App {
  val n: Int = StdIn.readInt()
  play(n)

  def play(n: Int): Unit = {
    val players = List(new Player("N"), new Player("E"), new Player("S"), new Player("W"))
    val deck = new Deck()

    (0 until n).foreach(_ => {
      deck.shuffle()
      val hands = deck.deal()
      (0 until 4).foreach(i => players(i).addHand(hands(i)))
    })

    printAverageValues(players)
    printDistributionFrequency(players)
  }

  def printAverageValues(players: List[Player]): Unit = players.foreach(player => println(f"${player.name}%s - ${calculateAverageValue(player)}%.1f"))

  def calculateAverageValue(player: Player): Double = player.hands.map(_.value()).sum.toDouble / player.hands.length

  def printDistributionFrequency(players: List[Player]): Unit = players.flatMap(_.hands)
    .groupBy(_.distribution)
    .map(row => (row._1, row._2.length.toDouble))
    .toList
    .sortWith(_._2 > _._2)
    .foreach(dist => println(f"${dist._1}%8s ${dist._2}%10.0f ${dist._2 / (n * 4) * 100}%10.2f%%"))
}
