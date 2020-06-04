package PoquerTrioColorPokerONada;

public class PokerStatus {
	
	private Jugada jugada = new Jugada();
	
	

	public String verificar(String carta1, String carta2, String carta3, String carta4, String carta5) 
		{
			return (jugada.getJugada(carta1, carta2, carta3, carta4, carta5));
		}
	
	
	

}
