package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import es.ucm.fdi.iw.model.Farmaceutico;

public class FarmaceuticoForm {
	
	//variables de insercion
	private final String role="FAR";
	private final int estado=0;
	
	//Varuables de usuario
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
	@Pattern(regexp = Patrones.numero ,message = Patrones.numero)
	@Size(min=9,max=9,message = Patrones.menTelefono)
	private String telefono;
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.usuario ,message = Patrones.menUsuario)
	private String usuario;
	@Size(min=4,max=8,message = "La contraseña debe de tener entre 4 y 8 caracteres alfanumericos")
	@Pattern(regexp = Patrones.usuario ,message = Patrones.menUsuario)
	private String contrasenia;
	@Size(min=4,max=8,message = "La contraseña debe de tener entre 4 y 8 caracteres alfanumericos")
	@Pattern(regexp = Patrones.usuario ,message = Patrones.menUsuario)
	private String contraseniaRep;
	
	//Variables especificas
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.numColegiado,message = Patrones.menNumColegiado)
	private String numColFarmaceutico;
	
	//Devuelve un farmaceutico con los datos extraidos del form
	public Farmaceutico getFarmaceutico()
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Farmaceutico farmaceutico= new Farmaceutico();
		//Datos genericos
		farmaceutico.setNombre(nombre);
		farmaceutico.setApellidos(apellidos);
		farmaceutico.setTelefono(telefono);
		farmaceutico.setEmail(email);
		//Datos usuario y estado y role
		farmaceutico.setRole(role);
		farmaceutico.setEstado(estado);
		farmaceutico.setUsuario(usuario);
		farmaceutico.setContrasenia(passwordEncoder.encode(contrasenia));
		//Datos especificos
		farmaceutico.setNumColFarmaceutico(numColFarmaceutico);
		return farmaceutico;
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
}
