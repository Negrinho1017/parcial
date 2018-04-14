package services
import domain.{Account, Person, TipoCuenta}
import org.scalatest._

class AdministradorDeCuentasTest extends FlatSpec with Matchers{
  "crear cuenta" should "return la cuenta" in{
    val administrador = new AdministradorDeCuentas()
    val person = new Person(1017,"Camilo")
    val tipo = new TipoCuenta(1,"Ahorros")
    val cuenta = new Account(11234,person,tipo,2000,false)
    administrador.crearCuenta(11234,person,tipo,2000) should be(cuenta)
  }

  "activar cuenta" should "return cuenta activa" in{
    val administrador = new AdministradorDeCuentas()
    val person = new Person(1017,"Camilo")
    val tipo = new TipoCuenta(1,"Ahorros")
    val cuenta = administrador.crearCuenta(11234,person,tipo,2000)
    administrador.activarCuenta(cuenta)
    cuenta.actividad should be(true)
  }

  "desactivar cuenta" should "return cuenta inactiva" in{
    val administrador = new AdministradorDeCuentas()
    val person = new Person(1017,"Camilo")
    val tipo = new TipoCuenta(1,"Ahorros")
    val cuenta = administrador.crearCuenta(11234,person,tipo,2000)
    administrador.activarCuenta(cuenta)
    administrador.desactivarCuenta(cuenta)
    cuenta.actividad should be(false)
  }
}
