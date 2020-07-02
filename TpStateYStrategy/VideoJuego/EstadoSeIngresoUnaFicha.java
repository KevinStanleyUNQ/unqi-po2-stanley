package VideoJuego;

public class EstadoSeIngresoUnaFicha extends Estado {

	@Override
	protected String presionarInicio() {
		
		return "Comienzo para un unico Jugador";
	}

	@Override
	protected void puedeHacerseCargo(int cantidadDeFichasIngresadas, VideoJuego unVideoJuego){
		
		if(cantidadDeFichasIngresadas==1){		
			unVideoJuego.setEstado(this);
		}	
	}

}
