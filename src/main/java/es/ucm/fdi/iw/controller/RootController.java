package es.ucm.fdi.iw.controller;

import java.security.Principal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ucm.fdi.iw.validation.Codigo;
import es.ucm.fdi.iw.validation.Farmaceutico;
import es.ucm.fdi.iw.validation.Medico;
import es.ucm.fdi.iw.validation.ValidarPaciente;

@Controller	
public class RootController {
	
	private static final Logger log = Logger.getLogger(RootController.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@RequestMapping({"","/", "/index"})
	String root(Model model) {
		model.addAttribute("control", new Codigo());
		return "index";
	}
	@RequestMapping("/login")
	String login(HttpSession sesion, Principal principal) {
		return "/login";
	}

	@RequestMapping("/logout")
	String login(HttpSession sesion) {
		sesion.invalidate();
		log.info("Sesion finalizada");
		return "redirect:/index";
	}
	@RequestMapping("/volverdenegado")
	String denegadovolver(HttpSession sesion) {
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
	String accesoDenegado(HttpSession sesion) {
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
	String validarCodigo(@ModelAttribute("control") @Valid Codigo codigo, BindingResult bindingResult,Model model) {
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
		String validarPacienteAction(Model model) {
			model.addAttribute("validar", new ValidarPaciente());
			return "validarPaciente";
		}
		@RequestMapping(value = "/validarPacienteSubmit", method = RequestMethod.POST)
		String login(@ModelAttribute("validar") @Valid ValidarPaciente validar, BindingResult bindingResult, Model model,
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
		String nuevoMedicoAction(Model model) {
			model.addAttribute("nuevo", new Medico());
			return "nuevoMedico";
		}
		@RequestMapping(value = "/nuevoMedicoSubmit", method = RequestMethod.POST)
		String login(@ModelAttribute("nuevo") @Valid Medico nuevo, BindingResult bindingResult, Model model,
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
		String nuevoFarmaceuticoAction(Model model) {
			model.addAttribute("nuevo", new Farmaceutico());
			return "nuevoFarmaceutico";
		}
		@RequestMapping(value = "/nuevoFarmacueticosubmit", method = RequestMethod.POST)
		String login(@ModelAttribute("nuevo") @Valid Farmaceutico nuevo, BindingResult bindingResult, Model model,
				HttpSession sesion) {
			if (bindingResult.hasErrors()) {
				log.error("Paso por aqui");
				return "nuevoFermaceutico";
			} else {
				log.info("Paciente validado");
				return "redirect:/index";
			}
		}
		
		
}
