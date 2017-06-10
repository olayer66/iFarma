<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarPaciente.jspf"%>


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
                    <th>Farmacia del pedido</th>
                    <th>Fecha</th>
                    <th>Estado</th>      
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="pedidos" items="${listaPed}">
                  <tr>
					<td><a href=/paciente/verPedido?id=${pedidos.id}>${pedidos.id}</a></td>
                    <td>${pedidos.farmacia.nombre}</td>
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
