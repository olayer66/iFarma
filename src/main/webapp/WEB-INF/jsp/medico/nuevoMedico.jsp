<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf" %>


<%@ include file="../../jspf/navbar.jspf" %>

<div class="container">
	<!--Inicio-->
    <div class="row">
    	<div class="col-lg-12">
            <h1 class="page-header">Nuevo Medico</h1>
            <h1><small>Rellene el siguiente formulario.</small></h1>
        </div>
    </div>
     <!--Nueva farmacia-->
    <div class="row">
        <s:url var="formUrl" value="/medico/nuevo" />
   		<sf:form modelAttribute="nuevo" action="${formUrl}">
			<fieldset>
                   <!--Datos del medico-->
               <div class="col-md-6 portfolio-item">
                   <h3>Datos medico</h3>
                   <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <sf:input path="nombre" class="form-control" id="nombre"/>
                   </div>
                   <div class="form-group">
                        <label for="apellidos">Apellidos:</label>
                        <sf:input path="apellidos" class="form-control" id="apellidos"/>
                   </div>
                   <div class="form-group">
                        <label for="numColMedico">Numero colegiado:</label>
                        <sf:input path="numColMedico" class="form-control" id="numColMedico"/>
                   </div>
                   <div class="form-group">
                        <label for="centroTrabajo">centro Trabajo:</label>
                        <sf:input path="centroTrabajo" class="form-control" id="centroTrabajo"/>
                   </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <sf:input path="email" class="form-control" id="email"/>
                   </div>
                    <div class="form-group">
                        <label for="Telefono">Telefono:</label>
                        <sf:input path="telefono" class="form-control" id="Telefono"/>
                   </div>   
               </div>
                    <div class="col-md-6 portfolio-item">
                <h3>Usuario</h3>
                <div class="form-group">
                        <label for="usuario">Usuario:</label>
                        <sf:input path="usuario" class="form-control" id="usuario"/>
                   </div>
                <div class="form-group">
                    <label for="contrasenia">Contraseña:</label>
                    <sf:password path="contrasenia" class="form-control" id="contrasenia"/>
                </div>
                <div class="form-group">
                    <label for="contraseniaRep">Repetir:</label>
                    <sf:password path="contraseniaRep" class="form-control" id="contraseniaRep"/>
                </div>
            </div>
                <div class="col-md-12 portfolio-item">
                    <input type="submit" class="btn-lg btn-default center-block" value="Enviar">
                </div>
             </fieldset>
  		</sf:form>
	 </div>
</div>

<%@ include file="../../jspf/footer.jspf"%>
