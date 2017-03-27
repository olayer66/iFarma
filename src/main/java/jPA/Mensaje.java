package jPA;

import java.sql.Date;

//Imports basicos para JPA
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
//Peticiones a la tabla
@NamedQueries({
	//CREAR
	
	//BORRAR
	@NamedQuery(name="borrarMensaje",
		query="delete from Mensaje m where m.ID= :IDMensaje"),
	//ACTUALIZAR
	
	//SELECT
    @NamedQuery(name="unMensaje",
        query="select m from Mensaje m where m.ID=:idParam"),    
    @NamedQuery(name="NumMensajesNoLeidos",
    	query="select m from Mensaje m where m.IDDestinatario=:IDDest and m.leido=false"),
    @NamedQuery(name="mensajesRecibidosPaciente",
        query="select m from Mensaje m where m.IDDestinatario=:IDPaciente"),
    @NamedQuery(name="mensajesRecibidosMedico",
    	query="select m from Mensaje m where m.IDDestinatario=:IDMedico"),
    @NamedQuery(name="mensajesUnPaciente",
		query="select m from Mensaje m where m.IDDestinatario=:IDMedico and m.IDRemitente=:IDPaciente"),
    @NamedQuery(name="mensajesPorFecha",
		query="select m from Mensaje m where m.IDDestinatario=:IDDest and mfechaMensaje=:fecha"),
})
public class Mensaje {
	//Campos de la tabla
	private long ID;
	private boolean leido;
	private long IDRemitente;
	private long IDDestinatario;
	private Date fechaMensaje;
	private String asunto;
	private String mensaje;
	
	//Getters y Setters de los campos de la tabla
	
	@Id
	@GeneratedValue
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
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
