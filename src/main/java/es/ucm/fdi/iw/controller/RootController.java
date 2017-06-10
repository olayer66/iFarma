package es.ucm.fdi.iw.controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import es.ucm.fdi.iw.customValidation.ValidarContrasenia;
import es.ucm.fdi.iw.customValidation.ValidarContraseniaFarma;
import es.ucm.fdi.iw.customValidation.ValidarContraseniaMedico;
import es.ucm.fdi.iw.model.ExistenciaMedicamento;
import es.ucm.fdi.iw.model.ExistenciaPedido;
import es.ucm.fdi.iw.model.Farmaceutico;
import es.ucm.fdi.iw.model.Farmacia;
import es.ucm.fdi.iw.model.Medicamento;
import es.ucm.fdi.iw.model.Medico;
import es.ucm.fdi.iw.model.Paciente;
import es.ucm.fdi.iw.model.Pedidos;
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

		/*---PRUEBAS----*/
		@Transactional
		@RequestMapping("mm")//PARA PRUEBAS. NO BORRAR.
		public @ResponseBody String mm() throws IOException{
			Farmacia f= entityManager.find(Farmacia.class, (long)2);
			Paciente pac= entityManager.find(Paciente.class, (long)5);
			Medicamento m= entityManager.find(Medicamento.class, (long)7024491);
			Medicamento m2= entityManager.find(Medicamento.class, (long)9676384);
			Medicamento m3= entityManager.find(Medicamento.class, (long)7098249);
			//EXISTENCIAS PEDIDO //NO PUEDE HABER DOS EXISTENCIAS CON EL MISMO MEDICAMENTO EN EL MISMO PEDIDO, PERO SI EN DISTINTOS
			ExistenciaPedido ex = new ExistenciaPedido() ;
			ex.setCantidad(5);
			ex.setMedicamento(m);
			ex.setFechaCaducidad(new Date(5, 12, 2017));
			
			ExistenciaPedido ex2 = new ExistenciaPedido() ;
			ex2.setCantidad(5);
			ex2.setMedicamento(m2);
			ex2.setFechaCaducidad(new Date(5, 12, 2017));
			
			ExistenciaPedido ex3 = new ExistenciaPedido() ;
			ex3.setCantidad(5);
			ex3.setMedicamento(m3);
			ex3.setFechaCaducidad(new Date(5, 12, 2017));
			
			ExistenciaPedido ex4 = new ExistenciaPedido() ;
			ex4.setCantidad(15);
			ex4.setMedicamento(m2);
			ex4.setFechaCaducidad(new Date(5, 12, 2017));
			
			ExistenciaPedido ex5 = new ExistenciaPedido() ;
			ex5.setCantidad(2);
			ex5.setMedicamento(m3);
			ex5.setFechaCaducidad(new Date(5, 12, 2017));
			
			entityManager.persist(ex);
			entityManager.persist(ex2);
			entityManager.persist(ex3);
			entityManager.persist(ex4);
			entityManager.persist(ex5);

			
			ExistenciaMedicamento exm = new ExistenciaMedicamento() ;
			exm.setCantidad(10);
			exm.setMedicamento(m);
			exm.setFechaCaducidad(new Date(5, 12, 2017));
			exm.setFarmacia(f);
			
			ExistenciaMedicamento exm2 = new ExistenciaMedicamento() ;
			exm2.setCantidad(10);
			exm2.setMedicamento(m2);
			exm2.setFechaCaducidad(new Date(5, 12, 2017));
			exm2.setFarmacia(f);
			
			ExistenciaMedicamento exm3 = new ExistenciaMedicamento() ;
			exm3.setCantidad(10);
			exm3.setMedicamento(m3);
			exm3.setFarmacia(f);
			exm3.setFechaCaducidad(new Date(5, 12, 2017));
			entityManager.persist(exm);
			entityManager.persist(exm2);
			entityManager.persist(exm3);
			
			
			
			
			

			List<ExistenciaPedido> listaExis = new ArrayList<ExistenciaPedido>();
			List<ExistenciaPedido> listaExis2 = new ArrayList<ExistenciaPedido>();
			listaExis.add(ex);
			listaExis.add(ex2);
			listaExis.add(ex3);
			listaExis2.add(ex4);
			listaExis2.add(ex5);
			
			Pedidos p = new Pedidos();
			p.setEstadoPedido(0);
			p.setExistenciasPedido(listaExis);
			p.setFarmacia(f);
			p.setFechaPedido(new Date(5, 12, 2017));
			p.setPaciente(pac);
			
			Pedidos p2 = new Pedidos();
			p2.setEstadoPedido(0);
			p2.setExistenciasPedido(listaExis2);
			p2.setFarmacia(f);
			p2.setFechaPedido(new Date(9, 12, 2017));
			p2.setPaciente(pac);
			
			entityManager.persist(p);
			entityManager.persist(p2);
			
			ex.setPedido(p);
			ex2.setPedido(p);
			ex3.setPedido(p);
			ex4.setPedido(p2);
			ex5.setPedido(p2);
			
			entityManager.persist(ex);
			entityManager.persist(ex2);
			entityManager.persist(ex3);
			entityManager.persist(ex4);
			entityManager.persist(ex5);
			
		
				
			
			
			return "redirect:/index";
			
		}	

}
