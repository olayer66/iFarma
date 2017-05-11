package es.ucm.fdi.iw.controller;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ucm.fdi.iw.validation.Farmaceutico;
import es.ucm.fdi.iw.validation.Medico;
import es.ucm.fdi.iw.validation.ValidarPaciente;
import es.ucm.fdi.parser.parserMedicamentos;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger log = Logger.getLogger(AdminController.class);

	@Autowired
	private EntityManager entityManager;

	@GetMapping("")
	String pantallaLoginAction() {
		return "admin/admin";
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
	//validacion del paciente
	@RequestMapping("validarPaciente")
	String validarPacienteAction(Model model) {
		model.addAttribute("validar", new ValidarPaciente());
		return "paciente/validarPaciente";
	}
	@RequestMapping(value = "/validarPacienteSubmit", method = RequestMethod.POST)
	String login(@ModelAttribute("validar") @Valid ValidarPaciente validar, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			log.error("Paso por aqui");
			return "paciente/validarPaciente";
		} else {
			log.info("Paciente validado");
			return "redirect:/index";
		}
	}
	
	//crear un nuevo medico
	@RequestMapping("nuevoMedico")
	String nuevoMedicoAction(Model model) {
		model.addAttribute("nuevo", new Medico());
		return "medico/nuevoMedico";
	}
	@RequestMapping(value = "/nuevoMedicoSubmit", method = RequestMethod.POST)
	String login(@ModelAttribute("nuevo") @Valid Medico nuevo, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			log.error("Paso por aqui");
			return "medico/nuevoMedico";
		} else {
			log.info("Paciente validado");
			return "redirect:/index";
		}
	}
	
	//nuevo farmaceutico
	@RequestMapping("nuevoFarmaceutico")
	String nuevoFarmaceuticoAction(Model model) {
		model.addAttribute("nuevo", new Farmaceutico());
		return "farmacia/nuevoFarmaceutico";
	}
	@RequestMapping(value = "/nuevoFarmacueticosubmit", method = RequestMethod.POST)
	String login(@ModelAttribute("nuevo") @Valid Farmaceutico nuevo, BindingResult bindingResult, Model model,
			HttpSession sesion) {
		if (bindingResult.hasErrors()) {
			log.error("Paso por aqui");
			return "farmacia/nuevoFermaceutico";
		} else {
			log.info("Paciente validado");
			return "redirect:/index";
		}
	}
	
	
	@RequestMapping("insMedicmaentos")
	String insertarMedicamentos() {
		new parserMedicamentos("/static/json/medicamentos.json",entityManager);
		return "admin/nuevoMedicamento";
	}
}
