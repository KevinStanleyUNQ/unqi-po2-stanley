package ReproductorMP3Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ReproductorMP3.Modo;
import ReproductorMP3.ModoPausa;
import ReproductorMP3.ModoReproduccion;
import ReproductorMP3.ModoSeleccionDeCancion;
import ReproductorMP3.ModoStop;
import ReproductorMP3.ReproductorMP3;
import ReproductorMP3.Song;
import static org.mockito.Mockito.*;

class ReproductorMp3Test {
	
	ReproductorMP3 reproductor;
	Modo enSeleccion;
	Modo pausa;
	Modo stop;
	Modo reproduccion;
	Song song;
	Song song2;
	
	
	@BeforeEach
	void setUp(){
		
		reproductor = new ReproductorMP3();
		
		enSeleccion = new ModoSeleccionDeCancion();
		pausa = new ModoPausa();
		stop = new ModoStop();
		reproduccion = new ModoReproduccion();
		song = mock(Song.class);
		song2 = mock(Song.class);
		
		when(song.play()).thenReturn("Reproduciendo: Cancion 1");
		when(song.pause()).thenReturn("Pausada: Cancion 1");
		when(song.stop()).thenReturn("Seleccione una Cancion");
		when(song2.play()).thenReturn("Reproduciendo: Cancion 2");
	}

	@Test
	void testElReproductorEstaEnModoSeleccionDeCancionesYSeQuiereReproducirUnaCancion(){
	
		assertEquals("Reproduciendo: Cancion 1",reproductor.play(song));
	}
	
	@Test
	void testElReproductorEstaEnModoPausaYSeQuiereReproducirOtraCancion(){
		
		assertEquals("Reproduciendo: Cancion 1",reproductor.play(song));			
		assertEquals("Pausada: Cancion 1",reproductor.pause());
		assertEquals("Error, hay una cancion en curso",
					 reproductor.play(song2));
		
	}
	
	@Test
	void testElReproductorEstaEnModoReproduccionYSeLePonePausaALaCancion(){
		
		assertEquals("Reproduciendo: Cancion 1",reproductor.play(song));
		assertEquals("Pausada: Cancion 1",reproductor.pause());
		assertEquals("Reproduciendo: Cancion 1",reproductor.pause());
	}
	
	@Test
	void testElReproductorEstaEnModoSeleccionDeCancionYSeIntentaPonerPause(){
		
		assertEquals("Error, no hay cancion en reproduccion",reproductor.pause());
	}
	
	@Test
	void testElReproductoEstaEnModoSeleccionDeCancionesSeReproduceUnaCancionYLuegoSePoneStopParaPasarASeleccionDeCancion(){
		
		assertEquals("Reproduciendo: Cancion 1",reproductor.play(song));
		assertEquals("Seleccione una cancion", reproductor.stop());	
	}
	
	@Test
	void testElReproductorEstaEnModoReproduccionSePonePausaYLuegoStopParaPasarASeleccionDeCancion(){
		
		assertEquals("Reproduciendo: Cancion 1",reproductor.play(song));
		assertEquals("Pausada: Cancion 1",reproductor.pause());
		assertEquals("Seleccione una cancion", reproductor.stop());	
	}
	
	@Test
	void testElReproductoEstaEnModoReproduccionSePoneStopYNuevamenteStopPeroNoHaceNada(){
		
		assertEquals("Reproduciendo: Cancion 1",reproductor.play(song));
		assertEquals("Seleccione una cancion", reproductor.stop());
		
		//Este ultimo muestra que no cambio nada que sigue solicitando una cancion para reproducir.
		assertEquals("Seleccione una cancion", reproductor.stop());
	}
	
	@Test
	void testElReproductorEstaEnModoSeleccionDeCancionYSePoneStop(){
		
		//Se ve como no hace nada ya que mantiene el mismo String.
		assertEquals("Seleccione una cancion", reproductor.stop());
	}

}
