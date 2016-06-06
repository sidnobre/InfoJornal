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
<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
<link href="<c:url value='/css/estilo.css'/>" rel="stylesheet">


<!-- <link rel="shortcut icon" href="<c:url value='/img/quixada.png'/>"> -->

<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/scripts.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.maskedinput.min.js'/>"></script>

</head>

<body>
	<div class="container">
	<c:import url="../header.jsp"></c:import>
	<div class="row clearfix well">
		<div class="col-md-12 column">
			<h3 class="text-center text-primary">Buscar notícias</h3>
			<div class="tabbable" id="tabs-604805">
				<ul class="nav nav-tabs">
					<li class="active">
						<a href="#panel-824432" data-toggle="tab">Por data</a>
					</li>
					<li >
						<a href="#panel-862197" data-toggle="tab">Por título</a>
					</li>
					<li>
						<a href="#panel-862198" data-toggle="tab">Por autor</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-824432">
						<form action="<c:url value='/noticia/buscar/por-data'/>" role="form" method="POST">
							<div class="form-group">
      						<label for="inputDataInicio">Data do Início</label>
      						<span class="erro">${errors.from('noticia.data.invalida')}</span>
        					<input class="form-control" id="inputDataInicio" name="dataInicio" type="text" pattern="^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/([0-9]{4})$" title="Data Inválida" required="required">
        					<script type="text/javascript">
        						jQuery(function($){
       								$("#inputDataInicio").mask("99/99/9999");
								});
        					</script>
        					</div>
        					
        					<div class="form-group">
        					<label for="inputDataFinal">Data do Final</label>
      						<span class="erro">${errors.from('noticia.data.invalida')}</span>
        					<input class="form-control" id="inputDataFinal" name="dataFinal" type="text" pattern="^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/([0-9]{4})$" title="Data Inválida" required="required">
        					<script type="text/javascript">
        						jQuery(function($){
       								$("#inputDataFinal").mask("99/99/9999");
								});
        					</script>
    						</div>
    						
    						<div class="form-group pull-right">
								<button type="reset" class="btn btn-default">Cancelar</button>
								<button type="submit" class="btn btn-primary">Enviar</button>
							</div>
    					</form>
					</div>
						<div class="tab-pane " id="panel-862197">
							<form action="<c:url value='/secao/adicionar'/>"
								class="row clearfix" role="form" method="POST">
								<div class="col-md-4 column"></div>
								<div class="col-md-4 column">
									<div class="form-group">
										<label for="inputTitulo">Titulo</label> <span
											style="color: red;">${errors.from('secao.titulo.invalido')}</span>
										<input class="form-control" id="inputTitulo"
											name="secao.titulo" type="text" required="required">
									</div>
									<div class="form-group">
										<label for="inputDescricao">Descrição</label> <span
											style="color: red;">${errors.from('secao.descricao.invalida')}</span>
										<input class="form-control" id="inputDescricao"
											name="secao.descricao" type="text" required="required">
									</div>
									<div class="form-group pull-right">
										<button type="reset" class="btn btn-default">Cancelar</button>
										<button type="submit" class="btn btn-primary">Enviar</button>
									</div>
								</div>
								<div class="col-md-4 column"></div>
							</form>
						</div>
						<div class="tab-pane " id="panel-862198">
						<p>
							conteudo 3
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>