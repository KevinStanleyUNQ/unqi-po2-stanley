package ReproductorMP3;

public class ReproductorMP3 {
	
	private Modo modoActual;
	private Song cancionEnReproduccion;
	private String estadoDelReproductor;
	
	public ReproductorMP3(){
		
		this.modoActual = new ModoSeleccionDeCancion();
		this.estadoDelReproductor = modoActual.textoAMostrar(cancionEnReproduccion);
	}

	public String play(Song song){
		
		if(this.modoActual.getClass().equals(ModoSeleccionDeCancion.class)){
			
			this.modoActual = new ModoReproduccion();
			this.estadoDelReproductor = modoActual.textoAMostrar(song);
			this.cancionEnReproduccion = song;
		}
		
		else{
			
			setEstadoDelReproductor("Error, hay una cancion en curso");
		}
		
		return estadoDelReproductor;

	}

	public String pause(){
	
		setEstadoDelReproductor(modoActual.pause(this));
		return this.estadoDelReproductor;
	}

	
	public void setModo(Modo unModo){
		
		this.modoActual = unModo;
		setEstadoDelReproductor(unModo.textoAMostrar(cancionEnReproduccion));
	}

	public String stop(){
		
		this.modoActual.stop(this);
		return this.estadoDelReproductor;
	}

	public void setEstadoDelReproductor(String textoAMostrar){
		
		this.estadoDelReproductor = textoAMostrar;
	}

	public Song getCancionEnReproduccion(){
		
		return this.cancionEnReproduccion;
	}

}
