/**
  * Created by Tom on 24/01/2017.
  */
import scala.io.StdIn
class Samaria {
  def printIntroductoryMessage(): Unit = {
    System.out.println("""Congratulations, you are the newest ruler of ancient Samaria, elected
                         |for a ten year term of office. Your duties are to dispense food, direct
                         |farming, and buy and sell land as needed to support your people. Watch
                         |out for rat infestations and the plague! Grain is the general currency,
                         |measured in bushels. The following will help you in your decisions:
                         |* Each person needs at least 20 bushels of grain per year to survive.
                         |* Each person can farm at most 10 acres of land.
                         |* It takes 2 bushels of grain to farm an acre of land.
                         |* The market price for land fluctuates yearly.
                         |Rule wisely and you will be showered with appreciation at the end of
                         |your term. Rule poorly and you will be kicked out of office!""")

    var answer = scala.io.StdIn.readLine().toInt

  }
  object Hammurabi {
    var starved = 0            // how many people starved
    var immigrants = 5         // how many people came to the city
    var population = 100
    var harvest = 3000          // total bushels harvested
    var bushelsPerAcre = 3      // amount harvested for each acre planted
    var rats_ate = 200          // bushels destroyed by rats
    var bushelsInStorage = 2800
    var acresOwned = 1000
    var pricePerAcre = 19       // each acre costs this many bushels
    var plagueDeaths = 0
    for (i <- 10) {
      System.out.println(""" O great Hammurabi!
                           |        You are in year """+ i +""" of your ten year rule.
                           |      In the previous year 0 people starved to death.
                           |        In the previous year 5 people entered the kingdom.
                           |        The population is now 100.
                           |      We harvested 3000 bushels at 3 bushels per acre.
                           |      Rats destroyed 200 bushels, leaving 2800 bushels in storage.
                           |      The city owns 1000 acres of land.
                           |      Land is currently worth 19 bushels per acre.
                           |      There were 0 deaths from the plague.""")

    }
    def summary(starved: Int, acres: Int): Unit = {
      var success = acres - starved
    }
    def landPrice(acre: Int): Unit = {
      var cost = 17 + (scala.math.random * 6) * acre
      cost.toInt
    }
    def plagueChange(population: Int): Boolean = {
      var x = 15/100 * scala.math.random * 100
      if (x > 15) {
        return false
      } else {
        return true
      }
    }
    def peopleFed(population: Int, bushels: Int) = {
      var starved = bushels - population * 20
    }
    def immigration(poulation: Int, acres: Int, bushels: Int) = {
      var immigrants = (20 * acres + bushels) / (100 * population) + 1
    }
    def harvest(acres: Int) = {
      var harvestTurnOut = 1/8 * scala.math.random * acres
    }
    def rats(grain: Int): Int = {
      var consume = 0.0;
      var infestation = 2/5 * scala.math.random * 100
      if (infestation > 40) {
        return 0
      } else {
        consume = grain / ((scala.math.random * 2.0) + 1.0)
      }
      consume.toInt
    }
    def readInt(message: String): Int = {
      try {
        StdIn.readLine().toInt
      } catch {
        case _ : Throwable =>
          println("Not an integeter.")
          StdIn.readLine().toInt
      }
    }
    def askHowMuchLandToBuy(bushels: Int, price: Int) = {
      var acresToBuy = readInt("How many acres will you buy? ")
      while (acresToBuy < 0 || acresToBuy * price > bushels) {
        println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
        acresToBuy = readInt("How many acres will you buy? ")
      }
      acresToBuy
    }
    def askHowMuchLandToSell(acres: Int, price: Int): Unit = {
      var acresToSell = readInt("How many acres will you sell?")
      while (acresToSell < 0) {
        println("O Great Hammurabi, we have but " + acres + " acres of land!")
      }
      acresToSell
    }
    def askHowMuchGrainForPeople(bushels: Int, people: Int): Unit = {
      var bushelsforPeople = readInt("How much grain will you give to the people?")
      while (bushelsforPeople > bushels) {
        println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
      }
      bushelsforPeople
    }
    def askHowManyAcrestoPlant(acres: Int, bushels: Int) = {
      if (bushels < 1) {
        println("O Great Hammurabi, we have no more bushels to sew!")
        0
      }
      var acresToPlant = readInt("How many acres will you plant?")
      while (acresToPlant > acres) {
        println("O Great Hammurabit, we have but " + " acres of land!")
      }
      acresToPlant
    }
    printIntroductoryMessage()
    def hammurabi: Unit = {
      printIntroductoryMessage()
      var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
      acresOwned = acresOwned + acresToBuy
    }
    Hammurabi.hammurabi
  }

}
