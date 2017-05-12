package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Codigo {
	@NotEmpty(message = "El campo esta vacio")
	@Pattern(regexp = "[0-9]*",message = "El codigo ha de ser numerico")
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
