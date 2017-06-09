<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
									<td><strong class="alerta">${farmacia.countPedidosPendientes}</strong></td>
		                        </tr>	
							</c:forEach>
						</tbody>
					</table>
					</div>
					<!-- fin tabla farmacias -->
					<button class="btn btn-success" data-toggle="modal" data-target="#solicitarFarmacia">
									Solicitar nueva farmacia
					</button>
					<!-- form nueva farmacia -->
			 <div id="solicitarFarmacia" class="modal fade" role="dialog" data-modal-show-on-error="${error}">
						<div class="modal-dialog modal-md">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Solicitar farmacia</h4>
								</div>
					
								<div class="modal-body">
									<sf:form method="POST" modelAttribute="form">
										<div class="box-body">

											<div class="form-group">
												<sf:input path="nombre" class="form-control" placeholder="Nombre" />
												<p><sf:errors path="nombre" cssClass="error"/></p>
											</div>											
											<div class="form-group">
												<sf:input path="telefono" class="form-control" placeholder="Telefono" />
												<p><sf:errors path="telefono" cssClass="error"/></p>
											</div>	
											<div class="form-group">
												<sf:input path="direccion" class="form-control" placeholder="Direccion" />
												<p><sf:errors path="direccion" cssClass="error"/></p>
											</div>	
											<div class="form-group">
												<sf:input path="codPostal" class="form-control" placeholder="Codigo Postal" />
												<p><sf:errors path="codPostal" cssClass="error"/></p>
											</div>	
											<div class="form-group">
												<sf:input path="ciudad" class="form-control" placeholder="Ciudad" />
												<p><sf:errors path="ciudad" cssClass="error"/></p>
											</div>	
							                <div class="form-group" >
							                    <sf:select path="comAutonoma" placeholder="Comunidad Autonoma" class="form-control" id="comboComunidades"  items="${comunidades}"/>
							                	<p><sf:errors path="comAutonoma" cssClass="error"/></p>
							                </div>
							                <div class="form-group">
							                    <sf:select path="provincia" placeholder="Provincia" class="form-control" id="comboProvincia" items="${provincias}"/>
							                	<p><sf:errors path="provincia" cssClass="error"/></p>
							                </div>
							                
							                
										</div>

										<button type="submit" class="btn btn-success">Enviar Solicitud</button>
									</sf:form>
								</div>				
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								</div>
							</div>
						</div>
					</div>
        		<!-- Fin formulario nueva farmacia  -->
				</div>
				<!-- /.box-body -->
			</div>
			<!-- tab -->
		</div>
	</div>











<hr>

	<%@ include file="../../jspf/footer.jspf"%>