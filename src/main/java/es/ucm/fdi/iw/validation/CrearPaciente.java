package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class CrearPaciente {

	//variables a validar
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.textoEspecial ,message = Patrones.menTextoEspecial)
	private String nombre;

	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.textoEspecial ,message = Patrones.menTextoEspecial)
	private String apellidos;

	@NotEmpty(message = Patrones.menVacio)
	@Email(message = Patrones.menEmail)
	private String email;

	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.numero ,message = Patrones.menNumero)
	@Size(min=9,max=9,message = Patrones.menTelefono)
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
