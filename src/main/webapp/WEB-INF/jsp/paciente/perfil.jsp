<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarPaciente.jspf"%>

<div class="container">
    <div class="row">
        
    
    <!--PERFIL -->
    
                <div  id="perfil" >
                <h2 class="page-header">Mi Perfil</h2>
                   
                    <div class="row">
                        <div class="col-lg-2">
                            <img src="/static/img/persona.png" width="150" height="150">
                        </div>

                        <div class="col-lg-10">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h4>Nombre: ${paciente.nombre}</h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h4>Apellidos: ${paciente.apellidos}</h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h4>Email: ${paciente.email}</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4>Direccion: ${paciente.direccion}</h4>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-xs-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4>Ciudad: ${paciente.ciudad}</h4>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-xs-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4>Codigo Postal: ${paciente.codPostal}</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-5">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4> Forma de pago: 
                                            <c:if test="${paciente.formaPago}==0">
                                            PayPal
                                            </c:if>
                                            <c:if test="${paciente.formaPago}==1">
                                            Con tarjeta
                                            </c:if>
                                            <c:if test="${paciente.formaPago}==2">
                                            Contrareembolso
                                            </c:if>
                                            </h4>  
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <h2 class="page-header">Mi Farmacia    <a href="/paciente/tratamiento" class="btn btn-default">Cambiar</a></h2>
                    <div class="row">
                        <div class="col-lg-2">
                            <img src="/static/img/farmacia.jpg"width="150" height="150">
                        </div>
                            
                        <div class="col-lg-10">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h4>Nombre: ${paciente.farmacia.nombre}</h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h4>Direccion: ${paciente.farmacia.direccion}</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4>Codigo Postal: ${paciente.farmacia.codPostal}</h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4>Ciudad: ${paciente.farmacia.ciudad}</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>