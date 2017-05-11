package es.ucm.fdi.iw.validation;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;

public class Mensaje {
	private static final Logger log = Logger.getLogger(Login.class);
	
	@NotEmpty(message = "El campo esta vacio")
	private String remitente;
	
	@NotEmpty(message = "El campo esta vacio")	
	private String asunto;
	
	@NotEmpty(message = "El campo esta vacio")
	private String mensaje;

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
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

