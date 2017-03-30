<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarPaciente.jspf"%>

<div class="container">
    <div class="row">
        <!--PEDIDOS-->
    
    
                <div id="pedidosPc">
                    <div>
                        <h2 class="page-header">Ultimos Pedidos</h2>
                    </div>
                    <div>
                        <table id="tablaPedidosPc" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>ID pedido</th>
                                    <th>Fecha</th>
                                    <th>Estado</th>         
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><a href="/paciente/verPedidos">751140</a></td>
                                    <td>21/04/2017</td>
                                    <td><span class="label label-warning" style="font-size: 20px">PENDIENTE</span></td>
                                </tr>
                                <tr>
                                    <td><a href="/paciente/verPedidos">015102</a></td>
                                    <td>22/03/2017</td>
                                    <td><span class="label label-success" style="font-size: 20px">EN RUTA</span></td>
                                </tr>
                                <tr>
                                    <td><a href="/paciente/verPedidos">501485</a></td>
                                    <td>20/02/2017</td>
                                    <td><span class="label label-primary" style="font-size: 20px">ENTREGADO</span></td>
                                </tr>
                                <tr>
                                    <td><a href="/paciente/verPedidos">369852</a></td>
                                    <td>15/02/2017</td>
                                    <td><span class="label label-danger" style="font-size: 20px">CANCELADO</span></td>
                                </tr>
                                <tr>
                                    <td><a href="/paciente/verPedidos">151545</a></td>
                                    <td>22/01/2017</td>
                                    <td><span class="label label-primary" style="font-size: 20px">ENTREGADO</span></td>
                                </tr>
                                <tr>
                                    <td><a href="/paciente/verPedidos">985632</a></td>
                                    <td>18/12/2016</td>
                                    <td><span class="label label-primary" style="font-size: 20px">ENTREGADO</span></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
       
               
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>