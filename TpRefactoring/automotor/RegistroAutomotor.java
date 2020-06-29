package automotor;

import java.time.LocalDate;

public class RegistroAutomotor {

	public Boolean debeRealizarVtv(Vehiculo vehiculo, LocalDate fecha) {

		LocalDate fechaFabricacion = vehiculo.getFechaFabricacion();
		Boolean esVehiculoPolicial = vehiculo.esVehiculoPolicial();
		String ciudadRadicacion = vehiculo.ciudadRadicacion();
		
		// Vehiculos policiales no realizan vtv, ya que tienen otro tipo de control
		// solo realizan vtv los vehiculos con mas de 1 anio de antiguedad y radicados
		// en 'Buenos Aires'
		return (chequearTodosLosDatos(fecha, esVehiculoPolicial,ciudadRadicacion,fechaFabricacion));

	}

	private Boolean chequearTodosLosDatos(LocalDate unaFecha, Boolean esVehiculoPolicial,
										  String unaCiudadRadicacion, LocalDate fechaFabricacion){
		
		return (!esVehiculoPolicial && comprobarSiTieneMasDeUnAño(fechaFabricacion, unaFecha)
				&& unaCiudadRadicacion.equalsIgnoreCase("Buenos Aires"));
	}

	private boolean comprobarSiTieneMasDeUnAño(LocalDate fechaFabricacion, LocalDate unaFecha) {

		return (unaFecha.minusYears(1).isAfter(fechaFabricacion));
	}
	
	/*
	 * Poseia como Bad Smells muchas condiciones en un mismor Return en lenguaje Java que no describian nada,
	 * extraje todas esas condiciones a un Metodo que si describia mas y en el Metodo creado, implemente la 
	 * creacion de otros Metodos mas pequeños para que se entiende que es lo que se esta haciendo.
	 * */
	
}


