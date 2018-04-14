package services

import domain.{Account, Person, TipoCuenta}

class AdministradorDeCuentas {
  def crearCuenta(numero:Int, cliente: Person, tipoCuenta: TipoCuenta, ingresoInicial: Double): Account = {
    Account(numero,cliente,tipoCuenta,ingresoInicial,false)
  }
  def activarCuenta(cuenta: Account): Unit ={
    cuenta.cambiarActividad(true)
  }
  def desactivarCuenta(cuenta: Account): Unit ={
    cuenta.cambiarActividad(false)
  }
}
