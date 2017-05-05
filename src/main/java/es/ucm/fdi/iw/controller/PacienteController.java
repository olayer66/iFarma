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
	String pantallaLoginAction(Model model) {
		return "paciente/tratamiento";
	}
	@RequestMapping("modificarPaciente")
	String modificarpacienteAction() {
		return "paciente/modificarPaciente";
	}
	@RequestMapping("cambiarPassword")
	String cambiarPasswordAction() {
		return "paciente/cambiarPassword";
	}
	@RequestMapping("modificarPago")
	String modificarpagoAction() {
		return "paciente/modificarPago";
	}
	@RequestMapping({"pedidosPc"})
	String pedidosPcAction() {
		return "paciente/pedidosPc";
	}
	@RequestMapping("validarPaciente")
	String validarPacienteAction(Model model) {
		model.addAttribute("validar", new ValidarPaciente());
		return "paciente/validarPaciente";
	}
	@RequestMapping("tratamiento")
	String tratamientoAction() {
		return "paciente/tratamiento";
	}
	@RequestMapping("perfil")
	String perfilAction() {
		return "paciente/perfil";
	}
	@RequestMapping("feedbackDR")
	String feedbackDrAction() {
		return "paciente/feedbackDR";
	}
	@RequestMapping("verPedidos")
	String pedidoAction() {
		return "paciente/verPedidos";
	}
	@RequestMapping(value = "/validar", method = RequestMethod.POST)
	String login(@ModelAttribute("validar") @Valid ValidarPaciente validar, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			log.error("Paso por aqui");
			return "paciente/validarPaciente";
		} else {
			log.info("Paciente validado");
			return "redirect:/index";
		}
	}
}
