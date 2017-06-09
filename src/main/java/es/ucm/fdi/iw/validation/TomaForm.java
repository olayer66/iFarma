package es.ucm.fdi.iw.validation;
import org.hibernate.validator.constraints.NotEmpty;

public class TomaForm {
	@NotEmpty(message = "El campo esta vacio")
	private String tratamiento;

	@NotEmpty(message = "El campo esta vacio")
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
