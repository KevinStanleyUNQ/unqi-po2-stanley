package BancoYPrestamos;

public class Cliente{
	
	private String nombre;
	private String apellido;
	private String direccion;
	private Integer edad;
	private Float sueldoNetoMensual;
	private Float sueldoAnual;
	private Float creditoObtenido;
	
	public Cliente(String unNombre,String unApellido,String unaDireccion,int unaEdad,float unSueldoNetoMensual){
		
		this.nombre = unNombre;
		this.apellido = unApellido;
		this.direccion = unaDireccion;
		this.edad = unaEdad;
		this.sueldoNetoMensual = unSueldoNetoMensual;
		this.sueldoAnual = calcularSueldoAnual();	
		this.creditoObtenido = 0f;
	}

	private Float calcularSueldoAnual(){
		
		return (this.sueldoNetoMensual*12);
	}

	public void solicitarCreditoPersonal(Banco unBanco, float unCreditoSolicitado, int unPlazo){
		
		SolicitudDeCredito solicitud = new SolicitudDeCreditoPersonal(this,unCreditoSolicitado,unPlazo);
		float creditoSolicitado = unBanco.registrarYEvaluar(solicitud);
		setCredito(creditoSolicitado);
	}

	private void setCredito(float unMonto){
		
		this.creditoObtenido = unMonto;	
	}

	public float getIngresosMensuales(){
		
		return this.sueldoNetoMensual;
	}

	public float getIngresoAnual(){
		
		return this.sueldoAnual;
	}

	public Float creditoObtenido(){
		
		return this.creditoObtenido;
	}

	public Float sueldoNeto(){
		
		return (this.sueldoNetoMensual + this.creditoObtenido);
	}

	public void solicitarCreditoHipotecario(Banco unBanco, float unCreditoSolicitado, int plazos,
											PropiedadInmobiliaria unaPropiedad){
		
		SolicitudDeCredito solicitud = new SolicitudDeCreditoHipotecario(this,unCreditoSolicitado,plazos,
																		unaPropiedad);
		
		float creditoSolicitado = unBanco.registrarYEvaluar(solicitud);
		setCredito(creditoSolicitado);	
	}

	public int getEdad(){

		return edad;
	}
		
	
}
