package es.ucm.fdi.iw.model;

import java.util.List;
//Imports de JPA
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import org.hibernate.validator.cfg.defs.EmailDef;

@MappedSuperclass
public class Usuario {
	//datos del usuario
	@Id
	@Column(name = "ID_Usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long IDUsuario;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	@Column(name = "email", nullable = false)
	private EmailDef email;
	@Column(name = "telefono", nullable = false)
	private String telefono;
	
	//Mensajes
	@OneToMany(mappedBy="destinatario")
	private List<Mensaje> mensajesRecibidos;
	@OneToMany(mappedBy="remitente")
	private List<Mensaje> mensajesEnviados;
	
	//Getters y setters de la entidad
	public long getIDUsuario() {
		return IDUsuario;
	}
	public void setIDUsuario(long iDUsuario) {
		IDUsuario = iDUsuario;
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
	public EmailDef getEmail() {
		return email;
	}
	public void setEmail(EmailDef email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<Mensaje> getMensajesRecibidos() {
		return mensajesRecibidos;
	}
	public void setMensajesRecibidos(List<Mensaje> mensajesRecibidos) {
		this.mensajesRecibidos = mensajesRecibidos;
	}
	public List<Mensaje> getMensajesEnviados() {
		return mensajesEnviados;
	}
	public void setMensajesEnviados(List<Mensaje> mensajesEnviados) {
		this.mensajesEnviados = mensajesEnviados;
	}
	
}
