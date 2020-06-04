package PoquerTrioColorPokerONada;

import java.util.ArrayList;

public class Poker implements EstadoDeLaJugada {

	@Override
	public String getEstado(String carta1, String carta2, String carta3, String carta4, String carta5)
		
		{		
			int poker = 0;
	
			ArrayList <String> cartas = new ArrayList<String>();
	
			cartas.add(carta1);
			cartas.add(carta2);
			cartas.add(carta3);
			cartas.add(carta4);
			cartas.add(carta5);
	
	
	
	
			for(int i= 0;i<4;i++)//i=4 p=3
			{
				poker += comprobarSiSonIguales(cartas.get(i), cartas.get(i+1));
			}
				//Sumo uno mas porque el cuando Compara 2 iguales por primera vez , el primer String de los 2 iguales
				//no lo cuenta.
	
			poker += 1;
		
			return (mencionarSiEsPoker(poker));
		}


		private String mencionarSiEsPoker(int poker)
		{
			if(poker==4)
				{
					return "Poker";
				}
			
			return "No es Poker";
			
		}


		/**
		 * 
		 * Comprueba si los Numeros de las String(posicion 0 del String) es igual al segundo numero
		 * del siguiente String. De ser igual devuelve "1" y sino "0".
		 * 
		 *
		 * 
		 * 
		 **/

	private int comprobarSiSonIguales(String carta1, String carta2) 
		{
			if(carta1.charAt(0) == carta2.charAt(0))
				{
					return 1;
				}
			
			return 0;
	
		}
}
