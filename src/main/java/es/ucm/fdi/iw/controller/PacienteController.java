package es.ucm.fdi.iw.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
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

import es.ucm.fdi.iw.model.Farmacia;
import es.ucm.fdi.iw.model.Mensaje;
import es.ucm.fdi.iw.validation.ValidarPaciente;

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
	public String feedbackDRAction(HttpSession sesion) {
		List<Mensaje> listMensajes;
		TypedQuery<Mensaje> query= entityManager.createNamedQuery("Mensaje.extraerMensaje", Mensaje.class);
		listMensajes=query.getResultList();
		log.warn("contador de mensajes leidos: "+listMensajes.size());
		sesion.setAttribute("listMensajes", listMensajes);
		return "paciente/feedbackDR";
	}
	
}
