package es.ucm.fdi.iw.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PacienteController {
	
	private static final Logger log = Logger.getLogger(PacienteController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping({"/paciente"})
	String pacienteAction() {
		return "paciente/paciente";
	}
	
	@RequestMapping({"/paciente/pedidosPc"})
	String pedidosPcAction() {
		return "paciente/pedidosPc";
	}
	
	@RequestMapping("/paciente/tratamiento")
	String tratamientoAction() {
		return "paciente/tratamiento";
	}
	@RequestMapping("/paciente/perfil")
	String perfilAction() {
		return "paciente/perfil";
	}
	@RequestMapping("/paciente/feedbackDR")
	String feedbackDrAction() {
		return "paciente/feedbackDR";
	}
	@RequestMapping("/paciente/verPedidos")
	String pedidoAction() {
		return "paciente/verPedidos";
	}

}
