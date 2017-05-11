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
	                                  <th>Nombre del medicamento</th>
	                                  <th>Uso</th>
	                                  <th>Cantidad</th>
	                                  <th>Precio</th>
	                                  <th>Accion</th>
	                                </tr>
	                            </thead>
	                            <tbody>
	                                <tr>
	                                	<td>Ibuprofeno</td>
		                                <td>Dolores</td>
		                                <td>24</td>
		                                <td>3.30</td>
		                                <td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                                <tr>
		                                <td>Paracetamol</td>
		                                <td>Mareos</td>
		                                <td>24</td>
		                                <td>2.50</td>
		                                <td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                                <tr>
	                             		<td>Acarbosa Tarbis</td>
	                                 	<td>Embarazo</td>
	                                 	<td>15</td>
	                                 	<td>10.90</td>
	                                 	<td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                                <tr>
	                                 	<td>Agua oxigenada</td>
	                                 	<td>Herias</td>
	                                 	<td>1 L</td>
	                                 	<td>1.05</td>
	                                	<td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                                <tr>
	                                 	<td>Ebastel</td>
	                                 	<td>Alergia</td>
	                                 	<td>20</td>
	                                 	<td>8.65</td>
	                                 	<td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                                <tr>
	                                 	<td>Zariten</td>
	                                 	<td>Alergia</td>
	                                 	<td>24</td>
	                                 	<td>15.00</td>
	                                 	<td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                                <tr>
	                                 	<td>Efferalgan</td>
	                                 	<td>Dolores</td>
	                                 	<td>24</td>
	                                 	<td>2.75</td>
	                                 	<td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                                <tr>
	                                 	<td>Azitromicina qualigen</td>
	                                 	<td>Gripe</td>
	                                 	<td>3</td>
	                                 	<td>51.35</td>
	                                 	<td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                                <tr>
	                                 	<td>Betadine</td>
	                                 	<td>Heridas</td>
	                                 	<td>50 Ml</td>
	                                 	<td>7.75</td>
	                                 	<td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                                <tr>
	                                 	<td>Shur Breath</td>
	                                 	<td>Alitosis</td>
	                                 	<td>28</td>
	                                 	<td>13.90</td>
	                                 	<td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                                <tr>
	                                 	<td>Optrex</td>
	                                 	<td>Conjuntivitis</td>
	                                 	<td>10 Ml</td>
	                                 	<td>3.90</td>
	                                 	<td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
	                                <tr>
	                                 	<td>Fortasec</td>
	                                 	<td>Diarrea</td>
	                                 	<td>24</td>
	                                 	<td>8.81</td>
	                                 	<td>
											<a href="#" class="btn btn-sm btn-primary">Modificar</a>
											<a href="#" class="btn btn-sm btn-danger" onclick="$(this).parent().parent().remove()">Eliminar</a>
										</td>
	                                </tr>
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