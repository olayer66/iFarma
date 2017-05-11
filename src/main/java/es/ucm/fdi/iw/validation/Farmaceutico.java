package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Farmaceutico {
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
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[A-Za-z]*",message = "El usuario no puede contener numeros ni caracteres especiales")
	private String usuario;
	@Size(min=4,max=8,message = "La contraseña debe de tener entre 4 y 8 caracteres alfanumericos")
	@Pattern(regexp = "[A-Za-z0-9]*",message = "La contraseña no puede contener caracteres especiales")
	private String contrasenia;
	@Size(min=4,max=8,message = "La contraseña debe de tener entre 4 y 8 caracteres alfanumericos")
	@Pattern(regexp = "[A-Za-z0-9]*",message = "La contraseña no puede contener caracteres especiales")
	private String contraseniaRep;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[0-9]*",message = "El numero de colegiado ha de ser numerico")
	private String numColFarmaceutico;
	
	public void insertar()
	{
		
	}
	
	//variables de insercion
	private final String tipo="farmaceutico";
	private final int estado=0;
	
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
	public String getContraseniaRep() {
		return contraseniaRep;
	}
	public void setContraseniaRep(String contraseniaRep) {
		this.contraseniaRep = contraseniaRep;
	}
	public String getNumColFarmaceutico() {
		return numColFarmaceutico;
	}
	public void setNumColFarmaceutico(String numColFarmaceutico) {
		this.numColFarmaceutico = numColFarmaceutico;
	}
	public String getTipo() {
		return tipo;
	}
	public int getEstado() {
		return estado;
	}
}
