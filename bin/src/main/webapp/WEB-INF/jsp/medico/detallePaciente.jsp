<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../../jspf/header.jspf"%>


<%@ include file="../../jspf/navbarMedico.jspf"%>

<div class="container">
	<h2>Detalles del Paciente</h2>
	<hr>

	<div class="row">
		<div class="col-lg-12">
			<div class="profile">
				<div class="row">
					<div class="col-lg-2">
						<div class="profile__avatar text-center">
							<i class="glyphicon glyphicon-user"></i>
						</div>
					</div>

					<div class="col-lg-10">
						<div class="panel panel-default profile__panel">
							<div class="panel-body">
								<h4>Nombre: ${paciente.nombre}</h4>
							</div>
						</div>
						<div class="panel panel-default profile__panel">
							<div class="panel-body">
								<h4>Apellidos: ${paciente.apellidos}</h4>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-6">
								<div class="panel panel-default profile__panel">
									<div class="panel-body">
										<h4>Teléfono: ${paciente.telefono}</h4>
									</div>
								</div>
							</div>

							<div class="col-xs-6">
								<div class="panel panel-default profile__panel">
									<div class="panel-body">
										<h4>Email: ${paciente.email}</h4>
									</div>
								</div>
							</div>

							<div class="col-xs-6">
								<div class="panel panel-default profile__panel">
									<div class="panel-body">
										<h4>Dirección: ${paciente.direccion}</h4>
									</div>
								</div>
							</div>

							<div class="col-xs-3">
								<div class="panel panel-default profile__panel">
									<div class="panel-body">
										<h4>CP: ${paciente.codPostal}</h4>
									</div>
								</div>
							</div>

							<div class="col-xs-3">
								<div class="panel panel-default profile__panel">
									<div class="panel-body">
										<h4>Ciudad: ${paciente.ciudad}</h4>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<h2>Tratamientos</h2>
					<hr>

					<div class="row">
						<div class="col-lg-2">
							<button class="btn btn-default btn-block" data-toggle="modal" data-target="#nuevoTratamiento">
								Nuevo
							</button>
							<br>

							<ul class="nav nav-pills nav-stacked">
								<li class="active">
									<a data-toggle="tab" href="#enCurso">
										En curso <span class="badge pull-right">${fn:length(paciente.tratamiento)}</span>
									</a>
								</li>
								<li>
									<a data-toggle="tab" href="#finalizados">
										Finalizados
									</a>
								</li>
							</ul>
						</div>

						<div class="col-lg-10">
							<div class="tab-content">
								<div id="enCurso" class="tab-pane fade in active">
									<c:forEach items="${paciente.tratamiento}" var="tratamiento">
										<div class="treatment">
											<div class="panel panel-default">
												<div class="panel-body">
													<div class="row">
														<div class="col-xs-8">
															<p><strong>${tratamiento.medicamento}</strong></p>
															<p><strong><i class="glyphicon glyphicon-calendar"></i> ${tratamiento.fechaInicio} - ${tratamiento.fechaFin}</strong></p>
															<span><i class="glyphicon glyphicon-time"></i> ${tratamiento.perioicidad}</span>
														</div>

														<div class="col-xs-4 text-right">
															<p class="treatment__dose">
																<c:forEach var="i" begin="1" end="${tratamiento.numDosis}">
																	<i class="glyphicon glyphicon-ok-circle${ i <= tratamiento.numDosisDia ? ' empty' : '' }"></i>
																</c:forEach>
															</p>

															<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().parent().parent().remove()">Eliminar</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>

								<div id="finalizados" class="tab-pane fade">
									<div class="treatment">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="row">
													<div class="col-xs-8">
														<p><strong>ESPIDIFEN - 400 MG 30 SOBRES [ZAMBON]</strong></p>
														<p><strong><i class="glyphicon glyphicon-calendar"></i> 2017-05-25 - 2017-06-01</strong></p>
														<span><i class="glyphicon glyphicon-time"></i> 8 horas</span>
													</div>

													<div class="col-xs-4 text-right">
														<p class="treatment__dose">
															<i class="glyphicon glyphicon-ok-circle empty"></i>
															<i class="glyphicon glyphicon-ok-circle empty"></i>
															<i class="glyphicon glyphicon-ok-circle empty"></i>
														</p>

														<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().parent().parent().remove()">Eliminar</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="nuevoTratamiento" class="modal fade" role="dialog" data-modal-show-on-error="${error}">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Nuevo tratamiento</h4>
			</div>

			<div class="modal-body">
				<sf:form method="POST" modelAttribute="form">
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
							<sf:input path="fechaInicio" type="date" class="form-control" placeholder="Fecha inicio tratamiento" value="" />
							<p><sf:errors path="fechaInicio" cssClass="error"/></p>
						</div>
						<div class="form-group">
							<sf:input path="fechaFin" type="date" class="form-control" placeholder="Fecha fin tratamiento" value="" />
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
							<sf:textarea path="comentario" class="form-control" style="height: 100px" placeholder="Comentario"></sf:textarea>
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
