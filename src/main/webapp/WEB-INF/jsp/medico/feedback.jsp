<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../../jspf/header.jspf" %>

<%@ include file="../../jspf/navbarMedico.jspf"%>

<div class="container">
    <h2>Feedback Pacientes</h2>
    <hr>

    <div class="col-lg-2">
        <ul class="nav nav-pills nav-stacked">
            <button class="btn btn-default btn-block" data-toggle="modal" data-target="#redactarMensaje">
                Redactar
            </button>
            <br>

            <li class="active">
                <a data-toggle="tab" href="#inbox">
                    Recibidos <span class="badge pull-right">${fn:length(medico.mensajesRecibidos)}</span>
                </a>
            </li>
            <li>
                <a data-toggle="tab" href="#sent">
                    Enviados
                </a>
            </li>
        </ul>
    </div>

    <div class="col-lg-10">
        <div class="tab-content">
			<!-- Recibidos -->
            <div id="inbox" class="tab-pane fade in active">
                <table class="table table-hover table-striped">
                    <tbody>
                    	<c:forEach items="${medico.mensajesRecibidos}" var="mensaje">
	                		<tr>
	                            <td><input type="checkbox"></td>
	                            <td class="mailbox-star"><a href="#"><i class="glyphicon glyphicon-star" style="color:#f39c12"></i></a></td>
	                            <td class="mailbox-name"><a href="/medico/feedback/${mensaje.id}">${mensaje.remitente}</a></td>
	                            <td class="mailbox-subject">${mensaje.asunto}</td>
	                            <td class="mailbox-attachment"></td>
	                            <td class="mailbox-date">${mensaje.fechaMensaje}</td>
	                        </tr>
						</c:forEach>
                    </tbody>
                </table>
            </div>

			<!-- Enviados -->
            <div id="sent" class="tab-pane fade">
                <table class="table table-hover table-striped">
					<tbody>
	                	<c:forEach items="${medico.mensajesEnviados}" var="mensaje">
	                		<tr>
	                            <td><input type="checkbox"></td>
	                            <td class="mailbox-star"><a href="#"><i class="glyphicon glyphicon-star" style="color:#f39c12"></i></a></td>
	                            <td class="mailbox-name"><a href="/medico/feedback/${mensaje.id}">${mensaje.destinatario}</a></td>
	                            <td class="mailbox-subject">${mensaje.asunto}</td>
	                            <td class="mailbox-attachment"></td>
	                            <td class="mailbox-date">${mensaje.fechaMensaje}</td>
	                        </tr>
						</c:forEach>
					</tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div id="redactarMensaje" class="modal fade" role="dialog" data-modal-show-on-error="${error}">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Redactar mensaje</h4>
            </div>

            <div class="modal-body">
                <sf:form method="POST" modelAttribute="mensaje" action="/medico/feedback/nuevo">
                    <div class="box-body">
                        <div class="form-group">
							<sf:select  path="destinatario" class="form-control">
								<sf:option value="">Destinatario...</sf:option>
								<sf:options items="${medico.pacientes}" itemValue="id"></sf:options>
							</sf:select>
                            <p><sf:errors path="destinatario" cssClass="error"/></p>
                        </div>
                        <div class="form-group">
                            <sf:input path="asunto" class="form-control" placeholder="Asunto:" value="" />
                            <p><sf:errors path="asunto" cssClass="error"/></p>
                        </div>
                        <div class="form-group">
                            <sf:textarea path="mensaje" class="form-control" style="height: 250px" placeholder="Mensaje..."></sf:textarea>
                            <p><sf:errors path="mensaje" cssClass="error"/></p>
                        </div>
                    </div>

                    <button type="submit" class="btn btn-success">Enviar</button>
                </sf:form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../jspf/footer.jspf" %>
