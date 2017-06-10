
package es.ucm.fdi.iw.controller;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
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
import es.ucm.fdi.iw.model.Tratamiento;
import es.ucm.fdi.iw.model.Usuario;
import es.ucm.fdi.iw.model.ExistenciaPedido;
import es.ucm.fdi.iw.model.Medicamento;
import es.ucm.fdi.iw.model.Medico;
import es.ucm.fdi.iw.validation.MensajeForm;
import es.ucm.fdi.iw.validation.TomaForm;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	private static final Logger log = Logger.getLogger(PacienteController.class);

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@GetMapping("")
	public String pantallaLoginAction(Model model) {
		return "redirect:/paciente/tratamiento";
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

	@Transactional
	@RequestMapping("/tratamiento")
	public String tratamientoAction(@ModelAttribute("form") @Valid TomaForm form, BindingResult bindingResult, Model model, HttpSession sesion, HttpServletRequest request) {
		if(!estadoValido()) {
			return "/estadoDenegado";
		}

		Paciente paciente = this.getLoggedUser(sesion);
		model.addAttribute("tratamientosEnCurso", entityManager.createNamedQuery("Tratamiento.enCurso").setParameter("paciente", paciente).getResultList());
		model.addAttribute("tratamientosFinalizados", entityManager.createNamedQuery("Tratamiento.finalizados").setParameter("paciente", paciente).getResultList());


		if (request.getMethod().equals("GET") || !bindingResult.hasErrors()) {
			model.addAttribute("form", new TomaForm());
		}

		if (request.getMethod().equals("POST")) {
			Tratamiento tratamiento = entityManager.find(Tratamiento.class, Long.parseLong(form.getTratamiento()));

			if (paciente.getTratamiento().contains(tratamiento)) {
				if (form.getAccion().equals("add")) {
					tratamiento.registraToma();
				} else if (form.getAccion().equals("sub")) {
					tratamiento.eliminaToma();
				}

				entityManager.persist(tratamiento);
				entityManager.persist(paciente);
			}
		}

		return "paciente/tratamiento";
	}

	@RequestMapping("perfil")
	public String perfilAction( HttpSession sesion) {
		Paciente paciente = this.getLoggedUser(sesion);

		//Medicamento m= entityManager.find(Medicamento.class, (long)7024491);
		//nuevoPedido(m,20); //para probar funcion, funciona perfecta

		sesion.setAttribute("paciente", paciente);
		return "paciente/perfil";
	}

	@RequestMapping({"pedidosPc"})
	public String pedidosPcAction() {


		return "paciente/pedidosPc";
	}

	@Transactional
	@GetMapping("pedidosPc")
	public String pedidosAction( HttpSession sesion,Model model) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Paciente paciente = entityManager.createQuery(
        		"FROM Paciente WHERE usuario = :usuario", Paciente.class)
                            .setParameter("usuario", username)
                            .getSingleResult();

			List<Pedidos> listaped = paciente.getListaPedidos();

			log.info("tamaño salida:" + listaped.size());
			model.addAttribute("listaPed", listaped);

		return "paciente/pedidosPc";
	}

	@Transactional
	private void nuevoPedido( Medicamento medicamento, int cantidad) {
		boolean continuar=true;
		int i=0;
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Paciente paciente = entityManager.createQuery(
        		"FROM Paciente WHERE usuario = :usuario", Paciente.class)
                            .setParameter("usuario", username)
                            .getSingleResult();

			List<Pedidos> listaPed = paciente.getListaPedidos();
			ExistenciaPedido nuevaExis = new ExistenciaPedido();




			while(i< listaPed.size() && continuar){
				if(listaPed.get(i).getEstadoPedido()==0){
					continuar=false;
				}
				i++;
			}
			if(continuar){//si no hay ningun pedido estado 0 crea el pedido
				List<ExistenciaPedido> listaExis = new ArrayList<ExistenciaPedido>();
				Pedidos nuevoPedido = new Pedidos();
				nuevoPedido.setEstadoPedido(0);
				nuevoPedido.setFarmacia(paciente.getFarmacia());
				nuevoPedido.setPaciente(paciente);
				nuevoPedido.setFechaPedido(new Date(System.currentTimeMillis()));

				nuevaExis.setCantidad(cantidad);
				nuevaExis.setFechaCaducidad(new Date(9, 12, 2020));
				nuevaExis.setMedicamento(medicamento);
				nuevaExis.setPedido(nuevoPedido);
				listaExis.add(nuevaExis);

				nuevoPedido.setExistenciasPedido(listaExis);
				listaPed.add(nuevoPedido);
				paciente.setListaPedidos(listaPed);

				entityManager.persist(nuevaExis);
				entityManager.persist(nuevoPedido);
				entityManager.persist(paciente);



			}else{//si he encontrado un pedido estado 0 (i-1)
				boolean existenciaencontrada=false;
				int j=0;
				Pedidos nuevoPedido = listaPed.get(i-1);
				listaPed.remove(i-1);
				List<ExistenciaPedido> listaExis =nuevoPedido.getExistenciasPedido();

				while(j < listaExis.size() && !existenciaencontrada){
					if(listaExis.get(j).getMedicamento()==medicamento){
						existenciaencontrada=true;;
					}
					j++;
				}

				if(existenciaencontrada){
					nuevaExis = listaExis.get(j-1);
					listaExis.remove(j-1);
					nuevaExis.setCantidad(nuevaExis.getCantidad()+cantidad);

				}else{
					nuevaExis.setCantidad(cantidad);
					nuevaExis.setFechaCaducidad(new Date(9, 12, 2020));
					nuevaExis.setMedicamento(medicamento);
					nuevaExis.setPedido(nuevoPedido);
				}


				listaExis.add(nuevaExis);

				nuevoPedido.setExistenciasPedido(listaExis);
				listaPed.add(nuevoPedido);
				paciente.setListaPedidos(listaPed);

				entityManager.persist(nuevaExis);
				entityManager.persist(nuevoPedido);
				entityManager.persist(paciente);
			}

	}

	@RequestMapping("verPedido")
	public String pedidoAction(HttpSession sesion,@RequestParam long id, Model model) {
		model.addAttribute("idPedido", id);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Paciente paciente = entityManager.createQuery(
        		"FROM Paciente WHERE usuario = :usuario", Paciente.class)
                            .setParameter("usuario", username)
                            .getSingleResult();



		Pedidos pedidos =entityManager.find(Pedidos.class, id);
		List<ExistenciaPedido> listEx = pedidos.getExistenciasPedido();


		if (paciente == null || pedidos.getPaciente() != paciente){
			log.info("Acceso denegado");
		}else{
			log.info("tamaño salida de Existencias:" +listEx.size());

			model.addAttribute("fecha", new Date(System.currentTimeMillis()));
			model.addAttribute("total", pedidos.getPrecioTotal());
			model.addAttribute("listEx", listEx);
			model.addAttribute("pedido", pedidos);
			model.addAttribute("farmacia", paciente.getFarmacia());
			model.addAttribute("paciente",paciente);

		}

		return "paciente/verPedido";
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

				nuevoMensaje.setFechaMensaje(new Date(System.currentTimeMillis()));
				nuevoMensaje.setDestinatario(medico);
				nuevoMensaje.setRemitente(paciente);
				nuevoMensaje.setAsunto(form.getAsunto());
				nuevoMensaje.setMensaje(form.getMensaje());
				paciente.getMensajesEnviados().add(nuevoMensaje);

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

			return "paciente/feedbackDR";
		}

		Mensaje mensaje = new Mensaje();
		Paciente paciente = this.getLoggedUser(sesion);
		Medico medico = paciente.getMedCabecera();

		mensaje.setFechaMensaje(new Date(System.currentTimeMillis()));
		mensaje.setDestinatario(medico);
		mensaje.setRemitente(paciente);
		mensaje.setAsunto(form.getAsunto());
		mensaje.setMensaje(form.getMensaje());
		paciente.getMensajesEnviados().add(mensaje);

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
	private boolean estadoValido()
	{
		Usuario usuario;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		usuario=entityManager.createNamedQuery("Usuario.findByUsuario", Usuario.class).setParameter("usuario", auth.getName()).getSingleResult();
		if(usuario.getEstado()!=1)
			return false;
		else
			return true;
	}

}
