package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class FarmaciaForm {
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[A-Za-z]*",message = "El nombre no puede contener numeros ni caracteres especiales")
	private String nombre;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[0-9]*",message = "El telefono solo puede contener caracteres numericos")
	private String telefono;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[A-Za-z0-9]*",message = "La direccion no puede contener caracteres especiales")
	private String direccion;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[A-Za-z]*",message = "La ciudad no puede contener numeros ni caracteres especiales")
	private String ciudad;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[0-9]*",message = "El codigo postal ha de ser numerico")
	@Size(min=5,max=5,message="El codigo postal ha de tener 5 digitos")
	private String codPostal;
	@NotEmpty(message = "El campo esta vacio")
	private String provincia;
	@NotEmpty(message = "El campo esta vacio")
	private String comAutonoma;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getComAutonoma() {
		return comAutonoma;
	}
	public void setComAutonoma(String comAutonoma) {
		this.comAutonoma = comAutonoma;
	}

}
