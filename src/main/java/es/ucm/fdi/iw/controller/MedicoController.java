package es.ucm.fdi.iw.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MedicoController {

	private static final Logger log = Logger.getLogger(MedicoController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping({"/medico", "/medico/listado-pacientes"})
	String listadoPacientesAction() {
		return "medico/listadoPacientes";
	}
	
	@RequestMapping("/medico/nuevo-paciente")
	String nuevoPacienteAction() {
		return "medico/nuevoPaciente";
	}

	@RequestMapping("/medico/detalle-paciente")
	String detallePacienteAction() {
		return "medico/detallePaciente";
	}
	
	@RequestMapping("/medico/feedback")
	String feedbackAction() {
		return "medico/feedback";
	}
}
