package jPA;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
//Imports basicos para JPA
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

import org.hibernate.validator.cfg.defs.EmailDef;

@Entity
@Table(name = "pacientes", uniqueConstraints = {
@UniqueConstraint(columnNames = "ID_Paciente")
})
//Peticiones a la tabla
@NamedQueries({	
	//BORRAR
	@NamedQuery(name="borrarPaciente",
		query="delete from Paciente p where p.IDPaciente= :IDPaciente"),
	//ACTUALIZAR
	
	//SELECT
	@NamedQuery(name="paciente",
    	query="select p from Paciente p where p.IDPaciente=:IDPaciente")   

})
public class Paciente implements Serializable {
	private static final long serialVersionUID = 2117067448004216461L;
	
	//datos del paciente
	@Id
	@Column(name = "ID_Paciente", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long IDPaciente;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	@Column(name = "email", nullable = false)
	private EmailDef email;
	@Column(name = "telefono", nullable = false)
	private String telefono;
	
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
	private String comAutonona;
	
	//medico de cabecera (N/1)
	@ManyToOne(optional=false)
    @JoinColumn(name="ID_Medico",referencedColumnName="ID_Medico")
	private Medico medCabecera;
	
	//Lista de medicamentos del tratamiento (N/M)
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="Tratamientos",
            joinColumns=
            @JoinColumn(name="ID_Paciente", referencedColumnName="ID_Paciente"),
      inverseJoinColumns=
            @JoinColumn(name="ID_Medicamento", referencedColumnName="ID_Medicamento")
    )
	private ArrayList<Medicamento> Tratamiento;
	
	//Farmamcia de referencia
	@ManyToOne(optional=false)
    @JoinColumn(name="ID_Farmacia",referencedColumnName="ID_Farmacia")
	private Farmacia IDFarmacia;
	
	//forma de pago
	@Column(name = "forma_Pago", nullable = false)
	private int formaPago;
	
	//datos tarjeta (si forma de pago es tarjeta)
	@Column(name = "num_Tarjeta", nullable = false)
	private long numTarjeta;
	@Column(name = "cod_Seg_Tarjeta", nullable = false)
	private int codSegTarjeta;
	@Column(name = "fecha_Cad_Tarjeta", nullable = false)
	private String fechaCadTarjeta;
	
	//Getters y Setters de los campos de la tabla
	public long getIDPaciente() {
		return IDPaciente;
	}
	public void setIDPaciente(long iDPaciente) {
		IDPaciente = iDPaciente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public EmailDef getEmail() {
		return email;
	}
	public void setEmail(EmailDef email) {
		this.email = email;
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
	public Medico getMedCabecera() {
		return medCabecera;
	}
	public void setMedCabecera(Medico medCabecera) {
		this.medCabecera = medCabecera;
	}
	public ArrayList<Medicamento> getTratamiento() {
		return Tratamiento;
	}
	public void setTratamiento(ArrayList<Medicamento> tratamiento) {
		Tratamiento = tratamiento;
	}
	public Farmacia getIDFarmacia() {
		return IDFarmacia;
	}
	public void setIDFarmacia(Farmacia iDFarmacia) {
		IDFarmacia = iDFarmacia;
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
