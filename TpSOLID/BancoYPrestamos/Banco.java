package BancoYPrestamos;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private List<SolicitudDeCredito> solicitudes = new ArrayList<SolicitudDeCredito>();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private Float dineroDisponible;
	private SistemaInformatico sistema;
	private Float dineroADesembolsar = 0f;

	/*
	 * Tengo en cuenta en este ejemplo que siempre el banco tendra mas dinero que el solicitado.
	 * */
	
	public Banco(SistemaInformatico unSistema){

			this.sistema = unSistema;
	}

	public float registrarYEvaluar(SolicitudDeCredito unaSolicitud){
	
		this.sistema.agregarSolicitud(unaSolicitud, this);
		float monto = unaSolicitud.chekearDatos();
		float dineroResultadoConLaResta = dineroDisponible - monto;
		setDinero(dineroResultadoConLaResta);
			
		return monto;
	}

	public void setDinero(float unaSumaDeDinero){
		
		this.dineroDisponible = unaSumaDeDinero;
	}

	public Float getDineroTotal(){
		
		return this.dineroDisponible;
	}

	public List<Cliente> getClientes(){
		
		return this.clientes;
	}

	public Integer cantidadDeClientes(){
		
		return this.clientes.size();
	}

	public List<SolicitudDeCredito> getSolicitudes(){
		
		return this.solicitudes;
	}

	public Integer cantidadDeSolicitudes(){
		
		return this.solicitudes.size();
	}

	public void setDineroADesembolsar(float montoTotal){
		
		this.dineroADesembolsar = montoTotal;
		
	}

	public Float montoTotalADesembolsarDeLasSolicitudes(){
		
		return this.dineroADesembolsar;
	}

}
