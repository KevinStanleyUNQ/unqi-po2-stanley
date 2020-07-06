package TP8CompositeTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TP8Composite.Soja;
import TP8Composite.Trigo;

class trigoTest {
	
	Trigo trigo1;
	Soja soja1;
	
	@BeforeEach
	void setUp()
		{
			trigo1 = new Trigo();
			soja1 = new Soja();
		}

	@Test
	void testUnCultivoPuroDeTipoSojaNoPoseeRegiones()
		{
			trigo1.agregarRegion(soja1);
			
			assertEquals(null, trigo1.getChild());
		}
	
	@Test
	void testUnCultivoPuroDeTipoTrigoNoPoseeRegiones()
		{
			soja1.agregarRegion(trigo1);
			
			assertEquals(null, soja1.getChild());
		}

}
