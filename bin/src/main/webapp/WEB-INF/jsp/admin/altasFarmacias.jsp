<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>

<div class="container">
    <div class="row">
        <!--Inicio-->
		<div class="col-lg-12">
		    <h1 class="page-header">Altas de farmacias</h1>
		    <table id="tablaPedidos" class="table table-bordered table-striped">
               <thead>
                  <tr>
                    <th>ID Solicitud</th>
                    <th>Fecha solicitud</th>
                    <th>Farmacia</th>
                    <th>Nombre Farmaceutico</th>
                    <th>Nº Colegiado</th>
                    <th>Telefono</th>
                    <th>Estado</th>         
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td>SOL842</td>
                    <td>22/03/2017</td>
                    <td>Farmacia Venancio</td>
                    <td>Paco Venancio Torres</td>
                    <td>452265441</td>
                    <td>913657445</td>
                    <td><span class="label label-warning">Pendiente</span></td>
                  </tr>
                  </tbody>
                </table>
		</div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>