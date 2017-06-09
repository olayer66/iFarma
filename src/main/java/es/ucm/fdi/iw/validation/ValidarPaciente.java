package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import es.ucm.fdi.iw.model.Paciente;

public class ValidarPaciente {

	//Datos que no se tocan
	private long id;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "El nombre no puede contener numeros ni caracteres especiales")
	private String nombre;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "los apellidos no pueden contener numeros ni caracteres especiales")
	private String apellidos;
	@NotEmpty(message = "El campo esta vacio")
	@Email(message = "La direccion email no es correcta")
	private String email;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[0-9]*",message = "El telefono ha de ser numerico")
	@Size(min=9,max=9,message = "El telefono debe de tener 9 digitos")
	private String telefono;

	//Datos de usuario
	@NotEmpty(message = "El campo esta vacio")
	@Size(min=3)
	@Pattern(regexp = "[A-Za-z0-9]*",message = "El usuario no puede contener caracteres especiales")
	private String usuario;
	@Size(min=4,max=8,message = "La contraseña debe de tener entre 4 y 8 caracteres alfanumericos")
	@Pattern(regexp = "[A-Za-z0-9]*",message = "La contraseña no puede contener caracteres especiales")
	private String contrasenia;
	@Size(min=4,max=8,message = "La contraseña debe de tener entre 4 y 8 caracteres alfanumericos")
	@Pattern(regexp = "[A-Za-z0-9]*",message = "La contraseña no puede contener caracteres especiales")
	private String contraseniaRep;

	//Datos de paciente
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "La direccion no puede contener caracteres especiales")
	private String direccion;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$*",message = "La ciudad no puede contener numeros ni caracteres especiales")
	private String ciudad;
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[0-9]*",message = "El codigo postal ha de ser numerico")
	@Size(min=5,max=5,message="El codigo postal ha de tener 5 digitos")
	private String codPostal;
	@NotEmpty(message = "El campo esta vacio")
	private String provincia;
	@NotEmpty(message = "El campo esta vacio")
	private String comAutonoma;
	
	private long farmacia;

	//forma de pago(0=paypal ,1=tarjeta, 2= contrareembolso)
	@NotEmpty(message = "El campo esta vacio")
	private String formaPago;

	//datos tarjeta (si forma de pago es tarjeta)
	@Pattern(regexp = "[0-9]*",message = "El nº de tarjeta ha de ser numerico")
	private String numTarjeta;
	@Pattern(regexp = "[0-9]*",message = "El codigo de seguridad ha de ser numerico")
	@Size(max=3,message="El codigo de seguridad ha de tener tres digitos")
	private String codSegTarjeta;
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private String fechaCadTarjeta;

	//Devuleve los datos capturados.
	public Paciente getPaciente()
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Paciente pac= new Paciente();
		pac.setDireccion(direccion);
		pac.setCiudad(ciudad);
		pac.setCodPostal(codPostal);
		pac.setComAutonona(comAutonoma);
		pac.setProvincia(provincia);
		pac.setUsuario(usuario);
		pac.setContrasenia(passwordEncoder.encode(contrasenia));
		pac.setFormaPago(Integer.parseInt(formaPago));
		if(formaPago.equals("1"))
		{
			pac.setCodSegTarjeta(Integer.parseInt(codSegTarjeta));
			pac.setNumTarjeta(Integer.parseInt(numTarjeta));
			pac.setFechaCadTarjeta(fechaCadTarjeta);
		}
		return pac;
	}
	//Getters y setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}

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
	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getCodSegTarjeta() {
		return codSegTarjeta;
	}

	public void setCodSegTarjeta(String codSegTarjeta) {
		this.codSegTarjeta = codSegTarjeta;
	}

	public String getFechaCadTarjeta() {
		return fechaCadTarjeta;
	}
	public void setFechaCadTarjeta(String fechaCadTarjeta) {
		this.fechaCadTarjeta = fechaCadTarjeta;
	}
	public long getFarmacia() {
		return farmacia;
	}
	public void setFarmacia(long farmacia) {
		this.farmacia = farmacia;
	}
	
}
