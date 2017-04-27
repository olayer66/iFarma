package es.ucm.fdi.iw.validation;

public class Contrasenia {
	public Contrasenia(String contra,String confContra)
	{
		contrasenia=contra;
		confContrasenia=confContra;
	}
	private String contrasenia;
	private String confContrasenia;
	public String getContrasenia() {
		return contrasenia;
	}
	public String getConfContrasenia() {
		return confContrasenia;
	}	
}
