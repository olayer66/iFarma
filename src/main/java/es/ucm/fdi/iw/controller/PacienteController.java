package es.ucm.fdi.iw.controller;

import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import es.ucm.fdi.iw.model.Mensaje;
import es.ucm.fdi.iw.model.Paciente;
import es.ucm.fdi.iw.model.Pedidos;
import es.ucm.fdi.iw.model.ExistenciaPedido;
import es.ucm.fdi.iw.model.Farmaceutico;
import es.ucm.fdi.iw.model.Farmacia;
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
	public String perfilAction( HttpSession sesion) {
		Paciente paciente = this.getLoggedUser(sesion);
		
		sesion.setAttribute("paciente", paciente);
		return "paciente/perfil";
	}
	
	@RequestMapping("verPedidos")
	public String pedidoAction(HttpSession sesion,@RequestParam long id,@RequestParam long idFarmacia, Model model) {
		Paciente paciente = this.getLoggedUser(sesion);
		model.addAttribute("idPedido", id);
		model.addAttribute("idFarmacia", idFarmacia);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		/*Paciente paciente = entityManager.createQuery(
        		"FROM Paciente WHERE usuario = :usuario", Paciente.class)
                            .setParameter("usuario", username)
                            .getSingleResult();
		*/

		Pedidos pedidos =entityManager.find(Pedidos.class, id);
		Farmacia farmacia =entityManager.find(Farmacia.class, idFarmacia); 
		List<ExistenciaPedido> listEx = pedidos.getExistenciasPedido();
		
				
		if (paciente == null || pedidos.getPaciente() != paciente){
			log.info("Acceso denegado");
		}else{
			log.info("tamaño salida de Existencias:" +listEx.size());
			Date date= new Date();//fecha actual
			
			model.addAttribute("fecha",date.toString());
			model.addAttribute("total", pedidos.getPrecioTotal());
			model.addAttribute("listEx", listEx);
			model.addAttribute("pedido", pedidos);
			model.addAttribute("farmacia", farmacia);
			model.addAttribute("paciente",paciente);
			
		}
	
		return "paciente/verPedidos";
	}
	
	@RequestMapping("feedbackDR")
	public String feedbackDRAction(Model model, HttpSession sesion) {
		Paciente paciente = this.getLoggedUser(sesion);
		MensajeForm mensaje = new MensajeForm();

		model.addAttribute("mensaje", mensaje);
		model.addAttribute("paciente", paciente);

		return "paciente/feedbackDR";
	}

	@Transactional
	@RequestMapping("feedbackDR/{id}")
	public String verFeedbackAction(@PathVariable("id") final Long id, @ModelAttribute("form") @Valid MensajeForm form, BindingResult bindingResult, Model model, HttpSession sesion, HttpServletRequest request) {
		Paciente paciente = this.getLoggedUser(sesion);
		Mensaje mensaje = entityManager.find(Mensaje.class, id);

		if (!paciente.getMensajesEnviados().contains(mensaje) && !paciente.getMensajesRecibidos().contains(mensaje)) {
			return "redirect:/denegado";
		}

		model.addAttribute("paciente", paciente);
		model.addAttribute("mensaje", mensaje);

		if (request.getMethod().equals("GET") || !bindingResult.hasErrors()) {
			model.addAttribute("form", new MensajeForm());
		}

		if (request.getMethod().equals("POST")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("error", true);
			} else {
				Medico medico = entityManager.find(Medico.class, Long.parseLong(form.getDestinatario()));
				Mensaje nuevoMensaje = new Mensaje();

				nuevoMensaje.setFechaMensaje(new java.sql.Date(new Date().getDate()));
				nuevoMensaje.setDestinatario(medico);
				nuevoMensaje.setRemitente(paciente);
				nuevoMensaje.setAsunto(form.getAsunto());
				nuevoMensaje.setMensaje(form.getMensaje());

				entityManager.persist(nuevoMensaje);

				return "redirect:/paciente/feedbackDR";
			}
		}

		return "paciente/detalleFeedbackDR";
	}

	@Transactional
	@RequestMapping(value = "/feedbackDR/nuevo", method = RequestMethod.POST)
	public String nuevoFeedbackAction(@ModelAttribute("mensaje") @Valid MensajeForm form, BindingResult bindingResult, Model model, HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", true);
			model.addAttribute("mensaje", form);

			return "medico/feedback";
		}

		Mensaje mensaje = new Mensaje();
		Paciente paciente = this.getLoggedUser(sesion);
		Medico medico = entityManager.find(Medico.class, Long.parseLong(form.getDestinatario()));

		mensaje.setFechaMensaje(new java.sql.Date(new Date().getDate()));
		mensaje.setDestinatario(medico);
		mensaje.setRemitente(paciente);
		mensaje.setAsunto(form.getAsunto());
		mensaje.setMensaje(form.getMensaje());
		medico.getMensajesEnviados().add(mensaje);

		entityManager.persist(mensaje);

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
