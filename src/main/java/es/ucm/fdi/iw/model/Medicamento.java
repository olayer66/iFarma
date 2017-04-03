package es.ucm.fdi.iw.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name = "medicamentos", uniqueConstraints = {
@UniqueConstraint(columnNames = "id_medicamento")
})
//Peticiones a la tabla
@NamedQueries({	

})
public class Medicamento implements Serializable{
	private static final long serialVersionUID = -5418658586012238577L;
	
	@Id
	@Column(name = "id_medicamento", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long IDMedicamento;
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	@Column(name = "forma_administracion", nullable = false)
	private String formaAdministracion;
	@Column(name = "via_administracion", nullable = false)
	private String viaAdministracion;
	@Column(name = "estado_administrativo", nullable = false)
	private String estadoAdministrativo;
	@Column(name = "tipo_autorizacion", nullable = false)
	private String tipoAutorizacion;
	@Column(name = "estado_comercial", nullable = false)
	private String estadoComercial;
	@Column(name = "fecha_AMM", nullable = false)
	private Date fechaAMM;
	@Column(name = "estado_bdm", nullable = false)
	private String estadoBDM;
	@Column(name = "num_aut_europeo", nullable = false)
	private String numAutEuropeo;
	@Column(name = "titular", nullable = false)
	private String titular;
	@Column(name = "vigilancia_reforzada", nullable = false)
	private String vigilanciaReforzada;
	
	//getters y setters
	public long getIDMedicamento() {
		return IDMedicamento;
	}
	public void setIDMedicamento(long iDMedicamento) {
		IDMedicamento = iDMedicamento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFormaAdministracion() {
		return formaAdministracion;
	}
	public void setFormaAdministracion(String formaAdministracion) {
		this.formaAdministracion = formaAdministracion;
	}
	public String getViaAdministracion() {
		return viaAdministracion;
	}
	public void setViaAdministracion(String viaAdministracion) {
		this.viaAdministracion = viaAdministracion;
	}
	public String getEstadoAdministrativo() {
		return estadoAdministrativo;
	}
	public void setEstadoAdministrativo(String estadoAdministrativo) {
		this.estadoAdministrativo = estadoAdministrativo;
	}
	public String getTipoAutorizacion() {
		return tipoAutorizacion;
	}
	public void setTipoAutorizacion(String tipoAutorizacion) {
		this.tipoAutorizacion = tipoAutorizacion;
	}
	public String getEstadoComercial() {
		return estadoComercial;
	}
	public void setEstadoComercial(String estadoComercial) {
		this.estadoComercial = estadoComercial;
	}
	public Date getFechaAMM() {
		return fechaAMM;
	}
	public void setFechaAMM(Date fechaAMM) {
		this.fechaAMM = fechaAMM;
	}
	public String getEstadoBDM() {
		return estadoBDM;
	}
	public void setEstadoBDM(String estadoBDM) {
		this.estadoBDM = estadoBDM;
	}
	public String getNumAutEuropeo() {
		return numAutEuropeo;
	}
	public void setNumAutEuropeo(String numAutEuropeo) {
		this.numAutEuropeo = numAutEuropeo;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getVigilanciaReforzada() {
		return vigilanciaReforzada;
	}
	public void setVigilanciaReforzada(String vigilanciaReforzada) {
		this.vigilanciaReforzada = vigilanciaReforzada;
	}
	
}
