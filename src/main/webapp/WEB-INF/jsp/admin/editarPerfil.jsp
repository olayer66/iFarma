
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>
<div class="container">
	<div class="row">
		<div>    
            <h2 class="page-header">Modificar medicamento</h2>
        </div>      
        <s:url var="formUrl" value="/admin/editarPerfilSubmit" />
<sf:form modelAttribute="validar" action="${formUrl}">
<sf:hidden path="id" value="${perfil.id}"/>
            <div class="col-md-6 portfolio-item">
                <div class="form-group">
                    <label for="nombre">Nombre: </label>
                 <sf:input path="nombre" class="form-control" value="${perfil.nombre}" id="nombre"/>
                 <sf:errors path="nombre" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="apellidos">Apellidos: </label>
                    <sf:input path="apellidos" class="form-control" value="${perfil.apellidos}" id="apellidos"/>
                    <sf:errors path="apellidos" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="telefono">Telefono: </label>
                    <sf:input path="telefono" class="form-control" value="${perfil.telefono}" id="telefono"/>
                    <sf:errors path="telefono" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="email">Email: </label>
                    <sf:input path="email" class="form-control" value="${perfil.email}" id="email"/>
                    <sf:errors path="email" cssClass="error"/>
                </div>
                <div class="form-group text-center">
                 	<input type="submit" value="Modificar" class="btn btn-default">
                </div>
            </div>
        </sf:form>     
	</div>
</div>

<%@ include file="../../jspf/footer.jspf" %>
</html>