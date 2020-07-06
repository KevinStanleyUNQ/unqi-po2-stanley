package PokerTrioColorONada;

import java.util.ArrayList;

public class Trio extends Jugada {

	@Override
	public void verificarJugada(String carta1, String carta2, String carta3, 
								String carta4, String carta5, PokerStatus pokerStatus) 
		{
			int trio = 1;
			ArrayList <String> cartas = new ArrayList<String>();
			cartas.add(carta1);	// 7D
			cartas.add(carta2); // 7T
			cartas.add(carta3); // 7C
			cartas.add(carta4); // 3P
			cartas.add(carta5); // 5D
	
			for(int i=0;i<cartas.size()&&trio<3;i++)
				{
					for(int k=i;k<cartas.size();k++)
						{
							trio += comprobarSiSonElMismoNumero(cartas.get(i), cartas.get(k));//1//
						}
		
				}
			comprobarDeQueSeaPoker(trio, pokerStatus);	
	}


	private void comprobarDeQueSeaPoker(int trio, PokerStatus pokerStatus)
		{	
				if (trio==3)
					{
						pokerStatus.guardarJugadaEnMano(this);
					}				
		}


	/**
	 * Comprueba si los Numeros de las String(posicion 0 del String) es igual al segundo numero
	 * del siguiente String. De ser igual devuelve "1" y sino "0".
	 **/

	private int comprobarSiSonElMismoNumero(String carta1, String carta2) 
		{	
			int condicion2 = (carta1.charAt(0) == carta2.charAt(0)) ? 1 : 0;
			int resultado = (carta1==carta2) ? 0 : condicion2;
			return resultado;
		}


	@Override
	public String getEnString(){
		
		return "Trio";
	}
		
}
