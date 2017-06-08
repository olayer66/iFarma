<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../../jspf/header.jspf" %>


<%@ include file="../../jspf/navbarMedico.jspf"%>

<div class="container">
	<h2>Listado de Pacientes</h2>
	<hr>

	<div class="alert alert-success alert-dismissible${ codigoAut != null ? '' : ' hidden' }" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<strong>¡Paciente dado de alta correctamente!</strong> Código: ${codigoAut}
	</div>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Teléfono</th>
				<th>Email</th>
				<th>Ciudad</th>
				<th>Tratamientos</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${medico.pacientes}" var="paciente">
				<tr>
					<td>${paciente.nombre}</td>
					<td>${paciente.apellidos}</td>
					<td>${paciente.telefono}</td>
					<td>${paciente.email}</td>
					<td>${paciente.ciudad}</td>
					<td><span class="badge">${fn:length(paciente.tratamiento)}</span></td>
					<td>
						<a href="/medico/detalle-paciente/${paciente.id}" class="btn btn-sm btn-success">Ver Paciente</a>
						<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../../jspf/footer.jspf" %>
