package BancoYPrestamosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BancoYPrestamos.Banco;
import BancoYPrestamos.Cliente;
import BancoYPrestamos.PropiedadInmobiliaria;
import BancoYPrestamos.SistemaInformatico;

class BancoTest {
	
	SistemaInformatico sistema;
	Cliente cliente;
	PropiedadInmobiliaria propiedad;
	Banco banco;
	
	
	@BeforeEach
	void setUp(){
		
		sistema = new SistemaInformatico();
		banco = new Banco(sistema);
		propiedad = new PropiedadInmobiliaria("Ejemplo","Calle 123",50000f);		
	}
	

	@Test
	void testElBancoBrindaUnCreditoPersonal(){
			
			cliente = new Cliente("Pepe","Pipo","Calle 123",43,20000f);
			banco.setDinero(100000f);
			cliente.solicitarCreditoPersonal(banco, 4000, 4);
			
			assertEquals(96000f, banco.getDineroTotal());
	}
	
	@Test
	void testElBancoNoBrindaUnCreditoPersonal(){
		
		cliente = new Cliente("Pepe","Pipo","Calle 123",43,2500f);
		banco.setDinero(100000f);
		cliente.solicitarCreditoPersonal(banco, 6000, 3);
		
		assertEquals(100000f, banco.getDineroTotal());	
	}
	
	@Test
	void testElBancoBrindaUnCreditoHipotecario(){
		
		cliente = new Cliente("Pepe","Pipo","Calle 123",43,25000f);
		propiedad = new PropiedadInmobiliaria("Algo","Calle Falsa",30000f);
		banco.setDinero(100000f);
		
		cliente.solicitarCreditoHipotecario(banco, 6000f, 8,propiedad);
		
		assertEquals(94000f, banco.getDineroTotal());
	}
	
	@Test
	void testElBancoNoBrindaUnCreditoHipotecario(){
		
		cliente = new Cliente("Pepe","Pipo","Calle 123",43,2500f);
		propiedad = new PropiedadInmobiliaria("Algo","Calle Falsa",12000f);
		banco.setDinero(100000f);
		
		cliente.solicitarCreditoHipotecario(banco, 6000f, 3,propiedad);
		
		assertEquals(100000f, banco.getDineroTotal());
	}

}
