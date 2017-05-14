package es.ucm.fdi.iw.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.ucm.fdi.iw.model.Medicamento;
import es.ucm.fdi.parser.MedicamentosParser;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger log = Logger.getLogger(AdminController.class);

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
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
		new MedicamentosParser("/static/json/medicamentos.json", entityManager);
		return "admin/nuevoMedicamento";
	}
	
	@Transactional
	@RequestMapping("m")
	String insertarMedicamento() {
		Medicamento m = new Medicamento();
		m.setDescripcion("pastilla");
		m.setLaboratorio("merk");
		m.setNombre("penicilina");
		m.setPrecio(100);
		entityManager.persist(m);
		log .info("medicamento insertado correctamente");
		return "admin/admin";
	}
}
