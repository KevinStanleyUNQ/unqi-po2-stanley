package ClienteDeEmail;

public class Correo {
	
	/*
	 * Cree los atributos, sus respectivos Getters y Setters, y genere su método Constructor.
	 **/
	
	private String asunto;
	private String destinatario;
	private String cuerpo;

	public Correo(String unAsunto, String unDestinatario, String unCuerpo){
		
			this.asunto = unAsunto;
			this.destinatario = unDestinatario;
			this.cuerpo = unCuerpo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void editarAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void editarDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void editarCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

}
