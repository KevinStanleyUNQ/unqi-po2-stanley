package BancoYPrestamosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BancoYPrestamos.Banco;
import BancoYPrestamos.Cliente;
import BancoYPrestamos.PropiedadInmobiliaria;
import BancoYPrestamos.SistemaInformatico;

class ClienteTest {
	
	SistemaInformatico sistema;
	Cliente cliente;
	Banco banco;
	PropiedadInmobiliaria propiedad;
	
	@BeforeEach
	void setUp(){
		
		sistema = new SistemaInformatico();
		banco = new Banco(sistema);		
	}

	@Test
	void testElClienteSolicitaUnCreditoPersonalAlBanco(){
		
		cliente = new Cliente("Pepe","Pipo","Calle 123",43,20000f);
		banco.setDinero(100000f);
		
		cliente.solicitarCreditoPersonal(banco,5000f,4);
		
		assertEquals(5000f, cliente.creditoObtenido());
		assertEquals(25000f, cliente.sueldoNeto());
		
	}
	
	@Test
	void testElClienteSolicitaUnCreditoPersonalAlBancoYEsteNoSeLoDa(){
		
		cliente = new Cliente("Pepe","Pipo","Calle 123",43,1000f);
		banco.setDinero(100000f);
		
		cliente.solicitarCreditoPersonal(banco,900f,4);
		
		assertEquals(0f, cliente.creditoObtenido());
		assertEquals(1000f, cliente.sueldoNeto());		
	}
	
	@Test
	void testElClienteSolicitaUnCreditoHipotecarioAlBanco(){
		
		cliente = new Cliente("Pepe","Pipo","Calle 123",43,25000f);
		propiedad = new PropiedadInmobiliaria("Algo","Calle Falsa",30000f);
		banco.setDinero(100000f);
		
		cliente.solicitarCreditoHipotecario(banco, 6000f, 8,propiedad);
		
		assertEquals(6000f, cliente.creditoObtenido());
		assertEquals(31000f, cliente.sueldoNeto());		
	}
	
	@Test
	void testElClienteSolicitaUnCreditoHipotecarioAlBancoYEsteNoSeLoDa(){
		
		cliente = new Cliente("Pepe","Pipo","Calle 123",43,2500f);
		propiedad = new PropiedadInmobiliaria("Algo","Calle Falsa",12000f);
		banco.setDinero(100000f);
		
		cliente.solicitarCreditoHipotecario(banco, 6000f, 3,propiedad);
		
		assertEquals(0f, cliente.creditoObtenido());
		assertEquals(2500f, cliente.sueldoNeto());		
	}
	
	@Test
	void testElClienteSolicitaUnCreditoHipotecarioAlBancoYEsteNoSeLoDaPorSerMayorDe65Anios(){
		
		cliente = new Cliente("Pepe","Pipo","Calle 123",66,25000f);
		propiedad = new PropiedadInmobiliaria("Algo","Calle Falsa",30000f);
		banco.setDinero(100000f);
		
		cliente.solicitarCreditoHipotecario(banco, 6000f, 8,propiedad);
		
		assertEquals(0f, cliente.creditoObtenido());
		assertEquals(25000f, cliente.sueldoNeto());
	}
}
