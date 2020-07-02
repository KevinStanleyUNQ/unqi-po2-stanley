package Encriptacion;

public class  EncriptadorNaive{
	
	FormaDeEncriptar encriptadorActual;
	
	public EncriptadorNaive(FormaDeEncriptar unaFormaDeEncriptacion){

			this.encriptadorActual = unaFormaDeEncriptacion;
	}

	public String encriptar(String unTexto){
		
		return (this.encriptadorActual.encriptar(unTexto));
	}
	
	public String desencriptar(String unTexto){
		
		
		return (this.encriptadorActual.desencriptar(unTexto));
	}
	

}
