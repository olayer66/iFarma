package es.ucm.fdi.iw.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
	@Column(name = "telefono", nullable = false)
	private String telefono;
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
	
	//Stock de la farmacia (N/1)
	@OneToMany(mappedBy="ExistenciaMedicamento")
	private List<ExistenciaMedicamento> stock;

	//getters y setters
	public long getIDFarmacia() {
		return IDFarmacia;
	}

	public void setIDFarmacia(long iDFarmacia) {
		IDFarmacia = iDFarmacia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getComAutonona() {
		return comAutonona;
	}

	public void setComAutonona(String comAutonona) {
		this.comAutonona = comAutonona;
	}

	public Farmaceutico getDuenio() {
		return duenio;
	}

	public void setDuenio(Farmaceutico duenio) {
		this.duenio = duenio;
	}

	public List<ExistenciaMedicamento> getStock() {
		return stock;
	}

	public void setStock(List<ExistenciaMedicamento> stock) {
		this.stock = stock;
	}
	
	
}
