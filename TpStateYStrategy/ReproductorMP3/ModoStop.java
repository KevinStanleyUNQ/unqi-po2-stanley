package ReproductorMP3;

public class ModoStop extends Modo {
	
	@Override
	public String pause(ReproductorMP3 reproductorMP3) {
		
		seleccionDeCancion = new ModoSeleccionDeCancion();
		reproductorMP3.setModo(seleccionDeCancion);
		return "Seleccione una cancion";
	}

	
	public void stop(ReproductorMP3 reproductorMP3){}


	@Override
	public String textoAMostrar(Song unaCancion){
		
		return unaCancion.stop();
	}

}
