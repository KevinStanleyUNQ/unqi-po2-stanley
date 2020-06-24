package TP5AbstractaEInterfacesTest;

public class ProductoTradicional extends Producto{

	public ProductoTradicional(String nombre, float precio) 
		{
			super(nombre, precio);
		}

	@Override
	public float getPrecio() 
		{	
			return (this.precio);
		}

}
