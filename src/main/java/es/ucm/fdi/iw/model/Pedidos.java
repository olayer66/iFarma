package es.ucm.fdi.iw.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pedidos",
	   uniqueConstraints = {
		   @UniqueConstraint(columnNames = "id_pedido")
	})
public class Pedidos implements Serializable {

	
	private static final long serialVersionUID = 9079583133750628192L;
	@Id
	@Column(name = "id_pedido", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	@JoinColumn(name="farmacia")
	private Farmacia farmacia;
	@ManyToOne
	@JoinColumn(name="paciente")
	private Paciente paciente;
	@OneToMany
	@JoinColumn(name="existencias_pedido")
	private List<ExistenciaMedicamento> existenciasPedido;
	@Column(name = "fecha_Pedido", nullable = false)
	private Date fechaPedido;
	@Column(name = "estado_Pedido", nullable = false)
	private int estadoPedido;//0 recibido 1 entregado
	public long getId() {
		return id;
	}
	public Farmacia getFarmacia() {
		return farmacia;
	}
	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public List<ExistenciaMedicamento> getExistenciasPedido() {
		return existenciasPedido;
	}
	public void setExistenciasPedido(List<ExistenciaMedicamento> existenciasPedido) {
		this.existenciasPedido = existenciasPedido;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public int getEstadoPedido() {
		return estadoPedido;
	}
	public void setEstadoPedido(int estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	
	
	
}
