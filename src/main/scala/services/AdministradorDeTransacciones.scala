package services

import domain.{Account, Divisa}
import Util.CambioDeDivisa
class AdministradorDeTransacciones {
  def retirar(cuenta:Account, valor:Int): Option[Unit] ={
    if(cuenta.actividad) Some(cuenta.retirar(valor))
    else None
  }
  def consignar(cuenta:Account, valor:Int): Option[Unit]={
    if(cuenta.actividad) Some(cuenta.consignar(valor))
    else None
  }
  def transferir(cuentaOrigen: Account, cuentaDestino: Account, valor: Double): Option[Unit] ={
    if(cuentaOrigen.actividad && cuentaDestino.actividad){
      Some(cuentaOrigen.retirar(valor))
      Some(cuentaDestino.consignar(valor))
    }else{
      None
    }
  }
  def verSaldo(cuenta: Account):Option[Double] = {
    if (cuenta.actividad) Some(cuenta.saldo)
    else None
  }

  def transferirConCambioDeDivisa(cuentaOrigen: Account, cuentaDestino: Account, valor: Double, divisaOrigen: Divisa, divisaFin:Divisa): Option[Unit] ={
    val cambioDeDivisa = new CambioDeDivisa()
    if(cuentaOrigen.actividad && cuentaDestino.actividad){
      Some(cuentaOrigen.retirar(cambioDeDivisa.cambiarDeDivisa(divisaFin,divisaOrigen,valor)))
      Some(cuentaDestino.consignar(cambioDeDivisa.cambiarDeDivisa(divisaFin,divisaOrigen,valor)))
    }else{
      None
    }
  }

}
