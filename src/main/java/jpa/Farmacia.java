package jpa;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "farmacias",
	   uniqueConstraints = {
		   @UniqueConstraint(columnNames = "ID_Usuario")
	})
//Peticiones a la tabla
@NamedQueries({	
	//BORRAR
	@NamedQuery(name="borrarFarmacia",
		query="delete from Farmacia f where f.IDFarmacia=:IDFarmacia"),
	//ACTUALIZAR
	
	//SELECT
	@NamedQuery(name="farmacia",
  	query="select p from Farmacia f where f.IDFarmacia=:IDFarmacia")   

})
public class Farmacia implements Serializable {
	private static final long serialVersionUID = 3729954187317206752L;
	
	//Datos de una farmacia
	@Id
	@Column(name = "ID_Farmacia", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long IDFarmacia;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "direccion", nullable = false)
	private String direccion;
	@Column(name = "ciudad", nullable = false)
	private String ciudad;
	@Column(name = "cod_Postal", nullable = false)
	private String codPostal;
	@Column(name = "provincia", nullable = false)
	private String provincia;
	@Column(name = "com_Autonoma", nullable = false)
	private String comAutonona;
	
	//Dueño de la farmacia (N/1)
	@ManyToOne(optional=false)
    @JoinColumn(name="duenio",referencedColumnName="num_Col_Farmaceutico")
	private Farmaceutico duenio;
	
	//Stock de la farmacia (N/M)
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="stocks",
            joinColumns=
            @JoinColumn(name="ID_Farmacia", referencedColumnName="ID_Farmacia"),
      inverseJoinColumns=
            @JoinColumn(name="ID_Medicamento", referencedColumnName="ID_Medicamento")
    )
	private ArrayList<Medicamento> stock;
}
