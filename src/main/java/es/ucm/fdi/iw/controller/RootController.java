package es.ucm.fdi.iw.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.security.Principal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
import es.ucm.fdi.iw.model.Farmacia;
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
		
			//farmaceutico1
			ArrayList<SimpleGrantedAuthority> roles = new ArrayList<>();
        	roles.add(new SimpleGrantedAuthority("ROLE_" + "FAR"));
			es.ucm.fdi.iw.model.Farmaceutico f = new es.ucm.fdi.iw.model.Farmaceutico("farma1",new BCryptPasswordEncoder().encode("1234"),roles); 
			
			f.setApellidos("hernandez");
			f.setEmail("hoeli@gmail.com");
			f.setEstado(1);
			f.setRole("FAR");
			f.setNombre("antoniio");
			f.setNumColFarmaceutico("5523155");
			f.setTelefono("64266666");
			//f.setFarmaciasPropias();
			entityManager.persist(f);

			
			ArrayList<SimpleGrantedAuthority> roles2 = new ArrayList<>();
        	roles.add(new SimpleGrantedAuthority("ROLE_" + "FAR"));
			es.ucm.fdi.iw.model.Farmaceutico f1 = new es.ucm.fdi.iw.model.Farmaceutico("farma2",new BCryptPasswordEncoder().encode("1234"),roles2); 
			
			f1.setApellidos("hernandez");
			f1.setContrasenia(new BCryptPasswordEncoder().encode("1234"));
			f1.setEmail("holi@gmail.com");
			f1.setEstado(1);
			f1.setRole("FAR");
			f1.setNombre("antunez");
			f1.setNumColFarmaceutico("554455");
			f1.setTelefono("696666666");
			f1.setUsuario("farma2");
			//f.setFarmaciasPropias();
			entityManager.persist(f1);

			
			
			
			ArrayList<SimpleGrantedAuthority> roles3 = new ArrayList<>();
        	roles.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));
			es.ucm.fdi.iw.model.Usuario f2 = new es.ucm.fdi.iw.model.Usuario("admin",new BCryptPasswordEncoder().encode("1234"),roles3);
			//un admin
			f2.setEstado(1);
			f2.setEmail("ddd@dd.com");
			f2.setApellidos("doming");
			f2.setNombre("holi");
			f2.setTelefono("33222222");
			f2.setRole("ADMIN");
			entityManager.persist(f2);
			
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

			List<es.ucm.fdi.iw.model.Farmacia> l = new ArrayList<es.ucm.fdi.iw.model.Farmacia>();
			l.add(f3);
			l.add(f4);
			f1.setFarmaciasPropias(l);
			entityManager.persist(f1);

			
			return "/";
		}
		
		
}