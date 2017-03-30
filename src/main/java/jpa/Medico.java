package jpa;

import java.io.Serializable;
import java.util.ArrayList;

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
	@Column(name = "especialidad", nullable = false)
	private String especialidad;
	@Column(name = "centro_Trabajo", nullable = false)
	private String centroTrabajo;
	@OneToMany(mappedBy="ID_Usuario")
	private ArrayList<Paciente> pacientes;
}
