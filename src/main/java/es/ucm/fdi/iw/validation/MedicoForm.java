package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import es.ucm.fdi.iw.model.Medico;

public class MedicoForm {
	
	//Estado inicial 0 (Validacion)
	private final int estado=0;
	//Role del usuario
	private final String role="MED";
	
	//Variables de entrada que validar	
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "^[a-zA-Z ]+$",message = "El nombre no puede contener numeros ni caracteres especiales")
	private String nombre;
	
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "^[a-zA-Z ]+$",message = "los apellidos no pueden contener numeros ni caracteres especiales")	
	private String apellidos;
	
	@NotEmpty(message = "El campo esta vacio")
	@Email(message = "La direccion email no es correcta")
	private String email;
	
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[0-9]*",message = "El telefono ha de ser numerico")
	@Size(min=9,max=9,message = "El telefono debe de tener 9 digitos")
	private String telefono;
	
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[A-Za-z0-9]*",message = "El usuario no puede contener numeros ni caracteres especiales")
	private String usuario;
	
	@Size(min=4,max=8,message = "La contraseña debe de tener entre 4 y 8 caracteres alfanumericos")
	@Pattern(regexp = "[A-Za-z0-9]*",message = "La contraseña no puede contener caracteres especiales")
	private String contrasenia;
	
	@Size(min=4,max=8,message = "La contraseña debe de tener entre 4 y 8 caracteres alfanumericos")
	@Pattern(regexp = "[A-Za-z0-9]*",message = "La contraseña no puede contener caracteres especiales")
	private String contraseniaRep;
	
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{6}",message = "El numero de colegiado no es valido, debe de seguir el formato nn/mm/pppppp")
	private String numColMedico;
	
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "El centro de trabajo no puede contener numeros ni caracteres especiales")
	private String centroTrabajo;
	
	//Devuelve un medico con los datos extraidos del form
	public Medico getMedico()
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Medico medico= new Medico();
		//Datos genericos
		medico.setNombre(nombre);
		medico.setApellidos(apellidos);
		medico.setTelefono(telefono);
		medico.setEmail(email);
		//Datos usuario y estado y role
		medico.setRole(role);
		medico.setEstado(estado);
		medico.setUsuario(usuario);
		medico.setContrasenia(passwordEncoder.encode(contrasenia));
		//Datos especificos
		medico.setNumColMedico(numColMedico);
		medico.setCentroTrabajo(centroTrabajo);
		return medico;
	}
	
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
	public String getcontraseniaRep() {
		return contraseniaRep;
	}
	public void setcontraseniaRep(String contraseniaRep) {
		this.contraseniaRep = contraseniaRep;
	}
	public String getNumColMedico() {
		return numColMedico;
	}
	public void setNumColMedico(String numColMedico) {
		this.numColMedico = numColMedico;
	}
	public String getCentroTrabajo() {
		return centroTrabajo;
	}
	public void setCentroTrabajo(String centroTrabajo) {
		this.centroTrabajo = centroTrabajo;
	}	
}
