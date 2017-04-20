package es.ucm.fdi.iw.login;

import org.apache.log4j.Logger;
import javax.validation.constraints.*;


public class Login {

	@NotNull
	@Pattern(regexp = "{A-Za-z}*")
	private String usuario;
	@NotNull
	@Size(min=4,max=8)
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String contrasenia;
	private static final Logger log = Logger.getLogger(Login.class);

	public boolean hasRole(String role) {
		if (usuario != null && contrasenia != null) {
			if (usuario.equals("admin") && contrasenia.equals("1234")) {
				log.info("Inicio de sesion correcto");
				return true;
			} else {
				log.warn("Fallo en el inicio de sesion");
				return false;
			}
		} else {
			return false;
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
