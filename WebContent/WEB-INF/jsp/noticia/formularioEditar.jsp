<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<link href="<c:url value='/css/img-preview.css'/>" rel="stylesheet">
	<link href="<c:url value='/css/bootstrap-select.min.css'/>" rel="stylesheet">

	<!--<link rel="shortcut icon" href="<c:url value='/img/quixada.png'/>"> -->

	<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jquery.maskedinput.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/simple-img-preview.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/ckeditor/ckeditor.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap-select.min.js'/>"></script>
</head>

<body>
<div class="container">
	<c:import url="../header.jsp"></c:import>
	<div class="row clearfix well">
		<div class="col-md-12 column">
			<h3 class="text-center text-primary">
				Editar notícia
			</h3>
			<c:if test="${not empty errors}">
				<div class="alert alert-dismissible alert-danger">
  					<button type="button" class="close" data-dismiss="alert">×</button>
        			<c:forEach var="error" items="${errors}">
            			<p class="text-center "><span class="glyphicon glyphicon-exclamation-sign"></span><strong> ${error.message}</strong></p>
        			</c:forEach>
    			</div>
			</c:if>
			<form action="<c:url value='/noticia/atualizar'/>" class="row clearfix" role="form" method="POST" enctype="multipart/form-data">
				<div class="col-md-1 column"></div>
				<div class="col-md-5 column">
						<input type="hidden" name="noticia.autor.id" value="${noticia.autor.id}" />
						<input type="hidden" name="noticia.id" value="${noticia.id}" />
						<div class="form-group">
							<label for="selectSecao">Seção</label><br>
							<select name="noticia.secao.id" id="selectSecao" class="selectpicker" data-style="btn-primary">
								<c:forEach items="${secaoList}" var="secaovar">
									<option value="${secaovar.id}">${secaovar.titulo}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
      						<label for="inputTitulo">Titulo</label>
        					<input class="form-control" id="inputTitulo" name="noticia.titulo" type="text" value="${noticia.titulo}">
    					</div>
						<div class="form-group">
      						<label for="inputSubtitulo">Subtitulo</label>
        					<input class="form-control" id="inputSubtitulo" name="noticia.subtitulo" type="text" value="${noticia.subtitulo}">
    					</div>
    					<div class="form-group">
      						<label for="inputData">Data</label>
      						<!--<span class="erro">${errors.from('noticia.data.invalida')}</span> -->
        					<input class="form-control" id="inputData" name="noticia.data" type="text" value=<fmt:formatDate value="${noticia.data}"/> >
        					<script type="text/javascript">
        						jQuery(function($){
       								$("#inputData").mask("99/99/9999");
								});
        					</script>
    					</div>
    					
    					<div class="form-group">
            				<img class="block-center img-rounded" id="imagemPreview" src="<c:url value='/noticia/imagem/${noticia.imagem}'/>" style="width: 300px; height: 300px;" />
            			</div>
						
						<div class="form-group">
            				<div class="input-group">
								<input type="file" id="inputImagem" name="imagem" style="display:none" value="<c:url value='/noticia/imagem/${noticia.imagem}'/>" onchange="PreviewImagem();">
								<input type="hidden" name="noticia.imagem" value="${noticia.imagem}"/>
								<input type="text" id="fake-file-input-name" disabled="disabled" placeholder="Nenhuma imagem selecionada" class="form-control">
								<span class="input-group-btn">
									<button id="fake-file-button-browse" type="button" class="btn btn-default" onclick="InputImagemClick();">
										<span class="glyphicon glyphicon-folder-open"> Procurar</span>
									</button>
								</span>
							</div>
            			</div>
				</div>
				<div class="col-md-5 column">
					<div class="form-group">
      					<label for="inputTexto">Texto</label>
        				<textarea class="form-control" name="noticia.texto" rows="25" id="inputTexto" required="required">${noticia.texto}</textarea>
        				<script type="text/javascript">
        					CKEDITOR.replace('inputTexto');
        				</script>
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