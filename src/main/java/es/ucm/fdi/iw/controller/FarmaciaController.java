package es.ucm.fdi.iw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FarmaciaController {
	
	@GetMapping({"/farmacia", "/farmacia/pedidos"})
	String listadoPacientesAction() {
		return "farmacia/pedidos";
	}
	
	
	@RequestMapping("/farmacia/stock")
	String detallePacienteAction() {
		return "farmacia/stock";
	}
	@RequestMapping("/farmacia/pedido")
	String detallePacienteAction() {
		return "farmacia/pedido";
	}
}
