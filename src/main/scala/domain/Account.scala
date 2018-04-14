package domain

case class Account(number:Int,
              cliente:Person,
             tipo:TipoCuenta,
                   var saldo:Double,
                   var actividad:Boolean){
  def retirar(valor: Double) {
    saldo = saldo - valor
  }

  def consignar(valor: Double) {
    saldo = saldo + valor
  }
  def cambiarActividad(valor: Boolean) {
    actividad = valor
  }
}
