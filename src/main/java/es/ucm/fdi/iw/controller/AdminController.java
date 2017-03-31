package es.ucm.fdi.iw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@GetMapping("")
	String listadoPacientesAction() {
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
	@GetMapping("/login/{u}/{c}")
	String login(@PathVariable String usuario,@PathVariable String contra, HttpSession s)
	{
		if(usuario.equals("admin") && contra.equals("1234"))
		{
			s.setAttribute("usuario", usuario);
			return "admin/admin";
		}
		else
		{
			return "redirect:index";
		}
	}
	@GetMapping("/logout")
	String login(HttpSession s)
	{
		s.invalidate();
		return "redirect:index";
	}
	
}
