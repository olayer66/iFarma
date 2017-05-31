package es.ucm.fdi.iw.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.ucm.fdi.iw.validation.Farmaceutico;
import es.ucm.fdi.iw.model.ExistenciaMedicamento;
import es.ucm.fdi.iw.model.Farmacia;
import es.ucm.fdi.iw.model.Medicamento;
import es.ucm.fdi.iw.model.Paciente;
import es.ucm.fdi.iw.model.Pedidos;
import es.ucm.fdi.iw.validation.Codigo;
import es.ucm.fdi.iw.validation.Farmaceutico;
import es.ucm.fdi.iw.validation.MedicoForm;
import es.ucm.fdi.iw.validation.ValidarPaciente;
import es.ucm.fdi.parser.MedicamentosParser;

@Controller	
public class RootController {
	
	private static final Logger log = Logger.getLogger(RootController.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@RequestMapping({"","/", "/index"})
	public String root(Model model, Principal principal) {
	//	log.info(principal.getName() + " de tipo " + principal.getClass());	
		model.addAttribute("control", new Codigo());
		return "index";
	}
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
	private String getRole(){
		String role;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        role=auth.getAuthorities().toString().split("_")[1];
        role=role.substring(0, role.length()-1);
        return role;
    }
	//Validar el codigo de acceso del paciente
	@RequestMapping(value = "/validarCodigo", method = RequestMethod.POST)
	public String validarCodigo(@ModelAttribute("control") @Valid Codigo codigo, BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			log.error("Paso por aqui");
			return "index";
		} else {
			log.info("Paciente validado");
			return "redirect:/index";
		}
	}
	
	//validacion del paciente
		@RequestMapping("validarPaciente")
		public 	String validarPacienteAction(Model model) {
			model.addAttribute("validar", new ValidarPaciente());
			return "validarPaciente";
		}
		@RequestMapping(value = "/validarPacienteSubmit", method = RequestMethod.POST)
		public 	String login(@ModelAttribute("validar") @Valid ValidarPaciente validar, BindingResult bindingResult, Model model,
				HttpSession sesion) {
			if (bindingResult.hasErrors()) {
				log.error("Paso por aqui");
				return "validarPaciente";
			} else {
				log.info("Paciente validado");
				return "redirect:/index";
			}
		}
		
		//crear un nuevo medico
		@RequestMapping("nuevoMedico")
		public 	String nuevoMedicoAction(Model model) {
			model.addAttribute("nuevo", new MedicoForm());
			return "nuevoMedico";
		}
		@RequestMapping(value = "/nuevoMedicoSubmit", method = RequestMethod.POST)
		public String login(@ModelAttribute("nuevo") @Valid MedicoForm nuevo, BindingResult bindingResult, Model model,
				HttpSession sesion) {
			if (bindingResult.hasErrors()) {
				log.error("Paso por aqui");
				return "nuevoMedico";
			} else {
				log.info("Paciente validado");
				return "redirect:/index";
			}
		}
		
		//nuevo farmaceutico
		@RequestMapping("/nuevoFarmaceutico")
		public String nuevoFarmaceuticoAction(Model model) {
			model.addAttribute("nuevo", new Farmaceutico());
			return "nuevoFarmaceutico";
		}
		@RequestMapping(value = "/nuevoFarmacueticosubmit", method = RequestMethod.POST)
		public 	String login(@ModelAttribute("nuevo") @Valid Farmaceutico nuevo, BindingResult bindingResult, Model model,
				HttpSession sesion) {
			if (bindingResult.hasErrors()) {
				log.error("Paso por aqui");
				return "nuevoFermaceutico";
			} else {
				log.info("Paciente validado");
				return "redirect:/index";
			}
		}	
		@Transactional
		@RequestMapping("mm")//PARA PRUEBAS. NO BORRAR.
		public @ResponseBody String mm() throws IOException{
			Farmacia f= entityManager.find(Farmacia.class, (long)2);
			Paciente pac= entityManager.find(Paciente.class, (long)2);
			Medicamento m= entityManager.find(Medicamento.class, (long)7024491);
			Medicamento m2= entityManager.find(Medicamento.class, (long)9676384);
			Medicamento m3= entityManager.find(Medicamento.class, (long)7098249);
			ExistenciaMedicamento ex = new ExistenciaMedicamento() ;
			ex.setCantidad(5);
			ex.setFarmacia(f);
			ex.setMedicamento(m);
			ex.setFechaCaducidad(new Date(5, 12, 2017));
			ExistenciaMedicamento ex2 = new ExistenciaMedicamento() ;
			ex2.setCantidad(5);
			ex2.setFarmacia(f);
			ex2.setMedicamento(m2);
			ex2.setFechaCaducidad(new Date(5, 12, 2017));
			ExistenciaMedicamento ex3 = new ExistenciaMedicamento() ;
			ex3.setCantidad(5);
			ex3.setFarmacia(f);
			ex3.setMedicamento(m3);
			ex3.setFechaCaducidad(new Date(5, 12, 2017));
			entityManager.persist(ex);
			entityManager.persist(ex2);
			entityManager.persist(ex3);

			List<ExistenciaMedicamento> listaExis = new ArrayList<ExistenciaMedicamento>();
			listaExis.add(ex);
			listaExis.add(ex2);
			listaExis.add(ex3);
			
			Pedidos p = new Pedidos();
			p.setEstadoPedido(0);
			p.setExistenciasPedido(listaExis);
			p.setFarmacia(f);
			p.setFechaPedido(new Date(5, 12, 2017));
			p.setPaciente(pac);
			
			Pedidos p2 = new Pedidos();
			listaExis.remove(0);
			p2.setEstadoPedido(0);
			p2.setExistenciasPedido(listaExis);
			p2.setFarmacia(f);
			p2.setFechaPedido(new Date(9, 12, 2017));
			p2.setPaciente(pac);
			
			entityManager.persist(p);
			entityManager.persist(p2);
			
			return "redirect:/index";
			
		}	
}
