<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf" %>


<%@ include file="../../jspf/navbarFarmacia.jspf" %>


    <!-- Page Content -->
    <div class="container">
     <div class="row">
 
    <!-- Main content -->
    <section class="invoice">
      <!-- title row -->
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header">
            <i class="fa fa-globe"></i>iFarma.
            <small class="pull-right">Fecha: ${fecha}</small>
          </h2>
        </div>
        <!-- /.col -->
      </div>
      <!-- info row -->
      <div class="row invoice-info">
        <div class="col-sm-4 invoice-col">
          From
          <address>
            <strong>${farmacia.nombre}.</strong><br>
            ${farmacia.direccion}<br>
            ${farmacia.ciudad},  ${farmacia.provincia}, CP:${farmacia.codPostal}<br>
            Telefono: ${farmacia.telefono}<br>
          </address>
        </div>
        <!-- /.col -->
        <div class="col-sm-4 invoice-col">
          To
          <address>
            <strong> ${paciente.nombre}</strong><br>
           ${paciente.direccion}<br>
            ${paciente.ciudad},${paciente.provincia}, CP:${paciente.nombre}<br>
            Telefono: ${paciente.telefono}<br>
            Email: ${paciente.email}
          </address>
        </div>
        <!-- /.col -->
        <div class="col-sm-4 invoice-col">
          <b>ID pedido:</b> ${pedido.id}<br>
          <b>Fecha de Pedido:</b> ${pedido.fechaPedido}<br>
          <b>Cuenta:</b> ${paciente.numTarjeta}
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

      <!-- Table row -->
		<div>
              <table id="tablaPedidos" class="table table-bordered table-striped">
               <thead>
                  <tr>
                 	<th>Medicamento:</th>
                  	<th>Descripción:</th>
                    <th>Fecha de Caducidad:</th>                    
                    <th>Cantidad:</th>
       				<th>Precio:</th>        
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="exPedido" items="${listEx}">
                  <tr>
					<td>${exPedido.medicamento.nombre} </td>
                    <td>${exPedido.medicamento.descripcion}</td>
                    <td>${exPedido.fechaCaducidad}</td>
                    <td>${exPedido.cantidad}</td>
					<td>${exPedido.medicamento.precio}</td>
                  	</tr>
           		  </c:forEach>
                  </tbody>
                </table>
              </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

      <div class="row">
        <!-- accepted payments column -->
        <div class="col-xs-6">
          <p class="lead">Payment Methods:</p>
          <img src="/static/img/credit/visa.png" alt="Visa"/>
          <img src="/static/img/credit/mastercard.png" alt="Mastercard">
          <img src="/static/img/credit/american-express.png" alt="American Express">
          <img src="/static/img/credit/paypal.png" alt="Paypal">

        </div>
        <!-- /.col -->
        <div class="col-xs-6">
          <p class="lead">Fecha de pago: ${fecha}</p>

          <div class="table-responsive">
            <table class="table">
              <tr>
                <th>Total a pagar:</th>
                <td>${total}</td>
              </tr>
            </table>
          </div>
        </div>
        <!-- /.col -->
         <div class="col-xs-6">
            <h2>Realizar pedido: </h2>
            <div class="btn-group">
                              <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                               Action <span class="caret"></span>
                              </button>
                               <ul class="dropdown-menu">
                               <li><a href=/farmacia/realizarPedido?id=${pedido.id}&idFarmacia=${idFarmacia} >EntregarPedido</a></li>
                             </ul>
             </div>
        </div>
        <hr>
      </div>
      <!-- /.row -->
     </div>
       
    	 <hr>

<%@ include file="../../jspf/footer.jspf" %>
