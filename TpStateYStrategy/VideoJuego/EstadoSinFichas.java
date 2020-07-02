package VideoJuego;

public class EstadoSinFichas extends Estado {

	@Override
	protected String presionarInicio(){
		
		return "Ingresar Fichas";
	}

	@Override
	protected void puedeHacerseCargo(int cantidadDeFichasIngresadas, VideoJuego unVideoJuego){

		if(cantidadDeFichasIngresadas==0){		
			unVideoJuego.setEstado(this);
		}	
	}
	

}
