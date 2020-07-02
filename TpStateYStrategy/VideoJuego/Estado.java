package VideoJuego;

public abstract class Estado {

	protected abstract String presionarInicio();

	protected abstract void puedeHacerseCargo(int cantidadDeFichasIngresadas, VideoJuego videoJuego);
	
	

}
