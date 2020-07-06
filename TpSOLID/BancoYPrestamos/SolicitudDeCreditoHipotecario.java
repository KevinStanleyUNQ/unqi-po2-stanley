package BancoYPrestamos;

public class SolicitudDeCreditoHipotecario extends SolicitudDeCredito {
	
	Cliente cliente;
	PropiedadInmobiliaria propiedad;

	public SolicitudDeCreditoHipotecario(Cliente unCliente, float unCreditoSolicitado, int plazos,
										PropiedadInmobiliaria unaPropiedad){
		
		this.cliente = unCliente;
		this.creditoSolicitado = unCreditoSolicitado;
		this.plazoEnMeses = plazos;
		this.propiedad = unaPropiedad;
		
	}

	@Override
	public float chekearDatos(){

		float monto = 0f;
		double montoPorMes = creditoSolicitado/plazoEnMeses;
		double porcentajeDelValorFiscal = propiedad.getValorFiscal()*0.7;
		double mitadDeSusIngesosMensuales = (cliente.getIngresosMensuales()/2);
		
		if(creditoSolicitado<=porcentajeDelValorFiscal && montoPorMes<=mitadDeSusIngesosMensuales &&
		   cliente.getEdad()<= 65){
			
			monto = this.creditoSolicitado;
			setEstadoDeSolicitud(true);
		}
		
		return monto;
	}
	
}
