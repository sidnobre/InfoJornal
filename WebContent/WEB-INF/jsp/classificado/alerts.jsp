<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty vmessages.success}">
	<div class="alert alert-dismissible alert-success">
  		<button type="button" class="close" data-dismiss="alert">×</button>
  		<p class="text-center"><strong>${vmessages.success.from('classificado.adicionado')}</strong></p>
  		<p class="text-center"><strong>${vmessages.success.from('oferta.adicionada')}</strong></p>
	</div>
</c:if>

<c:if test="${not empty errors}">
	<div class="alert alert-dismissible alert-danger">
  		<button type="button" class="close" data-dismiss="alert">×</button>
  		<p class="text-center"><strong>${errors.from('classificado.texto.invalido')}</strong></p>
  		<p class="text-center"><strong>${errors.from('classificado.titulo.invalido')}</strong></p>
  		<p class="text-center"><strong>${errors.from('classificado.preco.invalido')}</strong></p>
  		<p class="text-center"><strong>${errors.from('classificado.contato.invalido')}</strong></p>
  		<p class="text-center"><strong>${errors.from('oferta.valor.invalido')}</strong></p>
  		<p class="text-center"><strong>${errors.from('oferta.data.invalida')}</strong></p>
  		<p class="text-center"><strong>${errors.from('oferta.autor.invalido')}</strong></p>
	</div>
</c:if>