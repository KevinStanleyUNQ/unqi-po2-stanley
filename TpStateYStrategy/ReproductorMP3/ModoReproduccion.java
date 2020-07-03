package ReproductorMP3;

public class ModoReproduccion extends Modo {
	
	@Override
	public String pause(ReproductorMP3 reproductorMP3){
		
		pause = new ModoPausa();
		reproductorMP3.setModo(pause);
		return reproductorMP3.getCancionEnReproduccion().pause();
	}

	@Override
	public void stop(ReproductorMP3 reproductorMP3){
		
		seleccionDeCancion= new ModoSeleccionDeCancion();
		reproductorMP3.setModo(seleccionDeCancion);
	}

	@Override
	public String textoAMostrar(Song unaCancion){
		
		return unaCancion.play();
	}

}
