package TP8CompositeTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TP8Composite.IShapeShifter;
import TP8Composite.ShapeShifterComposite;
import TP8Composite.ShapeShifterLeaf;

class shapeShifterCompositeTest {
	
	ShapeShifterLeaf shapeShifterA;
	ShapeShifterLeaf shapeShifterB;
	ShapeShifterComposite shapeShifterC;
	ShapeShifterLeaf shapeShifterD;
	ShapeShifterComposite shapeShifterComposite;

	
	@BeforeEach
	void setUp()
		{
			shapeShifterA = mock(ShapeShifterLeaf.class);
			shapeShifterB = mock(ShapeShifterLeaf.class);
			shapeShifterD = mock(ShapeShifterLeaf.class);
			
		}
	
	/*
	 * Pensar por que da Vacio.
	 */
	@Test
	void testComposeDeBYCAmbosDeTipoLeafParaFormarUnShapeShifterAComposite()
		{
			when(shapeShifterA.values()).thenReturn(Arrays.asList(1));
			when(shapeShifterB.values()).thenReturn(Arrays.asList(2));
			when(shapeShifterD.values()).thenReturn(Arrays.asList(3));
			
			ShapeShifterComposite compuesto = new ShapeShifterComposite();		
			compuesto.agregarValores(shapeShifterA.values());
			compuesto.agregarValores(shapeShifterB.values());
			compuesto.addShapeShifter(shapeShifterA);
			compuesto.addShapeShifter(shapeShifterB);
			
			//assertEquals(Arrays.asList(3,Arrays.asList(1,2)), shapeShifterDEntreCYD.values());
			assertEquals(2, compuesto.values().size());
			
			ShapeShifterComposite shapeShifterNuevo = compuesto.compose(shapeShifterD);
			assertEquals(3,shapeShifterNuevo.values().size());
			
		}
	
	@Test
	void testComposeDeBYCAmbosDeTipoLeafParaFormarUnShapeShifterACompositeYSuProfundidadEsDos()
		{
			when(shapeShifterA.values()).thenReturn(Arrays.asList(1));
			when(shapeShifterB.values()).thenReturn(Arrays.asList(2));
			when(shapeShifterD.values()).thenReturn(Arrays.asList(3));
			
			ShapeShifterComposite compuesto = new ShapeShifterComposite();		
			compuesto.agregarValores(shapeShifterA.values());
			compuesto.agregarValores(shapeShifterB.values());
			compuesto.addShapeShifter(shapeShifterA);
			compuesto.addShapeShifter(shapeShifterB);
		
			ShapeShifterComposite shapeShifterNuevo = compuesto.compose(shapeShifterD);
			
			assertEquals(2, shapeShifterNuevo.deepest());
		}
}
