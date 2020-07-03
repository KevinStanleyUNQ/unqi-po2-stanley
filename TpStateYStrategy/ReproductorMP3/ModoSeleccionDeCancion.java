package ReproductorMP3;

public class ModoSeleccionDeCancion extends Modo {

	@Override
	public String pause(ReproductorMP3 reproductorMP3){
		
		return("Error, no hay cancion en reproduccion");
	}

	@Override
	public void stop(ReproductorMP3 reproductorMP3){}


	@Override
	public String textoAMostrar(Song unaCancion){
	
		return "Seleccione una cancion";
	}

}
