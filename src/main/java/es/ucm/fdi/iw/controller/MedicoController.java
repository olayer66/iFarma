package es.ucm.fdi.iw.controller;

import java.sql.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ucm.fdi.iw.model.Medicamento;
import es.ucm.fdi.iw.model.Medico;
import es.ucm.fdi.iw.model.Mensaje;
import es.ucm.fdi.iw.model.Paciente;
import es.ucm.fdi.iw.model.Tratamiento;
import es.ucm.fdi.iw.validation.MedicoForm;
import es.ucm.fdi.iw.validation.MensajeForm;
import es.ucm.fdi.iw.validation.TratamientoForm;

@Controller
@RequestMapping("/medico")
public class MedicoController {
	private static final Logger log = Logger.getLogger(MedicoController.class);

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@GetMapping("")
	public String indexAction() {
		return "redirect:/medico/listado-pacientes";
	}

	@GetMapping({"listado-pacientes"})
	public String listadoPacientesAction(Model model, HttpSession sesion) {
		model.addAttribute("medico", this.getLoggedUser(sesion));

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

	@Transactional
	@RequestMapping("/detalle-paciente/{id}")
	public String detallePacienteAction(@PathVariable("id") final Long id, @ModelAttribute("form") @Valid TratamientoForm form, BindingResult bindingResult, Model model, HttpSession sesion, HttpServletRequest request) {
		Paciente paciente = entityManager.find(Paciente.class, id);

		if (!this.getLoggedUser(sesion).getPacientes().contains(paciente)) {
			return "redirect:/denegado";
		}

		model.addAttribute("paciente", paciente);
		model.addAttribute("medicamentos", entityManager.createQuery("FROM Medicamento").getResultList());

		if (request.getMethod().equals("GET") || !bindingResult.hasErrors()) {
			model.addAttribute("form", new TratamientoForm());
		}

		if (request.getMethod().equals("POST")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("error", true);
			} else {
				Tratamiento tratamiento = new Tratamiento();

				tratamiento.setMedicamento(entityManager.find(Medicamento.class, Long.parseLong(form.getMedicamento())));
				tratamiento.setFechaInicio(form.getFechaInicioFormateada());
				tratamiento.setFechaFin(form.getFechaFinFormateada());
				tratamiento.setPerioicidad(form.getPeriodicidad());
				tratamiento.setNumDosis(form.getNumDosis());
				tratamiento.setNumDosisDia(form.getNumDosis());
				tratamiento.setPaciente(paciente);
				paciente.getTratamiento().add(tratamiento);

				entityManager.persist(tratamiento);
				entityManager.persist(paciente);
			}
		}

		return "/medico/detallePaciente";
	}

	@RequestMapping("feedback")
	String feedbackAction(Model model, HttpSession sesion) {
		Medico medico = this.getLoggedUser(sesion);
		MensajeForm mensaje = new MensajeForm();

		model.addAttribute("mensaje", mensaje);
		model.addAttribute("medico", medico);

		return "medico/feedback";
	}

	@RequestMapping("feedback/{id}")
	String verFeedbackAction(@PathVariable("id") final Long id, @ModelAttribute("form") @Valid MensajeForm form, BindingResult bindingResult, Model model, HttpSession sesion, HttpServletRequest request) {
		Medico medico = this.getLoggedUser(sesion);
		Mensaje mensaje = entityManager.find(Mensaje.class, id);

		if (!medico.getMensajesEnviados().contains(mensaje) && !medico.getMensajesRecibidos().contains(mensaje)) {
			return "redirect:/denegado";
		}

		model.addAttribute("medico", medico);
		model.addAttribute("mensaje", mensaje);

		if (request.getMethod().equals("GET") || !bindingResult.hasErrors()) {
			model.addAttribute("form", new MensajeForm());
		}

		if (request.getMethod().equals("POST")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("error", true);
			} else {
				Mensaje nuevoMensaje = new Mensaje();
				nuevoMensaje.setFechaMensaje(new Date(System.currentTimeMillis()));
				nuevoMensaje.setDestinatario(entityManager.find(Paciente.class, Long.parseLong(form.getDestinatario())));
				nuevoMensaje.setRemitente(medico);
				nuevoMensaje.setAsunto(form.getAsunto());
				nuevoMensaje.setMensaje(form.getMensaje());

				medico.getMensajesEnviados().add(nuevoMensaje);

				entityManager.persist(medico);

				return "redirect:/medico/feedback";
			}
		}

		return "medico/detalleFeedback";
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
