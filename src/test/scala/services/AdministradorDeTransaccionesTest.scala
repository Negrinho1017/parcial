package services
import domain.{Account, Divisa, Person, TipoCuenta}
import org.scalatest._

class AdministradorDeTransaccionesTest extends FlatSpec with Matchers{
  "ver saldo" should "return 2000" in{
    val administrador = new AdministradorDeTransacciones()
    val person = new Person(1017,"Camilo")
    val tipo = new TipoCuenta(1,"Ahorros")
    val cuenta = new Account(11234,person,tipo,2000,true)
    administrador.verSaldo(cuenta)should be(Some(2000))
  }

  "ver saldo después de retirar" should "return 1000" in{
    val administrador = new AdministradorDeTransacciones()
    val person = Person(1017,"Camilo")
    val tipo = TipoCuenta(1,"Ahorros")
    val cuenta = Account(11234,person,tipo,2000,true)
    administrador.retirar(cuenta,1000)
    administrador.verSaldo(cuenta)should be(Some(1000))
  }

  "ver saldo después de consignar" should "return 2111" in{
    val administrador = new AdministradorDeTransacciones()
    val person = Person(1017,"Camilo")
    val tipo = TipoCuenta(1,"Ahorros")
    val cuenta = Account(11234,person,tipo,2000,true)
    administrador.consignar(cuenta,111)
    administrador.verSaldo(cuenta)should be(Some(2111))
  }

  "ver saldo después de transferir" should "return 1000 y 3000" in{
    val administrador = new AdministradorDeTransacciones()
    val person = Person(1017,"Camilo")
    val tipo = TipoCuenta(1,"Ahorros")
    val cuentaOrigen = Account(11234,person,tipo,2000,true)
    val cuentaDestino = Account(112345,person,tipo,2000,true)
    administrador.transferir(cuentaOrigen,cuentaDestino,1000)
    administrador.verSaldo(cuentaOrigen)should be(Some(1000))
    administrador.verSaldo(cuentaDestino)should be(Some(3000))
  }

  "ver saldo de cuenta inactiva" should "return None" in{
    val administrador = new AdministradorDeTransacciones()
    val person = new Person(1017,"Camilo")
    val tipo = new TipoCuenta(1,"Ahorros")
    val cuenta = new Account(11234,person,tipo,2000,false)
    administrador.verSaldo(cuenta)should be(None)
  }

  "retirar  de cuenta inactiva" should "return None" in{
    val administrador = new AdministradorDeTransacciones()
    val person = Person(1017,"Camilo")
    val tipo = TipoCuenta(1,"Ahorros")
    val cuenta = Account(11234,person,tipo,2000,false)
    administrador.retirar(cuenta,1000)
    administrador.retirar(cuenta,1000) should be(None)
  }

  "consignar a una cuenta inactiva" should "return None" in{
    val administrador = new AdministradorDeTransacciones()
    val person = Person(1017,"Camilo")
    val tipo = TipoCuenta(1,"Ahorros")
    val cuenta = Account(11234,person,tipo,2000,false)
    administrador.consignar(cuenta,111) should be(None)
  }

  "transferir a una cuenta inactiva" should "return None" in{
    val administrador = new AdministradorDeTransacciones()
    val person = Person(1017,"Camilo")
    val tipo = TipoCuenta(1,"Ahorros")
    val cuentaOrigen = Account(11234,person,tipo,2000,true)
    val cuentaDestino = Account(112345,person,tipo,2000,false)
    administrador.transferir(cuentaOrigen,cuentaDestino,1000) should be(None)
  }

  "ver saldo después de transferir de pesos a dolares" should "return 200 y 4800" in{
    val administrador = new AdministradorDeTransacciones()
    val person = Person(1017,"Camilo")
    val tipo = TipoCuenta(1,"Ahorros")
    val pesos = Divisa(1,"COP")
    val dolares = Divisa(2,"USD")
    val cuentaOrigen = Account(11234,person,tipo,3000,true)
    val cuentaDestino = Account(112345,person,tipo,2000,true)
    administrador.transferirConCambioDeDivisa(cuentaOrigen,cuentaDestino, 1, pesos, dolares)
    administrador.verSaldo(cuentaOrigen)should be(Some(200))
    administrador.verSaldo(cuentaDestino)should be(Some(4800))
  }

}
