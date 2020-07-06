package TP8CompositeTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TP8Composite.IGananciaAnual;
import TP8Composite.Mixto;
import TP8Composite.Porcion;
import TP8Composite.Soja;
import TP8Composite.Trigo;

class cultivoTest {
	
	Porcion porcion;
	Trigo trigo1;
	Trigo trigo2;
	Trigo trigo3;
	Soja soja1;
	Soja soja2;
	Soja soja3;
	Soja soja4;
	Mixto mixto1;
	Mixto mixto2;
	
	@BeforeEach
	void setUp()
		{
			trigo1 = new Trigo();
			trigo2 = new Trigo();
			trigo3 = new Trigo();
			soja1 = new Soja();
			soja2 = new Soja();
			soja3 = new Soja();
			soja4 = new Soja();
			mixto1 = new Mixto();	
			mixto2 = new Mixto();
			porcion = new Porcion();		
		}

	@Test
	void testPorcionConTresCultivosPurosYUnoMixto() 
		{
			porcion.agregarRegion(trigo1);
			porcion.agregarRegion(soja1);
			porcion.agregarRegion(soja2);
			porcion.agregarRegion(mixto1);
			
			mixto1.agregarRegion(soja3);
			mixto1.agregarRegion(soja4);
			mixto1.agregarRegion(trigo2);
			mixto1.agregarRegion(trigo3);
			
			assertEquals(1700, porcion.getGananciaAnual());
		}
	
	@Test
	void testPorcionConDosMixtosYDosPuros()
		{
			porcion.agregarRegion(trigo1);
			porcion.agregarRegion(soja1);
			porcion.agregarRegion(mixto1);
			porcion.agregarRegion(mixto2);
		
			mixto1.agregarRegion(soja3);
			mixto1.agregarRegion(soja4);
			mixto1.agregarRegion(trigo2);
			mixto1.agregarRegion(trigo3);
			
			mixto2.agregarRegion(soja2);
			mixto2.agregarRegion(soja1);
			mixto2.agregarRegion(trigo2);
			mixto2.agregarRegion(trigo1);
			
			assertEquals(1600, porcion.getGananciaAnual());
		}
	
	@Test
	void testUnaPorcionPoseeLasRegionesUnoDeTrigoUnoDeSojaYDosMixto()
		{
			ArrayList <IGananciaAnual> childs = new ArrayList<IGananciaAnual>();
			
			porcion.agregarRegion(trigo1);
			porcion.agregarRegion(soja1);
			porcion.agregarRegion(mixto1);
			porcion.agregarRegion(mixto2);
	
			mixto1.agregarRegion(soja3);
			mixto1.agregarRegion(soja4);
			mixto1.agregarRegion(trigo2);
			mixto1.agregarRegion(trigo3);
			
			childs.add(trigo1);
			childs.add(soja1);
			childs.add(mixto1);
			childs.add(mixto2);
			
			assertEquals(childs, porcion.getChild());
		}

}
