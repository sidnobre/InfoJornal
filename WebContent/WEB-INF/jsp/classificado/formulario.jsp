<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Cadastrar Classificados</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
	<link href="<c:url value='/css/estilo.css'/>" rel="stylesheet">

	<!--<link rel="shortcut icon" href="<c:url value='/img/quixada.png'/>">-->

	<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jquery.maskedinput.min.js'/>"></script>
</head>

<body>
<div class="container">
	<c:import url="../header.jsp"></c:import>
	<div class="row clearfix well">
		<div class="col-md-12 column">
			<h3 class="text-center text-primary">
				Cadastro de Classificado
			</h3>
			<c:if test="${not empty errors}">
				<div class="alert alert-dismissible alert-danger">
  					<button type="button" class="close" data-dismiss="alert">×</button>
        			<c:forEach var="error" items="${errors}">
            			<p class="text-center "><span class="glyphicon glyphicon-exclamation-sign"></span><strong> ${error.message}</strong></p>
        			</c:forEach>
    			</div>
			</c:if>
			<form action="<c:url value='/classificado/adicionar'/>" class="row clearfix" role="form" method="POST">
				<div class="col-md-2 column"></div>
				<div class="col-md-8 column">
					<div class="form-group">
      					<label for="inputTitulo">Titulo</label>
        				<input class="form-control" id="inputTitulo" name="classificado.titulo" type="text" required="required">
    				</div>
    				<div class="form-group">
      					<label for="inputTelefone">Telefone de Contato</label>
        				<input class="form-control" id="inputTelefone" name="classificado.contato" type="tel" required="required">
        				<script type="text/javascript">
        					jQuery(function($){
       							$("#inputTelefone").mask("(99) 99999-9999");
							});
        				</script>
    				</div>
    				<div class="form-group">
      					<label for="inputPreco">Preço Inicial</label>
        				<input class="form-control" id="inputPreco" name="classificado.preco" type="number" min="0" required="required">
    				</div>
    				<div class="form-group">
      					<label for="inputTexto">Texto</label>
        				<textarea class="form-control" name="classificado.texto" rows="5" id="inputTexto" required="required"></textarea>
    				</div>
    				<div class="form-group pull-right">
        				<button type="reset" class="btn btn-default">Cancelar</button>
        				<button type="submit" class="btn btn-primary">Enviar</button>
    				</div>
				</div>
				<div class="col-md-2 column"></div>
			</form>
		</div>
	</div>
</div>
</body>
</html>