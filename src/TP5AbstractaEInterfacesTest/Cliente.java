package TP5AbstractaEInterfacesTest;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private float montoAPagar = 0f;
	
	private List <Producto> productosAComprar = new ArrayList<Producto>();

	public void comprarProducto(Producto unProducto)
		{
			productosAComprar.add(unProducto);
		}

	public List<Producto> getProductosAComprar()
		{	
			return (this.productosAComprar);
		}

	public Float montoQueDebePagar()
		{
			return montoAPagar;
		}

	public void recibirNotificacionDelMontoAPagar(float unMonto)
		{
			this.montoAPagar = unMonto;
		}

}
