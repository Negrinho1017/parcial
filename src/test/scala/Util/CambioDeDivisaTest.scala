package Util

import domain.Divisa
import org.scalatest._

class CambioDeDivisaTest extends FlatSpec with Matchers{
  "cambiar 10 usd a cop" should "return 28000" in{
    val cambioDeDivisa = new CambioDeDivisa()
    val pesos = new Divisa(1,"COP")
    val dolares = new Divisa(2,"USD")
    cambioDeDivisa.cambiarDeDivisa(dolares, pesos, 10) should be(28000)
  }

  "cambiar 10 eur a cop" should "return 33000" in{
    val cambioDeDivisa = new CambioDeDivisa()
    val pesos = new Divisa(1,"COP")
    val euros = new Divisa(3,"EUR")
    cambioDeDivisa.cambiarDeDivisa(euros, pesos, 10) should be(33000)
  }

  "cambiar 29700 cop a eur" should "return 9" in{
    val cambioDeDivisa = new CambioDeDivisa()
    val pesos = new Divisa(1,"COP")
    val euros = new Divisa(3,"EUR")
    cambioDeDivisa.cambiarDeDivisa(pesos, euros, 29700) should be(9)
  }

  "cambiar 14000 cop a eur" should "return 5" in{
    val cambioDeDivisa = new CambioDeDivisa()
    val pesos = new Divisa(1,"COP")
    val dolares = new Divisa(2,"USD")
    cambioDeDivisa.cambiarDeDivisa(pesos, dolares, 14000) should be(5)
  }

  "cambiar 5 usd a eur" should "return 4" in{
    val cambioDeDivisa = new CambioDeDivisa()
    val euros = new Divisa(3,"EUR")
    val dolares = new Divisa(2,"USD")
    cambioDeDivisa.cambiarDeDivisa(dolares, euros, 5) should be(4)
  }

  "cambiar 10 eur a usd" should "return 12" in{
    val cambioDeDivisa = new CambioDeDivisa()
    val euros = new Divisa(3,"EUR")
    val dolares = new Divisa(2,"USD")
    cambioDeDivisa.cambiarDeDivisa(euros, dolares, 10) should be(12.5)
  }
}
