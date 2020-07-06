package BancoYPrestamos;

public class PropiedadInmobiliaria {
	
	String descripcion;
	String direccion;
	Float valorFiscal;

	public PropiedadInmobiliaria(String unaDescripcion, String unaDireccion, float unValorFiscal){
			
		this.descripcion = unaDescripcion;
		this.direccion = unaDireccion;
		this.valorFiscal = unValorFiscal;

	}

	public float getValorFiscal(){
		
		return this.valorFiscal;
	}

	public String getDireccion(){
		
		return this.direccion;
	}

}
