<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../jspf/header.jspf" %>


<%@ include file="../jspf/navbar.jspf" %>

<div class="container">
    <div class="row">
         <div class="col-lg-12">
             <h1 class="page-header">Inicio
             </h1>
             <p><strong>iFarma</strong> es tu aplicación web para el control de su tratamiento farmacológico y su seguimiento por su médico de cabecera. Además, le permitirá realizar los pedidos de medicamentos de forma fácil y sencilla a su farmacia de confianza y que se los entreguen en su domicilio. </p>
           </div>
           <div class="col-md-4 portfolio-item">
				<img class="img-responsive" src="/static/img/banner-pac.jpg">
				<h3>Pacientes</h3>
               <p>
                   Si deseas registrarte como paciente deberas tener el codigo proporcionado por tu medico de cabecera y pulsar el siguiente boton.
               </p>
               <label>Codigo:</label>
               <input type="text" name="codigo" id="codNuevoPaciente">
               <a class="btn btn-default"  id="btnNuevoPaciente" href="/paciente/validarPaciente">Inscribirse</a>
           </div>
           <div class="col-md-4 portfolio-item">
               <img class="img-responsive" src="/static/img/banner-med.jpg">
               <h3>Medicos</h3>
               <p>
                   Si quieres registrarte como medico pulsa el siguiente boton.
               </p>
               <a class="btn btn-default" id="btnNuevoMedico" href="/medico/nuevoMedico">Inscribirse</a>
           </div>
           <div class="col-md-4 portfolio-item">
               <img class="img-responsive" src="/static/img/banner-far.jpg">
               <h3>Farmacias</h3>
               <p>
                   Bienvenido si eres farmaceutico y quieres unirte a nuestra red de suministradores pulsa en el siguiente boton.
               </p>
               <a class="btn btn-default" id="btnNuevaFarmacia" href="/farmacia/nuevoFarmaceutico">Inscribirse</a>
          </div>
    </div>      
</div>

<%@ include file="../jspf/footer.jspf" %>
