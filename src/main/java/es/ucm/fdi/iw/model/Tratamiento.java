package es.ucm.fdi.iw.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tratamientos",
	   uniqueConstraints = {
		   @UniqueConstraint(columnNames = "id_tratamiento")
	})
//Peticiones a la tabla
@NamedQueries({
})
public class Tratamiento implements Serializable {
	private static final long serialVersionUID = -8662915238597958222L;
	@Id
	@Column(name = "id_tratamiento", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long IDTratamiento;

	//Paciente al que pertenece
	@ManyToOne(optional=false)
    @JoinColumn(name="paciente",referencedColumnName="id")
	private Paciente paciente;
	//Medicamento
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_medicamento")
	private Medicamento medicamento;
	@Column(name = "fecha_inicio", nullable = false)
	private Date fechaInicio;
	@Column(name = "fecha_fin", nullable = false)
	private Date fechaFin;
	//numero de pastillas tomadas
	@Column(name = "num_dosis", nullable = true)
	private Integer numDosis;
	//tiempo entre dosis (cada 8 horas, 1 al dia, etc)//en horas
	@Column(name = "perioicidad", nullable = false)
	private String perioicidad;
	//Numero restante de tomas del dia
	@Column(name = "num_dosis_dia", nullable = false)
	private Integer numDosisDia;

	//getters y setters
	public long getIDTratamiento() {
		return IDTratamiento;
	}
	public void setIDTratamiento(long iDTratamiento) {
		IDTratamiento = iDTratamiento;
	}
	public Integer getNumDosis() {
		return numDosis;
	}
	public void setNumDosis(Integer numDosis) {
		this.numDosis = numDosis;
	}
	public Integer getNumDosisDia() {
		return numDosisDia;
	}
	public void setNumDosisDia(Integer numDosisDia) {
		this.numDosisDia = numDosisDia;
	}
	public String getPerioicidad() {
		return perioicidad;
	}
	public void setPerioicidad(String perioicidad) {
		this.perioicidad = perioicidad;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFinTratamiento) {
		this.fechaFin = fechaFinTratamiento;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
}
