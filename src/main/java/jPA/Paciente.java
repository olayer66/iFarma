package jPA;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//Imports basicos para JPA
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.validator.cfg.defs.EmailDef;

@Entity
//Peticiones a la tabla
@NamedQueries({	
	//BORRAR
	@NamedQuery(name="borrarPaciente",
		query="delete from Paciente p where p.ID= :IDPaciente"),
	//ACTUALIZAR
	
	//SELECT
  @NamedQuery(name="paciente",
      query="select p from Paciente p where p.ID=:IDPaciente")   

})
public class Paciente {
	//datos del paciente
	private long ID;
	private String Nombre;
	private String Apellidos;
	private EmailDef email;
	private String telefono;
	//medico de cabecera (1/1)
	private long ID_Medico;
	//Lsita de medicamentos del tratamiento (N/M)
	private ArrayList<Medicamento> Tratamiento;
	//Rel. farmacias y pedidos
	private long ID_Farmacia;
	private int forma_Pago;
	
}
