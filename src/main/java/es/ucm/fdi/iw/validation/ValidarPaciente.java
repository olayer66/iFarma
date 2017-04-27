package es.ucm.fdi.iw.validation;

import javax.persistence.Column;

public class ValidarPaciente {
	
	//Datos de usuario
	private String usuario;
	private String contrasenia;
	private String contraseniaRep;
	
	//Datos de paciente
	private String direccion;
	private String ciudad;
	private String codPostal;
	private String provincia;
	private String comAutonoma;
	
	//forma de pago(0=paypal ,1=tarjeta, 2= contrareembolso)
	private int formaPago;	
	
	//datos tarjeta (si forma de pago es tarjeta)
	private long numTarjeta;
	private int codSegTarjeta;
	private String fechaCadTarjeta;
}
