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
                    <th>Paciente del pedido</th>
                    <th>Fecha</th>
                    <th>Estado</th>        
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="pedidos" items="${listaPed}">
                  <tr>
					<td><a href=/farmacia/pedido?id=${pedidos.id}&idFarmacia=${idFarmacia}>${pedidos.id}</a></td>
                    <td>${pedidos.paciente.nombre}</td>
                    <td>${pedidos.fechaPedido}</td>
                    <td><span class="label label-success">${pedidos.estadoPedido==0 ? 'Pendiente' : 'Entrergado'}</span></td>
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
