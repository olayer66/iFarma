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

import es.ucm.fdi.iw.validation.Login;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	
	private static final Logger log = Logger.getLogger(PacienteController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("")
	String pantallaLoginAction(Model model) {
		model.addAttribute("login", new Login());
		return "paciente/loginPaciente";
	}
	
	@RequestMapping({"pedidosPc"})
	String pedidosPcAction() {
		return "paciente/pedidosPc";
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
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	String login(@ModelAttribute("login") @Valid Login login, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			log.error("Paso por aqui");
			return "paciente/loginPaciente";
		} else {
			if (login.hasRole("paciente")) {
				sesion.setAttribute("usuario", login.getUsuario());
				log.info("El administrador " + login.getUsuario() + " se ha logeado");
				return "paciente/perfil";
			} else {
				log.error("Error en el login");
				return "redirect:/index";
			}
		}
	}

	@GetMapping("/logout")
	String login(HttpSession sesion) {
		sesion.invalidate();
		log.info("Sesion finalizada");
		return "redirect:/index";
	}

}
