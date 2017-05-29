<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf" %>


<%@ include file="../../jspf/navbarFarmacia.jspf" %>

  <div class="container">     
          <div id="stock">
            <div>
              <h2>Tabla de stock</h2>
            </div>
            <div>
              <table id="tablaStock" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Nombre</th>
                  <th>Descripción</th>
                  <th>Cant. en stock</th>
				  <th>Precio</th>
                  <th>Fecha de Caducidad</th>
                  <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                 <c:forEach var="stock" items="${miStock}">
	                <tr>
	                  <td>${stock.medicamento.nombre}</td>
	                  <td> ${stock.medicamento.descripcion}</td>
	                  <td> ${stock.cantidad}</td>
	                  <td> ${stock.medicamento.precio}</td>
	                  <td> ${stock.fechaCaducidad}</td>
	                  <td>
	                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
	                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
	                  </td>
	                </tr>
                </c:forEach>
                </tbody>
              </table>
              <!-- fin tabla stock -->
                <div>
                    <h2>Añadir nuevos productos:</h2>
                  <ul class="nav nav-pills">
                    <li><a data-toggle="pill" href="#añadirMedicamentoManual">Añadir Medicamento Manualmente</a></li>
                    <li><a data-toggle="pill" href="#añadirMedicamentoarchivo">Añadir medicamentos desde archivo</a></li>
                  </ul>

                  <div class="tab-content">  
                    <div id="añadirMedicamentoManual" class="tab-pane fade">
                      <h3>Añadir Medicamento Manualmente</h3>
                        <!-- nuevo producto-->
                        <div>
                            <div class="col-lg-12">
                                <h3 class="page-header">Nuevo Producto:</h3>
                                <h3><small>Rellene el siguiente formulario.</small></h3>
                            </div>
                            <form>
                                <!--Datos del usuario-->
                                <div class="col-md-6 portfolio-item">
                                    <div class="form-group">
                                        <label for="nombreMedicamento">Nombre del medicamento:</label>
                                        <input type="text" class="form-control" id="nombreMedicamento">
                                    </div>
                                    <div class="form-group">
                                        <label for="descripcionMedicamento">Descripcion</label>
                                        <input type="text" class="form-control" id="descripcionMedicamento">
                                    </div>
                                    <div class="form-group">
                                        <label for="dosisMedicamento">Numero de dosis por caja:</label>
                                        <input type="text" class="form-control" id="dosisMedicamento">
                                    </div>
                                    <div class="form-group">
                                        <label for="cantidadMedicamento">Cantidad en stock:</label>
                                        <input type="text" class="form-control" id="cantidadMedicamento">
                                    </div>
                                    <div class="form-group">
                                        <label for="precioMedicamento">Precio:</label>
                                        <input type="text" class="form-control" id="precioMedicamento">
                                    </div>
                                </div>              
                                <div class="col-md-12 portfolio-item">
                                    <input type="submit" class="btn-lg btn-default center-block" value="Añadir">
                                </div>
                            </form>        
                        </div>
                    </div>
                    <div id="añadirMedicamentoarchivo" class="tab-pane fade">
                      <h3>Añadir Stock desde archivo</h3>
                      <!-- importar desde archivo -->
                        <div class="form-group">
                          <label for="exampleInputFile">Importar:</label>
                          <input type="file" id="exampleInputFile">

                          <p class="help-block">Importar stock desde archivo, 
                           este stock sustituirá por completo al actual</p>
                        </div>
                    </div>
                  </div>
                </div>
               <!-- fin añadir prpductos -->
            </div>
            <!-- /.box-body -->
           </div>
          <!-- tab -->
          </div>
          <!--row-->
         </div>
		</div>
        
           <!-- ________________TABLE: STOOOOOOCKS END___________________________ -->
        
        <hr>

<%@ include file="../../jspf/footer.jspf" %>
