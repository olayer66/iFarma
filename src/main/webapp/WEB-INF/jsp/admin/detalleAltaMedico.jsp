<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>

<div class="container">
    <div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Detalle alta medico</h1>
            <div class="panel panel-default">
				<div class="panel-body">
					<h2>Datos Personales</h2>
					<h4><strong>Nombre:</strong> ${detalleMedico.nombre}</h4>
					<h4><strong>Apellidos:</strong> ${detalleMedico.apellidos}</h4>
					<h4><strong>Telefono:</strong> ${detalleMedico.telefono}</h4>
					<h4><strong>Email:</strong> ${detalleMedico.email}</h4>
					<h4><strong>Nº Colegiado:</strong> ${detalleMedico.numColMedico}</h4>
					<h4><strong>Centro de trabajo:</strong> ${detalleMedico.centroTrabajo}</h4>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12  col-lg-offset-5">
			<div class="panel-body">
				<a href="/admin/aceptarPeticion/MED/${detalleMedico.id}" class="btn btn-success">Aceptar</a>
				<a href="/admin/denegarPeticion/MED/${detalleMedico.id}" class="btn btn-danger">Denegar</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>