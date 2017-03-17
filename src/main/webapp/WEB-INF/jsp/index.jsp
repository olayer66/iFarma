<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="../jspf/header.jspf" %>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"><img src="static/img/logo1.png" alt="Inicio"></a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a data-toggle="tab" href="#loginPaciente">Pacientes</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#loginMedico">Medicos</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#loginFarmacia">Farmacias</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="tab-content">
                <!--Inicio-->
                <div id="index" class="tab-pane fade in active">
                    <div class="col-lg-12">
                        <h1 class="page-header">Inicio  
                        </h1>
                        <p><strong>iFarma</strong> es tu aplicación web para el control de su tratamiento farmacológico y su seguimiento por su médico de cabecera. Además, le permitirá realizar los pedidos de medicamentos de forma fácil y sencilla a su farmacia de confianza y que se los entreguen en su domicilio. </p>
                    </div>
                    <div class="col-md-4 portfolio-item">
                        <img class="img-responsive" src="static/img/banner-pac.jpg">
                        <h3>Pacientes</h3>
                        <p>
                            Si deseas registrarte como paciente deberas tener el codigo proporcionado por tu medico de cabecera y pulsar el siguiente boton.
                        </p>
                        <label>Codigo:</label>
                        <input type="text" name="codigo" id="codNuevoPaciente">
                        <a data-toggle="tab" class="btn btn-default"  id="btnNuevoPaciente" href="#nuevoPaciente">Inscribirse</a>
                    </div>
                    <div class="col-md-4 portfolio-item">
                        <img class="img-responsive" src="static/img/banner-med.jpg">
                        <h3>Medicos</h3>
                        <p>
                            Si quieres registrarte como medico pulsa el siguiente boton.
                        </p>
                        <a data-toggle="tab" class="btn btn-default" id="btnNuevoMedico" href="#nuevoMedico">Inscribirse</a>
                    </div>
                    <div class="col-md-4 portfolio-item">
                        <img class="img-responsive" src="static/img/banner-far.jpg">
                        <h3>Farmacias</h3>
                        <p>
                            Bienvenido si eres farmaceutico y quieres unirte a nuestra red de suministradores pulsa en el siguiente boton.
                        </p>
                        <a data-toggle="tab" class="btn btn-default" id="btnNuevaFarmacia" href="#nuevaFarmacia">Inscribirse</a>
                    </div>
                </div>
                <!--Login del medico-->
                <div id="loginMedico" class="tab-pane fade">
                    <div class="col-lg-12">
                        <h1 class="page-header">Iniciar sesion</h1>
                        <h1><small>Por favor inicie sesion para acceder al sistema de gestion medica.</small></h1>
                    </div>
                    <form>
                        <div class="col-md-4 portfolio-item">
                            <div class="form-group">
                                <label for="numColMedico">Nº colegiado:</label>
                                <input type="text" class="form-control" id="numColMedico">
                            </div>
                            <div class="form-group">
                                <label for="contLoginMedico">Contraseña:</label>
                                <input type="password" name="contLoginMedico" class="form-control" id="contLoginMedico">
                            </div>
                            <a class="btn btn-default center-block"  id="btnLoginMedico" href="medico.html">Inciar sesión</a>
                        </div>
                    </form> 
                </div>
                <!--Login del Paciente-->
                <div id="loginPaciente" class="tab-pane fade">
                    <div class="col-lg-12">
                        <h1 class="page-header">Iniciar sesion</h1>
                        <h1><small>Por favor inicie sesion para acceder al sistema de gestion para pacientes.</small></h1>
                    </div>
                    <form>
                        <div class="col-md-4 portfolio-item">
                            <div class="form-group">
                                <label for="usuLoginPaciente">Usuario:</label>
                                <input type="text" class="form-control" id="usuLoginPaciente">
                            </div>
                            <div class="form-group">
                                <label for="contLoginPaciente">Contraseña:</label>
                                <input type="password" name="contLoginPaciente" class="form-control" id="contLoginPaciente">
                            </div>
                            <a class="btn btn-default center-block"  id="btnLoginPaciente" href="paciente.html">Inciar sesión</a>
                        </div>
                    </form> 
                </div>
                <!--Login de la Farmacia-->
                <div id="loginFarmacia" class="tab-pane fade">
                     <div class="col-lg-12">
                        <h1 class="page-header">Iniciar sesion</h1>
                        <h1><small>Por favor inicie sesion para acceder al sistema de gestion farmaceutico.</small></h1>
                    </div>
                     <form>
                        <div class="col-md-4 portfolio-item">
                            <div class="form-group">
                                <label for="nomLoginFarmacia">Farmacia:</label>
                                <input type="text" class="form-control" id="nomLoginFarmacia">
                            </div>
                            <div class="form-group">
                                <label for="contLoginFarmacia">Contraseña:</label>
                                <input type="password" name="contLoginFarmacia" class="form-control" id="contLoginFarmacia">
                            </div>
                            <a class="btn btn-default center-block"  id="btnLoginFarmacia" href="farmacia.html">Inciar sesión</a>
                        </div>
                    </form> 
                </div>
                <!--Nuevo paciente-->
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
                            <label class="radio-inline"><input type="radio" name="formaPago" value="p">PayPal</label>
                            <label class="radio-inline"><input type="radio" name="formaPago" value="t">Tarjeta</label>
                            <label class="radio-inline"><input type="radio" name="formaPago" value="e">Contrareembolso</label> 
                            <div id="pagoPayPal">
                                <h4>Pago mediante cuenta de PayPal</h4>
                                <img class="img-responsive center-block" src="static/img/credit/PayPal-Logo.jpg" alt="PayPal">
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
                <!--Nuevo Medico-->
                <div id="nuevoMedico" class="tab-pane fade">
                    <div class="col-lg-12">
                        <h1 class="page-header">Nuevo Medico</h1>
                        <h1><small>Rellene el siguiente formulario.</small></h1>
                    </div>
                    <form>
                        <!--Datos del usuario-->
                        <div class="col-md-6 portfolio-item">
                            <div class="form-group">
                                <label for="nombrePaciente">Nombre:</label>
                                <input type="text" class="form-control" id="nombreMedico">
                            </div>
                            <div class="form-group">
                                <label for="apellidosMedico">Apellidos:</label>
                                <input type="text" class="form-control" id="apellidosMedico">
                            </div>
                            <div class="form-group">
                                <label class="control-label">Fecha de nacimiento:</label>
                                <div class="input-group input-append date datePicker" id="datePickerMedico">
                                    <input type="text" class="form-control" name="fechNacMedico" />
                                    <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 portfolio-item">
                            <div class="form-group">
                                <label for="nColegiadoMedico">Numero colegiado:</label>
                                <input type="text" class="form-control" id="nColegiadoMedico">
                            </div>
                            <div class="form-group">
                                <label for="contraMedico">Contraseña:</label>
                                <input type="password" class="form-control" id="contraMedico">
                            </div>
                            <div class="form-group">
                                <label for="contraRepMedico">Repetir:</label>
                                <input type="password" class="form-control" id="contraRepMedico">
                            </div>
                        </div>
                        <div class="col-md-12 portfolio-item">
                            <input type="submit" class="btn-lg btn-default center-block" value="Enviar">
                        </div>
                    </form>        
                </div>
                <!--Nueva farmacia-->
                <div id="nuevaFarmacia" class="tab-pane fade">
                    <div class="col-lg-12">
                        <h1 class="page-header">Nueva Farmacia</h1>
                        <h1><small>Rellene el siguiente formulario.</small></h1>
                    </div>
                    <form>
                        <!--Datos del farmacia-->
                        <div class="col-md-6 portfolio-item">
                            <h3>Datos farmaceutico</h3>
                             <div class="form-group">
                                <label for="nombreDuFarmacia">Nombre:</label>
                                <input type="text" class="form-control" id="nombreDuFarmacia">
                            </div>
                            <div class="form-group">
                                <label for="nColegiadoFarnacia">Numero colegiado:</label>
                                <input type="text" class="form-control" id="nColegiadoFarnacia">
                            </div>
                            <div class="form-group">
                                <label for="apellidosFarmacia">Apellidos:</label>
                                <input type="text" class="form-control" id="apellidosFarmacia">
                            </div>
                            <div class="form-group">
                                <label class="control-label">Fecha de nacimiento:</label>
                                <div class="input-group input-append date datePicker" id="datePickerFarmacia">
                                    <input type="text" class="form-control" name="fechNacFarmacia" />
                                    <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 portfolio-item">
                            <h3>Datos de la farmacia</h3>
                            <div class="form-group">
                                <label for="nombreFarmacia">Nombre:</label>
                                <input type="text" class="form-control" id="nombreFarmacia">
                            </div>
                            <div class="form-group">
                                <label for="dirFarmacia">Direccion:</label>
                                <input type="text" class="form-control" id="dirFarmacia">
                            </div>
                             <div class="form-group">
                                <label for="contraFarmacia">Contraseña:</label>
                                <input type="password" class="form-control" id="contraFarmacia">
                            </div>
                            <div class="form-group">
                                <label for="contraRepFarmacia">Repetir:</label>
                                <input type="password" class="form-control" id="contraRepFarmacia">
                            </div>
                        </div>
                        <div class="col-md-12 portfolio-item">
                            <input type="submit" class="btn-lg btn-default center-block" value="Enviar">
                        </div>
                    </form>      
                </div>
            </div>
        </div>
        <hr>
		<%@ include file="../jspf/footer.jspf" %>
	</div>
</body>
</html>