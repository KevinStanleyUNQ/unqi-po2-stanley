package VideoJuego;

public class EstadoSeIngresoDosFichas extends Estado {

	@Override
	public String presionarInicio() {
		
		return "Comienzo para dos Jugadores";
	}

	@Override
	public void puedeHacerseCargo(int cantidadDeFichasIngresadas, VideoJuego unVideoJuego){
		
		if(cantidadDeFichasIngresadas==2){		
			unVideoJuego.setEstado(this);
		}	
	}

				
}