<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../jspf/header.jspf" %>


<%@ include file="../jspf/navbar.jspf" %>

<div class="container">
    <div class="row">
    <!--Inicio-->
        <div class="col-lg-12">
            <h1 class="page-header">Nuevo paciente</h1>
            <h1><small>Por favor compruebe los datos y rellene los que falten</small></h1>
        </div>
     </div>
     <s:url var="formUrl" value="/validarPacienteSubmit" />
     <sf:form modelAttribute="validar" action="${formUrl}">
     <sf:hidden path="id" value="${paciente.id}"/>
	 <fieldset>
     <div class="row">   
        <div class="col-lg-12">
            <!--Datos del usuario-->
          	<div class="col-md-4 portfolio-item">
              	<h3>Datos personales</h3>
               <div class="form-group">
                   <label for="nombre">Nombre:</label>
                   <sf:input path="nombre" value="${paciente.nombre}" class="form-control" id="nombre" readonly="true"/>
               </div>
               <div class="form-group">
                   <label for="apellidos">Apellidos:</label>
                   <sf:input path="apellidos" value="${paciente.nombre}" class="form-control" id="apellidos" readonly="true"/>
               </div>
               <div class="form-group">
                      <label for="email">Email:</label>
                      <sf:input path="email" value="${paciente.email}" class="form-control" id="email" readonly="true"/>
                 </div>
                  <div class="form-group">
                      <label for="Telefono">Telefono:</label>
                      <sf:input path="telefono" type="number" value="${paciente.telefono}" class="form-control" id="Telefono" readonly="true"/>
                 </div>   
          	</div>
          	<!-- Direccion -->
          	<div class="col-md-4 portfolio-item">
              	<h3>Datos personales</h3>
               <div class="form-group">
                   <label for="direccion">Direccion:</label>
                   <sf:input path="direccion" value="${paciente.direccion}" class="form-control" id="nombre" disabled="disabled"/>
                   <p><sf:errors path="direccion" cssClass="error"/></p>
               </div>
               <div class="form-group">
                   <label for="ciudad">Ciudad:</label>
                   <sf:input path="ciudad" value="${paciente.ciudad}" class="form-control" id="nombre" disabled="disabled"/>
               	<p><sf:errors path="ciudad" cssClass="error"/></p>
               </div>
               <div class="form-group">
                   <label for="codPostal">Codigo postal:</label>
                   <sf:input path="codPostal" type="number" value="${paciente.codPostal}" class="form-control" id="nombre" disabled="disabled"/>
               	<p><sf:errors path="codPostal" cssClass="error"/></p>
               </div>
               <div class="form-group">
                   <label for="comboComunidades">Comunidad autonoma:</label>
                   <sf:select path="comAutonoma"  class="form-control" id="comboComunidades"  items="${comunidades}"/>
               	<p><sf:errors path="comAutonoma" cssClass="error"/></p>
               </div>
               <div class="form-group">
                   <label for="comboProvincia">Provincia:</label>
                   <sf:select path="provincia"  class="form-control" id="comboProvincia" items="${provIncio}"/>
               	<p><sf:errors path="provincia" cssClass="error"/></p>
               </div>
          	</div>
           <!--contraseña-->
           <div class="col-md-4 portfolio-item">
               <h3>Datos del usuario</h3>
               <div class="form-group">
                   <label for="usuario">Usuario:</label>
                   <sf:input path="usuario" class="form-control" id="usuario"/>
              		<p><sf:errors path="usuario" cssClass="error"/></p>
               </div>
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
          	</div>
       </div>
   </div>
   <div class="row">
   	<div class="col-lg-12">
   		<div class="col-lg-6">
   			<h3>Farmacia de referencia</h3>
   			<div class="form-group">
                <label for="comboFarmacia">Seleccionar:</label>
                <sf:select path="farmacia"  class="form-control" id="comboFarmacia">
                	<c:forEach var="farmacia"  items="${listaFarmacias}">
                		<sf:option value="${farmacia.id}">${farmacia.nombre}</sf:option>
                	</c:forEach>
                </sf:select>
            </div>
   		</div>
           <div class="col-lg-6">
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
                      	<sf:input type="number" path="numTarjeta" class="form-control" id="numTarjeta"/>
                    	<p><sf:errors path="numTarjeta" cssClass="error"/></p>
                    </div>
                    <div class="form-group">
                       <label for="codSegTarjeta">CVC:</label>
                       <sf:input type="number" path="codSegTarjeta" class="form-control" id="codSegTarjeta"/>
                    	<p><sf:errors path="codSegTarjeta" cssClass="error"/></p>
                   </div>
                   <div class="form-group">
                   	<label for="fechaCadTarjeta">Fecha Caducidad:</label>	                    	
                   	<div class="input-group input-append date datePicker" id="datePickerPaciente">
                              <sf:input path="fechaCadTarjeta" class="form-control date-picker" id="fechaCadTarjeta"/>
                              <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                              <p><sf:errors path="fechaCadTarjeta" cssClass="error"/></p>
					</div>    	
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

<%@ include file="../jspf/footer.jspf"%>
