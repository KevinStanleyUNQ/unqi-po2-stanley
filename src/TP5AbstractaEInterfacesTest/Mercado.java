package TP5AbstractaEInterfacesTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mercado {
	
	List <Producto> stockDelMercado = new ArrayList<Producto>();

	public void agregarAlStock(Producto producto)
		{
			stockDelMercado.add(producto);
		}

	public boolean contieneElProducto(Producto producto)
		{
			
			return(this.stockDelMercado.contains(producto));
		}

	public void descontarProductoDelStock(Producto unProducto)
		{
			this.stockDelMercado.remove(unProducto);
			
		}

	public Integer cantidadDeProductos(Producto unProducto)
		{
			
			List <Producto> productosIgualesPedido = this.stockDelMercado.stream()
													.filter(i -> i.equals(unProducto))
													.collect(Collectors.toList());
		
				return (productosIgualesPedido.size());
		}

}
