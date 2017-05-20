package es.ucm.fdi.iw.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ucm.fdi.iw.model.Farmacia;
import es.ucm.fdi.iw.model.Medicamento;
import es.ucm.fdi.iw.validation.Farmaceutico;

@Controller
@RequestMapping("/farmacia")
public class FarmaciaController {

	private static final Logger log = Logger.getLogger(FarmaciaController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("")
	public String pantallaLoginAction() {
		return "farmacia/farmaceutico";
	}
	
	@RequestMapping("farmaceutico")
	public String farmaceuticoAction(HttpSession sesion) {
		List<Farmacia> listaFar;
		TypedQuery<Farmacia> query= entityManager.createNamedQuery("Farmaceutico.misFarmacias", Farmacia.class);
		listaFar=query.getResultList();
		log.info("tamaño salida:" + listaFar.size());
		sesion.setAttribute("listaMed", listaFar);
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
