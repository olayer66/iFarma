package es.ucm.fdi.iw.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import es.ucm.fdi.iw.customValidation.ValidarContrasenia;
import es.ucm.fdi.iw.customValidation.ValidarContraseniaFarma;
import es.ucm.fdi.iw.customValidation.ValidarContraseniaMedico;
import es.ucm.fdi.iw.model.Farmaceutico;
import es.ucm.fdi.iw.model.Farmacia;
import es.ucm.fdi.iw.model.Medico;
import es.ucm.fdi.iw.model.Paciente;
import es.ucm.fdi.iw.validation.Codigo;
import es.ucm.fdi.iw.validation.FarmaceuticoForm;
import es.ucm.fdi.iw.validation.MedicoForm;
import es.ucm.fdi.iw.validation.ValidarPaciente;


@Controller	
public class RootController {
	
	private static final Logger log = Logger.getLogger(RootController.class);
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	@Autowired
	private ValidarContrasenia valContra;
	@Autowired
	private ValidarContraseniaMedico valContraMedico;
	@Autowired
	private ValidarContraseniaFarma valContraFarma;
	 
	/*-----INDEX-----*/
	@RequestMapping({"","/", "/index"})
	public String root(Model model, Principal principal) {

		model.addAttribute("control", new Codigo());
		return "index";
	}
	/*---FOOTER---*/
	@RequestMapping("/avisoLegal")
	public String avisoAction()
	{
		return"avisoLegal";
	}
	@RequestMapping("/conocenos")
	public String conocenosAction()
	{
		return"conocenos";
	}
	/*----LOGIN Y LOGOUT-----*/
	@RequestMapping("/login")
	public String login(HttpSession sesion, Principal principal) {
		
		return "/login";
	}
	@RequestMapping("/logout")
	public String login(HttpSession sesion) {
		sesion.invalidate();
		log.info("Sesion finalizada");
		return "redirect:/index";
	}
	
	/*----FALLOS DE ACCESO----*/
	@RequestMapping("/estadoDenegado")
	public String estadoDenegado(HttpSession sesion) {
		sesion.invalidate();
		log.warn("Sesion finalizada por estado no valido");
		return "estadoDenegado";
	}
	@RequestMapping("/volverdenegado")
	public String denegadovolver(HttpSession sesion) {
		String role=getRole();
		String url=null;
		log.info("Role: " +role);
		if(role.equals("ADMIN")){
			url="redirect:/admin";
		}else if(role.equals("PAC")){
			url="redirect:/paciente";
		}else if(role.equals("MED")){
			url="redirect:/medico";
		}else if(role.equals("FAR")){
			url="redirect:/farmacia";
		}else{
			url="redirect:/index";
		}
		return url;
	}
	@RequestMapping("/denegado")
	public String accesoDenegado(HttpSession sesion) {
		sesion.invalidate();
		log.warn("Acceso no permitido");
		return "/denegado";
	}
	
