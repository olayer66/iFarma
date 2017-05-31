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
import javax.persistence.ManyToMany;
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
	@OneToMany(mappedBy="pedido")
	private List<ExistenciaPedido> existenciasPedido;
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
	public long getPacienteID() {
		return paciente.getId();
	}
	public long getFarmaciaID() {
		return farmacia.getId();
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public List<ExistenciaPedido> getExistenciasPedido() {
		return existenciasPedido;
	}
	public void setExistenciasPedido(List<ExistenciaPedido> existenciasPedido) {
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
	public double getPrecioTotal() {
		
		double suma=0;
		for(ExistenciaPedido m :existenciasPedido){
			for (int i=0; i< m.getCantidad();i++) {
				suma=suma +m.getMedicamento().getPrecio();
			}
		}

		return suma;
	}
	public boolean realizarPedido() {
		boolean exito=true;
		if (estadoPedido ==0){
			for(ExistenciaPedido ePed :existenciasPedido){
				for (ExistenciaMedicamento eMed : farmacia.getStock()) {
					if (ePed.getMedicamento() == eMed.getMedicamento()){
						if(ePed.getCantidad()<= eMed.getCantidad()){//si hay menos pedido que stock
							
						}else{
							exito=false;
						}
					}
				}
			}	
		}else{
			exito=false;
		}
		if(exito){
			realizo();
		}
		
		return exito;
	}
	
		private void realizo(){
			List<ExistenciaMedicamento> listaStock =  farmacia.getStock();
			
				for(ExistenciaPedido ePed :existenciasPedido){
					for (ExistenciaMedicamento eMed :listaStock) {
						if (ePed.getMedicamento() == eMed.getMedicamento()){
							eMed.setCantidad(eMed.getCantidad()-ePed.getCantidad());//quito del stock las cantidades del pedido
						}
					}	
				}
				
				estadoPedido=1;//entregado
				farmacia.setStock(listaStock);
				
		}
}
