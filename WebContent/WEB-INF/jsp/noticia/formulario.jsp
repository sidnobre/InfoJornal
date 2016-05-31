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
<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/scripts.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.maskedinput.min.js'/>"></script>

</head>
<body>
<div class="container">
	<c:import url="../header.jsp"></c:import>
	<div class="row clearfix well">
		<div class="col-md-12 column">
			<h3 class="text-center text-primary">
				Cadastro de Notícia
			</h3>
			<form action="<c:url value='/noticia/adicionar'/>" class="row clearfix" role="form" method="POST" enctype="multipart/form-data">
				<div class="col-md-1 column"></div>
				<div class="col-md-5 column">
						<input type="hidden" name="autor.id" value="${usuarioAutenticado.usuario.id}" />
						<div class="form-group">
							<label for="selectSecao">Seção</label>
							<select name="secao.id" id="selectSecao">
								<c:forEach items="${secaoList}" var="secaovar">
									<option value="${secaovar.id}">${secaovar.titulo}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
      						<label for="inputTitulo">Titulo</label>
        					<input class="form-control" id="inputTitulo" name="noticia.titulo" type="text" required="required">
    					</div>
						<div class="form-group">
      						<label for="inputSubtitulo">Subtitulo</label>
        					<input class="form-control" id="inputSubtitulo" name="noticia.subtitulo" type="text" required="required">
    					</div>
    					<div class="form-group">
      						<label for="inputData">Data</label>
      						<span class="erro">${errors.from('noticia.data.invalida')}</span>
        					<input class="form-control" id="inputData" name="noticia.data" type="text" pattern="^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/([0-9]{4})$" title="Data Inválida" required="required">
        					<script type="text/javascript">
        						jQuery(function($){
       								$("#inputData").mask("99/99/9999");
								});
        					</script>
    					</div>
						<div class="form-group">
							 <label for="inputImagem">Imagem</label>
							 <input id="inputImagem" name="imagem" type="file" required="required">
						</div>
				</div>
				<div class="col-md-5 column">
					<div class="form-group">
      					<label for="inputTexto">Texto</label>
        				<textarea class="form-control" name="noticia.texto" rows="10" id="inputTexto" required="required"></textarea>
    				</div>
    				<div class="form-group pull-right">
        					<button type="reset" class="btn btn-default">Cancelar</button>
        					<button type="submit" class="btn btn-primary">Enviar</button>
    				</div>
				</div>
				<div class="col-md-1 column"></div>
			</form>
		</div>
	</div>
</div>
</body>
</html>