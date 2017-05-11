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

@Controller
@RequestMapping("/farmacia")
public class FarmaciaController {

	private static final Logger log = Logger.getLogger(FarmaciaController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("")
	String pantallaLoginAction() {
		return "farmacia/farmaceutico";
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
}
