package es.ucm.fdi.iw.Facade;

import java.util.List;
import es.ucm.fdi.iw.model.Medico;
import es.ucm.fdi.iw.model.Paciente;

public interface IFacadeMedico {
	//medico
	public List<Paciente> obtenerTodosPacientes(Medico medico);
	public void insertarMedico(Medico medico);
	public Medico obtenerMedico(String codigo);
	
	//paciente

	//farmaceutico
}
