package Poquer;

import java.util.ArrayList;

/**
 * 
 * Hacer Refactor que esta horrible.
 * 
 * 
 * */

public class PokerStatus {
	
	
	public Boolean verificar(String carta1, String carta2, String carta3, String carta4, String carta5)
		{		
			int poker = 1;
			
			ArrayList <String> cartas = new ArrayList<String>();
			
			cartas.add(carta1);
			cartas.add(carta2);
			cartas.add(carta3);
			cartas.add(carta4);
			cartas.add(carta5);

			
		for(int i=0;i<cartas.size()&&poker<4;i++)
			{
				for(int k=0;k<4;k++)//i=4 p=3
					{
						poker += comprobarSiSonElMismoNumero(cartas.get(i), cartas.get(k));
					}
				
				poker = comprobarDeQueSeaPoker(poker);
			
					
			}
	
			return (poker==4);
		}

	
		private int comprobarDeQueSeaPoker(int poker)
		{
			if (poker==4)
				{
					return 4;	
				}
			return 1;
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
	
	private int comprobarSiSonElMismoNumero(String carta1, String carta2) 
		{
			int condicion2 = (carta1.charAt(0) == carta2.charAt(0)) ? 1 : 0;
			
			int resultado = (carta1==carta2) ? 0 : condicion2;
			
			return resultado;
				
			
		}

	
}
