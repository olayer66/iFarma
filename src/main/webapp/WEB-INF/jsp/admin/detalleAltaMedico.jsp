<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>

<div class="container">
    <div class="row">
        <div class="tab-content">
            <!--Inicio-->
            <div id="index" class="tab-pane fade in active">
                <div class="col-lg-12">
                    <h1 class="page-header">Detalle alta medico</h1>
					<div class="col-lg-4">
	                    <div class="panel panel-default">
	                    	<h3>Datos farmaceutico</h3>
							<div class="panel-body">
								<h4>Nombre: Francisca</h4>
								<h4>Apellidos: Sanchez Perez</h4>
								<h4>Nº Colegiado: 45524554747</h4>
								<h4>Direccion: c/falsa 123</h4>
								<h4>Telefono: 916853225</h4>
								<h4>Localidad: Algete</h4>
								<h4>Provincia: Madrid</h4>
								<h4>Cod.Postal: 28852</h4>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="panel panel-default">
	                    	<h3>Notas</h3>
							<div class="panel-body">
								<textarea class="form-control" rows="5" id="comment"></textarea>
							</div>
						</div>
	                    <div class="panel panel-default">
	                    	<h3>Respuesta</h3>
							<div class="panel-body">
								<div class="btn btn-success">Aceptar</div>
								<div class="btn btn-primary">Posponer</div>
								<div class="btn btn-danger">Denegar</div>
							</div>
						</div>
					</div>
                </div>
                </div>
            </div>
       	</div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>