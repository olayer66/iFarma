package es.ucm.fdi.iw.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
@Entity
@Table(name = "medicamentos")
@NamedQueries({
    @NamedQuery(name="Medicamento.findAll",
                query="SELECT m FROM Medicamento m"),
    @NamedQuery(name="Medicamento.findByName",
                query="SELECT m FROM Medicamento m WHERE m.nombre = :nombre"),
}) 
public class Medicamento implements Serializable{
	private static final long serialVersionUID = -5418658586012238577L;
	
	@Id
	@Column(name = "id_medicamento", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	@Column(name = "laboratorio", nullable = false)
	private String laboratorio;
	@Column(name = "precio", nullable = false)
	private double precio;
	
	//getters y setters
	public long getId() {
		return id;
	}
	public void setId(long iDMedicamento) {
		id = iDMedicamento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
