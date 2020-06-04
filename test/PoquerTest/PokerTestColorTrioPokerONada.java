package PoquerTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PoquerTrioColorPokerONada.PokerStatus;


class PokerTestColorTrioPokerONada {
	
	PokerStatus pokerStatus = new PokerStatus();
	
	String carta1;
	String carta2;
	String carta3;
	String carta4;
	String carta5;
	
	String carta6;
	String carta7;
	String carta8;
	String carta9;
	String carta10;
	
	String carta11;
	String carta12;
	String carta13;
	String carta14;
	String carta15;
	
	
	
	@BeforeEach
		void setUp()
			{
					
				carta1 = "4D";
				carta2 = "4T";
				carta3 = "4C";
				carta4 = "4P";
				carta5 = "5C";
				
				carta6 = "QD";
				carta7 = "8C";
				carta8 = "7C";
				carta9 = "2C";
				carta10 = "1C";
				
				carta11 = "KP";
				carta12 = "KP";
				carta13 = "KP";
				carta14 = "KP";
				carta15 = "KP";
				
				
			}
	
	
	@Test
	void testHayPokerOTrioOColorONada()
		{
			assertEquals("Poker", pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5));
		}
	

}
