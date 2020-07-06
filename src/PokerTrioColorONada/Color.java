package PokerTrioColorONada;

import java.util.ArrayList;

public class Color extends Jugada{

	@Override
	public void verificarJugada(String carta1, String carta2, String carta3, String carta4, String carta5,
			PokerStatus pokerStatus){
		
		int color = 1;
		ArrayList <String> cartas = new ArrayList<String>();
		cartas.add(carta1);	// 1D <--
		cartas.add(carta2); // 2C
		cartas.add(carta3); // 3D
		cartas.add(carta4); // 4D
		cartas.add(carta5); // 5C

		for(int i=0;i<cartas.size()&&color<5;i++)//0
			{
				for(int k=0;k<cartas.size();k++)//0//1//2//3//4//
					{
						color += comprobarSiSonElMismoNumeroYPalo(cartas.get(i), cartas.get(k));//1//1+1//2+1//3+1//4+1
						
					}
				
			}
		comprobarDeQueSeaColor(color, pokerStatus);	
	}
		
		private void comprobarDeQueSeaColor(int color, PokerStatus pokerStatus)
		{	
			//System.out.println(color);
				if (color==5)
					{
						pokerStatus.guardarJugadaEnMano(this);
					}				
		}


	/**
	 * Comprueba si los Numeros de las String(posicion 0 del String) es igual al segundo numero
	 * del siguiente String. De ser igual devuelve "1" y sino "0".
	 **/

	private int comprobarSiSonElMismoNumeroYPalo(String carta1, String carta2) 
		{	
			boolean sonColorNegro = comprobarSiSonDelMismoColorNegro(carta1, carta2);
			boolean sonColorRojo = comprobarSiSonDelMismoColorRojo(carta1, carta2);
			int condicion2 = (sonColorNegro || sonColorRojo ) ? 1 : 0;
			int resultado = (carta1==carta2) ? 0 : condicion2;
			return resultado;
		}
	
	private boolean comprobarSiSonDelMismoColorNegro(String carta1, String carta2){
		
		char[] arrayCarta1 = carta1.toCharArray();
		String ultimoCaracterDeCarta1 = ""+ arrayCarta1[arrayCarta1.length-1];
		char[] arrayCarta2 = carta2.toCharArray();
		String ultimoCaracterDeCarta2 = "" + arrayCarta2[arrayCarta2.length-1];
		boolean condicionA = ultimoCaracterDeCarta1.equals(ultimoCaracterDeCarta2);
		boolean condicionB = ultimoCaracterDeCarta1.equals("P") && ultimoCaracterDeCarta2.equals("T");
		boolean condicionC = ultimoCaracterDeCarta1.equals("T") && ultimoCaracterDeCarta2.equals("P");
		
		return (condicionA||condicionB||condicionC);
	}

	/*
	 * Es un desastre tantas condiciones, pero no se me ocurria en el momento como hacerlo.
	 * */

	private boolean comprobarSiSonDelMismoColorRojo(String carta1, String carta2) {
		
		char[] arrayCarta1 = carta1.toCharArray();
		String ultimoCaracterDeCarta1 = ""+ arrayCarta1[arrayCarta1.length-1];
		char[] arrayCarta2 = carta2.toCharArray();
		String ultimoCaracterDeCarta2 = "" + arrayCarta2[arrayCarta2.length-1];
		boolean condicion1 = ultimoCaracterDeCarta1.equals(ultimoCaracterDeCarta2);
		boolean condicion2 = ultimoCaracterDeCarta1.equals("D") && ultimoCaracterDeCarta2.equals("C");
		boolean condicion3 = ultimoCaracterDeCarta1.equals("C") && ultimoCaracterDeCarta2.equals("D");
		
		return (condicion1||condicion2||condicion3);
	}

	@Override
	public String getEnString(){
		
		return "Color";
	}

	

}
