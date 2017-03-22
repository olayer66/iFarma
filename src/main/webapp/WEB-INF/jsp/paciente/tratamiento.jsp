<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarPaciente.jspf"%>

<div class="container">
    <div class="row">
    
        <!--TRATAMIENTOS-->
        
                <div id="tratamiento">
                   
                        <h2 class="page-header">Tratamientos</h2>
                    
                    <div>
                        <table id="tablaTratamiento" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                  <th>Nombre del medicamento</th>
                                  <th>Uso</th>
                                  <th>Dosis</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                  <td>Ibuprofeno</td>
                                  <td>Dolores</td>
                                  <td>8h</td>
                                </tr>
                                <tr>
                                  <td>Paracetamol</td>
                                  <td>Mareos</td>
                                  <td>10h</td>
                                </tr>
                                <tr>
                                  <td>Acarbosa Tarbis</td>
                                  <td>Embarazo</td>
                                  <td>4h</td>
                                </tr>
                                <tr>
                                  <td>Agua oxigenada</td>
                                  <td>Herias</td>
                                  <td>24h</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
       
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>