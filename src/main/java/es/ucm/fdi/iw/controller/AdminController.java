package es.ucm.fdi.iw.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ucm.fdi.iw.login.Login;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger log = Logger.getLogger(AdminController.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	
	@GetMapping("")
	String pantallaLoginAction(Model model) {
		model.addAttribute("login", new Login());
		return "admin/loginAdmin";
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
	@RequestMapping(value="/login", method = RequestMethod.POST)
	String login(@ModelAttribute("login")Login login,Model model, HttpSession sesion)
	{
		if(login.login("admin"))
		{
			sesion.setAttribute("usuario", login.getUsuario());
			log.info("El administrador "+login.getUsuario() +" se ha logeado");
			return "admin/admin";		
		}
		else
		{
			log.error("Error en el login");
			return "redirect:/index";
		}
	}
	@GetMapping("/logout")
	String login(HttpSession sesion)
	{
		sesion.invalidate();
		log.info("Sesion finalizada");
		return "redirect:/index";
	}
	
}
