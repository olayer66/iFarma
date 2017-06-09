package es.ucm.fdi.iw.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.ucm.fdi.iw.model.ExistenciaMedicamento;
import es.ucm.fdi.iw.model.ExistenciaPedido;
import es.ucm.fdi.iw.model.Farmaceutico;
import es.ucm.fdi.iw.model.Farmacia;
import es.ucm.fdi.iw.model.Medicamento;
import es.ucm.fdi.iw.model.Paciente;
import es.ucm.fdi.iw.model.Pedidos;
import es.ucm.fdi.iw.model.Tratamiento;
import es.ucm.fdi.iw.validation.StockForm;
import es.ucm.fdi.iw.validation.TratamientoForm;


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
	
	@Transactional
	@RequestMapping("farmaceutico")
	public String farmaceuticoAction(HttpSession sesion, Model model,HttpServletRequest request,@ModelAttribute("form") @Valid es.ucm.fdi.iw.validation.FarmaciaForm form, BindingResult bindingResult) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Farmaceutico farmaceutico = entityManager.createQuery(
        		"FROM Farmaceutico WHERE usuario = :usuario", Farmaceutico.class)
                            .setParameter("usuario", username)
                            .getSingleResult();
		
		
		List<Farmacia> listaFar = farmaceutico.getFarmaciasActivas();

		log.info("tamaño salida:" + listaFar.size());
		model.addAttribute("listaFar", listaFar);
		model.addAttribute("comunidades", getComunidades());
		model.addAttribute("provincias", getProvincias());
		
		if (request.getMethod().equals("GET") || !bindingResult.hasErrors()) {
			model.addAttribute("form", new Farmacia());
		}
		
		//solicitar farmacia
		if (request.getMethod().equals("POST")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("error", true);
			} else {
				Farmacia farmacia = new Farmacia();

				farmacia.setNombre(form.getNombre());
				farmacia.setTelefono(form.getTelefono());
				farmacia.setDireccion(form.getDireccion());
				farmacia.setCodPostal(form.getCodPostal());
				farmacia.setCiudad(form.getCiudad());
				farmacia.setProvincia(form.getProvincia());
				farmacia.setComAutonoma(form.getComAutonoma());
				farmacia.setEstado(0);//pendiente de validacion estado=0
				farmacia.setDuenio(farmaceutico);
				
				entityManager.persist(farmacia);
				

			}
		}
		

		return "farmacia/farmaceutico";
	}


	
	@Transactional
	@RequestMapping("stock") 
	public String stockAction(@RequestParam long id, HttpSession sesion,HttpServletRequest request, Model model,@ModelAttribute("form") @Valid StockForm form, BindingResult bindingResult) {
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
			
			if (request.getMethod().equals("GET") || !bindingResult.hasErrors()) {
				model.addAttribute("form", new StockForm());
			}

			if (request.getMethod().equals("POST")) {
				if (bindingResult.hasErrors()) {
					model.addAttribute("error", true);
				} else {//Da error por la relacion ONE TO ONE con medicamento. Hay que cambiar esa relacion
					ExistenciaMedicamento existenciaStock = new ExistenciaMedicamento();

					existenciaStock.setMedicamento(entityManager.find(Medicamento.class, Long.parseLong(form.getMedicamento())));
					existenciaStock.setCantidad(form.getCantidad());	
					existenciaStock.setFechaCaducidad(form.getFechaFormateada());
					existenciaStock.setFarmacia(farmacia);
					
					int indexExiste=farmacia.contieneMedicamento(existenciaStock);
					//si existe actualiza la cantidad
					if(indexExiste!=-1){
						existenciaStock.setCantidad(existenciaStock.getCantidad()+miStock.get(indexExiste).getCantidad());
						miStock.remove(indexExiste);
					}
				
					
					entityManager.persist(existenciaStock);
					miStock.add(existenciaStock);
					farmacia.setStock(miStock);
					entityManager.persist(farmacia);
					

				}
			}
			
			
			model.addAttribute("miStock", miStock);
			model.addAttribute("medicamentos", entityManager.createQuery("FROM Medicamento").getResultList());



		}
		
		return "farmacia/stock";
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
	//Devuelve la comunidades autonomas
	private List<String> getComunidades()
	{
		String [] comu={"Andalucia", "Aragon", "Canarias", "Cantabria", "Castilla y Leon", "Castilla-La Mancha", "Catalunya", "Ceuta", "Comunidad Valenciana", "Comunidad de Madrid", "Extremadura", "Galicia", "Islas Baleares", "La Rioja", "Melilla", "Navarra", "Pais Vasco", "Principado de Asturias", "Region de Murcia"};
		return Arrays.asList(comu);
	}
	//Devuelve la provicias inicales a mostrar(Andalucia)
	private List<String> getProvincias()
	{
		String [] prov={"Almería", "Granada","Córdoba","Jaén","Sevilla","Málaga","Cádiz","Huelva"};
		return Arrays.asList(prov);
	}
	//para futuras versiones
	@RequestMapping("modificarFarmacia")
	public String modificarfarmaciaAction() {
		return "farmacia/modificarFarmacia";
	}
	@RequestMapping("modificarFarmaceutico")
	public String modificarfarmaceuticoAction() {
		return "farmacia/modificarFarmaceutico";
	}
	
	
}
