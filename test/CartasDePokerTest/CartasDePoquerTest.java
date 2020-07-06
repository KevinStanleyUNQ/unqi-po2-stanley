package CartasDePokerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CartasDePoker.Carta;
import CartasDePoker.Color;
import CartasDePoker.Jugada;
import CartasDePoker.Poker;
import CartasDePoker.PokerStatus;
import CartasDePoker.Trio;

/**
 * Juntare el Enunciado de Cartas con Jugadas de Poquer 
 **/

class CartasDePoquerTest {
	
	PokerStatus pokerStatus;
	Jugada poker;
	Jugada trio;
	Jugada color;
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	Carta carta6;
	Carta carta7;
	Carta carta8;
	Carta carta9;
	Carta carta10;
	
	@BeforeEach
	void setUp(){

		poker = new Poker();
		trio = new Trio();
		color = new Color();
		
		carta1 = mock(Carta.class);
		carta2 = mock(Carta.class);
		carta3 = mock(Carta.class);
		carta4 = mock(Carta.class);
		carta5 = mock(Carta.class);
		carta6 = mock(Carta.class);
		carta7 = mock(Carta.class);
		carta8 = mock(Carta.class);
		carta9 = mock(Carta.class);
		carta10 = mock(Carta.class);
	}

	@Test
	void testLaJugadaEsNada(){
		
		pokerStatus = new PokerStatus();
		
		pokerStatus.agregarJugadas(poker);
		pokerStatus.agregarJugadas(trio);
		pokerStatus.agregarJugadas(color);
		
		when(carta1.getValor()).thenReturn("3"); 
		when(carta1.getPalo()).thenReturn("D");
		when(carta2.getValor()).thenReturn("6"); 
		when(carta2.getPalo()).thenReturn("T");
		when(carta3.getValor()).thenReturn("Q"); 
		when(carta3.getPalo()).thenReturn("P");
		when(carta4.getValor()).thenReturn("2"); 
		when(carta4.getPalo()).thenReturn("P");
		when(carta5.getValor()).thenReturn("1"); 
		when(carta5.getPalo()).thenReturn("D");
		
		assertEquals("Nada", pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5));
	}
	
	@Test
	void testLaJugadaEsPoker(){
		
		pokerStatus = new PokerStatus();
		
		pokerStatus.agregarJugadas(poker);
		pokerStatus.agregarJugadas(trio);
		pokerStatus.agregarJugadas(color);
		
		when(carta1.getValor()).thenReturn("3"); 
		when(carta1.getPalo()).thenReturn("D");
		when(carta2.getValor()).thenReturn("3"); 
		when(carta2.getPalo()).thenReturn("T");
		when(carta3.getValor()).thenReturn("3"); 
		when(carta3.getPalo()).thenReturn("P");
		when(carta4.getValor()).thenReturn("10"); 
		when(carta4.getPalo()).thenReturn("P");
		when(carta5.getValor()).thenReturn("3"); 
		when(carta5.getPalo()).thenReturn("C");
		
		assertEquals("Poker", pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5));
	}
	
	@Test
	void testLaJugadaEsTrio(){
		
		pokerStatus = new PokerStatus();
		
		pokerStatus.agregarJugadas(poker);
		pokerStatus.agregarJugadas(trio);
		pokerStatus.agregarJugadas(color);
		
		when(carta1.getValor()).thenReturn("3"); 
		when(carta1.getPalo()).thenReturn("D");
		when(carta2.getValor()).thenReturn("3"); 
		when(carta2.getPalo()).thenReturn("T");
		when(carta3.getValor()).thenReturn("3"); 
		when(carta3.getPalo()).thenReturn("P");
		when(carta4.getValor()).thenReturn("10"); 
		when(carta4.getPalo()).thenReturn("P");
		when(carta5.getValor()).thenReturn("K"); 
		when(carta5.getPalo()).thenReturn("C");
		
		assertEquals("Trio", pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5));
	}
	
	@Test
	void testLaJugadaEsColor(){
		
		pokerStatus = new PokerStatus();
		
		pokerStatus.agregarJugadas(poker);
		pokerStatus.agregarJugadas(trio);
		pokerStatus.agregarJugadas(color);
		
		when(carta1.getValor()).thenReturn("K"); 
		when(carta1.getPalo()).thenReturn("D");
		when(carta2.getValor()).thenReturn("3"); 
		when(carta2.getPalo()).thenReturn("C");
		when(carta3.getValor()).thenReturn("A"); 
		when(carta3.getPalo()).thenReturn("C");
		when(carta4.getValor()).thenReturn("10"); 
		when(carta4.getPalo()).thenReturn("D");
		when(carta5.getValor()).thenReturn("9"); 
		when(carta5.getPalo()).thenReturn("C");
		
		assertEquals("Color", pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5));
	}
	
	@Test
	void testLaJugadaGanadoraEntrePokerYColorEsPoker(){
		
		pokerStatus = new PokerStatus();
		
		pokerStatus.agregarJugadas(poker);
		pokerStatus.agregarJugadas(trio);
		pokerStatus.agregarJugadas(color);
		
		List<Carta> jugadaPoker = new ArrayList<Carta>();
		List<Carta> jugadaColor = new ArrayList<Carta>();
		
		//Primera Jugada de tipo Poker
		when(carta1.getValor()).thenReturn("5"); 
		when(carta1.getPalo()).thenReturn("D");
		when(carta2.getValor()).thenReturn("5"); 
		when(carta2.getPalo()).thenReturn("T");
		when(carta3.getValor()).thenReturn("5"); 
		when(carta3.getPalo()).thenReturn("P");
		when(carta4.getValor()).thenReturn("5"); 
		when(carta4.getPalo()).thenReturn("C");
		when(carta5.getValor()).thenReturn("10"); 
		when(carta5.getPalo()).thenReturn("T");
		
		jugadaPoker.add(carta1);
		jugadaPoker.add(carta2);
		jugadaPoker.add(carta3);
		jugadaPoker.add(carta4);
		jugadaPoker.add(carta5);
		
		//Segunda Jugada de tipo Color
		when(carta6.getValor()).thenReturn("K"); 
		when(carta6.getPalo()).thenReturn("D");
		when(carta7.getValor()).thenReturn("3"); 
		when(carta7.getPalo()).thenReturn("C");
		when(carta8.getValor()).thenReturn("A"); 
		when(carta8.getPalo()).thenReturn("C");
		when(carta9.getValor()).thenReturn("10"); 
		when(carta9.getPalo()).thenReturn("D");
		when(carta10.getValor()).thenReturn("9"); 
		when(carta10.getPalo()).thenReturn("C");
		
		jugadaColor.add(carta6);
		jugadaColor.add(carta7);
		jugadaColor.add(carta8);
		jugadaColor.add(carta9);
		jugadaColor.add(carta10);
		
		assertEquals("Poker",pokerStatus.jugadaGanadora(jugadaPoker,jugadaColor));
	}
	
	@Test
	void testLaJugadaGanadoraEntrePokerYPokerEsLaQueTieneCartasMasGrandes(){
		
		pokerStatus = new PokerStatus();
		
		pokerStatus.agregarJugadas(poker);
		pokerStatus.agregarJugadas(trio);
		pokerStatus.agregarJugadas(color);
		
		List<Carta> jugadaPoker = new ArrayList<Carta>();
		List<Carta> jugadaOtraPoker = new ArrayList<Carta>();
		
		//Primera Jugada de tipo Poker mas Chica
		when(carta1.getValor()).thenReturn("5"); 
		when(carta1.getPalo()).thenReturn("D");
		when(carta1.getValorEnInt()).thenReturn(5);
		when(carta2.getValor()).thenReturn("5"); 
		when(carta2.getPalo()).thenReturn("T");
		when(carta2.getValorEnInt()).thenReturn(5);
		when(carta3.getValor()).thenReturn("5"); 
		when(carta3.getPalo()).thenReturn("P");
		when(carta3.getValorEnInt()).thenReturn(5);
		when(carta4.getValor()).thenReturn("5"); 
		when(carta4.getPalo()).thenReturn("C");
		when(carta4.getValorEnInt()).thenReturn(5);
		when(carta5.getValor()).thenReturn("10"); 
		when(carta5.getPalo()).thenReturn("T");
		when(carta5.getValorEnInt()).thenReturn(10);
		
		jugadaPoker.add(carta5);
		jugadaPoker.add(carta6);
		jugadaPoker.add(carta7);
		jugadaPoker.add(carta8);
		jugadaPoker.add(carta9);
		
		//Segunda Jugada de tipo Poker mas Grande
		when(carta6.getValor()).thenReturn("K"); 
		when(carta6.getPalo()).thenReturn("D");
		when(carta6.getValorEnInt()).thenReturn(13);
		when(carta7.getValor()).thenReturn("K"); 
		when(carta7.getPalo()).thenReturn("T");
		when(carta7.getValorEnInt()).thenReturn(13);
		when(carta8.getValor()).thenReturn("A"); 
		when(carta8.getPalo()).thenReturn("P");
		when(carta8.getValorEnInt()).thenReturn(14);
		when(carta9.getValor()).thenReturn("K"); 	
		when(carta9.getPalo()).thenReturn("C");
		when(carta9.getValorEnInt()).thenReturn(13);
		when(carta10.getValor()).thenReturn("K"); 
		when(carta10.getPalo()).thenReturn("P");
		when(carta10.getValorEnInt()).thenReturn(13);
		
		jugadaOtraPoker.add(carta6);
		jugadaOtraPoker.add(carta7);
		jugadaOtraPoker.add(carta8);
		jugadaOtraPoker.add(carta9);
		jugadaOtraPoker.add(carta10);
		
		assertEquals("Poker",pokerStatus.jugadaGanadora(jugadaPoker,jugadaOtraPoker));
		assertEquals(jugadaOtraPoker, pokerStatus.getJugadaGanadora().getCartas());
	}
	
	@Test
	void testLaJugadaGanadoraEntreColorYTrioEsColor(){
		
		pokerStatus = new PokerStatus();
		
		pokerStatus.agregarJugadas(poker);
		pokerStatus.agregarJugadas(trio);
		pokerStatus.agregarJugadas(color);
		
		List<Carta> jugadaColor = new ArrayList<Carta>();
		List<Carta> jugadaTrio = new ArrayList<Carta>();
		
		//Primera Jugada de tipo Color
		when(carta1.getValor()).thenReturn("A"); 
		when(carta1.getPalo()).thenReturn("D");
		when(carta2.getValor()).thenReturn("5"); 
		when(carta2.getPalo()).thenReturn("D");
		when(carta3.getValor()).thenReturn("7"); 
		when(carta3.getPalo()).thenReturn("C");
		when(carta4.getValor()).thenReturn("4"); 
		when(carta4.getPalo()).thenReturn("C");
		when(carta5.getValor()).thenReturn("10"); 
		when(carta5.getPalo()).thenReturn("C");
		
		jugadaColor.add(carta1);
		jugadaColor.add(carta2);
		jugadaColor.add(carta3);
		jugadaColor.add(carta4);
		jugadaColor.add(carta5);
		
		//Segunda Jugada de tipo Trio
		when(carta6.getValor()).thenReturn("Q"); 
		when(carta6.getPalo()).thenReturn("D");
		when(carta7.getValor()).thenReturn("Q"); 
		when(carta7.getPalo()).thenReturn("C");
		when(carta8.getValor()).thenReturn("Q"); 
		when(carta8.getPalo()).thenReturn("P");
		when(carta9.getValor()).thenReturn("10"); 
		when(carta9.getPalo()).thenReturn("D");
		when(carta10.getValor()).thenReturn("9"); 
		when(carta10.getPalo()).thenReturn("C");
		
		jugadaTrio.add(carta6);
		jugadaTrio.add(carta7);
		jugadaTrio.add(carta8);
		jugadaTrio.add(carta9);
		jugadaTrio.add(carta10);
		
		assertEquals("Color",pokerStatus.jugadaGanadora(jugadaColor,jugadaTrio));
	}
	
	@Test
	void testLaJugadaGanadoraEntreColorYColorEsLaQueTieneCartasMasGrandes(){
		
		pokerStatus = new PokerStatus();
		
		pokerStatus.agregarJugadas(poker);
		pokerStatus.agregarJugadas(trio);
		pokerStatus.agregarJugadas(color);
		
		List<Carta> jugadaColor = new ArrayList<Carta>();
		List<Carta> jugadaOtraColor = new ArrayList<Carta>();
		
		//Primera Jugada de tipo Color mas Grande
		when(carta1.getValor()).thenReturn("A"); 
		when(carta1.getPalo()).thenReturn("D");
		when(carta1.getValorEnInt()).thenReturn(14);
		when(carta2.getValor()).thenReturn("5"); 
		when(carta2.getPalo()).thenReturn("D");
		when(carta2.getValorEnInt()).thenReturn(5);
		when(carta3.getValor()).thenReturn("7"); 
		when(carta3.getPalo()).thenReturn("C");
		when(carta3.getValorEnInt()).thenReturn(7);
		when(carta4.getValor()).thenReturn("4"); 
		when(carta4.getPalo()).thenReturn("C");
		when(carta4.getValorEnInt()).thenReturn(4);
		when(carta5.getValor()).thenReturn("10"); 
		when(carta5.getPalo()).thenReturn("C");
		when(carta5.getValorEnInt()).thenReturn(10);
		
		jugadaColor.add(carta1);
		jugadaColor.add(carta2);
		jugadaColor.add(carta3);
		jugadaColor.add(carta4);
		jugadaColor.add(carta5);
		
		//Segunda Jugada de tipo Color mas Chica
		when(carta6.getValor()).thenReturn("2"); 
		when(carta6.getPalo()).thenReturn("D");
		when(carta6.getValorEnInt()).thenReturn(2);
		when(carta7.getValor()).thenReturn("3"); 
		when(carta7.getPalo()).thenReturn("C");
		when(carta7.getValorEnInt()).thenReturn(3);
		when(carta8.getValor()).thenReturn("4"); 
		when(carta8.getPalo()).thenReturn("C");
		when(carta8.getValorEnInt()).thenReturn(4);
		when(carta9.getValor()).thenReturn("5"); 
		when(carta9.getPalo()).thenReturn("D");
		when(carta9.getValorEnInt()).thenReturn(5);
		when(carta10.getValor()).thenReturn("6"); 
		when(carta10.getPalo()).thenReturn("C");
		when(carta10.getValorEnInt()).thenReturn(6);
		
		jugadaOtraColor.add(carta6);
		jugadaOtraColor.add(carta7);
		jugadaOtraColor.add(carta8);
		jugadaOtraColor.add(carta9);
		jugadaOtraColor.add(carta10);
		
		
		
		//Dice que la jugadaOtraColor es mayor cuando tiene menos valor.
		assertEquals("Color",pokerStatus.jugadaGanadora(jugadaColor,jugadaOtraColor));
		assertEquals(jugadaOtraColor, pokerStatus.getJugadaGanadora().getCartas());
	}
	
	@Test
	void testLaJugadaGanadoraEntreTrioYTrioEsLaQueTieneCartasMasGrandes(){
		
		pokerStatus = new PokerStatus();
		
		pokerStatus.agregarJugadas(poker);
		pokerStatus.agregarJugadas(trio);
		pokerStatus.agregarJugadas(color);
		
		List<Carta> jugadaTrio = new ArrayList<Carta>();
		List<Carta> jugadaOtraTrio = new ArrayList<Carta>();
		
		//Primera Jugada de tipo Trio mas Grande
		when(carta1.getValor()).thenReturn("6"); 
		when(carta1.getPalo()).thenReturn("D");
		when(carta2.getValor()).thenReturn("6"); 
		when(carta2.getPalo()).thenReturn("T");
		when(carta3.getValor()).thenReturn("6"); 
		when(carta3.getPalo()).thenReturn("P");
		when(carta4.getValor()).thenReturn("4"); 
		when(carta4.getPalo()).thenReturn("T");
		when(carta5.getValor()).thenReturn("10"); 
		when(carta5.getPalo()).thenReturn("P");
		
		jugadaTrio.add(carta1);
		jugadaTrio.add(carta2);
		jugadaTrio.add(carta3);
		jugadaTrio.add(carta4);
		jugadaTrio.add(carta5);
		
		//Segunda Jugada de tipo Trio mas Chica
		when(carta6.getValor()).thenReturn("1"); 
		when(carta6.getPalo()).thenReturn("D");
		when(carta7.getValor()).thenReturn("1"); 
		when(carta7.getPalo()).thenReturn("C");
		when(carta8.getValor()).thenReturn("1"); 
		when(carta8.getPalo()).thenReturn("T");
		when(carta9.getValor()).thenReturn("2"); 
		when(carta9.getPalo()).thenReturn("P");
		when(carta10.getValor()).thenReturn("3"); 
		when(carta10.getPalo()).thenReturn("C");
		
		jugadaOtraTrio.add(carta6);
		jugadaOtraTrio.add(carta7);
		jugadaOtraTrio.add(carta8);
		jugadaOtraTrio.add(carta9);
		jugadaOtraTrio.add(carta10);
		
		//Dice que la jugadaOtraColor es mayor cuando tiene menos valor.
		assertEquals("Trio",pokerStatus.jugadaGanadora(jugadaTrio,jugadaOtraTrio));
		assertEquals(jugadaOtraTrio, pokerStatus.getJugadaGanadora().getCartas());
	}
}
