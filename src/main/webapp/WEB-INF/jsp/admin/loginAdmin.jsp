<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarLoginAdmin.jspf"%>

<div class="container">
    <div class="row">
    	<div class="col-lg-12">
             <h1 class="page-header">Iniciar sesion</h1>
             <h1><small>Por favor inicie sesion para acceder al sistema de administracion.</small></h1>
         </div>
         <form method="post" action = "/admin/login">
             <div class="col-md-4 portfolio-item">
                 <div class="form-group">
                     <label for="usuLoginAdmin">Usuario:</label>
                     <input type="text" class="form-control" id="usuLoginAdmin">
                 </div>
                 <div class="form-group">
                     <label for="contLoginAdmin">Contraseña:</label>
                     <input type="password" name="contLoginAdmin" class="form-control" id="contLoginAdmin">
                 </div>
                 <div class="form-group">
                     <input type="submit" value="Inciar sesion" class="form-control">
                 </div>
             </div>
         </form>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>