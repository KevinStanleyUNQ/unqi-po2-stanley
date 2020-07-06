package CartasDePoker;

import java.util.ArrayList;

public class Color extends Jugada {
	
	ArrayList <Carta> cartas;
	
	@Override
	public void verificarJugada(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5,
								PokerStatus pokerStatus){
		
		cartas = new ArrayList<Carta>();
		
		int color = 1;
		
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

	private int comprobarSiSonElMismoNumeroYPalo(Carta carta, Carta carta2) 
		{	
			boolean sonColorNegro = comprobarSiSonDelMismoColorNegro(carta, carta2);
			boolean sonColorRojo = comprobarSiSonDelMismoColorRojo(carta, carta2);
			int condicion2 = (sonColorNegro || sonColorRojo ) ? 1 : 0;
			int resultado = (carta==carta2) ? 0 : condicion2;
			return resultado;
		}
	
	private boolean comprobarSiSonDelMismoColorNegro(Carta carta1, Carta carta2){
		
		boolean paloIguales = carta1.getPalo().equals(carta2.getPalo());
		boolean colorPYT = carta1.getPalo().equals("P") && carta2.getPalo().equals("T");
		boolean colorTYP = carta1.getPalo().equals("T") && carta2.getPalo().equals("P");
		
		return (paloIguales||colorPYT||colorTYP);
	}

	private boolean comprobarSiSonDelMismoColorRojo(Carta carta1, Carta carta2) {
		
		boolean paloIguales = carta1.getPalo().equals(carta2.getPalo());
		boolean colorCYD = carta1.getPalo().equals("C") && carta2.getPalo().equals("D");
		boolean colorDYC = carta1.getPalo().equals("D") && carta2.getPalo().equals("C");
		
		return (paloIguales||colorCYD||colorDYC);
	}

	@Override
	public String getEnString(){
		
		return "Color";
	}

	@Override
	public String jugadaMayor(Jugada unaJugada, PokerStatus pokerStatus){
		
		Jugada jugadaMayor = this;
		
		if(getEnString().equals(unaJugada.getEnString())){
			
			jugadaMayor = verificarManoMasGrande(unaJugada,pokerStatus);
		}
		
			jugadaMayor = comprobarQueSeaPoker(unaJugada);
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
	
	public Jugada comprobarQueSeaPoker(Jugada unaJugada){
		
		Jugada jugadaMasGrande = this;
		if(unaJugada.getEnString().equals("Poker")){
			
			jugadaMasGrande = unaJugada;
		}

		return jugadaMasGrande;
	}

	@Override
	public ArrayList<Carta> getCartas(){
		
		return cartas;
	}


}
