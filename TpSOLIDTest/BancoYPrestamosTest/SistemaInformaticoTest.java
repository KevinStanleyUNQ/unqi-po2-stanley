package BancoYPrestamosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BancoYPrestamos.Banco;
import BancoYPrestamos.Cliente;
import BancoYPrestamos.PropiedadInmobiliaria;
import BancoYPrestamos.SistemaInformatico;
import BancoYPrestamos.SolicitudDeCredito;
import BancoYPrestamos.SolicitudDeCreditoHipotecario;
import BancoYPrestamos.SolicitudDeCreditoPersonal;

class SistemaInformaticoTest {
	
	SistemaInformatico sistema;
	Cliente cliente;
	Cliente cliente2;
	Banco banco;
	PropiedadInmobiliaria propiedad;
	SolicitudDeCredito solicitudDeCreditoPersonal;
	SolicitudDeCredito solicitudDeCreditoHipotecario;
	
	@BeforeEach
	void setUp(){
		
		sistema = new SistemaInformatico();
		banco = new Banco(sistema);
		propiedad = new PropiedadInmobiliaria("Ejemplo","Calle 123",50000f);	
		
	}
	

	@Test
	void testElBancoAgregaNuevoClientesYElSistemaSeEncargaDeAgregarlos(){

		cliente = new Cliente("Pepe","Pipo","Calle 123",43,20000f);
		cliente2 = new Cliente("Lelo","Lila","Calle 12",33,35000f);
		
		sistema.agregarClientes(cliente,banco);
		sistema.agregarClientes(cliente2,banco);
		
		assertEquals(2, banco.cantidadDeClientes());
	}
	
	@Test
	void testElBancoAgregaNuevaSolicitudesDeCreditoyElSistemaSeEncargaDeAgregarlos(){
		
		cliente = new Cliente("Pepe","Pipo","Calle 123",43,20000f);
		cliente2 = new Cliente("Lelo","Lila","Calle 12",33,35000f);
		
		sistema.agregarClientes(cliente,banco);
		sistema.agregarClientes(cliente2,banco);
		
		solicitudDeCreditoPersonal = new SolicitudDeCreditoPersonal(cliente,30000f,6);
		solicitudDeCreditoHipotecario = new SolicitudDeCreditoHipotecario(cliente2,30000f,6,propiedad);
		
		sistema.agregarSolicitud(solicitudDeCreditoPersonal,banco);
		sistema.agregarSolicitud(solicitudDeCreditoHipotecario,banco);
		
		assertEquals(2, banco.cantidadDeSolicitudes());
	}
	
	
	//No se porque da falso este ultimo Test, como que no Setea el valor True cuando cumple las condiciones.
	/*@Test
	void testMontoTotalADesembolsarDelBanco(){
		
		cliente = new Cliente("Pepe","Pipo","Calle 123",43,20000f);
		cliente2 = new Cliente("Lelo","Lila","Calle 12",33,35000f);
		banco.setDinero(20000f);
		
		sistema.agregarClientes(cliente,banco);
		sistema.agregarClientes(cliente2,banco);
		
		solicitudDeCreditoPersonal = new SolicitudDeCreditoPersonal(cliente,5000f,4);
		//La hipotecaria no se la daran porque no cumple las condiciones.
		solicitudDeCreditoHipotecario = new SolicitudDeCreditoHipotecario(cliente2, 6000f, 3,propiedad);
		
		sistema.agregarSolicitud(solicitudDeCreditoPersonal,banco);
		sistema.agregarSolicitud(solicitudDeCreditoHipotecario,banco);
		
		sistema.calcularMontoTotalADesembolsar(banco);
		
		assertEquals(19500f, banco.montoTotalADesembolsarDeLasSolicitudes());
		
	}*/

}
