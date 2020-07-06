package CartasDePoker;

import java.util.ArrayList;
import java.util.List;


public class PokerStatus {


	private List<Jugada> jugadasPermitidas = new ArrayList<Jugada>();
	private Jugada jugadaEnMano;
	private String jugadaEnString;
	private List<Jugada> jugadasQueCompiten = new ArrayList<Jugada>();
	private Jugada jugadaGanadora;
	
	public PokerStatus(){
		
		this.jugadaEnMano = new Nada();
		this.jugadaEnString = this.jugadaEnMano.getEnString();
	}

	public String verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5)
		{	
			jugadasPermitidas.forEach(i -> i.verificarJugada(carta1,carta2,carta3,carta4,carta5,this));
			
			return (this.jugadaEnString);
		}

	public void agregarJugadas(Jugada unaJugada) 
		{
			jugadasPermitidas.add(unaJugada);
		}

	public void guardarJugadaEnMano(Jugada unaJugada) 
		{
			
			jugadaEnMano = unaJugada;
			jugadaEnString = unaJugada.getEnString();
		}

	public String jugadaGanadora(List<Carta> unaJugada, List<Carta> otraJugada){
		
		String jugadaGanadora;
		
		verificar(unaJugada.get(0),unaJugada.get(1),unaJugada.get(2),unaJugada.get(3),unaJugada.get(4));
		jugadasQueCompiten.add(jugadaEnMano);
		verificar(otraJugada.get(0),otraJugada.get(1),otraJugada.get(2),otraJugada.get(3),otraJugada.get(4));
		jugadasQueCompiten.add(jugadaEnMano);
		
		jugadaGanadora = (jugadasQueCompiten.get(0).jugadaMayor(jugadasQueCompiten.get(1),this));
		return jugadaGanadora;
		
	}
	
	public Carta cartaMasGrande(Carta carta1, Carta carta2){
		
		Carta cartaMayor = carta1;
		if(carta2.esMasGrande(carta1)){
			cartaMayor = carta2;
		}
		return cartaMayor;
	}

	public void setJugadaGanadora(Jugada jugadaMayor){
		
		this.jugadaGanadora = jugadaMayor;
	}

	public Jugada getJugadaGanadora(){
		
		return this.jugadaGanadora;
	}

	public int obtenerSumatoria(List<Carta> unaMano){
			
		int sumaTotal = 0;
		for(Carta unaCarta:unaMano){
			sumaTotal += unaCarta.getValorEnInt();
		}

		return sumaTotal;
	}

}
