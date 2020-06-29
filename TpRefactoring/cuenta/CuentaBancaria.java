package cuenta;

public abstract class CuentaBancaria {
	protected HistorialMovimientos historialDeMovimientos;
	protected Notificador notificador;
	protected int saldo;
	
	public CuentaBancaria(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super();
		this.historialDeMovimientos = historialDeMovimientos;
		this.notificador = notificador;
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}
	
	public abstract void extraer(Integer monto);
	
	public void registrarMovimientoYNotificarAlCliente(Integer unMonto){
		
		this.historialDeMovimientos.registrarMovimiento("Extraccion", unMonto);
		this.notificador.notificarNuevoSaldoACliente(this);
		
	}
	
	public void extraerElSaldo(Integer monto){
		
		this.saldo = saldo - monto;
	}
	
	public abstract boolean comprobarSiHaySaldoSuficiente(Integer monto);
	
	/*
	 * Ambas cuentas poseian codigo repetido y podian tener los mismos metodos pero con implementaciones
	 * diferetentes, por eso fuero extraidos a la clase Abstracta.
	 * */
}
