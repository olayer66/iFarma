package es.ucm.fdi.iw.validation;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Codigo {
	@NotEmpty(message = Patrones.menVacio)
	@Pattern(regexp = Patrones.numero ,message = Patrones.menNumero)
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
