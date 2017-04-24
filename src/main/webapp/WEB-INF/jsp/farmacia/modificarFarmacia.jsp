<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>


<%@ include file="../../jspf/navbarFarmacia.jspf"%>

<div class="container">
	<div class="row">
		<div class="tab-content">
			<div class="col-lg-12">
				<h3 class="page-header">Modificar datos de farmacia:</h3>
				<h3>
					<small>Rellene el siguiente formulario.</small>
				</h3>
			</div>		
			<form>
				<div class="col-md-6 portfolio-item">
					<div class="form-group">
						<label for="nombreFarmacia">Nombre de la farmacia:</label> <input
						type="text" class="form-control" id="nombreFarmacia">
					</div>
					<div class="form-group">
						<label for="telefonoFarmacia">Telefono:</label> <input
						type="text" class="form-control" id="telefonoFarmacia">
					</div>	
					<div class="form-group">
						<label for="direccionFarmacia">Direccion:</label> <input
						type="text" class="form-control" id="direccionFarmacia">
					</div>					
					<div class="form-group">
						<label for="codPostalFarmacia">Codigo postal:</label> <input
						type="text" class="form-control" id="codPostalFarmacia">
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
						value="Modificar datos">
				</div>
			</form>	
		</div>
	</div>
</div>











<hr>

	<%@ include file="../../jspf/footer.jspf"%>