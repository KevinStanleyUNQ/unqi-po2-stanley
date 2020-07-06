package TP8CompositeTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TP8Composite.ShapeShifterLeaf;

class shapeShifterLeafTest {
	
	ShapeShifterLeaf shapeShifterA;
	ShapeShifterLeaf shapeShifterB;
	ShapeShifterLeaf shapeShifterE;
	
	@BeforeEach
	void setUp()
		{
			shapeShifterA = new ShapeShifterLeaf();
			shapeShifterB = new ShapeShifterLeaf();	
			shapeShifterE = new ShapeShifterLeaf();
		}
	
	

	@Test
	void testElDepestEsCero()
		{
			assertEquals(0, shapeShifterA.deepest());
		}
	
	@Test
	void testElResultadoDeFlatEsElMismo()
		{
			assertEquals(shapeShifterA, shapeShifterA.flat());
		}
	
	@Test
	void testTieneUnUnicoValorYEsUnaListaConElNumeroUno()
		{
			List<Integer> valorEsperado = Arrays.asList(1);
			shapeShifterA.setValores(1);
		
			assertEquals(valorEsperado, shapeShifterA.values());
		}
	
	@Test
	void testComposeEntreShapeShifterAYShapeShifterBAmbosDeTipoLeaf()
		{
			shapeShifterA.setValores(1);
			shapeShifterB.setValores(2);
			
			assertEquals(Arrays.asList(1,2), (shapeShifterA.compose(shapeShifterB)).values());		
		}
	
	@Test
	void testElComposePoseeLosShapeShifterAYB()
		{
			shapeShifterA.setValores(1);
			shapeShifterB.setValores(2);
			
			assertEquals(Arrays.asList(shapeShifterA,shapeShifterB), (shapeShifterA.compose(shapeShifterB)).getShapeShifters());
		}

}
