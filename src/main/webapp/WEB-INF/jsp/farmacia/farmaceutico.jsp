<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../jspf/header.jspf"%>


<%@ include file="../../jspf/navbarFarmaceutico.jspf"%>

<div class="container">
	<div class="row">
		<div class="tab-content">
			<!-- ________________TABLE:FARMACIAS___________________________ -->
			<div id="pedidos" class="tab-pane in active">
				<div>
					<h2>Mis Farmacias</h2>
				</div>
				<div>
					<table id="tablaFarmacias" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Nombre de Farmacia</th>
								<th>Pedidos pendientes</th>
							</tr>
						</thead>
						<tbody>
							 <c:forEach var="farmacia" items="${listaFar}">
							   <tr>
									<td><a href=/farmacia/stock?id=${farmacia.id}>${farmacia.nombre}</a></td>
									<td><strong class="alerta">7</strong></td>
		                        </tr>	
							</c:forEach>
						</tbody>
					</table>
					</div>
					<!-- fin tabla farmacias -->
					<!-- form nueva farmacia -->
					<div>
						<h2>Añadir nueva Farmacia:</h2>
						<ul class="nav nav-pills">
							<li><a data-toggle="pill" href="#añadirFarmacia">Añadir
									nueva farmacia</a></li>
						</ul>

						<div class="tab-content">
							<div id="añadirFarmacia" class="tab-pane fade">
								<div>
									<div class="col-lg-12">
										<h3 class="page-header">Nueva Farmacia:</h3>
										<h3>
											<small>Rellene el siguiente formulario.</small>
										</h3>
									</div>
									<form>
										<!--Datos del usuario-->
										<div class="col-md-6 portfolio-item">
											<div class="form-group">
												<label for="nombreFarmacia">Nombre de la Farmacia:</label> <input
													type="text" class="form-control" id="nombreFarmacia">
											</div>
											<div class="form-group">
												<label for="telefonoFarmacia">Telefono</label> <input
													type="text" class="form-control" id="telefonoFarmacia">
											</div>
											<div class="form-group">
												<label for="direccionFarmacia">Direccion:</label> <input
													type="text" class="form-control" id="direccionFarmacia">
											</div>
											<div class="form-group">
												<label for="codigopostalFarmacia">Codigo postal:</label> <input
													type="text" class="form-control" id="codigopostalFarmacia">
											</div>
											<div class="form-group">
												<label for="ciudadFarmacia">Ciudad:</label> <input
													type="text" class="form-control" id="ciudadFarmacia">
											</div>
											<div class="form-group">
												<label for="provinciaFarmacia">Provincia:</label> <input
													type="text" class="form-control" id="provinciaFarmacia">
											</div>
										</div>
										<div class="col-md-12 portfolio-item">
											<input type="submit" class="btn-lg btn-default center-block"
												value="Añadir">
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- tab -->
		</div>
	</div>











<hr>

	<%@ include file="../../jspf/footer.jspf"%>