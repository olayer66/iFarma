package es.ucm.fdi.iw.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.ucm.fdi.iw.model.Farmacia;
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
	public String adminAction(HttpSession sesion) {
		Long petFarmaceutico;
		Long petMedico;
		Long petFarmacia;
		
		petFarmaceutico=(Long) entityManager.createNamedQuery("Usuario.count").setParameter("tiporole", "FAR").getSingleResult();
		petMedico=(Long) entityManager.createNamedQuery("Usuario.count").setParameter("tiporole", "MED").getSingleResult();
		petFarmacia=(Long) entityManager.createNamedQuery("Farmacia.countFARMA").getSingleResult();
		
		sesion.setAttribute("petFarmaceutico", petFarmaceutico);
		sesion.setAttribute("petMedico", petMedico);
		sesion.setAttribute("petFarmacia", petFarmacia);
		return "admin/admin";
	}

	@RequestMapping("altasMedicos")
	public String altasMedicosAction() {
		return "admin/altasMedicos";
	}

	@RequestMapping("altasFarmacias")
	public String altaFarmaciasAction(HttpSession sesion) {
		List<Farmacia> listaFarmacia;
		TypedQuery<Farmacia> query= entityManager.createNamedQuery("Farmacia.findValidar", Farmacia.class);
		listaFarmacia=query.getResultList();
		log.warn("contador de farmacias: "+listaFarmacia.size());
		sesion.setAttribute("listaFarmacia", listaFarmacia);
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

	@RequestMapping("detalleAltaFarmaceutico")
	public String detalleAltaFarmaciaAction(@RequestParam("id") Long id) {
		return "admin/detalleAltaFarmacia";
	}
	
	@RequestMapping(value="detalleAltaFarmacia/{id}", method=RequestMethod.GET)
	public String detalleAltaFarmaceuticoAction(@PathVariable Long id, HttpSession sesion) {
		Farmacia farmacia;
		farmacia=entityManager.createNamedQuery("Farmacia.findById", Farmacia.class).setParameter("id", id).getSingleResult();
		sesion.setAttribute("detalleFarmacia", farmacia);
		return "admin/detalleAltaFarmacia";
	}
	//aceptar o denegar peticiones
	@RequestMapping(value="aceptarPeticion/{tipo}/{id}", method=RequestMethod.GET)
	public String aceptarPeticionAction(@PathVariable("tipo") String tipo,@PathVariable("id") Long id, HttpSession sesion) {
		
		return "admin/detalleAltaFarmacia";
	}
	
	@RequestMapping("nuevoMedicamento")
	public String nuevoMedicamentoAction() {
		return "admin/nuevoMedicamento";
	}
	@Transactional
	@RequestMapping("insMedicamentos")
	public String insertarMedicamentos() throws IOException {
		InputStream dataStream = getClass().getResourceAsStream(
				"/static/json/medicamentos.json");
		MedicamentosParser.carga(new String(IOUtils.toByteArray(dataStream)),
				entityManager);
		return "redirect:/admin/gestionMedicamentos";
	}
}
