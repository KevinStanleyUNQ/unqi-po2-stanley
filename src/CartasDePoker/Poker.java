package CartasDePoker;

import java.util.ArrayList;

public class Poker extends Jugada {

	ArrayList <Carta> cartas;
	
	@Override
	public void verificarJugada(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5,
								PokerStatus pokerStatus){
		
		cartas = new ArrayList<Carta>();
	
		int poker = 1;
		
		cartas.add(carta1);	// 4D
		cartas.add(carta2); // 4T
		cartas.add(carta3); // 4C
		cartas.add(carta4); // 4P
		cartas.add(carta5); // 5D

		for(int i=0;i<cartas.size()&&poker<4;i++)//0//1
		{
			for(int k=i;k<4;k++)//0//1//2//3//NoProcesa--//
				{
					poker += comprobarSiSonElMismoNumero(cartas.get(i), cartas.get(k));//1+0//1+1//2+1//3+1
				}
		
		}
		comprobarDeQueSeaPoker(poker, pokerStatus);	
	}


	private void comprobarDeQueSeaPoker(int poker, PokerStatus pokerStatus)
		{	
			if (poker==4)
				{
					pokerStatus.guardarJugadaEnMano(this);	
				}	
		}


/**
 * Comprueba si los Numeros de las String(posicion 0 del String) es igual al segundo numero
 * del siguiente String. De ser igual devuelve "1" y sino "0".
 * 
 **/

	private int comprobarSiSonElMismoNumero(Carta carta1, Carta carta2) 
		{	
			int condicion2 = (carta1.getValor().equals(carta2.getValor())) ? 1 : 0;
			int resultado = (carta1==carta2) ? 0 : condicion2;
			return resultado;
		}


	@Override
	public String getEnString(){

		return "Poker";
	}


	public String jugadaMayor(Jugada unaJugada, PokerStatus pokerStatus){
		
		Jugada jugadaMayor = this;
		
		if(getEnString().equals(unaJugada.getEnString())){
			
			jugadaMayor = verificarManoMasGrande(unaJugada,pokerStatus);
		}
		
			pokerStatus.setJugadaGanadora(jugadaMayor);
			
		return jugadaMayor.getEnString();
	}
	
	public Jugada verificarManoMasGrande(Jugada unaJugada, PokerStatus pokerStatus){
		
		ArrayList<Carta> otraMano = unaJugada.getCartas();
		int sumatoriaDeJugadaActual = obtenerSumaDeCartas(cartas);
		int sumatoriaDeOtraJugada = obtenerSumaDeCartas(otraMano);
		Jugada jugadaGanadoraConMasValor = this;
		
		if(sumatoriaDeOtraJugada >= sumatoriaDeJugadaActual){
			jugadaGanadoraConMasValor = unaJugada;
		}
		
		return jugadaGanadoraConMasValor;
	}
	
	@Override
	public ArrayList<Carta> getCartas(){
		
		return cartas;
	}

}
