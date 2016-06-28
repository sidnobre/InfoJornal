<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Formulário</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<meta name="description" content="">
  	<meta name="author" content="">

	<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
	<link href="<c:url value='/css/estilo.css'/>" rel="stylesheet">
  
	<!--<link rel="shortcut icon" href="<c:url value='/img/quixada.png'/>"> -->
  
	<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"> </script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
</head>

<body>
<div class="container">
	<c:import url="../header.jsp"></c:import>

	<div class="row clearfix well">
		<div class="col-md-3 column">
		</div>
		<div class="col-md-6 column">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<h1 class="text-center text-primary">
						Alterar o e-mail de usuário
					</h1>
				</div>
			</div>
			<c:if test="${not empty errors}">
				<div class="alert alert-dismissible alert-danger">
  					<button type="button" class="close" data-dismiss="alert">×</button>
        			<c:forEach var="error" items="${errors}">
            			<p class="text-center"><span class="glyphicon glyphicon-exclamation-sign"></span><strong> ${error.message}</strong></p>
        			</c:forEach>
    			</div>
			</c:if>
			<form action="<c:url value='/usuario/atualizarEmail'/>" role="form" method="POST">
				<div class="form-group">
					<input type="hidden" name="usuario.id" value="${usuarioSessao.usuario.id}">
					 <label for="inputSenhaAtual">Confirme a senha atual</label>
					 <div class="input-group">
					 	<span class="input-group-addon"><span class="glyphicon glyphicon-check"></span></span>
					 	<input class="form-control" id="inputSenhaAtual" type="password" name="usuarioAtual.senha" required="required">
					 </div>
				</div>
				<div class="form-group">
					 <label for="inputSenhaNova">Novo e-mail</label>
					 <div class="input-group">
					 	<span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
					 	<input class="form-control" id="inputSenhaNova" type="email" name="novoEmail" required="required">
					 </div>
				</div>
				<button type="submit" class="btn btn-primary btn-lg pull-right">Enviar</button>
			</form>
		</div>
		<div class="col-md-3 column">
		</div>
	</div>
</div>
</body>
</html>