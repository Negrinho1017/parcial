import domain.{Account, Person, TipoCuenta}
import services.AdministradorDeTransacciones

object main {
  def main(args: Array[String]): Unit = {
    val administrador = new AdministradorDeTransacciones()
    val person = Person(1017,"Camilo")
    val tipo = TipoCuenta(1,"Ahorros")
    val cuenta = Account(11234,person,tipo,2000,true)
    administrador.retirar(cuenta,1000)
    println(administrador.verSaldo(cuenta))
    administrador.consignar(cuenta, 3000)
    println(administrador.verSaldo(cuenta))
  }
}



