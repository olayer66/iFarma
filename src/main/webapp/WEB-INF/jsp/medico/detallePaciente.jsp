<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../../jspf/header.jspf"%>


<%@ include file="../../jspf/navbarMedico.jspf"%>

<div class="container">
	<h2>Detalles del Paciente</h2>
	<hr>

	<div class="row">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-2">
					<img class="img-circle" src="http://placehold.it/150x150">
				</div>

				<div class="col-lg-10">
					<div class="panel panel-default">
						<div class="panel-body">
							<h4>Nombre: Placido</h4>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-body">
							<h4>Apellidos: Olego Da Silva</h4>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-4">
							<div class="panel panel-default">
								<div class="panel-body">
									<h4>Edad: 27</h4>
								</div>
							</div>
						</div>

						<div class="col-xs-4">
							<div class="panel panel-default">
								<div class="panel-body">
									<h4>Peso: 75</h4>
								</div>
							</div>
						</div>

						<div class="col-xs-4">
							<div class="panel panel-default">
								<div class="panel-body">
									<h4>Altura: 1,75</h4>
								</div>
							</div>
						</div>
					</div>

					<h3>Tratamientos</h3>
					<hr>
					
					<div class="row">
						<div class="col-lg-2">
							<button class="btn btn-primary btn-block" data-toggle="modal" data-target="#nuevoTratamiento">
				                Nuevo
				            </button>
						</div>
						
						<div class="col-lg-10">
							<table class="table table-hover table-striped">
			                    <tbody>
			                        <tr>
			                            <td class="mailbox-name"><a href="#">Placido Olego Da Silva</a></td>
			                            <td class="mailbox-subject"><b>Toma olvidada</b> - El paciente olvidó la toma...</td>
			                            <td class="mailbox-attachment"></td>
			                            <td class="mailbox-date">5 mins ago</td>
			                        </tr>
			                        <tr>
			                            <td class="mailbox-name"><a href="#">Juan Pedro Torrado Muñoz</a></td>
			                            <td class="mailbox-subject"><b>Consulta</b> - Consulta sobre como proceder con la toma...</td>
			                            <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
			                            <td class="mailbox-date">28 mins ago</td>
			                        </tr>
								</tbody>
			            	</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="nuevoTratamiento" class="modal fade" role="dialog">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Nuevo tratamiento</h4>
            </div>

            <div class="modal-body">
                <sf:form method="POST" modelAttribute="form" action="/medico/tratamiento/nuevo">
                	<sf:input path="paciente" type="hidden" value="${paciente.id}" />
                	
                    <div class="box-body">
                        <div class="form-group">
                            <sf:select  path="medicamento" class="form-control">
								<sf:option value="">Medicamento</sf:option>
								<sf:options items="${medicamentos}" itemValue="id"></sf:options>
							</sf:select>
                            <p><sf:errors path="medicamento" cssClass="error"/></p>
                        </div>
                        <div class="form-group">
                            <sf:input path="fechaFin" class="form-control" placeholder="Fecha fin tratamiento" value="" />
                            <p><sf:errors path="fechaFin" cssClass="error"/></p>
                        </div>
                        <div class="form-group">
                            <sf:input path="numDosis" class="form-control" placeholder="Número de dosis" />
                            <p><sf:errors path="numDosis" cssClass="error"/></p>
                        </div>
                        <div class="form-group">
                            <sf:input path="periodicidad" class="form-control" placeholder="Periodicidad" />
                            <p><sf:errors path="periodicidad" cssClass="error"/></p>
                        </div>
                        <div class="form-group">
                            <sf:textarea path="comentario" class="form-control" style="height: 150px" placeholder="Comentario"></sf:textarea>
                            <p><sf:errors path="comentario" cssClass="error"/></p>
                        </div>
                    </div>

                    <button type="submit" class="btn btn-success">Guardar tratamiento</button>
                </sf:form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../jspf/footer.jspf"%>
