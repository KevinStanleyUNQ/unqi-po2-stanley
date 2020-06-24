package TP5AbstractaEInterfacesTest;

public class Impuesto extends Factura {
	
	private float tasaDeServicio = 0f;

	@Override
	public float calcularMontoAPagar()
		{	
			return tasaDeServicio;
		}

}
