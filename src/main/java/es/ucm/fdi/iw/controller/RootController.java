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
import es.ucm.fdi.iw.validation.Codigo;
import es.ucm.fdi.iw.validation.Farmaceutico;
import es.ucm.fdi.iw.validation.Medico;
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
			model.addAttribute("nuevo", new Medico());
			return "nuevoMedico";
		}
		@RequestMapping(value = "/nuevoMedicoSubmit", method = RequestMethod.POST)
		public String login(@ModelAttribute("nuevo") @Valid Medico nuevo, BindingResult bindingResult, Model model,
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
		@RequestMapping("mm")
		public @ResponseBody String addFarmaceutico() throws IOException {
		
			MedicamentosParser.carga(
					new File("/home/hlocal/sts/proyectos/IFarma/src/main/resources/static/json/medicamentos.json"),
					entityManager);
			//dos farmaceuticos
			es.ucm.fdi.iw.model.Farmaceutico f = new es.ucm.fdi.iw.model.Farmaceutico(); 
			
			f.setApellidos("hernandez");
			f.setContrasenia(new BCryptPasswordEncoder().encode("1234"));
			f.setEmail("hoeli@gmail.com");
			f.setEstado(1);
			f.setNombre("antoniio");
			f.setNumColFarmaceutico("5523155");
			f.setRole("FAR");
			f.setTelefono("64266666");
			f.setUsuario("farma1");
			//f.setFarmaciasPropias();
			entityManager.persist(f);

			
			es.ucm.fdi.iw.model.Farmaceutico f1 = new es.ucm.fdi.iw.model.Farmaceutico(); 
			
			f1.setApellidos("hernandez");
			f1.setContrasenia(new BCryptPasswordEncoder().encode("1234"));
			f1.setEmail("holi@gmail.com");
			f1.setEstado(1);
			f1.setNombre("antunez");
			f1.setNumColFarmaceutico("554455");
			f1.setRole("FAR");
			f1.setTelefono("696666666");
			f1.setUsuario("farma2");
			//f.setFarmaciasPropias();
			entityManager.persist(f1);

			
			es.ucm.fdi.iw.model.Usuario f2 = new es.ucm.fdi.iw.model.Usuario();
			//un admin
			f2.setUsuario("admin");
			f2.setContrasenia(new BCryptPasswordEncoder().encode("1234"));
			f2.setRole("ADMIN");	
			f2.setEstado(1);
			f2.setEmail("ddd@dd.com");
			f2.setApellidos("doming");
			f2.setNombre("holi");
			f2.setTelefono("33222222");
			entityManager.persist(f2);
			//farmacia1
			es.ucm.fdi.iw.model.Farmacia f3 = new es.ucm.fdi.iw.model.Farmacia(); 
			f3.setCiudad("mAdr");
			f3.setCodPostal("555");
			f3.setComAutonoma("madrid");
			f3.setDireccion("going to hell n3");
			f3.setDuenio(f1);
			f3.setNombre("farmacias number 1 pepito");
			f3.setProvincia("madrid");
			f3.setTelefono("6666");
			f3.setEstado(1);
			entityManager.persist(f3);
			//farmacia2
			es.ucm.fdi.iw.model.Farmacia f4 = new es.ucm.fdi.iw.model.Farmacia(); 
			f4.setCiudad("mAdr");
			f4.setCodPostal("555");
			f4.setComAutonoma("madrid");
			f4.setDireccion("going to hell n3");
			f4.setDuenio(f1);
			f4.setNombre("farmacias number 2 pepito DOOOOSUIAE");
			f4.setProvincia("madrid");
			f4.setTelefono("6666");
			f4.setEstado(1);
			entityManager.persist(f4);
			
	//añadir faracias a farmaceutico2
			List<es.ucm.fdi.iw.model.Farmacia> l = new ArrayList<es.ucm.fdi.iw.model.Farmacia>();
			l.add(f3);
			l.add(f4);
			f1.setFarmaciasPropias(l);
			entityManager.persist(f1);
			
			//añadir stock a farmacia1 
			es.ucm.fdi.iw.model.ExistenciaMedicamento ex = new es.ucm.fdi.iw.model.ExistenciaMedicamento(); 
			es.ucm.fdi.iw.model.ExistenciaMedicamento ex2 = new es.ucm.fdi.iw.model.ExistenciaMedicamento(); 
			es.ucm.fdi.iw.model.ExistenciaMedicamento ex3 = new es.ucm.fdi.iw.model.ExistenciaMedicamento();
			
			List<Medicamento> ms = (List<Medicamento>)entityManager.createQuery("select m from Medicamento m").getResultList();
			log.info("Total medicamentos: " + ms.size());
			
			es.ucm.fdi.iw.model.Medicamento Md1 = entityManager.createQuery(
	        		"FROM Medicamento WHERE nombre = :nombre", Medicamento.class)
	                            .setParameter("nombre", "AAS")
	                            .getSingleResult();
			es.ucm.fdi.iw.model.Medicamento Md2 = entityManager.createQuery(
	        		"FROM Medicamento WHERE nombre = :nombre", Medicamento.class)
	                            .setParameter("nombre", "ACETENSIL")
	                            .getSingleResult();
			es.ucm.fdi.iw.model.Medicamento Md3 = entityManager.createQuery(
	        		"FROM Medicamento WHERE nombre = :nombre", Medicamento.class)
	                            .setParameter("nombre", "ACFOL")
	                            .getSingleResult();
			List<ExistenciaMedicamento> listaStock= new ArrayList<ExistenciaMedicamento>();
			ex.setCantidad(5);
			ex.setFechaCaducidad(new Date(10, 04, 2030));
			ex.setMedicamento(Md1);
			ex.setFarmacia(f3);
			
			entityManager.persist(ex);
			ex2.setFarmacia(f3);
			ex2.setCantidad(4);
			ex2.setFechaCaducidad(new Date(10, 04, 2021));
			ex2.setMedicamento(Md2);
			entityManager.persist(ex2);
			ex3.setFarmacia(f3);
			ex3.setCantidad(3);
			ex3.setFechaCaducidad(new Date(10, 04, 2019));
			ex3.setMedicamento(Md3);
			entityManager.persist(ex3);
			listaStock.add(ex);
			listaStock.add(ex2);
			listaStock.add(ex3);
			
			
			
			
			f3.setStock(listaStock);
			entityManager.persist(f3);

			
			return "/";
		}
		
		
}
