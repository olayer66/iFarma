package es.ucm.fdi.iw.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.ucm.fdi.iw.LocalData;
import es.ucm.fdi.iw.model.Farmaceutico;
import es.ucm.fdi.iw.model.Farmacia;
import es.ucm.fdi.iw.model.Usuario;


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
		return "farmacia/farmaceutico";
	}
	
	@RequestMapping("farmaceutico")
	public String farmaceuticoAction(HttpSession sesion) {
		
		Usuario u =(Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	

		Farmaceutico farmaceutico = (Farmaceutico)entityManager.find(Farmaceutico.class,2);//no estoy seguro de que id necesito
		List<Farmacia> listaFar = farmaceutico.getFarmaciasPropias();
		
		log.info("tamaño salida:" + listaFar.size());
		sesion.setAttribute("listaFar", listaFar);
		return "farmacia/farmaceutico";
	}
	
	@RequestMapping("modificarFarmaceutico")
	public String modificarfarmaceuticoAction() {
		return "farmacia/modificarFarmaceutico";
	}
	
	@GetMapping({"farmacia", "pedidos"})
	public String pedidosAction() {
		return "farmacia/pedidos";
	}
	
	@RequestMapping("stock")
	public String stockAction() {
		return "farmacia/stock";
	}
	@RequestMapping("pedido")
	public String pedidoAction() {
		return "farmacia/pedido";
	}
	@RequestMapping("modificarFarmacia")
	public String modificarfarmaciaAction() {
		return "farmacia/modificarFarmacia";
	}
	
}
