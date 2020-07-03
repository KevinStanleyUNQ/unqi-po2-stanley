package ReproductorMP3;

public abstract class Modo {
	
	Modo modoReproduccion;
	Modo seleccionDeCancion;
	Modo pause;
	Song cancionActual;

	public abstract String pause(ReproductorMP3 reproductorMP3);

	public abstract void stop(ReproductorMP3 reproductorMP3);

	public abstract String textoAMostrar(Song cancionEnReproduccion);


}
