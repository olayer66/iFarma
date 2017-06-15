package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

public class MensajeForm {
	
	@NotEmpty(message = Patrones.menVacio)
	private String destinatario;
	
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.textoEspecial ,message = Patrones.menTextoEspecial)
	private String asunto;
	
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.textoEspecial ,message = Patrones.menTextoEspecial)
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

