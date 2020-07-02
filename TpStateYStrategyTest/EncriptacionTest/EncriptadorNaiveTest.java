package EncriptacionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Encriptacion.EncriptadorANumeros;
import Encriptacion.EncriptadorNaive;
import Encriptacion.EncriptadorPorVocal;
import Encriptacion.FormaDeEncriptar;

class EncriptadorNaiveTest {
	
	EncriptadorNaive encriptadorNaive;
	FormaDeEncriptar encriptadorPorVocal;
	FormaDeEncriptar encriptadorANumeros;
	String stringAEncriptar;
	
	@BeforeEach
	void setUp(){
		
		encriptadorPorVocal = new EncriptadorPorVocal();
		encriptadorANumeros = new EncriptadorANumeros();
		
		stringAEncriptar = "hola mundo";
	}

	@Test
	void testLaEncriptacionEstaBasadaEnModificarCadaVocalALaSiguiente(){
		
		encriptadorNaive = new EncriptadorNaive(encriptadorPorVocal);
			
		assertEquals("hule mandu", encriptadorNaive.encriptar(stringAEncriptar));		
	}
	
	@Test
	void testLaDesencriptacionEstaBasadaEnModificarCadaVocalALaAnterior(){
		
		encriptadorNaive = new EncriptadorNaive(encriptadorPorVocal);
		
		String stringEncriptado = encriptadorNaive.encriptar(stringAEncriptar);
		
		assertEquals("hola mundo", encriptadorNaive.desencriptar(stringEncriptado));
	}
	
	@Test
	void testLaEncriptacionEstaBasadaEnObtenerElTextoEncriptadoANumeros(){
		
		encriptadorNaive = new EncriptadorNaive(encriptadorANumeros);
		
		assertEquals("8,15,12,1,0,13,21,14,4,15", encriptadorNaive.encriptar(stringAEncriptar));
	}
	
	@Test
	void testLaDesencriptacionEstaBasadaEnObtenerElTextoEncriptadoANumerosEnLetras(){
		
		encriptadorNaive = new EncriptadorNaive(encriptadorANumeros);
		
		String stringANumeros = encriptadorNaive.encriptar(stringAEncriptar);
		
		assertEquals("hola mundo", encriptadorNaive.desencriptar(stringANumeros));
	}
	
}

