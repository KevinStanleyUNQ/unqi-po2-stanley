package PoquerTrioColorPokerONada;

public class Jugada {
	
	EstadoDeLaJugada estado;

	public void esPoker()
		{
			estado = new Poker();
		}
	
	public void esTrio()
		{
			estado = new Trio();
		}
	
	public void esColor()
		{
			estado = new Color();
		}
	
	public void esNada()
		{
			estado = new Nada();
		}
	
	
	
	public String getJugada(String carta1, String carta2, String carta3, String carta4, String carta5)
		{
			return estado.getEstado(carta1, carta2, carta3, carta4, carta5);
		}

}
