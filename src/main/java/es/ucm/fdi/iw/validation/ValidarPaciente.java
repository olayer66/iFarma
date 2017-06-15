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
	@Pattern(regexp = Patrones.numero ,message = Patrones.menNumero)
	@Size(min=9,max=9,message = Patrones.menTelefono)
	private String telefono;

	//Datos de usuario
	@NotEmpty(message = Patrones.menVacio)
	@Size(min=3)
	@Pattern(regexp = Patrones.usuario ,message = Patrones.menUsuario)
	private String usuario;
	@Size(min=4,max=8,message = Patrones.menContrasenia)
	@Pattern(regexp = Patrones.usuario ,message = Patrones.menUsuario)
	private String contrasenia;
	@Size(min=4,max=8,message = Patrones.menContrasenia)
	@Pattern(regexp = Patrones.usuario ,message = Patrones.menUsuario)
	private String contraseniaRep;

	//Datos de paciente
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.direccion ,message = Patrones.menDireccion)
	private String direccion;
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.textoEspecial ,message = Patrones.menTextoEspecial)
	private String ciudad;
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.numero ,message = Patrones.numero)
	@Size(min=5,max=5,message=Patrones.menCodPostal)
	private String codPostal;
	@NotEmpty(message = Patrones.menVacio)
	private String provincia;
	@NotEmpty(message = Patrones.menVacio)
	private String comAutonoma;
	
	private long farmacia;

	//forma de pago(0=paypal ,1=tarjeta, 2= contrareembolso)
	@NotEmpty(message = Patrones.menVacio)
	private String formaPago;

	//datos tarjeta (si forma de pago es tarjeta)
	@Pattern(regexp = Patrones.numero ,message = Patrones.numero)
	private String numTarjeta;
	@Pattern(regexp = Patrones.numero ,message = Patrones.numero)
	@Size(max=3,message=Patrones.menCodSeg)
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
