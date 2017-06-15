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
	@Pattern(regexp = "[0-9]*",message = Patrones.menNumero)
	@Size(min=9,max=9,message = Patrones.menTelefono)
	private String telefono;
	
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.usuario ,message = Patrones.menUsuario)
	private String usuario;
	
	@Size(min=4,max=8,message = Patrones.menContrasenia)
	@Pattern(regexp = Patrones.usuario ,message = Patrones.menUsuario)
	private String contrasenia;
	
	@Size(min=4,max=8,message = Patrones.menContrasenia)
	@Pattern(regexp = Patrones.usuario ,message = Patrones.menUsuario)
	private String contraseniaRep;
	
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.numColegiado,message = Patrones.menNumColegiado)
	private String numColMedico;
	
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.textoEspecial ,message = Patrones.menTextoEspecial)
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
