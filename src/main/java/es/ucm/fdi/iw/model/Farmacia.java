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
		   @UniqueConstraint(columnNames = "id_farmacia")
	})
public class Farmacia implements Serializable {
	private static final long serialVersionUID = 3729954187317206752L;
	
	//Datos de una farmacia
	@Id
	@Column(name = "id_farmacia", nullable = false)
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

	
	//Dueño de la farmacia (N/1)
	@ManyToOne(optional=false)
    @JoinColumn(name="duenio")
	private Farmaceutico duenio;
	
	//Listado de clientes // la farmacia no tiene un listado de pacientes, solo tiene pedidos
	@OneToMany(mappedBy="farmaciaReferencia")
	private List<Paciente> listaClientes;
	
	//Stock de la farmacia (N/1)
	@OneToMany(mappedBy="farmacia")
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
