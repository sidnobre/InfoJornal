<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Esqueci a Senha</title>
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
						Solicitar nova senha
					</h1>
				</div>
			</div>
			<form action="<c:url value='/usuario/resetarSenha'/>" role="form" method="POST">
				<div class="form-group">
					 <label for="inputEmail">E-mail</label>
					 <span style="color:red;">${errors.from('usuario.email.invalido')}</span>
					 <div class="input-group">
					 	<span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
					 	<input class="form-control" id="inputEmail" type="email" name="usuario.email" required="required">
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