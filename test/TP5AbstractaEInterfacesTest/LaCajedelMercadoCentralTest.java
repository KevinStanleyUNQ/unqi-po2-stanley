package TP5AbstractaEInterfacesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LaCajedelMercadoCentralTest {
	
	Caja caja;
	Mercado mercado;
	Cliente cliente1;
	Producto producto1;
	Producto producto2;
	
	@BeforeEach
	void setUp()
		{
			caja = new Caja();
			mercado = new Mercado();
			producto1 = new ProductoCooperativa("Sprite", 55f);
			producto2 = new ProductoTradicional("Pan", 50f);
			cliente1 = new Cliente();
		}
// Cambiar los Test y en vez de pasarle los productos le paso al cliente con los productos.
	@Test
	void testElProductoEsDeTipoTradicionalYSePideElMontoAPagar()
		{
			mercado.agregarAlStock(producto2);
			cliente1.comprarProducto(producto2);
			caja.registrarProductosDelCliente(cliente1, mercado);
			
			assertEquals(50f, caja.montoAPagar());	
		}
	
	@Test
	void testElProductoEsDeTipoCooperativaYTieneUnDescuentoDelDiezPorciento()
		{
			mercado.agregarAlStock(producto1);
			cliente1.comprarProducto(producto1);
			caja.registrarProductosDelCliente(cliente1, mercado);
			
			assertEquals(49.5f, caja.montoAPagar());
		}
	
	@Test
	void testElMontoAPagarTotalDeAmbosProductos()
		{
			mercado.agregarAlStock(producto1);
			mercado.agregarAlStock(producto2);
			cliente1.comprarProducto(producto1);
			cliente1.comprarProducto(producto2);
			caja.registrarProductosDelCliente(cliente1, mercado);
			caja.registrarProductosDelCliente(cliente1, mercado);
			
			assertEquals(99.5f, caja.montoAPagar());
		}
	

}
