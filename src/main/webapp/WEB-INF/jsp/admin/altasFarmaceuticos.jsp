<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
<h1 class="page-header">Altas de farmaceuticos</h1>
<table id="tablaAltaFarmaceuticos" class="table table-bordered table-striped">
	<thead>
		<tr>
		 <th>Nombre</th>
		 <th>Nº Colegiado</th>
		 <th>Telefono</th>   
		 <th>Detalles</th> 
		</tr>
	</thead>
	<tbody>
		<c:forEach var="farmaceutico" items="${listaFarmaceutico}">
			<tr>
			  <td>${farmaceutico.nombre} ${farmaceutico.apellidos}</td>
			  <td>${farmaceutico.numColFarmaceutico}</td>
			  <td>${farmaceutico.telefono}</td>
			  <td><a href="/admin/detalleAltaFarmaceutico/${farmaceutico.id}" class="btn btn-default">Ver detalle</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
		</div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>