package es.ucm.fdi.iw.controller;

import java.sql.Date;
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

import es.ucm.fdi.iw.model.Mensaje;
import es.ucm.fdi.iw.model.Paciente;
import es.ucm.fdi.iw.model.Medico;
import es.ucm.fdi.iw.validation.MensajeForm;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	private static final Logger log = Logger.getLogger(PacienteController.class);

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
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
	@RequestMapping("verPedidos")
	public String pedidoAction() {
		return "paciente/verPedidos";
	}
	@RequestMapping("feedbackDR")
	String feedbackDRAction(Model model, HttpSession sesion) {
		Paciente paciente = this.getLoggedUser(sesion);
		MensajeForm mensaje = new MensajeForm();

		model.addAttribute("mensaje", mensaje);
		model.addAttribute("paciente", paciente);

		return "paciente/feedbackDR";
	}

	@Transactional
	@RequestMapping(value = "/feedbackDR/nuevo", method = RequestMethod.POST)
	String nuevoFeedbackDRAction(@ModelAttribute("mensaje") @Valid MensajeForm form, BindingResult bindingResult, Model model, HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", true);
			model.addAttribute("mensaje", form);

			return "paciente/feedbackDR";
		}

		Mensaje mensaje = new Mensaje();
		Paciente paciente = this.getLoggedUser(sesion);
		Medico medico = paciente.getMedCabecera();

		mensaje.setFechaMensaje(new Date(System.currentTimeMillis()));
		mensaje.setRemitente(paciente);
		mensaje.setDestinatario(medico);
		mensaje.setAsunto(form.getAsunto());
		mensaje.setMensaje(form.getMensaje());

		medico.getMensajesRecibidos().add(mensaje);
		paciente.getMensajesEnviados().add(mensaje);

		entityManager.persist(mensaje);
		entityManager.persist(paciente);

		return "redirect:/paciente/feedbackDR";
	}

	private Paciente getLoggedUser(HttpSession sesion) {
		Paciente paciente;

		if ((paciente = (Paciente) sesion.getAttribute("paciente")) == null) {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();

			paciente = entityManager
					.createQuery("FROM Paciente WHERE usuario = :usuario", Paciente.class)
					.setParameter("usuario", username)
					.getSingleResult();

			sesion.setAttribute("paciente", paciente);
		}

		return paciente;
	}

}
