package es.ucm.fdi.iw.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "medicos", 
	   uniqueConstraints = {
			   @UniqueConstraint(columnNames = "ID_Usuario")
		})
public class Medico  extends Usuario implements Serializable {
	private static final long serialVersionUID = 9190127841629484829L;
	
	@Column(name = "num_Col_Medico", nullable = false)
	private String numColMedico;
	@Column(name = "centro_Trabajo", nullable = false)
	private String centroTrabajo;
	
	//Lista de pacientes del medico
	@OneToMany(mappedBy="ID_Usuario")
	private List<Paciente> pacientes;
	
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
	
	
}
