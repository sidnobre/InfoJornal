<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty vmessages.success}">
	<div class="alert alert-dismissible alert-success">
  		<button type="button" class="close" data-dismiss="alert">×</button>
  		<p class="text-center"><strong>${vmessages.success.from('secao.adicionada')}</strong></p>
  		<p class="text-center"><strong>${vmessages.success.from('usuario.adicionado')}</strong></p>
  		<p class="text-center"><strong>${vmessages.success.from('noticia.adicionada')}</strong></p>
  		<p class="text-center"><strong>${vmessages.success.from('noticia.removida')}</strong></p>
	</div>
</c:if>

<c:if test="${not empty vmessages.info}">
	<div class="alert alert-dismissible alert-info">
  		<button type="button" class="close" data-dismiss="alert">×</button>
  		<p class="text-center"><strong>${vmessages.info.from('usuario.autenticado')}</strong></p>
  		<p class="text-center"><strong>${vmessages.info.from('usuario.desautenticado')}</strong></p>
	</div>
</c:if>

<c:if test="${not empty errors}">
	<div class="alert alert-dismissible alert-danger">
  		<button type="button" class="close" data-dismiss="alert">×</button>
  		<p class="text-center"><strong>${errors.from('usuario.nao.autenticado')}</strong></p>
  		<p class="text-center"><strong>${errors.from('papel.nao.autorizado')}</strong></p>
  		<p class="text-center"><strong>${errors.from('autorizacao.invalida')}</strong></p>
  		<p class="text-center"><strong>${errors.from('autenticacao.invalida')}</strong></p>
  		
	</div>
</c:if>