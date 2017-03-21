package es.ucm.fdi.iw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MedicoController {
	
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
