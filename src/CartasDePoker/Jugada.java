package CartasDePoker;

import java.util.ArrayList;

public abstract class Jugada {

	public abstract void verificarJugada(Carta carta1, Carta carta2, Carta carta3, Carta carta4,
										 Carta carta5, PokerStatus pokerStatus);

	public abstract String getEnString();

	public abstract String jugadaMayor(Jugada unaJugada, PokerStatus pokerStatus);

	public abstract ArrayList<Carta> getCartas();
	
	public abstract Jugada verificarManoMasGrande(Jugada unaJugada, PokerStatus pokerStatus);
	
	public int obtenerSumaDeCartas(ArrayList<Carta> manoDecartas){
		
		int sumatoriaTotal = 0;
		for(Carta unaCarta:manoDecartas){
			
			sumatoriaTotal += unaCarta.getValorEnInt();
		}
		return sumatoriaTotal;
	}
	
}
