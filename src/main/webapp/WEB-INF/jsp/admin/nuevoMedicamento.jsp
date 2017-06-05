<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>

<div class="container">
    <div class="row">
         <!--FEEDBACK-->
    
                <div id="nuevoMedicamento">
                    <div>    
                    <h2 class="page-header">Nuevo medicamento</h2>
                    </div>
                    
                    <s:url var="formUrl" value="/admin/nuevoMedicamentoSubmit" />
     				<sf:form modelAttribute="validar" action="${formUrl}">
                        <div class="col-md-4 portfolio-item">
                            <div class="form-group">
                                <label for="nombre">Nombre del medicamento: </label>
	                            <sf:input path="nombre" class="form-control" id="nombre"/>
	                            <sf:errors path="nombre" cssClass="error"/>
                            </div>
                            <div class="form-group">
                                <label for="descripcion">Descripcion: </label>
                                <sf:input path="descripcion" class="form-control" id="descripcion"/>
                                <sf:errors path="descripcion" cssClass="error"/>
                            </div>
                            <div class="form-group">
                                <label for="laboratorio">Laboratorio: </label>
                                <sf:input path="laboratorio" class="form-control" id="laboratorio"/>
                                <sf:errors path="laboratorio" cssClass="error"/>
                            </div>
                            <div class="form-group">
                                <label for="precio">Precio: </label>
                                <div class="hide-inputbtns">
                                	<sf:input path="precio" type="number" value="1" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class=" form-control currency"  id="precio"/>
                                	<sf:errors path="precio" cssClass="error"/>
                            	</div>
                            </div>
                            <div class="form-group">
                             	<input type="submit" value="Añadir" class="btn btn-default">
                            </div>
                        </div>
                    </sf:form>     
                </div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>