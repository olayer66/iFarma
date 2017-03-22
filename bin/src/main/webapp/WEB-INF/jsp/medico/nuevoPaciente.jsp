<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>


<%@ include file="../../jspf/navbarMedico.jspf"%>

<div class="container">
	<h2>Detalles del Paciente</h2>
	<hr>

	<div class="row">
        <div class="col-md-6 portfolio-item">
            <form>
                <!--Datos del usuario-->
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" placeholder="Introducir nombre">
                </div>
                <div class="form-group">
                    <label for="apellidos">Apellidos:</label>
                    <input type="text" class="form-control" id="apellidos" placeholder="Introducir apellidos">
                </div>
                <div class="form-group">
                    <label for="edad">Edad:</label>
                    <input type="text" class="form-control" id="edad" placeholder="Introducir edad" />
                </div>
                <div class="form-group">
                    <label for="peso">Peso:</label>
                    <input type="text" class="form-control" id="peso" placeholder="Introducir peso" />
                </div>
                <div class="form-group">
                    <label for="altura">Altura:</label>
                    <input type="text" class="form-control" id="altura" placeholder="Introducir altura" />
                </div>
                <input type="submit" class="btn btn-default center-block" value="Enviar">
            </form>
        </div>
    </div>
</div>

<%@ include file="../../jspf/footer.jspf"%>
