package ClienteDeEmail;

import java.util.ArrayList;
import java.util.List;

public class ServidorPop implements IServidor {

	public List<Correo> recibirNuevos(String unUser, String unaPass){
		
		List<Correo> retorno = new ArrayList<Correo>();
	  //Verificar autenticidad de usuario.
		//obtener emails Nuevos del usuario.
		//asignar a retorno la lista de los nuevos e-mails.
		return retorno;
	}

	public void conectar(String nombreUsuario, String passusuario){
	   //Verifica que el usuario sea valido y establece la conexion.		
		
	}

	public void enviar(Correo correo) {
      //realiza lo necesario para enviar el correo.		
	}
	
	/*
	 * Extraje el método resetear, tazaDeTransferencia, y realizarBackUp a otra Interfaz de Servidor 
	 * ya que ServidorPop no implementaba estos métodos, pero tal vez otro Servidor si lo haga.
	 * 
	 * Aplique el Principio de Segregación de Interfaz (I).
	 **/

}
