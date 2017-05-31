<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>

<div class="container">
    <div class="row">
        <div class="tab-content">
            <!--Inicio-->
            <div id="index" class="tab-pane fade in active">
                <div class="col-lg-12">
                    <h1 class="page-header">Detalle alta farmacia</h1>
                    <div class="col-lg-6">
	                    <div class="panel panel-default">
	                    	<h2>Datos farmacia</h2>
							<div class="panel-body">
								<h4><strong>Nombre:</strong> ${detalleFarmacia.nombre}</h4>
								<h4><strong>Direccion:</strong> ${detalleFarmacia.direccion}</h4>
								<h4><strong>Telefono:</strong> ${detalleFarmacia.telefono}</h4>
								<h4><strong>Localidad:</strong> ${detalleFarmacia.ciudad}</h4>
								<h4><strong>Provincia:</strong> ${detalleFarmacia.provincia}</h4>
								<h4><strong>Comunidad autonoma:</strong> ${detalleFarmacia.comAutonoma}</h4>
								<h4><strong>Codigo Postal:</strong> ${detalleFarmacia.codPostal}</h4>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
	                    <div class="panel panel-default">
	                    	<h2>Datos farmaceutico</h2>
							<div class="panel-body">
								<h4><strong>Nombre:</strong> ${detalleFarmacia.duenio.nombre}</h4>
								<h4><strong>Apellidos:</strong> ${detalleFarmacia.duenio.apellidos}</h4>
								<h4><strong>Nº Colegiado:</strong> ${detalleFarmacia.duenio.numColFarmaceutico}</h4>
								<h4><strong>Email:</strong> ${detalleFarmacia.duenio.email}</h4>
								<h4><strong>Telefono:</strong> ${detalleFarmacia.duenio.telefono}</h4>
							</div>
						</div>
						<div class="panel-body">
							<a href="/admin/aceptarPeticion/farma/${detalleFarmacia.id}"><div class="btn btn-success">Aceptar</div></a>
							<a href="/admin/denegarPeticion/farma/${detalleFarmacia.id}"><div class="btn btn-danger">Denegar</div></a>
						</div>
					</div>
                </div>
            </div>
       	</div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>