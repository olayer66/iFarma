package es.ucm.fdi.iw.validation;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import es.ucm.fdi.iw.model.Medicamento;

public class ValidarMedicamento {
	
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[A-Za-z0-9]*",message = "El nombre no puede contener caracteres especiales")
	private String nombre;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "La descripcion no puede contener caracteres especiales")
	private String descripcion;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "El laboratorio no puede contener caracteres especiales")
	private String laboratorio;
	@DecimalMax("1000.0")
	private Double precio;
	
	//Devuelve un objeto del tipo
	public Medicamento getMedicamento()
	{
		Medicamento medicamento= new Medicamento();
		medicamento.setNombre(nombre);
		medicamento.setDescripcion(descripcion);
		medicamento.setLaboratorio(laboratorio);
		medicamento.setPrecio(precio);
		return medicamento;	
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}
