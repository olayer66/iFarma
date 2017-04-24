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

import es.ucm.fdi.iw.login.Login;

@Controller
@RequestMapping("/medico")
public class MedicoController {

	private static final Logger log = Logger.getLogger(MedicoController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("")
	String pantallaLoginAction(Model model) {
		model.addAttribute("login", new Login());
		return "medico/loginMedico";
	}
	@GetMapping({"listado-pacientes"})
	String listadoPacientesAction() {
		return "medico/listadoPacientes";
	}
	
	@RequestMapping("nuevo-paciente")
	String nuevoPacienteAction() {
		return "medico/nuevoPaciente";
	}

	@RequestMapping("detalle-paciente")
	String detallePacienteAction() {
		return "medico/detallePaciente";
	}
	
	@RequestMapping("feedback")
	String feedbackAction() {
		return "medico/feedback";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	String login(@ModelAttribute("login") @Valid Login login, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			log.error("Paso por aqui");
			return "medico/loginMedico";
		} else {
			if (login.hasRole("medico")) {
				sesion.setAttribute("usuario", login.getUsuario());
				log.info("El administrador " + login.getUsuario() + " se ha logeado");
				return "/medico/listadoPacientes";
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
