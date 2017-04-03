package es.ucm.fdi.iw.model;

import java.util.List;
//Imports de JPA
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.cfg.defs.EmailDef;

@Entity
@Table(name = "usuario", uniqueConstraints = {
@UniqueConstraint(columnNames = "id_usuario")})
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Usuario {
	//datos del usuario
	@Id
	@Column(name = "id_usuario", nullable = false)
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
