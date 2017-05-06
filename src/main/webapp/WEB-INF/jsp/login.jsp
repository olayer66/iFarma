<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

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
			<form action="/login" method="post">               
		        <fieldset>
		            <legend>Please Login</legend>
		            <label for="username">Username</label>
		            <input type="text" id="username" name="username"/>        
		            <label for="password">Password</label>
		            <input type="password" id="password" name="password"/>
		            
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		            
		            <div class="form-actions">
		                <button type="submit" class="btn">Log in</button>
		            </div>
		        </fieldset>
			</form>
		</div>
	</div>
</div>
<%@ include file="../jspf/footer.jspf" %>
</html>