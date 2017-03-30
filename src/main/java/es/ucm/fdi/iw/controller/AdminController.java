package es.ucm.fdi.iw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/")
	String listadoPacientesAction() {
		return "admin/loginAdmin";
	}
	
	@RequestMapping("/admin")
	String adminAction() {
		return "admin/admin";
	}
	
	@RequestMapping("/altasMedicos")
	String altasMedicosAction() {
		return "admin/altasMedicos";
	}

	@RequestMapping("/altasFarmacias")
	String altaFarmaciasAction() {
		return "admin/altasFarmacias";
	}
	@RequestMapping("/gestionMedicamentos")
	String gestionMedicamentosAction() {
		return "admin/gestionMedicamentos";
	}
	@RequestMapping("/detalleAltaMedico")
	String detalleAltaMedicoAction() {
		return "admin/detalleAltaMedico";
	}
	@RequestMapping("/detalleAltaFarmacia")
	String detalleAltaFarmaciaAction() {
		return "admin/detalleAltaFarmacia";
	}
	@RequestMapping("/nuevoMedicamento")
	String nuevoMedicamentoAction() {
		return "/admin/nuevoMedicamento";
	}
	
	
}
