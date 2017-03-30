<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarPaciente.jspf"%>

<div class="container">
    <div class="row">
        
    
    <!--PERFIL-->
    
                <div  id="perfil" >
                <h2 class="page-header">Mi Perfil</h2>
                   
                    <div class="row">
                        <div class="col-lg-2">
                            <img src="/static/img/persona.png" width="150" height="150">
                        </div>

                        <div class="col-lg-10">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h4>Nombre: Saturnino</h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h4>Apellidos: Diaz</h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h4>Numero Seg. Social: 28054185200</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4>Edad: 84</h4>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-xs-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4>Peso: 102</h4>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-xs-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4>Altura: 1,76</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-5">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4> Forma de pago: 
                                                <select class="btn btn-default" name="opt">
                                                    <option value="fut">Efectivo</option>
                                                    <option value="bal">VISA</option>
                                                    <option value="nat">MASTERCARD</option>
                                                    <option value="ten">American Express</option>
                                                    <option value="pad">PayPal</option>
                                                </select>
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
                                    <h4>Nombre: La Soledad</h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h4>Direccion: C/ La Fontana nº10</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4>Codigo Postal: 28035</h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4>Ciudad: Madrid</h4>
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