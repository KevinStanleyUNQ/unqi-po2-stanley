package ClienteDeEmail;

import java.util.ArrayList;

public class ClienteEMail {
	
	/*
	 * Si quiero agregar otro Servidor debo editar en Atributo servidor y cambiarlo en el constructor. 
	 * Rompe el Principio de Inversion de Dependencias(D), Principio de Sustitucion de Liskov (L).
	 * 
	 * Cambie el Atributo ServidorPop por la Interfaz IServidor donde ServidorPop la implementa.
	 */
	
	 private IServidor servidor;
	 private String nombreUsuario;
	 private String passusuario;
	 private ArrayList<Correo> inbox;
	 private ArrayList<Correo> borrados;
	
	public ClienteEMail(IServidor servidor, String nombreUsuario, String pass){
		this.servidor=servidor;
		this.nombreUsuario=nombreUsuario;
		this.passusuario=pass;
		this.inbox = new ArrayList<Correo>();
		this.borrados = new ArrayList<Correo>();
		this.conectar();
	}
	
	public void conectar(){
		this.servidor.conectar(this.nombreUsuario,this.passusuario);
	}
	
	public void borrarCorreo(Correo correo){
		this.inbox.remove(correo);
		this.borrados.remove(correo);
	}
	
	public int contarBorrados(){
		return this.borrados.size();
	}
	
	public int contarInbox(){
		return this.inbox.size();
	}
	
	public void eliminarBorrado(Correo correo){
		this.borrados.remove(correo);
	}
	
	public void recibirNuevos(){
		this.servidor.recibirNuevos(this.nombreUsuario, this.passusuario);
	}
	
	public void enviarCorreo(String asunto, String destinatario, String cuerpo){
		Correo correo = new Correo(asunto, destinatario, cuerpo);
		this.servidor.enviar(correo);
	}

}
