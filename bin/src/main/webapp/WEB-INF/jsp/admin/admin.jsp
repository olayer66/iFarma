<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>

<div class="container">
    <div class="row">
		<div class="col-lg-12">
		    <h1 class="page-header">Alertas</h1>
		    <div class="col-lg-6">
		     <h2>Altas de medicos</h2>
		     <h3>Tiene <strong>3</strong> altas de medicos pendientes de verificar</h3>
		     <p>Para verificar a un medico de cabecera debera seguir los siguientes pasos.</p>
		     <ol>
		     	<li>Comprobar los datos del medico en la web del colegio de medicina</li>
		     	<li>Contactar con el medico para confirmar su solicitud de acceso</li>
		     	<li>Confirmar el acceso en la ventana de <span>Altas medicos</span></li>
		     </ol>
		    </div>
		    <div class="col-lg-6">
		     <h2>Altas de farmacias</h2>
		     <h3>Tiene <strong>8</strong> altas de farmacias pendientes de verificar</h3>
		     <p>Para verificar una farmacia debera seguir los siguientes pasos.</p>
		     <ol>
		     	<li>Comprobar los datos del farmaceutico abscrito a la farmacia en el colegio de farmacia</li>
		     	<li>Contactar con el farmaceutico para confirmar su solicitud de acceso</li>
		     	<li>Confirmar el acceso en la ventana de <span>Altas farmacias</span></li>
		     </ol>
		    </div>
		</div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>