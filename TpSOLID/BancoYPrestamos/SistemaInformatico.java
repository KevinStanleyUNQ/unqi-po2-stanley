package BancoYPrestamos;


import java.util.List;
import java.util.stream.Collectors;

public class SistemaInformatico {

	public void agregarClientes(Cliente unCliente, Banco unBanco){
		
		List<Cliente> clientes = unBanco.getClientes();
		clientes.add(unCliente);
	}

	public void agregarSolicitud(SolicitudDeCredito unaSolicitudDeCredito, Banco unBanco) {
		
		List<SolicitudDeCredito> solicitudes = unBanco.getSolicitudes();
		solicitudes.add(unaSolicitudDeCredito);
	}

	public void calcularMontoTotalADesembolsar(Banco unBanco){
		
		float montoTotal = 0f;
		List<SolicitudDeCredito> solicitudes = unBanco.getSolicitudes();
		System.out.println(solicitudes);
		List<SolicitudDeCredito> solicitudesAceptadas = solicitudes.stream().filter(i -> i.getEstado()).collect(Collectors.toList());
		
		
		for(SolicitudDeCredito solicitud:solicitudesAceptadas){
			
			montoTotal += solicitud.getMonto();
		}
		
		unBanco.setDineroADesembolsar(montoTotal);
	}
	

}
