<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarPaciente.jspf"%>

<div class="container">
    <div class="row">
    
    
        <!--ICONOS-->

                <div id="index" >
                    <div class="col-md-4 portfolio-item">
                        
                        <h2>Tratamiento</h2>
                        <a href="/paciente/tratamiento"><img src="/static/img/tratamiento.jpg" alt="Tratamiento" width="200" height="200"></a>
                        
                    </div>
                    <div class="col-md-4 portfolio-item">
                         
                        <h2>Pedidos</h2>
                        <a href="/paciente/pedidosPc"><img src="/static/img/pedidos3.jpg" alt="PedidosPc" width="200" height="200"></a>
                        
                    </div>
                    <div class="col-md-4 portfolio-item">
                         
                        <h2>Feedback</h2>
                        <a href="/paciente/feedbackDR"><img src="/static/img/doctor.jpg" alt="FeedbackDR" width="200" height="200"></a>
                        
                    </div>
                    <div class="col-md-4 portfolio-item">
                         
                        <h2>Mi Perfil</h2>
                        <a href="/paciente/perfil"><img src="/static/img/perfil.jpg" alt="Perfil" width="200" height="200"></a>
                        
                    </div>
                </div>
               
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>