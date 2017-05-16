package es.ucm.fdi.iw.controller;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * ATENCION!!!
 * No tocar este controller es para aplicacion movil 
 * Fdo: Jose Luis 
 */
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.ucm.fdi.iw.controller.resp.RespLogin;
import es.ucm.fdi.iw.validation.Login;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	private static final Logger log = Logger.getLogger(AdminController.class);

	@PersistenceContext
	private EntityManager entityManager;

	@RequestMapping(value="login", method = RequestMethod.POST)
	@ResponseBody RespLogin LoginAction(@RequestBody @Valid Login datos, BindingResult bindingResult) {
		
		RespLogin respuesta= new RespLogin();
		String role;
		if(bindingResult.hasErrors())
		{
			respuesta.setAcceso(false);
			respuesta.setRole("");
		}
		else
		{
			role=datos.hasRole();
			if(!role.equals(""))
			{
				respuesta.setAcceso(true);
				respuesta.setRole(role);
			}
			else
			{
				respuesta.setAcceso(false);
				respuesta.setRole("");
			}
				
		}	
		return respuesta;
	}
}
