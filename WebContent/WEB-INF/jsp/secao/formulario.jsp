<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>News!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
<link href="<c:url value='/css/estilo.css'/>" rel="stylesheet">


<link rel="shortcut icon" href="<c:url value='/img/quixada.png'/>">

<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>">
	
</script>
<script type="text/javascript"
	src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/scripts.js'/>"></script>
</head>
<body>
	<div class="container">
	<c:import url="../header.jsp"></c:import>
	<div class="row clearfix well">
		<div class="col-md-12 column">
			<h3 class="text-center text-primary">
				Cadastro de Seção
			</h3>
			<form action="<c:url value='/secao/adicionar'/>" class="row clearfix" role="form" method="POST">
				<div class="col-md-4 column"></div>
				<div class="col-md-4 column">
						<div class="form-group">
      						<label for="inputTitulo">Titulo</label>
      						<span style="color:red;">${errors.from('secao.titulo.invalido')}</span>
        					<input class="form-control" id="inputTitulo" name="secao.titulo" type="text" required="required">
    					</div>
						<div class="form-group">
      						<label for="inputDescricao">Descrição</label>
      						<span style="color:red;">${errors.from('secao.descricao.invalida')}</span>
        					<input class="form-control" id="inputDescricao" name="secao.descricao" type="text" required="required">
    					</div>
    					<div class="form-group pull-right">
        					<button type="reset" class="btn btn-default">Cancelar</button>
        					<button type="submit" class="btn btn-primary">Enviar</button>
    					</div>
				</div>
				<div class="col-md-4 column"></div>
			</form>
		</div>
	</div>
</div>
</body>
</html>