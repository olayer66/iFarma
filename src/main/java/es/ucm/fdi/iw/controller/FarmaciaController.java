package es.ucm.fdi.iw.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.ucm.fdi.iw.LocalData;
import es.ucm.fdi.iw.model.ExistenciaMedicamento;
import es.ucm.fdi.iw.model.Farmaceutico;
import es.ucm.fdi.iw.model.Farmacia;
import es.ucm.fdi.iw.model.Medicamento;
import es.ucm.fdi.iw.model.Pedidos;
import es.ucm.fdi.iw.model.Usuario;
import es.ucm.fdi.parser.MedicamentosParser;


@Controller
@RequestMapping("/farmacia")
public class FarmaciaController {

	private static final Logger log = Logger.getLogger(FarmaciaController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private LocalData localData;
	
	@GetMapping("")
	public String pantallaLoginAction() {
		return "redirect:/farmacia/farmaceutico";
	}
	
	@RequestMapping("farmaceutico")
	public String farmaceuticoAction(HttpSession sesion, Model model) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Farmaceutico farmaceutico = entityManager.createQuery(
        		"FROM Farmaceutico WHERE usuario = :usuario", Farmaceutico.class)
                            .setParameter("usuario", username)
                            .getSingleResult();
		
		//no estoy seguro de que id necesito
		List<Farmacia> listaFar = farmaceutico.getFarmaciasPropias();

		log.info("tamaño salida:" + listaFar.size());
		model.addAttribute("listaFar", listaFar);

		return "farmacia/farmaceutico";
	}
	@RequestMapping("modificarFarmaceutico")
	public String modificarfarmaceuticoAction() {
		return "farmacia/modificarFarmaceutico";
	}
	
	@GetMapping({"farmacia", "pedidos"})
	public String pedidosAction( HttpSession sesion,@RequestParam long id,Model model) {
		model.addAttribute("idFarmacia", id);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Farmaceutico farmaceutico = entityManager.createQuery(
        		"FROM Farmaceutico WHERE usuario = :usuario", Farmaceutico.class)
                            .setParameter("usuario", username)
                            .getSingleResult();
		
		Farmacia f = entityManager.find(Farmacia.class, id);
				
		if (f == null || f.getDuenio()!=farmaceutico){
			log.info("Acceso denegado");
		}else{
			List<Pedidos> listaped = f.getListaPedidos();

			log.info("tamaño salida:" + listaped.size());
			model.addAttribute("listaPed", listaped);
			
		}
		
			
		return "farmacia/pedidos";
	}
	
	@RequestMapping("stock") //lo voy a probar primero con medicamentos, luego con inventarios
	public String stockAction(@RequestParam long id, HttpSession sesion, Model model) {
		model.addAttribute("idFarmacia", id);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Farmaceutico farmaceutico = entityManager.createQuery(
        		"FROM Farmaceutico WHERE usuario = :usuario", Farmaceutico.class)
                            .setParameter("usuario", username)
                            .getSingleResult();
		

		Farmacia farmacia = entityManager.find(Farmacia.class, id);
		if (farmacia == null || farmacia.getDuenio()!=farmaceutico){
			log.info("Acceso denegado");
		}else{
			List<ExistenciaMedicamento> miStock= farmacia.getStock();
			log.info("tamaño salida mistock:" + miStock.size());
			model.addAttribute("miStock", miStock);

		}
		
		return "farmacia/stock";
	}
	@RequestMapping("pedido")
	public String pedidoAction(HttpSession sesion) {
		return "farmacia/pedido";
	}
	@RequestMapping("modificarFarmacia")
	public String modificarfarmaciaAction() {
		return "farmacia/modificarFarmacia";
	}
	
}
