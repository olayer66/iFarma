package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.apache.log4j.Logger;

public class CrearPaciente {
	//logger
	private static final Logger log = Logger.getLogger(Login.class);

	//variables a validar
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[A-Za-z]*",message = "El nombre no puede contener numeros ni caracteres especiales")
	private String nombre;

	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[A-Za-z\n]*",message = "los apellidos no pueden contener numeros ni caracteres especiales")
	private String apellidos;

	@NotEmpty(message = "El campo esta vacio")
	@Email(message = "La direccion email no es correcta")
	private String email;

	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[0-9]*",message = "El telefono ha de ser numerico")
	private String telefono;

	//Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
