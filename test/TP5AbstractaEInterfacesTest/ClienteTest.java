package TP5AbstractaEInterfacesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
	
	Caja caja;
	Mercado mercado;
	Cliente cliente1;
	Producto producto1;
	Producto producto2;
	
	@BeforeEach
	void setUp()
		{
			mercado = new Mercado();
			caja = new Caja();
			producto1 = new ProductoTradicional("Sprite", 55f);
			producto2 = new ProductoCooperativa("Pan", 50f);
			cliente1 = new Cliente();
		}

	@Test
	void testElClienteRecibeElAvisoDeCuantoDebePagar()
		{
			mercado.agregarAlStock(producto1);
			mercado.agregarAlStock(producto2);
			cliente1.comprarProducto(producto1);
			cliente1.comprarProducto(producto2);
			caja.registrarProductosDelCliente(cliente1, mercado);
			
			assertEquals(100f, cliente1.montoQueDebePagar());
		}

}
