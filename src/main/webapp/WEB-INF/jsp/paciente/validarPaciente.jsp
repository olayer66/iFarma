<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf" %>


<%@ include file="../../jspf/navbar.jspf" %>

<div class="container">
    <div class="row">
    <!--Inicio-->
        <div class="col-lg-12">
            <h1 class="page-header">Nuevo paciente</h1>
            <h1><small>Por favor compruebe los datos y rellene los que falten</small></h1>
        </div>
        <s:url var="formUrl" value="/paciente/validar" />
        <sf:form modelAttribute="validar" action="${formUrl}">
			<fieldset>
            <!--Datos del usuario-->
            	<div class="col-md-4 portfolio-item">
                	<h3>Datos personales</h3>
	                <div class="form-group">
	                    <label for="nombre">Nombre:</label>
	                    <sf:input path="text" value="" class="form-control" id="nombre"/>
	                </div>
	                <div class="form-group">
	                    <label for="apellidos">Apellidos:</label>
	                    <sf:input path=" value="" class="form-control" id="apellidos"/>
	                </div>
            	</div>
	            <!--contraseña-->
	            <div class="col-md-4 portfolio-item">
	                <h3>Contraseña</h3>
	                <div class="form-group">
	                    <label for="contrasenia">Contraseña:</label>
	                    <sf:password path="password" class="form-control" id="contrasenia"/>
	                </div>
	                <div class="form-group">
	                    <label for="contraseniaRep">Repetir:</label>
	                    <sf:password path="password" class="form-control" id="contraseniaRep"/>
	                </div>
	            </div>
	            <!--forma de pago-->
	            <div class="col-md-4 portfolio-item">
	                <h3>Forma de pago</h3>
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
	                        	<sf:input path="text" class="form-control" id="numTarjeta"/>
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
	            <!--enviar-->
	            <div class="col-md-12">
	                <input type="submit" class="btn-lg btn-default center-block" value="Enviar">
	            </div>
	        </fieldset>
	  </sf:form>
    </div>
</div>

<%@ include file="../../jspf/footer.jspf"%>
