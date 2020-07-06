package BancoYPrestamos;

public class SolicitudDeCreditoPersonal extends SolicitudDeCredito {

	private Cliente cliente;
	
	
	public SolicitudDeCreditoPersonal(Cliente unCliente, float unaSumaDeDinero, int unPlazo){

			this.cliente = unCliente;
			this.creditoSolicitado = unaSumaDeDinero;
			this.plazoEnMeses = unPlazo;
	}

	//No Setea el elEstadoDeSolicitud;
	@Override
	public float chekearDatos(){
		
		float monto = 0f;
		float montoPorMes = creditoSolicitado/plazoEnMeses;
		double porcentajeDeSusIngesosMensuales = (cliente.getIngresosMensuales()*0.7);
		
		if(cliente.getIngresoAnual()>=15000f && montoPorMes<=porcentajeDeSusIngesosMensuales){
			
			monto = this.creditoSolicitado;
			setEstadoDeSolicitud(true);
		}	
		
		
		return monto;
	}
	

}
