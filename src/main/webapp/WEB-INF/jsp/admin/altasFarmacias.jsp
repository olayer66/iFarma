<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>

<div class="container">
    <div class="row">
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
                    <td><a href="/admin/detalleAltaFarmacia" target="blank">SOL842</a></td>
                    <td>22/03/2017</td>
                    <td>Farmacia Venancio</td>
                    <td>Paco Venancio Torres</td>
                    <td>452265441</td>
                    <td>913657445</td>
                    <td><span class="label label-warning">Pendiente</span></td>
                  </tr>
                  <tr>
                    <td><a href="/admin/detalleAltaFarmacia" target="blank">SOL442</a></td>
                    <td>22/03/2017</td>
                    <td>Farmacia Torreon</td>
                    <td>esther Torre</td>
                    <td>433341</td>
                    <td>91458872</td>
                    <td><span class="label label-primary">En proceso</span></td>
                  </tr>
                  <tr>
                    <td><a href="/admin/detalleAltaFarmacia" target="blank">SOL452</a></td>
                    <td>22/03/2017</td>
                    <td>Farmacia Coslada</td>
                    <td>Paco Venancio Torres</td>
                    <td>452265441</td>
                    <td>913657445</td>
                    <td><span class="label label-success">Concedido</span></td>
                  </tr>
                  <tr>
                    <td><a href="/admin/detalleAltaFarmacia" target="blank">SOL222</a></td>
                    <td>22/03/2017</td>
                    <td>Farmacia Pedro</td>
                    <td>Pedro Venancio Torres</td>
                    <td>45265441</td>
                    <td>913653445</td>
                    <td><span class="label label-danger">Denegado</span></td>
                  </tr>
                  </tbody>
                </table>
		</div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>