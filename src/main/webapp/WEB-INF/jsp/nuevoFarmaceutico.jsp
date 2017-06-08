<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../jspf/header.jspf" %>


<%@ include file="../jspf/navbar.jspf" %>

<div class="container">
	<!--Inicio-->
    <div class="row">
    	<div class="col-lg-12">
            <h1 class="page-header">Nuevo farmaceutico</h1>
            <h1><small>Rellene el siguiente formulario.</small></h1>
        </div>
    </div>
     <!--Nueva farmacia-->
    <div class="row">
        <s:url var="formUrl" value="/nuevoFarmaceuticoSubmit" />
   		<sf:form modelAttribute="nuevofarma" action="${formUrl}">
			<fieldset>
                   <!--Datos del medico-->
               <div class="col-md-6 portfolio-item">
                   <h3>Datos farmaceutico</h3>
                   <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <sf:input path="nombre" class="form-control" id="nombre"/>
                        <sf:errors path="nombre" cssClass="error"/>
                   </div>
                   <div class="form-group">
                        <label for="apellidos">Apellidos:</label>
                        <sf:input path="apellidos" class="form-control" id="apellidos"/>
                        <sf:errors path="apellidos" cssClass="error"/>
                   </div>
                   <div class="form-group">
                        <label for="numColFarmaceutico">Numero colegiado:</label>
                        <sf:input path="numColFarmaceutico" class="form-control" id="numColFarmaceutico"/>
                        <sf:errors path="numColFarmaceutico" cssClass="error"/>
                   </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <sf:input path="email" class="form-control" id="email"/>
                        <sf:errors path="email" cssClass="error"/>
                   </div>
                    <div class="form-group">
                        <label for="Telefono">Telefono:</label>
                        <sf:input type="number" path="telefono" class="form-control" id="Telefono"/>
                        <sf:errors path="telefono" cssClass="error"/>
                   </div>   
               </div>
                    <div class="col-md-6 portfolio-item">
                <h3>Usuario</h3>
                <div class="form-group">
                        <label for="usuario">Usuario:</label>
                        <sf:input path="usuario" class="form-control" id="usuario"/>
                        <sf:errors path="usuario" cssClass="error"/>
                   </div>
                <div class="form-group">
                    <label for="contrasenia">Contraseña:</label>
                    <sf:password path="contrasenia" class="form-control" id="contrasenia"/>
                    <sf:errors path="contrasenia" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="contraseniaRep">Repetir:</label>
                    <sf:password path="contraseniaRep" class="form-control" id="contraseniaRep"/>
                    <sf:errors path="contraseniaRep" cssClass="error"/>
                </div>
            </div>
                <div class="col-md-12 portfolio-item">
                    <input type="submit" class="btn-lg btn-default center-block" value="Enviar">
                </div>
             </fieldset>
  		</sf:form>
	</div>
</div>

<%@ include file="../jspf/footer.jspf"%>