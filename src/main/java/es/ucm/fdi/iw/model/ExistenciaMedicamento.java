package es.ucm.fdi.iw.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "existencias",
	   uniqueConstraints = {
		   @UniqueConstraint(columnNames = "id_existencia")
	})
public class ExistenciaMedicamento implements Serializable {
	private static final long serialVersionUID = 4000356623437817386L;
	@Id
	@Column(name = "id_existencia", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private Medicamento medicamento;
	@ManyToOne
	@JoinColumn(name="farmacia")
	private Farmacia farmacia;
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	@Column(name = "fecha_caducidad", nullable = false)
	private Date fechaCaducidad;
	
	
	//getters y setters
	public long getId() {
		return id;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public void setFarmacia(Farmacia f){
		this.farmacia=f;
	}
}
