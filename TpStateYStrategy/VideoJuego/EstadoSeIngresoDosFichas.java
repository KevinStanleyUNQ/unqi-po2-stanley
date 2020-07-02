package VideoJuego;

public class EstadoSeIngresoDosFichas extends Estado {

	@Override
	protected String presionarInicio() {
		
		return "Comienzo para dos Jugadores";
	}

	@Override
	protected void puedeHacerseCargo(int cantidadDeFichasIngresadas, VideoJuego unVideoJuego){
		
		if(cantidadDeFichasIngresadas==2){		
			unVideoJuego.setEstado(this);
		}	
	}

				
}