	/*----VALIDAR PACIENTE----*/
	//Validar el codigo de acceso del paciente
	@RequestMapping(value = "/validarCodigo", method = RequestMethod.POST)
	public String validarCodigo(@ModelAttribute("control") @Valid Codigo codigo, BindingResult bindingResult,Model model, HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			log.warn("Codigo no Valido");
			return "index";
		} else {
			Paciente paciente;
			TypedQuery<Paciente> query= entityManager.createNamedQuery("Paciente.findByCodAut", Paciente.class).setParameter("codigo", codigo.getCodigo());		
			if(!query.getResultList().isEmpty()){
				paciente=query.getSingleResult();
				model.addAttribute("validar", new ValidarPaciente());
				sesion.setAttribute("paciente", paciente);
				sesion.setAttribute("listaFarmacias", getFarmacias());
				sesion.setAttribute("comunidades", getComunidades());
				sesion.setAttribute("provIncio", getProvincias());
				return"validarPaciente";
			}else{
				log.warn("Codigo no encontrado");
				bindingResult.rejectValue("codigo","messageCode","El codigo no se existe, compruebe que esta bien escrito o contacte con su medico");
				return "index";
			}
		}
	}
	//Validar el paciente
	@Transactional
	@RequestMapping(value = "/validarPacienteSubmit", method = RequestMethod.POST)
	public 	String validarPacienteSubmit(@ModelAttribute("validar") @Valid ValidarPaciente validar, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		valContra.validate(validar, bindingResult);
		if (bindingResult.hasErrors()) {
			log.warn("Errores en la validacion");
			return "validarPaciente";
		} else {
			Paciente paciente=entityManager.find(Paciente.class, validar.getId());
			Paciente modPac= validar.getPaciente();
			paciente.setDireccion(modPac.getDireccion());
			paciente.setCiudad(modPac.getCiudad());
			paciente.setCodPostal(modPac.getCodPostal());
			paciente.setComAutonona(modPac.getComAutonoma());
			paciente.setProvincia(modPac.getProvincia());
			paciente.setUsuario(modPac.getUsuario());
			paciente.setContrasenia(modPac.getContrasenia());
			paciente.setFormaPago(modPac.getFormaPago());
			paciente.setFarmacia(entityManager.find(Farmacia.class, validar.getFarmacia()));
			paciente.setEstado(1);
			if(modPac.getFormaPago()==1)
			{
				paciente.setCodSegTarjeta(modPac.getCodSegTarjeta());
				paciente.setNumTarjeta(modPac.getNumTarjeta());
				paciente.setFechaCadTarjeta(modPac.getFechaCadTarjeta());		
			}		
			entityManager.persist(paciente);
			return "redirect:/index";
		}
	}
	
	/*------NUEVO MEDICO------*/
	//crear un nuevo medico
	@RequestMapping("nuevoMedico")
	public 	String nuevoMedicoAction(Model model) {
		model.addAttribute("nuevo", new MedicoForm());
		return "nuevoMedico";
	}
	//Insertar nuevo medico
	@Transactional
	@RequestMapping(value = "/nuevoMedicoSubmit", method = RequestMethod.POST)
	public String nuevoMedicoSubmit(@ModelAttribute("nuevo") @Valid MedicoForm nuevo, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		valContraMedico.validate(nuevo, bindingResult);
		if (bindingResult.hasErrors()) {
			log.warn("Datos no validos en el form de entrada");
			return "nuevoMedico";
		} else {
			Medico medico=nuevo.getMedico();
			entityManager.persist(medico);
			return "redirect:/index";
		}
	}
	
	/*------NUEVO FARMACEUTICO-------*/
	//Crear nuevo farmaceutico
	@RequestMapping("/nuevoFarmaceutico")
	public String nuevoFarmaceuticoAction(Model model) {
		model.addAttribute("nuevofarma", new FarmaceuticoForm());
		return "nuevoFarmaceutico";
	}
	//Insertar nuevo farmaceutico
	@Transactional
	@RequestMapping(value = "/nuevoFarmaceuticoSubmit", method = RequestMethod.POST)
	public 	String nuevoFarmacueticoSubmit(@ModelAttribute("nuevofarma") @Valid FarmaceuticoForm nuevo, BindingResult bindingResult, Model model) {
		valContraFarma.validate(nuevo, bindingResult);
		if (bindingResult.hasErrors()) {
			log.warn("Datos no validos en el form de entrada");
			return "nuevoFarmaceutico";
		} else {
			Farmaceutico farmaceutico= nuevo.getFarmaceutico();
			entityManager.persist(farmaceutico);
			return "redirect:/index";
		}
	}
	
	/*----FUNCIONES----*/
	private String getRole(){
		String role;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        role=auth.getAuthorities().toString().split("_")[1];
        role=role.substring(0, role.length()-1);
        return role;
    }
	//Devuelve la comunidades autonomas
	private List<String> getComunidades()
	{
		String [] comu={"Andalucia", "Aragon", "Canarias", "Cantabria", "Castilla y Leon", "Castilla-La Mancha", "Catalunya", "Ceuta", "Comunidad Valenciana", "Comunidad de Madrid", "Extremadura", "Galicia", "Islas Baleares", "La Rioja", "Melilla", "Navarra", "Pais Vasco", "Principado de Asturias", "Region de Murcia"};
		return Arrays.asList(comu);
	}
	//Devuelve la provicias inicales a mostrar(Andalucia)
	private List<String> getProvincias()
	{
		String [] prov={"Almería", "Granada","Córdoba","Jaén","Sevilla","Málaga","Cádiz","Huelva"};
		return Arrays.asList(prov);
	}
	//Devuleve un listado con la farmacias refereciables por el paciente(estado=1)
	private List<Farmacia> getFarmacias()
	{
		TypedQuery<Farmacia> query= entityManager.createNamedQuery("Farmacia.findValidar", Farmacia.class).setParameter("estado", 1);
		return query.getResultList();
	}
	
	public ValidarContrasenia getValContra() {
		return valContra;
	}

	public void setValContra(ValidarContrasenia valContra) {
		this.valContra = valContra;
	}
<<<<<<< HEAD
=======



>>>>>>> 0f33a36fe736c04ccead8e60f92656f1adbb99cc
}
