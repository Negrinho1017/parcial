package Util

import domain.Divisa

class CambioDeDivisa {
  def cambiarDeDivisa(divisaInicial: Divisa, divisaFinal: Divisa, valor: Double): Double = {
    def copAUsd(valor: Double): Double = valor/2800
    def usdACop(valor: Double): Double = valor*2800
    def copAEur(valor: Double): Double = valor/3300
    def eurACop(valor: Double): Double = valor*3300
    def eurAUsd(valor: Double): Double = valor/0.8
    def usdAEur(valor: Double): Double = valor*0.8

    if(divisaInicial.id == 1 && divisaFinal.id == 2) copAUsd(valor)
    else if(divisaInicial.id == 1 && divisaFinal.id == 3) copAEur(valor)
    else if(divisaInicial.id == 2 && divisaFinal.id == 1) usdACop(valor)
    else if(divisaInicial.id == 3 && divisaFinal.id == 1) eurACop(valor)
    else if(divisaInicial.id == 2 && divisaFinal.id == 3) usdAEur(valor)
    else eurAUsd(valor)

  }
}
