<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>InfoJornal</title>
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
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h1 class="text-center text-primary">
					Informações da conta de usuário
				</h1>
			</div>
		</div>
		<c:if test="${not empty confirmations}">
			<div class="alert alert-dismissible alert-success">
  				<button type="button" class="close" data-dismiss="alert">×</button>
        		<c:forEach var="confirmation" items="${confirmations}">
        			<p class="text-center"><span class="glyphicon glyphicon-ok"></span><strong> ${confirmation.message}</strong></p>
        		</c:forEach>
    		</div>
		</c:if>
		<div class="col-md-3 column"></div>
		<div class="col-md-6 column well altura-min-form">
			<div class="row">
				<div class="col-md-4" >
		    		<img src="<c:url value='/img/user-placeholder.png'/>">
        		</div>
        
        		<div class="col-md-6">
            		<h4>${usuarioSessao.nome}</h4>
            		<h6>Tipo de conta: ${usuarioSessao.papel.descricao}</h6>
            		<h6>Email: ${usuarioSessao.usuario.email}</h6>
            		<h6>Login: ${usuarioSessao.usuario.login}</h6>
            		<h6>Senha: * * * * * *</h6>
        		</div>
        
        		<div class="col-md-2">
            		<div class="btn-group">
                		<a class="btn dropdown-toggle btn-info" data-toggle="dropdown" href="#">
                    		Ações
                    		<span class="icon-cog icon-white"></span><span class="caret"></span>
                		</a>
                	<ul class="dropdown-menu">
                    	<li><a href="<c:url value='/usuario/alterarEmail'></c:url>"><span class="icon-wrench"></span> Alterar E-mail</a></li>
                    	<li><a href="<c:url value='/usuario/alterarSenha'></c:url>"><span class="icon-trash"></span> Alterar Senha</a></li>
                	</ul>
            	</div>
            </div>
        </div>
		</div>
		<div class="col-md-3 column"></div>
	</div>
</div>
</body>
</html>