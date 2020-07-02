package VideoJuegoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import VideoJuego.Estado;
import VideoJuego.EstadoSeIngresoDosFichas;
import VideoJuego.EstadoSeIngresoUnaFicha;
import VideoJuego.VideoJuego;

class VideojuegoTest {
	
	VideoJuego videoJuego;
	Estado sinFichas;
	Estado seIngresoUnaFicha;
	Estado seIngresoDosFichas;
	
	@BeforeEach
	void setUp(){
		
		videoJuego = new VideoJuego();
		seIngresoUnaFicha = new EstadoSeIngresoUnaFicha();
		seIngresoDosFichas = new EstadoSeIngresoDosFichas();
		
		videoJuego.agregarEstados(seIngresoUnaFicha);
		videoJuego.agregarEstados(seIngresoDosFichas);
		
	}

	@Test
	void testElvideoJuegoNoTieneFichasYSePresionaInicio(){
		
		assertEquals("Ingresar Fichas",videoJuego.presionarInicio());
	}
	
	@Test
	void testElVideoJuegoNoTieneFichasYSeLeAgregaUna(){
		
		videoJuego.insertarFicha();
		
		assertEquals("Comienzo para un unico Jugador", videoJuego.presionarInicio());
		
	}
	
	@Test
	void testElVideoJuegoNoTieneFichasYSeLeAgregaDosFichas(){
		
		videoJuego.insertarFicha();
		videoJuego.insertarFicha();
		
		assertEquals("Comienzo para dos Jugadores",videoJuego.presionarInicio());
	}
	
	@Test
	void testElVideoJuegoYaFinalizo(){
		
		videoJuego.insertarFicha();
		
		assertEquals("Comienzo para un unico Jugador", videoJuego.presionarInicio());
		
		videoJuego.finalizarJuego();
		
		assertEquals("Ingresar Fichas", videoJuego.presionarInicio());
	}

}
