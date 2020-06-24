package TP5AbstractaEInterfacesTest;

public class ProductoCooperativa extends Producto {

	public ProductoCooperativa(String nombre, float precio)
		{
			super(nombre, precio);
		}

	@Override
	public float getPrecio() 
		{
			float precioADescontar = (this.precio * 10) / 100;		
			return (this.precio - precioADescontar);
		}

}
