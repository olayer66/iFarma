<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>

<div class="container">
    <div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Detalle farmaceutico</h1>
            <div class="panel panel-default">
				<div class="panel-body">
					<h2>Datos Personales</h2>
					<h4><strong>Nombre:</strong> ${detalleFarmaceutico.nombre}</h4>
					<h4><strong>Apellidos:</strong> ${detalleFarmaceutico.apellidos}</h4>
					<h4><strong>Telefono:</strong> ${detalleFarmaceutico.telefono}</h4>
					<h4><strong>Email:</strong> ${detalleFarmaceutico.email}</h4>
					<h4><strong>Nº Colegiado:</strong> ${detalleFarmaceutico.numColFarmaceutico}</h4>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12  col-lg-offset-5">
			<div class="panel-body">
				<a href="/admin/aceptarPeticion/FAR/${detalleFarmaceutico.id}" class="btn btn-success">Aceptar</a>
				<a href="/admin/denegarPeticion/FAR/${detalleFarmaceutico.id}" class="btn btn-danger">Denegar</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>