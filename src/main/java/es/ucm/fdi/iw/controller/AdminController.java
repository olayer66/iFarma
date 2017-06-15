package es.ucm.fdi.iw.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import es.ucm.fdi.iw.model.Farmaceutico;
import es.ucm.fdi.iw.model.Farmacia;
import es.ucm.fdi.iw.model.Medicamento;
import es.ucm.fdi.iw.model.Medico;
import es.ucm.fdi.iw.model.Usuario;
import es.ucm.fdi.iw.validation.ValidarMedicamento;
import es.ucm.fdi.parser.MedicamentosParser;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger log = Logger.getLogger(AdminController.class);

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	/*-----PAGINA PRICIPAL-------*/
	//Pagina principal
	@GetMapping("")
	public String pantallaLoginAction() {
		return "redirect:/admin/admin";
	}
	@RequestMapping("admin")
	public String adminAction(HttpSession sesion) {
		Long petFarmaceutico;
		Long petMedico;
		Long petFarmacia;
		if(estadoValido())
		{
			petFarmaceutico=(Long) entityManager.createNamedQuery("Usuario.count").setParameter("tiporole", "FAR").getSingleResult();
			petMedico=(Long) entityManager.createNamedQuery("Usuario.count").setParameter("tiporole", "MED").getSingleResult();
			petFarmacia=(Long) entityManager.createNamedQuery("Farmacia.countFARMA").getSingleResult();
			
			sesion.setAttribute("petFarmaceutico", petFarmaceutico);
			sesion.setAttribute("petMedico", petMedico);
			sesion.setAttribute("petFarmacia", petFarmacia);
			return "admin/admin";
		}
		else
			return "/estadoDenegado";
	}
	
	/*-----PETICIONES DE MEDICOS-----*/
	//Lista de peticiones de medicos
	@RequestMapping("altasMedicos")
	public String altasMedicosAction(HttpSession sesion) {
		List<Medico> listaMedico;
		TypedQuery<Medico> query= entityManager.createNamedQuery("Medico.findValidar", Medico.class);
		listaMedico=query.getResultList();
		sesion.setAttribute("listaMedico", listaMedico);
		return "admin/altasMedicos";
	}
	//Detalle de la peticion de un medico
	@RequestMapping(value="detalleAltaMedico/{id}", method=RequestMethod.GET)
	public String detalleAltaMedicoAction(@PathVariable Long id, HttpSession sesion) {
		Medico medico;
		medico= entityManager.find(Medico.class, id);
		sesion.setAttribute("detalleMedico", medico);
		return "admin/detalleAltaMedico";
	}
	/*-----PETICIONES DE UN FARMACEUTICO------*/
	//Lista de peticiones de farmaceuticos
	@RequestMapping("altasFarmaceuticos")
	public String altasFarmaceuticosAction(HttpSession sesion) {
		List<Farmaceutico> listaFarmaceutico;
		TypedQuery<Farmaceutico> query= entityManager.createNamedQuery("Farmaceutico.findValidar", Farmaceutico.class);
		listaFarmaceutico=query.getResultList();
		sesion.setAttribute("listaFarmaceutico", listaFarmaceutico);
		return "admin/altasFarmaceuticos";
	}
	//Detalle de la peticion de un farmaceutico
	@RequestMapping(value="detalleAltaFarmaceutico/{id}", method=RequestMethod.GET )
	public String detalleAltaFarmaciaAction(@PathVariable Long id,HttpSession sesion) {
		Farmaceutico farmaceutico= entityManager.find(Farmaceutico.class, id);
		sesion.setAttribute("detalleFarmaceutico", farmaceutico);
		return "admin/detalleAltaFarmaceutico";
	}
	
	/*-----ALTAS DE FARMACIAS-------*/
	//Listado de farmacias con peticion
	@RequestMapping("altasFarmacias")
	public String altaFarmaciasAction(HttpSession sesion) {
		List<Farmacia> listaFarmacia;
		TypedQuery<Farmacia> query= entityManager.createNamedQuery("Farmacia.findValidar", Farmacia.class).setParameter("estado", 0);
		listaFarmacia=query.getResultList();
		log.warn("contador de farmacias: "+listaFarmacia.size());
		sesion.setAttribute("listaFarmacia", listaFarmacia);
		return "admin/altasFarmacias";
	}
	//Detalle de la peticion de una farmacia
	@RequestMapping(value="detalleAltaFarmacia/{id}", method=RequestMethod.GET)
	public String detalleAltaFarmaceuticoAction(@PathVariable Long id, HttpSession sesion) {
		Farmacia farmacia;
		farmacia=entityManager.find(Farmacia.class,id);
		sesion.setAttribute("detalleFarmacia", farmacia);
		return "admin/detalleAltaFarmacia";
	}
	/*------ACEPTAR Y DENEGAR PETICIONES DE ACCESO-------*/
	//aceptar peticiones
	@Transactional
	@RequestMapping(value="aceptarPeticion/{tipo}/{id}", method=RequestMethod.GET)
	public String aceptarPeticionAction(@PathVariable("tipo") String tipo,@PathVariable("id") Long id, HttpSession sesion) {
		log.warn("Tipo "+tipo+" con id "+id);		
		switch(tipo)
		{
		case "FARMA":
			Farmacia farmacia= entityManager.find(Farmacia.class, id);
			farmacia.setEstado(1);
			entityManager.persist(farmacia);
			return "redirect:/admin/altasFarmacias";
		case "MED":
			Medico medico= entityManager.find(Medico.class, id);
			medico.setEstado(1);
			entityManager.persist(medico);
			return "redirect:/admin/altasMedicos";
		case "FAR":
			Farmaceutico farmaceutico= entityManager.find(Farmaceutico.class, id);
			farmaceutico.setEstado(1);
			entityManager.persist(farmaceutico);
			return "redirect:/admin/altasFarmaceuticos";
		default:
			return "redirect:/admin/admin";		
		}
	}
	//Denegar peticiones
	@Transactional
	@RequestMapping(value="denegarPeticion/{tipo}/{id}", method=RequestMethod.GET)
	public String denegarPeticionAction(@PathVariable("tipo") String tipo,
			@PathVariable("id") long id, HttpSession sesion) {
		log.info("piden denegar con id " + id);
		switch(tipo)
		{
		case "FARMA":
			entityManager.remove(entityManager.find(Farmacia.class, id));
			return "redirect:/admin/altasFarmacias";
		case "MED":
			//Medico medico=entityManager.find(Medico.class, id);
			entityManager.remove(entityManager.find(Medico.class, id));
			return "redirect:/admin/altasMedicos";
		case "FAR":
			entityManager.remove(entityManager.find(Farmaceutico.class, id));
			return "redirect:/admin/altasFarmaceuticos";
		default:
			return "redirect:/admin/admin";		
		}
	}
	
	/*-----------MEDICAMENTOS----------*/
	//Mostrar el listado de medicamentos
	@RequestMapping("gestionMedicamentos")
	public String gestionMedicamentosAction(HttpSession sesion) {
		List<Medicamento> listaMed;
		TypedQuery<Medicamento> query= entityManager.createNamedQuery("Medicamento.findAll", Medicamento.class);
		listaMed=query.getResultList();
		log.info("tamaño salida:" + listaMed.size());
		sesion.setAttribute("listaMed", listaMed);
		return "admin/gestionMedicamentos";
	}
	//Importar los medicamntos de la BBDD
	@Transactional
	@RequestMapping("insMedicamentos")
	public String insertarMedicamentos() throws IOException {
		InputStream dataStream = getClass().getResourceAsStream(
				"/static/json/medicamentos.json");
		MedicamentosParser.carga(new String(IOUtils.toByteArray(dataStream)),
				entityManager);
		return "redirect:/admin/gestionMedicamentos";
	}
	//Ventana Añadir un nuevo medicamento
	@RequestMapping("nuevoMedicamento")
	public String nuevoMedicamentoAction(Model model) {
		model.addAttribute("validar", new ValidarMedicamento());
		return "admin/nuevoMedicamento";
	}
	//Añadir un nuevo medicamento
	@Transactional
	@RequestMapping(value="nuevoMedicamentoSubmit", method = RequestMethod.POST)
	public String nuevoMedicamentoSubmitAction(@ModelAttribute("validar") @Valid ValidarMedicamento validar, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			return "admin/nuevoMedicamento";
		} else {
			entityManager.persist(validar.getMedicamento());
			return "redirect:/admin/gestionMedicamentos";
		}
	}
	//Ventana modificar un medicamento
	@Transactional
	@RequestMapping(value="modificarMedicamento/{id}", method=RequestMethod.GET)
	public String modificarMedicamentoAction(@PathVariable Long id,HttpSession sesion,Model model)
	{
		Medicamento medicamento=entityManager.find(Medicamento.class, id);
		sesion.setAttribute("modMedicamento", medicamento);
		model.addAttribute("validar", new ValidarMedicamento());
		return "admin/modificarMedicamento";
	}
	//Modificar un medicamento
	@Transactional
	@RequestMapping(value="modificarMedicamentoSubmit", method = RequestMethod.POST)
	public String modificarMedicamentoSubmitAction(@ModelAttribute("validar") @Valid ValidarMedicamento validar, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			log.warn("Temenos errores");
			return "admin/modificarMedicamento";
		} else {
			Medicamento med= entityManager.find(Medicamento.class, validar.getId());
			Medicamento modMed=validar.getMedicamentoMod();
			med.setEstado(modMed.isEstado());
			med.setNombre(modMed.getNombre());
			med.setDescripcion(modMed.getDescripcion());
			med.setLaboratorio(modMed.getLaboratorio());
			med.setPrecio(modMed.getPrecio());
			entityManager.persist(med);
			return "redirect:/admin/gestionMedicamentos";
		}
	}
	//Eliminar un medicamento
	@Transactional
	@RequestMapping(value="descatalogarMedicamento/{id}", method=RequestMethod.GET)
	public String descatalogarMedicamentoAction(@PathVariable Long id)
	{
		Medicamento medicamento=entityManager.find(Medicamento.class, id);
		medicamento.setEstado(false);
		entityManager.persist(medicamento);
		return "redirect:/admin/gestionMedicamentos";
	}
	
	/*-----Control estado------*/
	private boolean estadoValido()
	{
		Usuario usuario;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		usuario=entityManager.createNamedQuery("Usuario.findByUsuario", Usuario.class).setParameter("usuario", auth.getName()).getSingleResult();
		if(usuario.getEstado()!=1)
			return false;
		else
			return true;
	}
}
