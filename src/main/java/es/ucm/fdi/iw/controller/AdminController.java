package es.ucm.fdi.iw.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.ucm.fdi.parser.parserMedicamentos;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger log = Logger.getLogger(AdminController.class);

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("")
	String pantallaLoginAction() {
		return "admin/admin";
	}

	@RequestMapping("admin")
	String adminAction() {
		return "admin/admin";
	}

	@RequestMapping("altasMedicos")
	String altasMedicosAction() {
		return "admin/altasMedicos";
	}

	@RequestMapping("altasFarmacias")
	String altaFarmaciasAction() {
		return "admin/altasFarmacias";
	}

	@RequestMapping("gestionMedicamentos")
	String gestionMedicamentosAction() {
		return "admin/gestionMedicamentos";
	}

	@RequestMapping("detalleAltaMedico")
	String detalleAltaMedicoAction() {
		return "admin/detalleAltaMedico";
	}

	@RequestMapping("detalleAltaFarmacia")
	String detalleAltaFarmaciaAction() {
		return "admin/detalleAltaFarmacia";
	}

	@RequestMapping("nuevoMedicamento")
	String nuevoMedicamentoAction() {
		return "admin/nuevoMedicamento";
	}
	@RequestMapping("insMedicmaentos")
	String insertarMedicamentos() {
		new parserMedicamentos("/static/json/medicamentos.json");
		return "admin/nuevoMedicamento";
	}
}
