package es.ucm.fdi.iw.login;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;


public class Login {

	@Size(min=1,message = "El campo esta vacio")
	@Pattern(regexp = "[A-Za-z]*",message = "El usuario no puede contener numeros ni caracteres especiales")
	private String usuario;
	@Size(min=4,max=8,message = "La contraseña debe de tener entre 4 y 8 caracteres alfanumericos")
	@Pattern(regexp = "[A-Za-z0-9]*",message = "La contraeña no puede contener caracteres especiales")
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
