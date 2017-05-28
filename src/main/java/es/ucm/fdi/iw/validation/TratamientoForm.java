package es.ucm.fdi.iw.validation;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;

public class TratamientoForm {
	private static final Logger log = Logger.getLogger(Login.class);
	
	@NotEmpty(message = "El campo esta vacio")
	private String paciente;
	
	@NotEmpty(message = "El campo esta vacio")	
	private String medicamento;
	
	@NotEmpty(message = "El campo esta vacio")
	private String fechaFin;
	
	@NotEmpty(message = "El campo esta vacio")
	private String numDosis;
	
	@NotEmpty(message = "El campo esta vacio")
	private String periodicidad;
	
	@NotEmpty(message = "El campo esta vacio")
	private String comentario;

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getNumDosis() {
		return numDosis;
	}

	public void setNumDosis(String numDosis) {
		this.numDosis = numDosis;
	}

	public String getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(String perioicidad) {
		this.periodicidad = perioicidad;
	}
}
