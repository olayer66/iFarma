package jPA;

import java.sql.Date;

import javax.persistence.Column;
//Imports basicos para JPA
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity (name="mensajes")
//Peticiones a la tabla
@NamedQueries({	
	//BORRAR
	@NamedQuery(name="borrarMensaje",
		query="delete from Mensaje m where m.ID_Mensaje= :IDMensaje"),
	//ACTUALIZAR
	@NamedQuery(name="actualizarLeido",
		query="update Mensaje m set m.leido=true where m.ID_Mensaje= :IDMensaje"),
	//SELECT
    @NamedQuery(name="unMensaje",
        query="select m from Mensaje m where m.ID_Mensaje=:IDMensaje"),    
    @NamedQuery(name="NumMensajesNoLeidos",
    	query="select count(m) from Mensaje m where m.IDDestinatario=:IDDest and m.leido=false"),
    @NamedQuery(name="mensajesRecibidosPaciente",
        query="select m from Mensaje m where m.IDDestinatario=:IDPaciente"),
    @NamedQuery(name="mensajesRecibidosMedico",
    	query="select m from Mensaje m where m.IDDestinatario=:IDMedico"),
    @NamedQuery(name="mensajesUnPaciente",
		query="select m from Mensaje m where m.IDDestinatario=:IDMedico and m.IDRemitente=:IDPaciente"),
    @NamedQuery(name="mensajesPorFecha",
		query="select m from Mensaje m where m.IDDestinatario=:IDDest and mfechaMensaje=:fecha")
})
public class Mensaje {
	
	//ID
	@Id
	@Column(name = "ID_Mensaje", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long IDMensaje;
	
	//Si esta leido por parte del destinatario
	private boolean leido;
	
	// ID del remitente y el destinatario
	@Column(name = "ID_Remitente", nullable = false)
	private long IDRemitente;
	@Column(name = "ID_Destinatario", nullable = false)
	private long IDDestinatario;
	
	//Cuerpo del mensaje
	@Column(name = "fecha_Mensaje", nullable = false)
	private Date fechaMensaje;
	@Column(name = "asunto", nullable = false)
	private String asunto;
	@Column(name = "mensaje", nullable = false)
	private String mensaje;
	
	//Getters y Setters de los campos de la tabla
	public long getIDMensaje() {
		return IDMensaje;
	}
	public void setIDMensaje(long iDMensaje) {
		IDMensaje = iDMensaje;
	}
	public boolean isLeido() {
		return leido;
	}
	public void setLeido(boolean leido) {
		this.leido = leido;
	}
	public long getIDRemitente() {
		return IDRemitente;
	}
	public void setIDRemitente(long iDRemitente) {
		IDRemitente = iDRemitente;
	}
	public long getIDDestinatario() {
		return IDDestinatario;
	}
	public void setIDDestinatario(long iDDestinatario) {
		IDDestinatario = iDDestinatario;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Date getFechaMensaje() {
		return fechaMensaje;
	}
	public void setFechaMensaje(Date fechaMensaje) {
		this.fechaMensaje = fechaMensaje;
	}
}
