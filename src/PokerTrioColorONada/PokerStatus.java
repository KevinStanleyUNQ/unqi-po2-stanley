package PokerTrioColorONada;

import java.util.ArrayList;
import java.util.List;

public class PokerStatus {

	 private List<Jugada> jugadasPermitidas = new ArrayList<Jugada>();
	private String jugadaEnMano = "Nada";

	public String verificar(String carta1, String carta2, String carta3, String carta4, String carta5)
		{	
			jugadasPermitidas.forEach(i -> i.verificarJugada(carta1,carta2,carta3,carta4,carta5,this));
			
			return jugadaEnMano;
		}

	public void agregarJugadas(Jugada unaJugada) 
		{
			jugadasPermitidas.add(unaJugada);
		}

	public void guardarJugadaEnMano(String nombreDeLaJugada) 
		{
			
			jugadaEnMano = nombreDeLaJugada;
		}
	
	

}
