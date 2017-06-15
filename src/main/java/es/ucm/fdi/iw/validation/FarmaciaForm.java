package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class FarmaciaForm {
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.textoEspecial ,message = Patrones.menTextoEspecial)
	private String nombre;
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.numero ,message = Patrones.menNumero)
	@Size(min=9,max=9,message = Patrones.menTelefono)
	private String telefono;
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.direccion ,message = Patrones.menDireccion)
	private String direccion;
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.textoEspecial ,message = Patrones.menTextoEspecial)
	private String ciudad;
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.numero ,message = Patrones.menNumero)
	@Size(min=5,max=5,message=Patrones.menCodPostal)
	private String codPostal;
	@NotEmpty(message = Patrones.menVacio)
	private String provincia;
	@NotEmpty(message = Patrones.menVacio)
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
