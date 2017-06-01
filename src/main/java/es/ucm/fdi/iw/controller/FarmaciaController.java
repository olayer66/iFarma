package es.ucm.fdi.iw.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.ucm.fdi.iw.model.ExistenciaMedicamento;
import es.ucm.fdi.iw.model.ExistenciaPedido;
import es.ucm.fdi.iw.model.Farmaceutico;
import es.ucm.fdi.iw.model.Farmacia;
import es.ucm.fdi.iw.model.Paciente;
import es.ucm.fdi.iw.model.Pedidos;


@Controller
@RequestMapping("/farmacia")
public class FarmaciaController {

	private static final Logger log = Logger.getLogger(FarmaciaController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
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
		List<Farmacia> listaFar = farmaceutico.getFarmaciasActivas();
		
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
	public String pedidoAction(HttpSession sesion,@RequestParam long id,@RequestParam long idFarmacia, Model model) {
		model.addAttribute("idPedido", id);
		model.addAttribute("idFarmacia", idFarmacia);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Farmaceutico farmaceutico = entityManager.createQuery(
        		"FROM Farmaceutico WHERE usuario = :usuario", Farmaceutico.class)
                            .setParameter("usuario", username)
                            .getSingleResult();
		

		Pedidos p =entityManager.find(Pedidos.class, id);
		Farmacia f =entityManager.find(Farmacia.class, idFarmacia); 
		List<ExistenciaPedido> listEx = p.getExistenciasPedido();
		Paciente pac = p.getPaciente();
	
				
		if (f == null || f.getDuenio()!=farmaceutico||p.getFarmacia()!=f){
			log.info("Acceso denegado");
		}else{
			log.info("tamaño salida de Existencias:" +listEx.size());
			Date date= new Date();//fecha actual
			
			model.addAttribute("fecha",date.toString());
			model.addAttribute("total", p.getPrecioTotal());
			model.addAttribute("listEx", listEx);
			model.addAttribute("pedido", p);
			model.addAttribute("farmacia", f);
			model.addAttribute("paciente",pac);
			
		}
	
		return "farmacia/pedido";
	}
	@Transactional
	@RequestMapping("realizarPedido")
	public String pedidoAction(HttpSession sesion,@RequestParam long id, Model model) {
		
		model.addAttribute("idPedido", id);
		Pedidos p =entityManager.find(Pedidos.class, id);
		model.addAttribute("idFarmacia",p.getFarmacia().getId() );


		if(p.realizarPedido()){
			log.info("Pedido realizado con exito");
			entityManager.persist(p);
			entityManager.persist(p.getFarmacia());

		}else{
			log.info("imposible realizar el pedido");
		}

	
		return "redirect:/farmacia/pedidos?id="+p.getFarmacia().getId();
	}
	@RequestMapping("modificarFarmacia")
	public String modificarfarmaciaAction() {
		return "farmacia/modificarFarmacia";
	}
	
}
