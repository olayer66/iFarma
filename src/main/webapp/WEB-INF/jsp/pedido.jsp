<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../jspf/headerFarmacia.jspf" %>


<%@ include file="../jspf/navbarFarmacia.jspf" %>

    <!-- Page Content -->
    <div class="container">

    <!-- Main content -->
    <section class="invoice">
      <!-- title row -->
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header">
            <i class="fa fa-globe"></i>iFarma.
            <small class="pull-right">Fecha: 5/5/55</small>
          </h2>
        </div>
        <!-- /.col -->
      </div>
      <!-- info row -->
      <div class="row invoice-info">
        <div class="col-sm-4 invoice-col">
          From
          <address>
            <strong>Farmacias pepito.</strong><br>
            Calle canarias nº52<br>
            Madrid, CP 55223<br>
            Telefono: 999555999<br>
            Email: farmaciasPepito@gemail.com
          </address>
        </div>
        <!-- /.col -->
        <div class="col-sm-4 invoice-col">
          To
          <address>
            <strong>Eugenio lopez.</strong><br>
            Calle la almendra nº21<br>
            Madrid, CP 55669<br>
            Telefono: 666555666<br>
            Email: EseEuge@gemail.com
          </address>
        </div>
        <!-- /.col -->
        <div class="col-sm-4 invoice-col">
          <b>Factura #007612</b><br>
          <br>
          <b>ID pedido:</b> 4F3S8J<br>
          <b>Fecha de pago:</b> 2/22/2014<br>
          <b>Cuenta</b> 968-34567
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

      <!-- Table row -->
      <div class="row">
        <div class="col-xs-12 table-responsive">
          <table class="table table-striped">
            <thead>
            <tr>
              <th>Cantidad</th>
              <th>Producto</th>
              <th>ID producto</th>
              <th>Descripción</th>
              <th>Subtotal</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>3</td>
              <td>Ibuprofeno</td>
              <td>455-981-221</td>
              <td>Medicamento Antinflamatorio</td>
              <td>10.50€</td>
            </tr>
            <tr>
              <td>1</td>
              <td>Paracetamol</td>
              <td>247-925-726</td>
              <td>Panacea. Lo cura todo.</td>
              <td>5.00€</td>
            </tr>
            <tr>
              <td>1</td>
              <td>Tobrex</td>
              <td>735-845-642</td>
              <td>Colirio antibiótico.</td>
              <td>10.70€</td>
            </tr>
            <tr>
              <td>5</td>
              <td>Omeprazol</td>
              <td>422-568-642</td>
              <td>Protector de estómago.</td>
              <td>$25.99</td>
            </tr>
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
          <img src="images/credit/visa.png" alt="Visa"/>
          <img src="images/credit/mastercard.png" alt="Mastercard">
          <img src="images/credit/american-express.png" alt="American Express">
          <img src="images/credit/paypal2.png" alt="Paypal">

        </div>
        <div class="col-xs-6">
            <h2>Modificar estado del pedido: </h2>
            <div class="btn-group">
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
        </div>
        <hr>
        <!-- /.col -->
        <div class="col-xs-6">
          <p class="lead">Fecha de pago 2/22/2014</p>

          <div class="table-responsive">
            <table class="table">
              <tr>
                <th style="width:50%">Subtotal:</th>
                <td>100.00€</td>
              </tr>
              <tr>
                <th>Impuestos(21%):</th>
                <td>21.00€</td>
              </tr>
              <tr>
                <th>Envío:</th>
                <td>5.80€</td>
              </tr>
              <tr>
                <th>Total:</th>
                <td>126.80€</td>
              </tr>
            </table>
          </div>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
       
    	 <hr>

<%@ include file="../jspf/footer.jspf" %>
