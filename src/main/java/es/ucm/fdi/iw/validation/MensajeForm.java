package es.ucm.fdi.iw.validation;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;

public class MensajeForm {
	private static final Logger log = Logger.getLogger(Login.class);
	
	@NotEmpty(message = "El campo esta vacio")
	private String destinatario;
	
	@NotEmpty(message = "El campo esta vacio")	
	private String asunto;
	
	@NotEmpty(message = "El campo esta vacio")
	private String mensaje;

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}

