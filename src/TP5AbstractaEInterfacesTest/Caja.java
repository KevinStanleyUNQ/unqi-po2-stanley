package TP5AbstractaEInterfacesTest;

import java.util.List;

public class Caja implements Agencia{
	
	private float montoAPagar = 0f;
	private float montoAPagarDeLaFactura = 0f;
	
	public void registrarProductosDelCliente(Cliente unCliente, Mercado unMercado)
		{
			List <Producto> listaDeProductos = unCliente.getProductosAComprar();
			
				for(Producto producto:listaDeProductos)
					{
						cobrarElProductoSiEsQueHayStock(producto,unMercado);
					}
				unCliente.recibirNotificacionDelMontoAPagar(montoAPagar);
		}

	private void cobrarElProductoSiEsQueHayStock(Producto unProducto, Mercado unMercado)
		{
			if(unMercado.contieneElProducto(unProducto))
			{
				this.montoAPagar += unProducto.getPrecio();
				unMercado.descontarProductoDelStock(unProducto);
				
			}
		}

	public float montoAPagar() 
		{
			return montoAPagar;
		}

	@Override
	public void registrarPago(Factura factura)
		{
			montoAPagarDeLaFactura = factura.calcularMontoAPagar();
			notificarPagoALaAgencia(factura.getAgencia());
		}

	private void notificarPagoALaAgencia(Agencia agencia)	
		{
			agencia.registrarPagoDeLaFactura(montoAPagarDeLaFactura);
		}

	@Override
	public void registrarPagoDeLaFactura(float montoAPagarDeLaFactura){}
}
