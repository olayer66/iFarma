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
     </div>
     <s:url var="formUrl" value="/paciente/validar" />
     <sf:form modelAttribute="validar" action="${formUrl}">
	 <fieldset>
     <div class="row">   
        <div class="col-lg-12">
            <!--Datos del usuario-->
            	<div class="col-md-4 portfolio-item">
                	<h3>Datos personales</h3>
	                <div class="form-group">
	                    <label for="nombre">Nombre:</label>
	                    <sf:input path="nombre" value="paco" class="form-control" id="nombre" readonly="true"/>
	                </div>
	                <div class="form-group">
	                    <label for="apellidos">Apellidos:</label>
	                    <sf:input path="apellidos" value="sanchez" class="form-control" id="apellidos" readonly="true"/>
	                </div>
	                <div class="form-group">
                        <label for="email">Email:</label>
                        <sf:input path="email" class="form-control" id="email" readonly="true"/>
                   </div>
                    <div class="form-group">
                        <label for="Telefono">Telefono:</label>
                        <sf:input path="telefono" class="form-control" id="Telefono" readonly="true"/>
                   </div>   
            	</div>
            	<!-- Direccion -->
            	<div class="col-md-4 portfolio-item">
                	<h3>Datos personales</h3>
	                <div class="form-group">
	                    <label for="direccion">Direccion:</label>
	                    <sf:input path="direccion" value="" class="form-control" id="nombre" disabled="disabled"/>
	                    <p><sf:errors path="direccion" cssClass="error"/></p>
	                </div>
	                <div class="form-group">
	                    <label for="ciudad">Ciudad:</label>
	                    <sf:input path="ciudad" value="" class="form-control" id="nombre" disabled="disabled"/>
	                	<p><sf:errors path="ciudad" cssClass="error"/></p>
	                </div>
	                <div class="form-group">
	                    <label for="codPostal">Codigo postal:</label>
	                    <sf:input path="codPostal" value="" class="form-control" id="nombre" disabled="disabled"/>
	                	<p><sf:errors path="codPostal" cssClass="error"/></p>
	                </div>
	                <div class="form-group">
	                    <label for="comAutonoma">Comunidad autonoma:</label>
	                    <sf:input path="comAutonoma" value="" class="form-control" id="nombre" disabled="disabled"/>
	                	<p><sf:errors path="comAutonoma" cssClass="error"/></p>
	                </div>
	                <div class="form-group">
	                    <label for="provincia">Provincia:</label>
	                    <sf:input path="provincia" value="" class="form-control" id="nombre" disabled="disabled"/>
	                	<p><sf:errors path="provincia" cssClass="error"/></p>
	                </div>
            	</div>
	            <!--contraseña-->
	            <div class="col-md-4 portfolio-item">
	                <h3>Contraseña</h3>
	                <div class="form-group">
	                    <label for="contrasenia">Contraseña:</label>
	                    <sf:password path="contrasenia" class="form-control" id="contrasenia"/>
	               		<p><sf:errors path="contrasenia" cssClass="error"/></p>
	                </div>
	                <div class="form-group">
	                    <label for="contraseniaRep">Repetir:</label>
	                    <sf:password path="contraseniaRep" class="form-control" id="contraseniaRep"/>
	                	<p><sf:errors path="contraseniaRep" cssClass="error"/></p>
	                </div>
	            <!--forma de pago-->
	                <h3>Forma de pago</h3>
	                <label class="radio-inline"><sf:radiobutton path="formaPago" value="0"/>PayPal</label>
	                <label class="radio-inline"><sf:radiobutton path="formaPago" value="1"/>Tarjeta</label>
	                <label class="radio-inline"><sf:radiobutton path="formaPago" value="2"/>Contrareembolso</label>
	                <div id="pagoPayPal">
	                    <h4>Pago mediante cuenta de PayPal</h4>
	                    <img class="img-responsive center-block" src="/static/img/credit/PayPal-Logo.jpg" alt="PayPal">
	                </div>
	                <div id="pagoTarjeta">
	                     <div class="form-group">
                        	<label for="numTarjeta">Numero tarjeta:</label>
                        	<sf:input path="numTarjeta" class="form-control" id="numTarjeta"/>
	                     	<p><sf:errors path="numTarjeta" cssClass="error"/></p>
	                     </div>
	                     <div class="form-group">
	                        <label for="codSegTarjeta">CVC:</label>
	                        <sf:input path="codSegTarjeta" class="form-control" id="codSegTarjeta"/>
	                     	<p><sf:errors path="codSegTarjeta" cssClass="error"/></p>
	                    </div>
	                    <div class="form-group">
	                        <label for="fechaCadTarjeta">Fecha Cad::</label>
	                        <sf:input path="fechaCadTarjeta" class="form-control" id="fechaCadTarjeta"/>
	                    	<p><sf:errors path="fechaCadTarjeta" cssClass="error"/></p>
	                    </div>
	                </div>
	                <div id="pagoEfectivo">
	                    <h4>Los pedidos se pagaran al momento de recibirlos</h4>
	                </div>
	            </div>
	        </div>
        </div>
        <div class="row">   
            <!--enviar-->
            <div class="col-md-12">
                <input type="submit" class="btn-lg btn-default center-block" value="Enviar">
            </div>
        </div>
	        </fieldset>
	  </sf:form>
</div>

<%@ include file="../../jspf/footer.jspf"%>
