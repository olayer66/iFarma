package es.ucm.fdi.iw.validation;

import java.util.Random;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.apache.log4j.Logger;

public class Paciente {
	//logger
	private static final Logger log = Logger.getLogger(Login.class);
	
	//variables ha validar
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
	
	//variables de insercion
	private int codAut;
	private final String tipo="paciente";
	private final int estado=0;
	
	//Insertar en la BBDD
	public boolean insertarPaciente()
	{
		//Insercion de los datos basicos del paciente por parte del medico
		generarCodAuteticacion();
		
		//Introducimos en la BBDD
		
		return true;
	}
	private void generarCodAuteticacion()
	{
		Random rand = new Random();		
		codAut= rand.nextInt();
		log.info("Codigo de paciente generado: "+ codAut);
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
	public int getCodAut() {
		return codAut;
	}
	public void setCodAut(int codAut) {
		this.codAut = codAut;
	}
	public String getTipo() {
		return tipo;
	}	
}