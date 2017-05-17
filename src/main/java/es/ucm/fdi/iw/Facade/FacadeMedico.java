package es.ucm.fdi.iw.Facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ucm.fdi.iw.integracion.IMedicoDao;
import es.ucm.fdi.iw.model.Medico;
import es.ucm.fdi.iw.model.Paciente;

@Service
public class FacadeMedico implements IFacadeMedico{

	@Autowired
	private IMedicoDao medicoDao;
	@Override
	public List<Paciente> obtenerTodosPacientes(Medico medico) {
		// TODO Auto-generated method stub
		return this.medicoDao.getPacientes();
	}

	@Override
	public void insertarMedico(Medico medico) {
		 this.medicoDao.addMedico(medico);
	}

	@Override
	public Medico obtenerMedico(String codigo) {
		// TODO Auto-generated method stub
		return this.medicoDao.getMedico(codigo);
	}

}
