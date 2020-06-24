package PokerTrioColorONada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerTestPokerTrioColorONada {
	
	PokerStatus pokerStatus;
	IJugada jugada;
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
			pokerStatus = new PokerStatus();
			
			poker = new Poker();
			trio = new Trio();
			color = new Color();
			
			pokerStatus.agregarJugadas(poker);
			pokerStatus.agregarJugadas(trio);
			pokerStatus.agregarJugadas(color);
		}
	

	@Test
	void testHayPoker() 
		{
			carta1 = "4D";
			carta2 = "4T";
			carta3 = "4C";
			carta4 = "4P";
			carta5 = "5D";
			
			assertEquals("Poker", pokerStatus.verificar(carta1,carta2,carta3,carta4,carta5));
		}
	
	@Test
	void testHayTrio()
		{
			carta1 = "7D";
			carta2 = "7T";
			carta3 = "2C";
			carta4 = "3P";
			carta5 = "5D";
	
			assertEquals("Trio", pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5));
			
		}

}
