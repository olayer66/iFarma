package es.ucm.fdi.iw.validation;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class StockForm {
	
	@NotEmpty(message = "El campo esta vacio")
	private String medicamento;
	@NotNull(message = "El campo esta vacio")
	@Min(value = 0)
	@Max(value = 1000)
	@Digits(message = "El campo debe ser un valor numérico", fraction = 0, integer = 1000)
	private int cantidad;
	@NotEmpty(message = "El campo esta vacio")
	private String fechaCaducidad;
	public String getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public Date getFechaFormateada() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			return new Date(format.parse(this.fechaCaducidad).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
}
