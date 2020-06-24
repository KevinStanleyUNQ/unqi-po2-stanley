package TP5AbstractaEInterfacesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MercadoTest {
	
	Caja caja;
	Mercado mercado;
	Cliente cliente1;
	Producto producto1;
	Producto producto2;
	Producto producto3;
	Producto producto4;
	Producto producto5;
	
	@BeforeEach
	void setUp()
		{
			mercado = new Mercado();
			caja = new Caja();
			producto1 = new ProductoTradicional("Sprite", 55f);
			producto2 = new ProductoCooperativa("Pan", 50f);
			producto3 = new ProductoTradicional("Pan", 50f);
			producto4 = new ProductoTradicional("Pan", 50f);
			producto5 = new ProductoTradicional("Pan", 50f);
			cliente1 = new Cliente();
			
		}
	

	@Test
	void testElClienteCompraDosProductosIgualesDejandoAlStockConDosProductoIguales() 
		{
			mercado.agregarAlStock(producto1);
			mercado.agregarAlStock(producto2);
			mercado.agregarAlStock(producto3);
			mercado.agregarAlStock(producto4);
			mercado.agregarAlStock(producto5);
	
			cliente1.comprarProducto(producto2);
			cliente1.comprarProducto(producto3);
			
			caja.registrarProductosDelCliente(cliente1, mercado);
			
			assertEquals(2, mercado.cantidadDeProductos(producto5));
		}

}
