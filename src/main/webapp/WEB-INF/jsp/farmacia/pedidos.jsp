<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf" %>


<%@ include file="../../jspf/navbarFarmacia.jspf" %>

  <div class="container">
        <div class="row">
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
                  <c:forEach var="pedidos" items="${listaPed}">
                  <tr>
					<td><a href=/farmacia/pedido?id=${pedidos.id}>${pedidos.id}</a></td>
                    <td>${pedidos.id}</td>
                    <td>${pedidos.fechaPedido}</td>
                    <td><span class="label label-success">${pedidos.estadoPedido}</span></td>
                    <td> <div class="btn-group">
                         <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Action <span class="caret"></span>
                         </button>
                          <ul class="dropdown-menu">
                          <li><a href="#">Pendiente</a></li>
                          <li><a href="#">Entregado</a></li>
                        </ul>
                      </div>
                    </td>
                  	</tr>
           		  </c:forEach>
                  </tbody>
                </table>
              </div>
               <!-- fin tabla -->
              </div>
            </div>
     	   </div>
        
        <hr>


<%@ include file="../../jspf/footer.jspf" %>
