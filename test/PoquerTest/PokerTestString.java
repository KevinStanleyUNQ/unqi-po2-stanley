package PoquerTest;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Poquer.PokerStatus;

	


class PokerTestString {
	
	PokerStatus pokerStatus;
	
	String carta1;
	String carta2;
	String carta3;
	String carta4;
	String carta5;
	
	@BeforeEach
		void setUp()
			{
				pokerStatus = new PokerStatus();
				
				carta1 = "2T";
				carta2 = "QD";
				carta3 = "2C";
				carta4 = "2D";
				carta5 = "2P";
			}

	@Test
	void testHayPoker() 
	{
		assertTrue(pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5));
	}

}
