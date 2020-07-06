package VideoJuego;

public class EstadoSeIngresoUnaFicha extends Estado {

	@Override
	public String presionarInicio() {
		
		return "Comienzo para un unico Jugador";
	}

	@Override
	public void puedeHacerseCargo(int cantidadDeFichasIngresadas, VideoJuego unVideoJuego){
		
		if(cantidadDeFichasIngresadas==1){		
			unVideoJuego.setEstado(this);
		}	
	}

}
