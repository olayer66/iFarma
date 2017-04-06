package es.ucm.fdi.iw.login;

import org.apache.log4j.Logger;

import es.ucm.fdi.iw.controller.AdminController;

public class Login {
	
	private String usuario;
	private String contrasenia;
	private static final Logger log = Logger.getLogger(Login.class);
	public boolean login()
	{
		log.info("usuario: "+ usuario);
		log.info("Contraseña: " +contrasenia);
		if(usuario!=null && contrasenia!=null)
		{
			if(usuario.equals("admin") && contrasenia.equals("1234"))
				return true;
			else
				return false;
		}
		else
			return false;
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
