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
	
	@RequestMapping("/admin/altasMedicos")
	String altasMedicosAction() {
		return "admin/altasMedicos";
	}

	@RequestMapping("/admin/altasFarmacias")
	String altaFarmaciasAction() {
		return "admin/altasFarmacias";
	}
	@RequestMapping("/admin/gestionMedicamentos")
	String gestionMedicamentosAction() {
		return "admin/gestionMedicamentos";
	}
	@RequestMapping("/admin/detalleAltaMedico")
	String detalleAltaMedicoAction() {
		return "admin/detalleAltaMedico";
	}
	@RequestMapping("/admin/detalleAltaFarmacia")
	String detallateAltaFarmaciaAction() {
		return "admin/detalleAltaFarmacia";
	}
}
