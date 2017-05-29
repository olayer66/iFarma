<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../jspf/header.jspf"%>


<%@ include file="../../jspf/navbarMedico.jspf"%>

<div class="container">
	<h2>Detalles del Paciente</h2>
	<hr>

	<div class="row">
        <<s:url var="formUrl" value="/medico/nuevoPac" />
        		<sf:form modelAttribute="nuevoPac" action="${formUrl}">
				<fieldset>
                    <!--Datos del farmacia-->
                <div class="col-md-6 portfolio-item">
                    <h3>Datos paciente</h3>
                    <div class="form-group">
                         <label for="nombre">Nombre:</label>
                         <sf:input path="text" class="form-control" id="nombre"/>
                    </div>
                    <div class="form-group">
                         <label for="apellidos">Apellidos:</label>
                         <sf:input path="text" class="form-control" id="apellidos"/>
                    </div>
                     <div class="form-group">
                         <label for="email">Email:</label>
                         <sf:input path="text" class="form-control" id="email"/>
                    </div>
                     <div class="form-group">
                         <label for="Telefono">Telefono:</label>
                         <sf:input path="text" class="form-control" id="Telefono"/>
                    </div>   
                </div>
                <input type="submit" class="btn btn-default center-block" value="Enviar">
           </fieldset>
	  		</sf:form>
    </div>
</div>

<%@ include file="../../jspf/footer.jspf"%>
