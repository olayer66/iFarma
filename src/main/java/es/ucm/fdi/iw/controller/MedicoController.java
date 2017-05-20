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

import es.ucm.fdi.iw.validation.Medico;

@Controller
@RequestMapping("/medico")
public class MedicoController {

	private static final Logger log = Logger.getLogger(MedicoController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("")
	public String indexAction() {
		return "medico/listadoPacientes";
	}
	@GetMapping({"listado-pacientes"})
	public String listadoPacientesAction() {
		return "medico/listadoPacientes";
	}
	
	@RequestMapping("nuevo-paciente")
	public String nuevoPacienteAction() {
		return "medico/nuevoPaciente";
	}
	@RequestMapping("nuevoMedico")
	public String nuevoMedicoAction(Model model) {
		model.addAttribute("nuevo", new Medico());
		return "medico/nuevoMedico";
	}
	@RequestMapping("detalle-paciente")
	public String detallePacienteAction() {
		return "medico/detallePaciente";
	}
	
	@RequestMapping("feedback")
	public String feedbackAction() {
		return "medico/feedback";
	}
	@GetMapping("/logout")
	public String login(HttpSession sesion) {
		sesion.invalidate();
		log.info("Sesion finalizada");
		return "redirect:/index";
	}
}
