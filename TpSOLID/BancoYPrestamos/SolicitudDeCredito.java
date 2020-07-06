package BancoYPrestamos;

public abstract class SolicitudDeCredito {
	
	protected float creditoSolicitado;
	protected int plazoEnMeses;
	public Boolean estadoDeLaSolicitud = false;

	public abstract float chekearDatos();
	
	public void setEstadoDeSolicitud(boolean unBooleano){

		this.estadoDeLaSolicitud = unBooleano;
		
	}
	
	protected Boolean getEstado(){
		
		return this.estadoDeLaSolicitud;
	}

	public float getMonto(){
		
		return this.creditoSolicitado;
	}

}
