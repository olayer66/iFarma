package es.ucm.fdi.iw.controller;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ucm.fdi.iw.model.Medico;
import es.ucm.fdi.iw.model.Mensaje;
import es.ucm.fdi.iw.model.Paciente;
import es.ucm.fdi.iw.validation.MedicoForm;
import es.ucm.fdi.iw.validation.MensajeForm;

@Controller
@RequestMapping("/medico")
public class MedicoController {

	private static final Logger log = Logger.getLogger(MedicoController.class);

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
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
		model.addAttribute("nuevo", new MedicoForm());
		
		return "medico/nuevoMedico";
	}
	@RequestMapping("detalle-paciente")
	public String detallePacienteAction() {
		return "medico/detallePaciente";
	}

	@RequestMapping("feedback")
	String feedbackAction(Model model, HttpSession sesion) {
		Medico medico = this.getLoggedUser(sesion);
		MensajeForm mensaje = new MensajeForm();
		
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("medico", medico);

		return "medico/feedback";
	}

	@Transactional
	@RequestMapping(value = "/feedback/nuevo", method = RequestMethod.POST)
	String nuevoFeedbackAction(@ModelAttribute("mensaje") @Valid MensajeForm form, BindingResult bindingResult, Model model, HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", true);
			model.addAttribute("mensaje", form);

			return "medico/feedback";
		}
		
		Mensaje mensaje = new Mensaje();
		mensaje.setAsunto(form.getAsunto());
		mensaje.setMensaje(form.getMensaje());
		mensaje.setDestinatario(entityManager.find(Paciente.class, Long.parseLong(form.getDestinatario())));
		mensaje.setRemitente(this.getLoggedUser(sesion));
		mensaje.setFechaMensaje(new Date(System.currentTimeMillis()));
		
		Medico medico = this.getLoggedUser(sesion);
		medico.getMensajesEnviados().add(mensaje);
		
		entityManager.persist(medico);
		
		return "redirect:/medico/feedback";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	String login(@ModelAttribute("nuevo") @Valid MedicoForm nuevo, BindingResult bindingResult, Model model,
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
	public String login(HttpSession sesion) {
		sesion.invalidate();
		log.info("Sesion finalizada");
		return "redirect:/index";
	}
	
	private Medico getLoggedUser(HttpSession sesion) {
		Medico medico;
		
		if ((medico = (Medico) sesion.getAttribute("medico")) == null) {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			
			medico = entityManager
					.createQuery("FROM Medico WHERE usuario = :usuario", Medico.class)
					.setParameter("usuario", username)
					.getSingleResult();
			
			sesion.setAttribute("medico", medico);
		}
		
		return medico;
	}
}
