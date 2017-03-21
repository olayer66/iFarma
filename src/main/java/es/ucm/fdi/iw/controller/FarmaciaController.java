package es.ucm.fdi.iw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FarmaciaController {
	
	@GetMapping({"/farmacia", "/farmacia/pedidos"})
	String pedidosAction() {
		return "farmacia/pedidos";
	}
	
	
	@RequestMapping("/farmacia/stock")
	String stockAction() {
		return "farmacia/stock";
	}
	@RequestMapping("/farmacia/pedido")
	String pedidoAction() {
		return "farmacia/pedido";
	}
	

/*	@RequestMapping("/farmacia/farmacia")
	String farmaciaAction() {
		return "farmacia/farmacia";
	}*/
}
