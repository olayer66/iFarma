<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../jspf/header.jspf"%>

<%@ include file="../jspf/navbarLoginAdmin.jspf"%>

<div class="container">
    <div class="row">
    	<div class="col-lg-12">
             <h1 class="page-header">Iniciar sesión</h1>
             <h1><small>Por favor inicie sesion para acceder al sistema.</small></h1>
         </div>
	</div>
	<div class="row">
		<div class="col-lg-6">
			<form action="${loginUrl}" method="post" class="form-horizontal">
                 <c:if test="${param.error != null}">
                     <div class="alert alert-danger">
                         <p>Invalid username and password.</p>
                     </div>
                 </c:if>
                 <c:if test="${param.logout != null}">
                     <div class="alert alert-success">
                         <p>You have been logged out successfully.</p>
                     </div>
                 </c:if>
                 <div class="input-group input-sm">
                     <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                     <input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required>
                 </div>
                 <div class="input-group input-sm">
                     <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                     <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                 </div>
                 <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
                      
                 <div class="form-actions">
                     <input type="submit"
                         class="btn btn-block btn-primary btn-default" value="Log in">
                 </div>
             </form>
		</div>
	</div>
</div>
<%@ include file="../jspf/footer.jspf" %>
</html>