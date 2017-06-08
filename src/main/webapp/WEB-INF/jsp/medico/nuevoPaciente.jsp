<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarMedico.jspf"%>

<div class="container">
	<h2>Datos paciente</h2>
	<hr>

	<div class="row">
		<sf:form modelAttribute="form" method="POST">
			<div class="col-md-6 portfolio-item">
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<sf:input path="nombre" class="form-control" id="nombre" />
					<p><sf:errors path="nombre" cssClass="error"/></p>
				</div>

				<div class="form-group">
					<label for="apellidos">Apellidos:</label>
					<sf:input path="apellidos" class="form-control" id="apellidos" />
					<p><sf:errors path="apellidos" cssClass="error"/></p>
				</div>

				<div class="form-group">
					<label for="email">Email:</label>
					<sf:input path="email" class="form-control" id="email" />
					<p><sf:errors path="email" cssClass="error"/></p>
				</div>

				<div class="form-group">
					<label for="Telefono">Teléfono:</label>
					<sf:input path="telefono" class="form-control" id="Telefono" />
					<p><sf:errors path="telefono" cssClass="error"/></p>
				</div>

				<button type="submit" class="btn btn-default center-block">Enviar</button>
			</div>
		</sf:form>
	</div>
</div>

<%@ include file="../../jspf/footer.jspf"%>
