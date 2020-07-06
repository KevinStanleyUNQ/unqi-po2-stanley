package VideoJuego;

public class EstadoSinFichas extends Estado {

	@Override
	public String presionarInicio(){
		
		return "Ingresar Fichas";
	}

	@Override
	public void puedeHacerseCargo(int cantidadDeFichasIngresadas, VideoJuego unVideoJuego){

		if(cantidadDeFichasIngresadas==0){		
			unVideoJuego.setEstado(this);
		}	
	}
	

}
