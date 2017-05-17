package es.ucm.fdi.iw.integracion;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.ucm.fdi.iw.model.Medico;
import es.ucm.fdi.iw.model.Paciente;


@Repository
public class MedicoDao implements IMedicoDao {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Paciente> getPacientes() {
		//Query query = this.entityManager.createQuery("from Pacientes where idMedico=this.medico.id");//por ejemplo
		//mirar que guarda la tabla paciente del medico de cabecera
		return null;
		
	}

	@Override
	public void addMedico(Medico medico) {
		this.entityManager.persist(medico);
		this.entityManager.flush();
		
	}

	@Override
	public Medico getMedico(String codigo) {
		Medico medico = null;
		Query query = this.entityManager.createQuery("from Medico where numColMedico = :codigo");
		query.setParameter("numColMedico", codigo);
		List<Medico> medicos = query.getResultList();
		if(medicos != null && medicos.size() > 0){
			medico = medicos.get(0);
		}
		return medico;
	}

}
