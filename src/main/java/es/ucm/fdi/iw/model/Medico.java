package es.ucm.fdi.iw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
@OnDelete(action = OnDeleteAction.CASCADE)
public class Medico extends Usuario {
	private static final long serialVersionUID = 9190127841629484829L;
	
	@Column(name = "num_col_medico", nullable = false)
	private String numColMedico;
	@Column(name = "centro_trabajo", nullable = false)
	private String centroTrabajo;
	
	//Lista de pacientes del medico
	@OneToMany(targetEntity=Paciente.class, cascade=CascadeType.REMOVE)
	@JoinColumn(name="med_cabecera_id")
	private List<Paciente> pacientes = new ArrayList<>();
	
	//getters y setters
	public String getNumColMedico() {
		return numColMedico;
	}
	public void setNumColMedico(String numColMedico) {
		this.numColMedico = numColMedico;
	}
	public String getCentroTrabajo() {
		return centroTrabajo;
	}
	public void setCentroTrabajo(String centroTrabajo) {
		this.centroTrabajo = centroTrabajo;
	}
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	@Override
	public String toString() {
		return "Medico [numColMedico=" + numColMedico + ", centroTrabajo=" + centroTrabajo + ", pacientes=" + pacientes
				+ ", id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", telefono="
				+ telefono + ", estado=" + estado + ", role=" + role + ", usuario=" + usuario + ", contrasenia="
				+ contrasenia + ", mensajesRecibidos=" + mensajesRecibidos + ", mensajesEnviados=" + mensajesEnviados
				+ "]";
	}
	
	
}
