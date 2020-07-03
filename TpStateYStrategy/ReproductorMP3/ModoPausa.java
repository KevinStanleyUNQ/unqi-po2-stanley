package ReproductorMP3;

public class ModoPausa extends Modo {

	@Override
	public String pause(ReproductorMP3 reproductorMP3) {
		
		modoReproduccion = new ModoReproduccion();
		reproductorMP3.setModo(modoReproduccion);
		return reproductorMP3.getCancionEnReproduccion().play();
	}

	@Override
	public void stop(ReproductorMP3 reproductorMP3){
		
		cancionActual = reproductorMP3.getCancionEnReproduccion();
		seleccionDeCancion = new ModoSeleccionDeCancion();
		reproductorMP3.setModo(seleccionDeCancion);
		reproductorMP3.setEstadoDelReproductor(seleccionDeCancion.textoAMostrar(cancionActual));
	}

	@Override
	public String textoAMostrar(Song unaCancion){
		
		return unaCancion.pause();
	}

	

}
