<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarPaciente.jspf"%>

<div class="container">
    <div class="row">
        <!--FEEDBACK-->
    
                <div id="feedbackDR">
                    <div>    
                    <h2 class="page-header">Feedback</h2>
                    </div>
                    
                    <form>
                        <div class="col-md-4 portfolio-item">
                            <div class="form-group">
                                <label for="nombrePaciente">Nombre:</label>
                                <input type="text"class="form-control" id="nombrePaciente">
                            </div>
                            <div class="form-group">
                                <label for="apellidosPaciente">Apellidos:</label>
                                <input type="text" class="form-control" id="apellidosPaciente">
                            </div>
                            <div class="form-group">
                                <label for="nSegSocialPaciente">Numero Seg. social:</label>
                                <input type="text" class="form-control" id="nSegSocialPaciente">
                            </div>
                            <div class="form-group">
                                <label for="nColegiadoMedico">Codigo de su medico:</label>
                                <input type="text" class="form-control" id="nColegiadoMedico">
                            </div>
                            <div class="form-group">
                                <label>Feedback</label>   
                                <textarea rows="3" name="Feedback" class="form-control" id ="FeedbackPc"></textarea>
                            </div> 
                            <a class="btn btn-default center-block"  id="btnFeedbackDR" href="/paciente">Enviar</a>
                        </div>
                    </form>     
                </div>
       
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>