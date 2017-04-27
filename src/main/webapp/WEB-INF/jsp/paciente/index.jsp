<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../jspf/header.jspf" %>


<%@ include file="../jspf/navbar.jspf" %>

<div class="container">
    <div class="row">
        <div class="tab-content">
            <!--Inicio-->
            <div id="index" class="tab-pane fade in active">
   
            <div id="nuevoPaciente" class="tab-pane fade">
                <div class="col-lg-12">
                    <h1 class="page-header">Nuevo paciente</h1>
                    <h1><small>Por favor compruebe los datos y rellene los que falten</small></h1>
                </div>
                <form>
                    <!--Datos del usuario-->
                    <div class="col-md-4 portfolio-item">
                        <h3>Datos personales</h3>
                        <div class="form-group">
                            <label for="nombrePaciente">Nombre:</label>
                            <input type="text" value="Paco" class="form-control" id="nombrePaciente">
                        </div>
                        <div class="form-group">
                            <label for="apellidosPaciente">Apellidos:</label>
                            <input type="text" value="Torreblanca" class="form-control" id="apellidosPaciente">
                        </div>
                        <div class="form-group">
                            <label class="control-label">Fecha de nacimiento:</label>
                            <div class="input-group input-append date datePicker" id="datePickerPaciente">
                                <input type="text" class="form-control" name="fechNacPaciente" />
                                <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nSegSocialPaciente">Numero Seg. social:</label>
                            <input type="text" value="21001457888"  class="form-control" id="nSegSocialPaciente">
                        </div>
                    </div>
                    <!--contraseña-->
                    <div class="col-md-4 portfolio-item">
                        <h3>Contraseña</h3>
                        <div class="form-group">
                            <label for="contraPaciente">Contraseña:</label>
                            <input type="password" class="form-control" id="contraPaciente">
                        </div>
                        <div class="form-group">
                            <label for="contraRepPaciente">Repetir:</label>
                            <input type="password" class="form-control" id="contraRepPaciente">
                        </div>
                    </div>
                    <!--forma de pago-->
                    <div class="col-md-4 portfolio-item">
                        <h3>Forma de pago</h3>
                        <label class="radio-inline"><sf:checkbox path="formaPago" value="0" disabled="disabled"/>PayPal</label>
                        <label class="radio-inline"><sf:checkbox path="formaPago" value="1"/>Tarjeta</label>
                        <label class="radio-inline"><sf:checkbox path="formaPago" value="2"/>Contrareembolso</label>
                        <div id="pagoPayPal">
                            <h4>Pago mediante cuenta de PayPal</h4>
                            <img class="img-responsive center-block" src="/static/img/credit/PayPal-Logo.jpg" alt="PayPal">
                        </div>
                        <div id="pagoTarjeta">
                             <div class="form-group">
                                <label for="numTarPaciente">Numero tarjeta:</label>
                                <input type="password" class="form-control" id="numTarPaciente">
                            </div>
                             <div class="form-group">
                                <label for="CodSegTarPaciente">CVC:</label>
                                <input type="text" class="form-control" id="CodSegTarPaciente">
                            </div>
                        </div>
                        <div id="pagoEfectivo">
                            <h4>Los pedidos se pagaran al momento de recibirlos</h4>
                        </div>
                    </div>
                    <!--enviar-->
                    <div class="col-md-12">
                        <input type="submit" class="btn-lg btn-default center-block" value="Enviar">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../jspf/footer.jspf"%>
