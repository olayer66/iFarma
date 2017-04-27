<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarPaciente.jspf"%>


<div class="container">
    <div class="row">
        <div class="tab-content">
            <!--Inicio-->
            <div id="editarPaciente" class="tab-pane fade">
                <div class="col-lg-12">
                    <h1 class="page-header">Modicar datos del paciente</h1>
                </div>
                <s:url var="formUrl" value="/paciente/editar" />
                <sf:form modelAttribute="editar" action="${formUrl}">
	    	 		<fieldset>
                    <!--Datos del usuario-->
                    <div class="col-md-4 portfolio-item">
                        <h3>Modificar datos personales</h3>
	                    <div class="form-group">
							<label for="nombre">Nombre:</label> <sf:input path="text" class="form-control" id="nombre"/>
						</div>
						<div class="form-group">
							<label for="apellidos">Apellidos:</label> <sf:input path="text" class="form-control" id="apellidos"/>
						</div>
						<div class="form-group">
							<label for="email">Email:</label> <sf:input path="text" class="form-control" id="email"/>
						</div>
						<div class="form-group">
							<label for="telefono">Telefono:</label> <sf:input path="text" class="form-control" id="telefono"/>
						</div>	
						<div class="form-group">
							<label for="direccion">Direccion:</label> <sf:input path="text" class="form-control" id="direccion"/>
						</div>					
						<div class="form-group">
							<label for="ciudad">Codigo postal:</label> <sf:input path="text" class="form-control" id="ciudad"/>
						</div>
						<div class="form-group">
							<label for="codPostal">Ciudad:</label> <sf:input path="text" class="form-control" id="codPostal"/>
						</div>
						<div class="form-group">
							<label for="provincia">Provincia:</label> <sf:input path="text" class="form-control" id="provincia"/>
						</div>
						<div class="form-group">
							<label for="comAutonoma">Comunidad Autonoma:</label> <sf:input path="text" class="form-control" id="comAutonoma"/>
						</div>
                    </div>
                    <!--contraseña-->
                    <div class="col-md-4 portfolio-item">
                        <h3>Cambiar Contraseña</h3>
	                    <div class="form-group">
							<label for="usuario">Usuario:</label> <sf:input path="text" class="form-control" id="usuario"/>
						</div>
						<div class="form-group">
							<label for="contrasenia">Contraseña antigua:</label> <sf:input path="text" class="form-control" id="contrasenia"/>
						</div>					
						<div class="form-group">
							<label for="newcontrasenia">Contraseña nueva:</label> <sf:input path="text" class="form-control" id="newcontrasenia"/>
						</div>
						<div class="form-group">
							<label for="newcontraseniarep">Repetir nueva contraseña:</label> <sf:input path="text" class="form-control" id="newcontraseniarep"/>
						</div>
                    </div>
                    <!--forma de pago-->
                    <div class="col-md-4 portfolio-item">
                        <h3>Cambiar forma de pago</h3>
	                       <label class="radio-inline"><sf:checkbox path="formaPago" value="0" disabled="disabled"/>PayPal</label>
	                        <label class="radio-inline"><sf:checkbox path="formaPago" value="1"/>Tarjeta</label>
	                        <label class="radio-inline"><sf:checkbox path="formaPago" value="2"/>Contrareembolso</label>
	                        <div id="pagoPayPal">
	                            <h4>Pago mediante cuenta de PayPal</h4>
	                            <img class="img-responsive center-block" src="/static/img/credit/PayPal-Logo.jpg" alt="PayPal">
	                        </div>
	                        <div id="pagoTarjeta">
	                             <div class="form-group">
	                                <label for="numTarjeta">Numero tarjeta:</label>
	                               <sf:input path="password" class="form-control" id="numTarjeta"/>
	                            </div>
	                             <div class="form-group">
	                                <label for="codSegTarjeta">CVC:</label>
	                                <sf:input path="text" class="form-control" id="codSegTarjeta"/>
	                            </div>
	                            <div class="form-group">
	                                <label for="fechaCadTarjeta">Fecha Cad::</label>
	                                <sf:input path="date" class="form-control" id="fechaCadTarjeta"/>
	                            </div>
	                        </div>
	                        <div id="pagoEfectivo">
	                            <h4>Los pedidos se pagaran al momento de recibirlos</h4>
	                        </div>
                    </div>
                    <!--modificar-->
                    <div class="col-md-12">
                        <input type="submit" class="btn-lg btn-default center-block"
						value="Modificar Datos">
                    </div>
                    </fieldset>
	         </sf:form>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../jspf/footer.jspf"%>
