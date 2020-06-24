package TP5AbstractaEInterfacesTest;

public abstract class Producto {

	String nombre;
	float precio;
	
	public Producto(String nombre, float precio)
		{
			this.nombre = nombre;
			this.precio = precio;
		}

	public abstract float getPrecio();
	
	public Boolean equals(Producto unProducto)
		{
			return((this.nombre == unProducto.nombre)&&(this.precio == unProducto.precio));
		}

}
