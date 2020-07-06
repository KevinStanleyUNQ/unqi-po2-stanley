package PokerTrioColorONada;

public abstract class Jugada {
	
	public abstract void verificarJugada(String carta1, String carta2, String carta3,
										 String carta4, String carta5, PokerStatus pokerStatus);

	public abstract String getEnString();


}
