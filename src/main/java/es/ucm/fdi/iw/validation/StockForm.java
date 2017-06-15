package es.ucm.fdi.iw.validation;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class StockForm {
	
	@NotEmpty(message = Patrones.menVacio)
	private String medicamento;
	@NotNull(message = Patrones.menVacio)
	@Min(value = 0)
	@Max(value = 1000)
	@Digits(message = Patrones.menNumero, fraction = 0, integer = 1000)
	private int cantidad;
	@NotEmpty(message = Patrones.menVacio)
	@DateTimeFormat(pattern="MM/dd/yyyy")
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
