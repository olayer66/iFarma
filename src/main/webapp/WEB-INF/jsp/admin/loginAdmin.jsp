<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../jspf/header.jspf"%>

<%@ include file="../../jspf/navbarLoginAdmin.jspf"%>

<div class="container">
    <div class="row">
    	<div class="col-lg-12">
             <h1 class="page-header">Iniciar sesion</h1>
             <h1><small>Por favor inicie sesion para acceder al sistema de administracion.</small></h1>
         </div>
         <form>
             <div class="col-md-4 portfolio-item">
                 <div class="form-group">
                     <label for="usuLoginAdmin">Usuario:</label>
                     <input type="text" class="form-control" id="usuLoginAdmin">
                 </div>
                 <div class="form-group">
                     <label for="contLoginAdmin">Contraseña:</label>
                     <input type="password" name="contLoginAdmin" class="form-control" id="contLoginAdmin">
                 </div>
                 <a class="btn btn-default center-block"  id="btnLoginAdmin" href="/admin/admin">Inciar sesión</a>
             </div>
         </form>
	</div>
</div>
<%@ include file="../../jspf/footer.jspf" %>
</html>