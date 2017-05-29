<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarAdministrador.jspf"%>

<div class="container">
    <div class="row">
         <!--FEEDBACK-->
    
                <div id="nuevoMedicamento">
                    <div>    
                    <h2 class="page-header">Nuevo medicamento</h2>
                    </div>
                    
                    <form>
                        <div class="col-md-4 portfolio-item">
                            <div class="form-group">
                                <label for="nombreMedicamento">Nombre del medicamento: </label>
	                                   <input type="text"class="form-control" id="nombreMedicamento">
                            </div>
                            <div class="form-group">
                                <label for="uso">Uso: </label>
                                <input type="text" class="form-control" id="uso">
                            </div>
                            <div class="form-group">
                                <label for="cantidad">Cantidad: </label>
                                <input type="text" class="form-control" id="cantidad">
                            </div>
                            <div class="form-group">
                                <label for="precio">Precio: </label>
                                <input type="text" class="form-control" id="precio">
                            </div>
                            <a class="btn btn-default center-block"  id="btnNuevoMedicamento" href="/admin">Añadir</a>
                        </div>
                    </form>     
                </div>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>