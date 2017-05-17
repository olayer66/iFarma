<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>

<div class="container">
    <div class="row">
        <div class="tab-content">
            <!--Inicio-->
            <div id="index" class="tab-pane fade in active">
                <div class="col-lg-12">
                     <div id="medicamentos">
                   
	                 	<h2 class="page-header">Medicamentos    
	                 	<a href="/admin/nuevoMedicamento" class="btn btn-default">Añadir</a>
	                 	<a href="/admin/insMedicmaentos" class="btn btn-default">Cargar fichero</a>
	                 	</h2>
	                    
	                    <div>
	                        <table id="tablaMedicamento" class="table table-bordered table-striped">
	                            <thead>
	                                <tr>
	                                  <th>Nombre</th>
	                                  <th>Laboratorio</th>
	                                  <th>Descripcion</th>
	                                  <th>Precio</th>
	                                  <th>Accion</th>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            <c:forEach var="medicamento" items="${listaMed}">
	                                <tr>
	                                	<td>${medicamento.nombre}</td>
		                                <td>${medicamento.laboratorio}</td>
		                                <td>${medicamento.descripcion}</td>
		                                <td>${medicamento.precio}€</td>
		                                <td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                              </c:forEach>  
	                            </tbody>
	                        </table>
	                    </div>
	                </div>
                </div>
            </div>
       	</div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>