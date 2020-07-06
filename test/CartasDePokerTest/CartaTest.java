package CartasDePokerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CartasDePoker.Carta;

class CartaTest {
	
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	
	@BeforeEach
	void setUp(){
		
		carta1 = new Carta("4","C");
		carta2 = new Carta("K","T");
		carta3 = new Carta("10","P");
		carta4 = new Carta("A","D");
		carta5 = new Carta("5","D");
		
	}

	@Test
	void testObtengoElValorYElPaloDeUnaCarta(){

		assertEquals("4", carta1.getValor());
		assertEquals("C", carta1.getPalo());
	}

	
	@Test
	void testEsVerdaderoQueCarta2EsMasGrandeQueCarta1(){
		
		assertTrue(carta2.esMasGrande(carta1));
	}
	
	@Test
	void testEsFalsoQueCarta1EsMasGrandeQueCarta3(){
		
		assertFalse(carta1.esMasGrande(carta3));	
	}
	
	@Test
	void testEsVerdaderoQuePoseenElMismoPalo(){
		
		assertTrue(carta4.esElMismoPalo(carta5));
	}
	
	@Test
	void testElValorDeStringAInt(){
		
		assertEquals(4, carta1.getValorEnInt());
	}
	
	@Test
	void testElValorEsKYPasaASerTreceEnInt(){
		
		assertEquals(13, carta2.getValorEnInt());
	}
}
