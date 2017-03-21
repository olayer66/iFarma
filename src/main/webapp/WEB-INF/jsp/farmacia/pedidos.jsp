<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../jspf/headerFarmacia.jspf" %>


<%@ include file="../jspf/navbarFarmacia.jspf" %>

  <div class="container">
           <div id="pedidos">
               <div>
                  <h2>Tabla de pedidos</h2>
               </div>
            <div>
              <table id="tablaPedidos" class="table table-bordered table-striped">
               <thead>
                  <tr>
                    <th>ID pedido</th>
                    <th>Pedido</th>
                    <th>Fecha</th>
                    <th>Estado</th>
                    <th>Realizar pedido</th>         
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td><a href="/farmacia/pedido">OR9842</a></td>
                    <td>Pepe botica</td>
                    <td>22/05/2016</td>
                    <td><span class="label label-success">Enviado</span></td>
                    <td> <div class="btn-group">
                         <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Action <span class="caret"></span>
                         </button>
                          <ul class="dropdown-menu">
                          <li><a href="#">Pendiente</a></li>
                          <li><a href="#">En proceso</a></li>
                          <li><a href="#">Enviado</a></li>
                          <li><a href="#">Entregado</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td><a href="/farmacia/pedido">OR1848</a></td>
                    <td>Ronaldo santos</td>
                     <td>22/05/2016</td>
                    <td><span class="label label-warning">Pendiente</span></td>
                    <td> <div class="btn-group">
                         <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Action <span class="caret"></span>
                         </button>
                          <ul class="dropdown-menu">
                          <li><a href="#">Pendiente</a></li>
                          <li><a href="#">En proceso</a></li>
                          <li><a href="#">Enviado</a></li>
                          <li><a href="#">Entregado</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td><a href="/farmacia/pedido">OR7429</a></td>
                    <td>Jose luis perales</td>
                     <td>22/05/2016</td>
                    <td><span class="label label-danger">Entregado</span></td>
                    <td> <div class="btn-group">
                         <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Action <span class="caret"></span>
                         </button>
                          <ul class="dropdown-menu">
                          <li><a href="#">Pendiente</a></li>
                          <li><a href="#">En proceso</a></li>
                          <li><a href="#">Enviado</a></li>
                          <li><a href="#">Entregado</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td><a href="/farmacia/pedido">OR7429</a></td>
                    <td>Conchita velascp</td>
                     <td>22/05/2016</td>
                    <td><span class="label label-info">En proceso</span></td>
                    <td> <div class="btn-group">
                         <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Action <span class="caret"></span>
                         </button>
                          <ul class="dropdown-menu">
                          <li><a href="#">Pendiente</a></li>
                          <li><a href="#">En proceso</a></li>
                          <li><a href="#">Enviado</a></li>
                          <li><a href="#">Entregado</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                  </tbody>
                </table>
              </div>
               <!-- fin tabla -->
              </div>
            </div>
        
        
        <hr>

<%@ include file="../jspf/footer.jspf" %>
