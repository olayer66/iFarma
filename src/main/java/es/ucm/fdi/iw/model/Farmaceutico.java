package es.ucm.fdi.iw.model;

<<<<<<< HEAD
=======

import java.util.ArrayList;
>>>>>>> 606c9b33927317758c8933be54352b3ded649ab8
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class Farmaceutico extends Usuario {
	private static final long serialVersionUID = -6791548916804839L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "num_col_farmaceutico", nullable = false)
	private String numColFarmaceutico;
	//Lista de farmacias que le pertenecen
	@OneToMany(targetEntity=Farmacia.class, cascade=CascadeType.REMOVE)
	@JoinColumn(name="duenio")
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
	public List<Farmacia> getFarmaciasActivas() {
		 List<Farmacia> activas = new ArrayList<Farmacia>();
		for(Farmacia f :farmaciasPropias ){
			
			if(f.getEstado()==1){
				activas.add(f);
			}
		}
		
		
		
		return activas;
	}
	public void setFarmaciasPropias(List<Farmacia> farmaciasPropias) {
		this.farmaciasPropias = farmaciasPropias;
	}
	
}
