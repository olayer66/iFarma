package es.ucm.fdi.iw.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
//Imports basicos para JPA
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
@Table(name = "pacientes",
	   uniqueConstraints = {
		   @UniqueConstraint(columnNames = "id_paciente")
	})
//Peticiones a la tabla
@NamedQueries({	
})
public class Paciente implements Serializable {
	private static final long serialVersionUID = 2117067448004216461L;

	@Id
	@Column(name = "id_paciente", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long IDPaciente;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	//direccion de envio de pedidos
	@Column(name = "direccion", nullable = false)
	private String direccion;
	@Column(name = "ciudad", nullable = false)
	private String ciudad;
	@Column(name = "cod_Postal", nullable = false)
	private String codPostal;
	@Column(name = "provincia", nullable = false)
	private String provincia;
	@Column(name = "com_Autonoma", nullable = false)
	private String comAutonoma;
	
	//medico de cabecera (N/1)
	@ManyToOne(optional=false)
    @JoinColumn(name="medCabecera")
	private Medico medCabecera;
	
	//Lista de medicamentos del tratamiento (1/N)
	@OneToMany(mappedBy="paciente")
	private List<Tratamiento> tratamiento;
	
	//Farmamcia de referencia
	@ManyToOne(optional=false)
    @JoinColumn(name="farmaciaReferencia",referencedColumnName="id_farmacia")
	private Farmacia farmaciaReferencia;
	
	//forma de pago
	@Column(name = "forma_pago", nullable = false)
	private int formaPago;
	
	//datos tarjeta (si forma de pago es tarjeta)
	@Column(name = "num_tarjeta", nullable = false)
	private long numTarjeta;
	@Column(name = "cod_seg_tarjeta", nullable = false)
	private int codSegTarjeta;
	@Column(name = "fecha_cad_tarjeta", nullable = false)
	private String fechaCadTarjeta;
	
	//Getters y Setters de los campos de la tabla
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
	public String getComAutonoma() {
		return comAutonoma;
	}
	public void setComAutonona(String comAutonoma) {
		this.comAutonoma = comAutonoma;
	}
	public Medico getMedCabecera() {
		return medCabecera;
	}
	public void setMedCabecera(Medico medCabecera) {
		this.medCabecera = medCabecera;
	}
	public List<Tratamiento> getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(List<Tratamiento> tratamiento) {
		this.tratamiento = tratamiento;
	}
	public Farmacia getFarmaciaReferencia() {
		return farmaciaReferencia;
	}
	public void setFarmaciaReferencia(Farmacia farmaciaReferencia) {
		this.farmaciaReferencia = farmaciaReferencia;
	}
	public int getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(int formaPago) {
		this.formaPago = formaPago;
	}
	public long getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(long numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public int getCodSegTarjeta() {
		return codSegTarjeta;
	}
	public void setCodSegTarjeta(int codSegTarjeta) {
		this.codSegTarjeta = codSegTarjeta;
	}
	public String getFechaCadTarjeta() {
		return fechaCadTarjeta;
	}
	public void setFechaCadTarjeta(String fechaCadTarjeta) {
		this.fechaCadTarjeta = fechaCadTarjeta;
	}	
}