package es.ucm.fdi.iw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@GetMapping({"/admin", "admin/admin"})
	String listadoPacientesAction() {
		return "admin/admin";
	}
	
	@RequestMapping("/admin/altas-medicos")
	String nuevoPacienteAction() {
		return "admin/altasMedicos";
	}

	@RequestMapping("/admin/altas-farmacias")
	String detallePacienteAction() {
		return "admin/altasFarmacias";
	}
}
