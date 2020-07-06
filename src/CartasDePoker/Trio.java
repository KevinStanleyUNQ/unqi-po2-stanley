package CartasDePoker;

import java.util.ArrayList;


public class Trio extends Jugada {
	
	ArrayList <Carta> cartas;
	
	@Override
	public void verificarJugada(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5,
								PokerStatus pokerStatus){
			
			cartas = new ArrayList<Carta>();
			
			int trio = 1;
			
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

	private int comprobarSiSonElMismoNumero(Carta carta1, Carta carta2) 
		{	
			int condicion2 = (carta1.getValor().equals(carta2.getValor())) ? 1 : 0;
			int resultado = (carta1==carta2) ? 0 : condicion2;
			return resultado;
		}


	@Override
	public String getEnString(){
		
		return "Trio";
	}	
	

	@Override
	public ArrayList<Carta> getCartas() {
		
		return cartas;
	}


	@Override
	public String jugadaMayor(Jugada unaJugada, PokerStatus pokerStatus){
		
		Jugada jugadaMayor = this;	
		System.out.println(unaJugada);
		//System.out.println(pokerStatus.obtenerSumatoria(unaJugada.getCartas()));
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
		
		if(sumatoriaDeOtraJugada > sumatoriaDeJugadaActual){
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
	
	
	
}
