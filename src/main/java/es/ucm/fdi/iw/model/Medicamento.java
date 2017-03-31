package es.ucm.fdi.iw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name = "medicamentos", uniqueConstraints = {
@UniqueConstraint(columnNames = "id_medicamento")
})
//Peticiones a la tabla
@NamedQueries({	

})
public class Medicamento implements Serializable{
	private static final long serialVersionUID = -5418658586012238577L;
	
	@Id
	@Column(name = "id_medicamento", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long IDMedicamento;
	
	
}
