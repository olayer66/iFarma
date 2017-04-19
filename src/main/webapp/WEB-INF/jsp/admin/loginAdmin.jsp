<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarLoginAdmin.jspf"%>

<div class="container">
    <div class="row">
    	<div class="col-lg-12">
             <h1 class="page-header">Iniciar sesion</h1>
             <h1><small>Por favor inicie sesion para acceder al sistema de administracion.</small></h1>
         </div>
         <s:url var="formUrl" value="/admin/login" />
         <div class="col-md-4 portfolio-item">
	    	 <sf:form modelAttribute="login" action="${formUrl}">
	    	 	<fieldset>      
	                 <div class="form-group">
	                     <label for="usuario">Usuario:</label>
	                     <sf:input path="usuario" />
	                 </div>
	                 <div class="form-group">
	                     <label for="contrasenia">Contraseña:</label>
	                     <sf:password path="contrasenia" />
	                 </div>
	                 <div class="form-group">
	                     <input type="submit" value="Inciar sesion" class="form-control">
	                 </div>
	         	</fieldset>
	         </sf:form>
         </div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>