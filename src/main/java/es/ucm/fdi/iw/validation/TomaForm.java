package es.ucm.fdi.iw.validation;
import org.hibernate.validator.constraints.NotEmpty;

public class TomaForm {
	@NotEmpty(message = Patrones.menVacio)
	private String tratamiento;

	@NotEmpty(message = Patrones.menVacio)
	private String accion;

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String codigo) {
		this.tratamiento = codigo;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
}
