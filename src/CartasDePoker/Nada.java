package CartasDePoker;

import java.util.ArrayList;

public class Nada extends Jugada {

	@Override
	public void verificarJugada(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5,
			PokerStatus pokerStatus){}

	@Override
	public String getEnString(){
		
		return "Nada";
	}

	@Override
	public String jugadaMayor(Jugada unaJugada, PokerStatus pokerStatus){
		
		return "Nada";
	}

	@Override
	public ArrayList<Carta> getCartas() {
		return null;
	}

	@Override
	public Jugada verificarManoMasGrande(Jugada unaJugada, PokerStatus pokerStatus) {
		return null;
	}

}
