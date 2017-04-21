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
@Table(name = "farmaceuticos", 
uniqueConstraints = {
		   @UniqueConstraint(columnNames = "id_farmaceutico")
	})
public class Farmaceutico implements Serializable{
	private static final long serialVersionUID = -6791548916804839L;
	
	@Id
	@Column(name = "id_farmaceutico", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long IDFarmaceutico;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@Column(name = "num_col_farmaceutico", nullable = false)
	private String numColFarmaceutico;
	//Lista de farmacias que le pertenecen
	@OneToMany(mappedBy="duenio")
	private List<Farmacia> farmaciasPropias;
	
	//getters y setters
	public String getNumColFarmaceutico() {
		return numColFarmaceutico;
	}
	public void setNumColFarmaceutico(String numColFarmaceutico) {
		this.numColFarmaceutico = numColFarmaceutico;
	}
	public List<Farmacia> getFarmaciasPropias() {
		return farmaciasPropias;
	}
	public void setFarmaciasPropias(List<Farmacia> farmaciasPropias) {
		this.farmaciasPropias = farmaciasPropias;
	}
	
}