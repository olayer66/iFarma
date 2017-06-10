<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarPaciente.jspf"%>

<div class="container">
    <div class="row">
				<div class="col-lg-12">
					<h2>Tratamientos<img class ="help" data-toggle="modal" data-target="#ayuda" src="/static/img/help.png" ></h2>
					<hr>

					<div class="row">
						<div class="col-lg-2">
							<br>

							<ul class="nav nav-pills nav-stacked">
								<li class="active">
									<a data-toggle="tab" href="#enCurso">
										En curso <span class="badge pull-right">${fn:length(tratamientosEnCurso)}</span>
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
									<c:forEach items="${tratamientosEnCurso}" var="tratamiento">
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
															<sf:form method="POST" modelAttribute="form">
																<sf:input type="hidden" path="tratamiento" value="${tratamiento.id}" />
																<sf:input type="hidden" path="accion" id="accion" value="" />

																<p class="treatment__dose">
																	<c:forEach var="i" begin="1" end="${tratamiento.numDosis}">
																		<i
																			data-submit
																			data-action="${ i <= tratamiento.numDosisDia ? 'add' : 'sub' }"
																			class="glyphicon glyphicon-ok-circle${ i <= tratamiento.numDosisDia ? ' empty' : '' }"
																		></i>
																	</c:forEach>
																</p>
															</sf:form>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>

								<div id="finalizados" class="tab-pane fade">
									<c:forEach items="${tratamientosFinalizados}" var="tratamiento">
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
															<sf:form method="POST" modelAttribute="form">
																<sf:input type="hidden" path="tratamiento" value="${tratamiento.id}" />
																<sf:input type="hidden" path="accion" id="accion" value="" />

																<p class="treatment__dose">
																	<c:forEach var="i" begin="1" end="${tratamiento.numDosis}">
																		<i
																			data-submit
																			data-action="${ i <= tratamiento.numDosisDia ? 'add' : 'sub' }"
																			class="glyphicon glyphicon-ok-circle${ i <= tratamiento.numDosisDia ? ' empty' : '' }"
																		></i>
																	</c:forEach>
																</p>
															</sf:form>

															<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().parent().parent().remove()">Eliminar</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</div>

<div id="ayuda" class="modal fade" role="dialog" data-modal-show-on-error="${error}">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Ayuda</h4>
			</div>

			<div class="modal-body">
				<h4>A continuacion se le explica el funcionamiento del control de tratamientos.</h4>
				<p>Para poder marcar la toma debera hacer click en el boton <i class="glyphicon glyphicon-ok-circle"></i>, esto añadira una toma al sistema.</p>
				<p>Si el nivel de medicamento es reducido el sistema realizara un pedido del mismo que usted podra consultar en la ventana de <a href="/paciente/pedidosPc">Pedidos</a>.</p>
				<p>Una vez finalize el tratamiento este se eliminara del su pantalla.</p>
				
			</div>
		</div>
	</div>
</div>


<%@ include file="../../jspf/footer.jspf" %>


<script>
	$('[data-submit]').on('click', function () {
		var $this = $(this);
		var $form = $this.parent().parent();
		var $input = $form.find('#accion');
		var action = $this.data('action');

		$input.val(action);
		$form.submit();
	})
</script>