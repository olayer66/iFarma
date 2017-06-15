package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;


public class Login {

	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.usuario ,message = Patrones.menUsuario)
	private String usuario;
	@NotEmpty(message = Patrones.menVacio)
	@Size(min=4,max=8,message = Patrones.menContrasenia)
	@Pattern(regexp = Patrones.usuario ,message = Patrones.menUsuario)
	private String contrasenia;
	private static final Logger log = Logger.getLogger(Login.class);

	public String hasRole() {
		if (usuario != null && contrasenia != null) {
			if (usuario.equals("admin") && contrasenia.equals("1234")) {
				log.info("Inicio de sesion correcto");
				return "PAC";
			} else {
				log.warn("Fallo en el inicio de sesion");
				return "";
			}
		} else {
			return "";
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
