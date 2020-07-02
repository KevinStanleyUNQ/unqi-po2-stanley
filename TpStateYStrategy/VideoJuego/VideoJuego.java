package VideoJuego;

import java.util.ArrayList;
import java.util.List;

public class VideoJuego {

	List<Estado> estados = new ArrayList<Estado>();
	int cantidadDeFichasIngresadas = 0;
	Estado miEstado;
	
	public VideoJuego(){
		this.miEstado = new EstadoSinFichas();
	}
	
	public void agregarEstados(Estado unEstado){

		estados.add(unEstado);		
	}
	
	public void setEstado(Estado unEstado){
		this.miEstado = unEstado;
	}

	public String presionarInicio(){
		
		return miEstado.presionarInicio();
	}

	public void insertarFicha() {
		if(cantidadDeFichasIngresadas<3){
			this.cantidadDeFichasIngresadas +=1;
		}
	
		estados.forEach(i-> i.puedeHacerseCargo(cantidadDeFichasIngresadas,this));	
	}

	public void finalizarJuego(){

		this.cantidadDeFichasIngresadas = 0;
		this.miEstado= new EstadoSinFichas();
		
	}
}
