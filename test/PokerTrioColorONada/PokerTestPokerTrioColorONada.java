package PokerTrioColorONada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerTestPokerTrioColorONada {
	
	PokerStatus pokerStatus;
	Jugada poker;
	Jugada trio;
	Jugada color;
	String carta1;
	String carta2;
	String carta3;
	String carta4;
	String carta5;
	
	@BeforeEach
	void setUp()
		{	
			poker = new Poker();
			trio = new Trio();
			color = new Color();
		}
	
	@Test
	void testLaJugadaEsNada(){
		
		pokerStatus = new PokerStatus();
		
		pokerStatus.agregarJugadas(poker);
		pokerStatus.agregarJugadas(trio);
		pokerStatus.agregarJugadas(color);
		
		carta1 = "3D";
		carta2 = "6T";
		carta3 = "QC";
		carta4 = "2P";
		carta5 = "1D";
		
		assertEquals("Nada", pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5));
		
	}
	
	
	@Test
	void testLaJugadaEsPoker() 
		{
			pokerStatus = new PokerStatus();
			
			pokerStatus.agregarJugadas(poker);
			pokerStatus.agregarJugadas(trio);
			pokerStatus.agregarJugadas(color);
		
			carta1 = "10D";
			carta2 = "10T";
			carta3 = "10C";
			carta4 = "10P";
			carta5 = "5D";
			
			assertEquals("Poker", pokerStatus.verificar(carta1,carta2,carta3,carta4,carta5));
		}
	
	@Test
	void testLaJugadaEsTrio()
		{
			pokerStatus = new PokerStatus();
		
			pokerStatus.agregarJugadas(poker);
			pokerStatus.agregarJugadas(trio);
			pokerStatus.agregarJugadas(color);
			
			carta1 = "7D";
			carta2 = "7T";
			carta3 = "7C";
			carta4 = "3P";
			carta5 = "5D";
	
			assertEquals("Trio", pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5));		
		}
	
	@Test
	void testLaJugadaEsColor(){
		
		pokerStatus = new PokerStatus();
		
		pokerStatus.agregarJugadas(poker);
		pokerStatus.agregarJugadas(trio);
		pokerStatus.agregarJugadas(color);
		
		carta1 = "1D";
		carta2 = "2C";
		carta3 = "3D";
		carta4 = "4D";
		carta5 = "5C";
		
		assertEquals("Color", pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5));
		
		
	}

}
