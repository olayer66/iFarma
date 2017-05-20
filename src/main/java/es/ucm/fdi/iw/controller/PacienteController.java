package es.ucm.fdi.iw.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ucm.fdi.iw.validation.ValidarPaciente;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	
	private static final Logger log = Logger.getLogger(PacienteController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("")
	public String pantallaLoginAction(Model model) {
		return "paciente/tratamiento";
	}
	@RequestMapping("modificarPaciente")
	public String modificarpacienteAction() {
		return "paciente/modificarPaciente";
	}
	@RequestMapping("cambiarPassword")
	public String cambiarPasswordAction() {
		return "paciente/cambiarPassword";
	}
	@RequestMapping("modificarPago")
	public String modificarpagoAction() {
		return "paciente/modificarPago";
	}
	@RequestMapping({"pedidosPc"})
	public String pedidosPcAction() {
		return "paciente/pedidosPc";
	}
	@RequestMapping("tratamiento")
	public String tratamientoAction() {
		return "paciente/tratamiento";
	}
	@RequestMapping("perfil")
	public String perfilAction() {
		return "paciente/perfil";
	}
	@RequestMapping("feedbackDR")
	public String feedbackDrAction() {
		return "paciente/feedbackDR";
	}
	@RequestMapping("verPedidos")
	public String pedidoAction() {
		return "paciente/verPedidos";
	}
	
}
