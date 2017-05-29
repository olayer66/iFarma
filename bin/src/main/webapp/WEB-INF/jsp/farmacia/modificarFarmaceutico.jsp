<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>


<%@ include file="../../jspf/navbarFarmaceutico.jspf"%>

<div class="container">
	<div class="row">
		<div class="tab-content">
			<div class="col-lg-12">
				<h3 class="page-header">Modificar datos de farmaceutico:</h3>
				<h3>
					<small>Rellene el siguiente formulario.</small>
				</h3>
			</div>		
			<form>
				<div class="col-md-6 portfolio-item">
					<div class="form-group">
						<label for="nombreFarmaceutico">Nombre:</label> <input
						type="text" class="form-control" id="nombreFarmaceutico">
					</div>
					<div class="form-group">
						<label for="nColFarmaceutico">Numero de colegiado:</label> <input
						type="text" class="form-control" id="nColFarmaceutico">
					</div>	
					<div class="form-group">
						<label for="passFarmaceutico">Contraseña antigua:</label> <input
						type="text" class="form-control" id="passFarmaceutico">
					</div>					
					<div class="form-group">
						<label for="newPassFarmaceutico">Contraseña nueva:</label> <input
						type="text" class="form-control" id="newPassFarmaceutico">
					</div>
					<div class="form-group">
						<label for="newPassFarmaceutico2">Repetir nueva contraseña:</label> <input
						type="text" class="form-control" id="newPassFarmaceutico2">
					</div>
															
				</div>
				<div class="col-md-12 portfolio-item">
					<input type="submit" class="btn-lg btn-default center-block"
						value="Modificar Datos">
				</div>
			</form>	
		</div>
	</div>
</div>











<hr>

	<%@ include file="../../jspf/footer.jspf"%>