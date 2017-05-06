package es.ucm.fdi.iw.controller;

import java.security.Principal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
public class RootController {
	
	private static final Logger log = Logger.getLogger(RootController.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping({"","/", "/index"})
	String root() {
		return "index";
	}
	
	private static boolean hasAuthority(Principal principal, String role) {
		SimpleGrantedAuthority a = new SimpleGrantedAuthority("ROLE_" + role);
		return ((User)principal).getAuthorities().contains(a);
	}
	
	@RequestMapping("/login")
	String login(HttpSession sesion, Principal principal) {
		
		/*if(hasAuthority(principal, "administrador"))
		{
			log.info("logeado como adminsitrador");
			return "redirect:/admin";
		}
		else if(hasAuthority(principal, "paciente"))
		{
			log.info("logeado como paciente");
			return "redirect:/paciente";
		}
		else if(hasAuthority(principal, "medico"))
		{
			log.info("logeado como medico");
			return "redirect:/medico";
		}
		else if(hasAuthority(principal, "farmacia"))
		{
			log.info("logeado como farmacia");
			return "redirect:/farmacia";
		}
		else
		{
			log.error("Role no reconocido");
			return "redirect:/index";
		}*/
		return "/login";
	}

	@GetMapping("/logout")
	String login(HttpSession sesion) {
		sesion.invalidate();
		log.info("Sesion finalizada");
		return "redirect:/index";
	}

}
