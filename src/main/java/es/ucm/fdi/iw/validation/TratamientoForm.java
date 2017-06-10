package es.ucm.fdi.iw.validation;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;

public class TratamientoForm {
	private static final Logger log = Logger.getLogger(Login.class);

	@NotEmpty(message = "El campo esta vacio")
	private String paciente;

	@NotEmpty(message = "El campo esta vacio")
	private String medicamento;

	@NotEmpty(message = "El campo esta vacio")
	private String fechaInicio;

	@NotEmpty(message = "El campo esta vacio")
	private String fechaFin;

	@NotNull(message = "El campo esta vacio")
	@Digits(message = "El cambio debe ser un valor numérico", fraction = 0, integer = 1)
	private Integer numDosis;

	@NotEmpty(message = "El campo esta vacio")
	private String periodicidad;

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

	public String getFechaInicio() {
		return this.fechaInicio;
	}

	public Date getFechaInicioFormateada() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		try {
			return new Date(format.parse(this.fechaInicio).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return this.fechaFin;
	}

	public Date getFechaFinFormateada() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		try {
			return new Date(format.parse(this.fechaFin).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getNumDosis() {
		return numDosis;
	}

	public void setNumDosis(Integer numDosis) {
		this.numDosis = numDosis;
	}

	public String getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(String perioicidad) {
		this.periodicidad = perioicidad;
	}
}
