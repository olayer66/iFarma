package es.ucm.fdi.iw.integracion;

import java.util.List;

import es.ucm.fdi.iw.model.Medico;
import es.ucm.fdi.iw.model.Paciente;

public interface IMedicoDao {
	
	public List<Paciente> getPacientes();
	public void addMedico(Medico medico);
	public Medico getMedico(String codigo);

}