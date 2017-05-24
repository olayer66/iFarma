package es.ucm.fdi.iw.model;


import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.security.core.GrantedAuthority;

@Entity

public class Farmaceutico extends Usuario {
	public Farmaceutico(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = -6791548916804839L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
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
