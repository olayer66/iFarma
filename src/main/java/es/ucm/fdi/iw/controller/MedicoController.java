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

import es.ucm.fdi.iw.model.Mensaje;
import es.ucm.fdi.iw.validation.Medico;

@Controller
@RequestMapping("/medico")
public class MedicoController {

	private static final Logger log = Logger.getLogger(MedicoController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("")
	String indexAction() {
		return "medico/listadoPacientes";
	}
	@GetMapping({"listado-pacientes"})
	String listadoPacientesAction() {
		return "medico/listadoPacientes";
	}
	
	@RequestMapping("nuevo-paciente")
	String nuevoPacienteAction() {
		return "medico/nuevoPaciente";
	}
	@RequestMapping("nuevoMedico")
	String nuevoMedicoAction(Model model) {
		model.addAttribute("nuevo", new Medico());
		return "medico/nuevoMedico";
	}
	@RequestMapping("detalle-paciente")
	String detallePacienteAction() {
		return "medico/detallePaciente";
	}
	
	@RequestMapping("feedback")
	String feedbackAction() {
		return "medico/feedback";
	}
	
	@RequestMapping(value = "feedback/nuevo", method = RequestMethod.POST)
	String nuevoFeedbackAction(@ModelAttribute("crearFeedback") @Valid Mensaje mensaje, BindingResult bindingResult, HttpSession sesion) {
		return "medico/feedback";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	String login(@ModelAttribute("nuevo") @Valid Medico nuevo, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			log.error("Paso por aqui");
			return "medico/nuevoMedico";
		} else {
			log.info("Paciente validado");
			return "redirect:/index";
		}
	}
	@GetMapping("/logout")
	String login(HttpSession sesion) {
		sesion.invalidate();
		log.info("Sesion finalizada");
		return "redirect:/index";
	}
}
