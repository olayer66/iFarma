package es.ucm.fdi.iw.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
	public String pantallaLoginAction() {
		return "redirect:/admin/admin";
	}

	@RequestMapping("admin")
	public String adminAction() {
		return "admin/admin";
	}

	@RequestMapping("altasMedicos")
	public String altasMedicosAction() {
		return "admin/altasMedicos";
	}

	@RequestMapping("altasFarmacias")
	public String altaFarmaciasAction() {
		return "admin/altasFarmacias";
	}

	
	@RequestMapping("gestionMedicamentos")
	public String gestionMedicamentosAction(HttpSession sesion) {
		List<Medicamento> listaMed;
		TypedQuery<Medicamento> query= entityManager.createNamedQuery("Medicamento.findAll", Medicamento.class);
		listaMed=query.getResultList();
		log.info("tamaño salida:" + listaMed.size());
		sesion.setAttribute("listaMed", listaMed);
		return "admin/gestionMedicamentos";
	}

	@RequestMapping("detalleAltaMedico")
	public String detalleAltaMedicoAction() {
		return "admin/detalleAltaMedico";
	}

	@RequestMapping("detalleAltaFarmacia")
	public String detalleAltaFarmaciaAction() {
		return "admin/detalleAltaFarmacia";
	}
	
	@RequestMapping("detalleAltaFarmaceutico")
	public String detalleAltaFarmaceuticoAction() {
		return "admin/detalleAltaFarmaceutico";
	}
	
	@RequestMapping("nuevoMedicamento")
	public String nuevoMedicamentoAction() {
		return "admin/nuevoMedicamento";
	}
	@Transactional
	@RequestMapping("insMedicamentos")
	public String insertarMedicamentos() throws IOException {
		MedicamentosParser.carga(
				new File("/home/hlocal/iFarma/src/main/resources/static/json/medicamentos.json"),
				entityManager);
		return "admin/gestionMedicamentos";
	}
}
