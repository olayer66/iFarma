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
						<div class="profile__avatar text-center" data-ui-back>
							<i class="glyphicon glyphicon-arrow-left"></i>
						</div>
					</div>

					<div class="col-lg-10">
						<div class="row">
							<div class="col-xs-9">
								<div class="panel panel-default profile__panel">
									<div class="panel-body">
										<h4>Destinatario: ${mensaje.destinatario.nombre} ${mensaje.destinatario.apellidos}</h4>
									</div>
								</div>

								<div class="panel panel-default profile__panel">
									<div class="panel-body">
										<h4>Remitente: ${mensaje.remitente.nombre} ${mensaje.remitente.apellidos}</h4>
									</div>
								</div>
							</div>

							<div class="col-xs-3">
								<div class="panel panel-default profile__panel">
									<div class="panel-body">
										<h4 class="text-center">
											<i class="glyphicon glyphicon-calendar"></i> ${mensaje.fechaMensaje}
										</h4>
									</div>
								</div>
							</div>
						</div>

						<div class="panel panel-default profile__panel">
							<div class="panel-body">
								<h4>Asunto: ${mensaje.asunto}</h4>
							</div>
						</div>

						<div class="panel panel-default profile__panel">
							<div class="panel-body">
								<h4>Mensaje: ${mensaje.mensaje}</h4>
							</div>
						</div>

						<button class="btn btn-primary" data-toggle="collapse" data-target="#response">
							Responder
						</button>

						<br><br>

						<div class="collapse" id="response" data-collapse-show-on-error="${error}">
							<div class="well">
								<sf:form method="POST" modelAttribute="mensaje">
									<div class="box-body">
										<sf:input type="hidden" path="destinatario" value="${mensaje.remitente}" />

										<div class="form-group">
											<sf:input path="asunto" class="form-control" placeholder="Asunto:" value="" />
											<p><sf:errors path="asunto" cssClass="error"/></p>
										</div>
										<div class="form-group">
											<sf:textarea path="mensaje" class="form-control" style="height: 250px" placeholder="Mensaje..."></sf:textarea>
											<p><sf:errors path="mensaje" cssClass="error"/></p>
										</div>
									</div>

									<button type="submit" class="btn btn-success">Enviar</button>
								</sf:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../../jspf/footer.jspf"%>

