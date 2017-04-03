package es.ucm.fdi.iw.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "medicos", 
	   uniqueConstraints = {
			   @UniqueConstraint(columnNames = "id_medico")
		})
public class Medico implements Serializable {
	private static final long serialVersionUID = 9190127841629484829L;
	
	@Id
	@Column(name = "id_medico", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long IDMedico;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@Column(name = "num_col_medico", nullable = false)
	private String numColMedico;
	@Column(name = "centro_trabajo", nullable = false)
	private String centroTrabajo;
	
	//Lista de pacientes del medico
	@OneToMany(mappedBy="medCabecera")
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
