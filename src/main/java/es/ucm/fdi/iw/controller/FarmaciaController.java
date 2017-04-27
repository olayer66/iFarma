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

import es.ucm.fdi.iw.validation.Farmaceutico;
import es.ucm.fdi.iw.validation.Login;
import es.ucm.fdi.iw.validation.Medico;

@Controller
@RequestMapping("/farmacia")
public class FarmaciaController {

	private static final Logger log = Logger.getLogger(FarmaciaController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("")
	String pantallaLoginAction(Model model) {
		model.addAttribute("login", new Login());
		return "farmacia/loginFarmacia";
	}
	
	@RequestMapping("farmaceutico")
	String farmaceuticoAction() {
		return "farmacia/farmaceutico";
	}
	@RequestMapping("modificarFarmaceutico")
	String modificarfarmaceuticoAction() {
		return "farmacia/modificarFarmaceutico";
	}
	
	@GetMapping({"farmacia", "pedidos"})
	String pedidosAction() {
		return "farmacia/pedidos";
	}
	
	@RequestMapping("nuevoFarmaceutico")
	String nuevoFarmaceuticoAction(Model model) {
		model.addAttribute("nuevo", new Farmaceutico());
		return "farmacia/nuevoFarmaceutico";
	}
	
	@RequestMapping("stock")
	String stockAction() {
		return "farmacia/stock";
	}
	@RequestMapping("pedido")
	String pedidoAction() {
		return "farmacia/pedido";
	}
	@RequestMapping("modificarFarmacia")
	String modificarfarmaciaAction() {
		return "farmacia/modificarFarmacia";
	}



	@RequestMapping(value = "/login", method = RequestMethod.POST)
	String login(@ModelAttribute("login") @Valid Login login, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			log.error("Paso por aqui");
			return "farmacia/loginFarmacia";
		} else {
			if (login.hasRole("farmaceutico")) {
				sesion.setAttribute("usuario", login.getUsuario());
				log.info("El farmaceutico " + login.getUsuario() + " se ha logeado");
				return "farmacia/farmaceutico";
			} else {
				log.error("Error en el login");
				return "redirect:/index";
			}
		}
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	String login(@ModelAttribute("nuevo") @Valid Farmaceutico nuevo, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			log.error("Paso por aqui");
			return "farmacia/nuevoFermaceutico";
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
/*	@RequestMapping("/farmacia/farmacia")
	String farmaciaAction() {
		return "farmacia/farmacia";
	}*/
}
