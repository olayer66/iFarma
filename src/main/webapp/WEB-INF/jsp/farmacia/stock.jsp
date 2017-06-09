<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



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
 
				<button class="btn btn-success" data-toggle="modal" data-target="#añadirMedicamentoManual">
									Añadir Stock Manualmente
				</button>

                	<div>
	                    <h2>Añadir nuevos productos:</h2>
	                  <ul class="nav nav-pills">
	                    <li><a data-toggle="pill" href="#añadirMedicamentoarchivo">Añadir medicamentos desde archivo</a></li>
	                  </ul>
	                  <div class="tab-content">  
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
	            </div>
	            <!-- /.box-body -->
	           </div>
	          <!-- tab -->
	          </div>
			 <div id="añadirMedicamentoManual" class="modal fade" role="dialog" data-modal-show-on-error="${error}">
						<div class="modal-dialog modal-md">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Añadir stock</h4>
								</div>
					
								<div class="modal-body">
									<sf:form method="POST" modelAttribute="form">
										<div class="box-body">
											<div class="form-group">
												<sf:select  path="medicamento" class="form-control">
													<sf:option value="">medicamento</sf:option>
													<sf:options items="${medicamentos}" itemValue="id"></sf:options>
												</sf:select>
												<p><sf:errors path="medicamento" cssClass="error"/></p>
											</div>
											<div class="form-group">
												<sf:input path="cantidad" class="form-control" placeholder="Cantidad" />
												<p><sf:errors path="cantidad" cssClass="error"/></p>
											</div>											
											<div class="form-group">
												<sf:input path="fechaCaducidad" type="date" class="form-control" placeholder="Fecha de caducidad" value="" />
												<p><sf:errors path="fechaCaducidad" cssClass="error"/></p>
											</div>
										</div>
					
										<button type="submit" class="btn btn-success">Añadir stock</button>
									</sf:form>
								</div>
					
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
								</div>
							</div>
						</div>
					</div>
        
           <!-- ________________TABLE: STOOOOOOCKS END___________________________ -->
        
        <hr>

<%@ include file="../../jspf/footer.jspf" %>
