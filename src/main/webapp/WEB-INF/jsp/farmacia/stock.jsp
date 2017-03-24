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
                  <th>Cantidad </th>
                  <th>Cant. en stock</th>
                  <th>Precio</th>
                  <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td>Ibuprofeno</td>
                  <td> algo escrito</td>
                  <td>20 Cap</td>
                  <td> 4</td>
                  <td>2</td>
                  <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>
                </tr>
                <tr>
                  <td>Ibuprofeno</td>
                  <td>Prueba 2 </td>
                  <td>30 Cap</td>
                  <td>5</td>
                  <td>2</td>
                  <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>               
                </tr>
                <tr>
                  <td>Ibuprofeno</td>
                  <td>Prueba </td>
                  <td>tonteria</td>
                  <td>2</td>
                  <td>5.20</td>
                  <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>                 
                </tr>
                <tr>
                  <td>Ibuprofeno</td>
                  <td> No tomar con agua</td>
                  <td>Na de na</td>
                  <td>6</td>
                  <td>4.30</td>
                  <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>
                </tr>
                <tr>
                  <td>Ibuprofeno</td>
                  <td>De 8 a  7</td>
                  <td>Droga de la mala SP2+</td>
                  <td>7</td>
                  <td>2.20</td>
                   <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>
                </tr>
                <tr>
                  <td>Ibuprofeno</td>
                  <td>Na que decir</td>
                  <td>Droga de la mala</td>
                  <td>6</td>
                  <td>2.20</td>
                   <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>
                </tr>
                <tr>
                  <td>Paracetamol</td>
                  <td>Chungo</td>
                  <td>15 Cap</td>
                  <td>1</td>
                  <td>18.30</td>
                  <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>
                </tr>            
                <tr>
                  <td>Paracetamol</td>
                  <td>mu Chungo</td>
                  <td>15 Cap</td>
                  <td>4</td>
                  <td>27.32</td>
                   <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>
                </tr>
                <tr>
                  <td>Paracetamol</td>
                  <td>Droga de la buena</td>
                  <td>10 Cap</td>
                  <td>0</td>
                  <td>0.36</td>
                   <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>
                </tr>
                <tr>
                  <td>Paracetamol</td>
                  <td>Diazepan de 1.0</td>
                  <td>15 Cap</td>
                  <td>1</td>
                  <td>52.21</td>
                   <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>
                </tr>
                <tr>
                  <td>Paracetamol</td>
                  <td>Diazepan de 1.5</td>
                  <td>10 Cap</td>
                  <td>1</td>
                  <td>7.36</td>
                   <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>
                </tr>
                <tr>
                  <td>Paracetamol sobres</td>
                  <td>0.3mg codeina</td>
                  <td>10 Sobres/td>
                  <td>2</td>
                  <td>4.56</td>
                   <td>
                  	<div id="btnAnadirStock" data-id="1" class="btn btn-success">Añadir</div>
                  	<div id="btnEliminarMed" data-id="1" class="btn btn-danger">Eliminar</div>
                  </td>
                </tr>
                
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
