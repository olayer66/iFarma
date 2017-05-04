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
    @JoinColumn(name="paciente",referencedColumnName="id_paciente")
	private Paciente paciente;
	//Medicamento
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_medicamento")
	private Medicamento medicamento;
	//duracion en dias del tratamiento
	@Column(name = "fecha_fin_tratamiento", nullable = false)
	private Date fechaFinTratamiento;
	//numero de pastillas tomadas
	@Column(name = "num_dosis", nullable = true)
	private String numDosis;
	//tiempo entre dosis (cada 8 horas, 1 al dia, etc)//en horas
	@Column(name = "perioicidad", nullable = false)
	private String perioicidad;
	//Numero restante de tomas del dia
	@Column(name = "num_dosis_dia", nullable = false)
	private String numDosisDia;
	//fecha del dia acutal para el calculo de las tomas
	@Column(name = "fecha_actual", nullable = false)
	private Date fechaActual;
	
	
	//getters y setters
	public long getIDTratamiento() {
		return IDTratamiento;
	}
	public void setIDTratamiento(long iDTratamiento) {
		IDTratamiento = iDTratamiento;
	}
	public String getNumDosis() {
		return numDosis;
	}
	public void setNumDosis(String numDosis) {
		this.numDosis = numDosis;
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
	public Date getFechaFinTratamiento() {
		return fechaFinTratamiento;
	}
	public void setFechaFinTratamiento(Date fechaFinTratamiento) {
		this.fechaFinTratamiento = fechaFinTratamiento;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
}
