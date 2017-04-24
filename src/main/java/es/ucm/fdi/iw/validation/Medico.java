package es.ucm.fdi.iw.validation;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Medico {
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
		@NotEmpty(message = "El campo esta vacio")
		@Pattern(regexp = "[A-Za-z]*",message = "El usuario no puede contener numeros ni caracteres especiales")
		private String usuario;
		@Size(min=4,max=8,message = "La contraseña debe de tener entre 4 y 8 caracteres alfanumericos")
		@Pattern(regexp = "[A-Za-z0-9]*",message = "La contraseña no puede contener caracteres especiales")
		private String contrasenia;
		@Size(min=4,max=8,message = "La contraseña debe de tener entre 4 y 8 caracteres alfanumericos")
		@Pattern(regexp = "[A-Za-z0-9]*",message = "La contraseña no puede contener caracteres especiales")
		private String contraRep;
		@NotEmpty(message = "El campo esta vacio")
		@Pattern(regexp = "[0-9]*",message = "El numero de colegiado ha de ser numerico")
		private String numColMedico;
		@Column(name = "centro_trabajo", nullable = false)
		private String centroTrabajo;
		
		//variables de insercion
		private final String tipo="medico";
		private final int estado=0;

}
