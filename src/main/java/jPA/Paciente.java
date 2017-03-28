package jPA;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.cfg.defs.EmailDef;

@Entity (name="pacientes")
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
public class Paciente {
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
	//medico de cabecera (1/1)
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
	//Listado de mensajes
	@OneToMany(mappedBy="pacientes",targetEntity=Mensaje.class,fetch=FetchType.EAGER)
	private ArrayList<Mensaje> mensajes;
	
}
