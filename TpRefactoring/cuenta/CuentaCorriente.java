package cuenta;

public class CuentaCorriente extends CuentaBancaria{
	private Integer limiteDescubierto;
	
	public CuentaCorriente(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo, Integer limiteDescubierto) {
		super(historialDeMovimientos, notificador, saldo);
		this.limiteDescubierto = limiteDescubierto;
	}
	
	@Override
	public void extraer(Integer monto) {
		if(comprobarSiHaySaldoSuficiente(monto))
			extraerElSaldo(monto); // Mismo caso que el de registrarMovimientosYNotificarAlCliente.
			registrarMovimientoYNotificarAlCliente(monto); // Extraje el ambos mensajes a la clase abstracta
			   											   //asi no tengo código repetido en ambas cuentas.
	}
	
	//Metodo creado en la Clase Abstracta con diferente implementacion en cada Clase.
	@Override
	public boolean comprobarSiHaySaldoSuficiente(Integer monto){
		
		return (this.saldo + this.limiteDescubierto >= monto);
	}

	
}
