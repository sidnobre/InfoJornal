<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Classificados</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
	<link href="<c:url value='/css/estilo.css'/>" rel="stylesheet">

	<!--<link rel="shortcut icon" href="<c:url value='/img/quixada.png'/>"> -->

	<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>

</head>
<body>
	<div class="container">
		<c:import url="../header.jsp"></c:import>
		<div class="row clearfix fundo" style="padding-bottom:35px;">
			<c:import url="../menu.jsp"></c:import>
			<div class="col-md-9 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value='/' />">Início</a> <span class="divider">/</span></li>
					<li class="active">Lista de Classificados</li>
				</ul>
				<c:import url="alerts.jsp"></c:import>
				<c:forEach items="${classificadoList}" var="classificado">
				<div class="panel-group" id="panel-group-${classificado.id}">
					<div class="panel panel-default">
						<div class="panel-heading">
						 	<a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-group-${classificado.id}" href="#panel-element-${classificado.id}">
						 		${classificado.titulo}
						 		<span class="badge pull-right">Preço Inicial: ${classificado.preco}</span>
						 	</a>
						</div>
						<div id="panel-element-${classificado.id}" class="panel-collapse collapse">
							<div class="panel-body">
								<div class="row clearfix">
									<div class="col-md-5 column">
										<p>${classificado.texto}</p> 
										<address><strong><abbr title="Contato">Telefone:</abbr>${classificado.contato}</strong></address>
									</div>
									<div class="col-md-4 column">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h3 class="panel-title text-center">
													Última Oferta
												</h3>
											</div>
											<div class="panel-body">
												<c:if test="${classificado.valorOferta <= 0}">
													<p>Nenhuma oferta foi realizada para este anúncio. Aproveite! Seja o primeiro a ofertar.</p>
												</c:if>
												<c:if test="${classificado.valorOferta > 0}">
													<p><span class="badge">Valor: ${classificado.valorOferta}</span></p>
													<p><span class="badge">Data: ${classificado.dataOferta}</span></p>
													<p><span class="badge">Autor: ${classificado.autorOferta.nome}</span></p>
												</c:if>
											</div>
										</div>
									</div>
									<div class="col-md-3 column">
										<c:if test="${usuarioAutenticado.papel.nivel==1000}">
										<form action="<c:url value='/classificado/ofertar' />" role="form" method="POST">
											<input type="hidden" name="classificado.id" value="${classificado.id}"/>
											<input type="hidden" name="autor.id" value="${usuarioAutenticado.usuario.id}"/>
											<div class="form-group">
												<label for="inputOferta">Valor da Oferta</label>
												<c:if test="${classificado.valorOferta<=0}">
													<input class="form-control" id="inputOferta" name="oferta.valor" type="number" min="${classificado.preco}" title="Oferta deve ser maior que última oferta.">
												</c:if>
												<c:if test="${classificado.valorOferta>0}">
													<input class="form-control" id="inputOferta" name="oferta.valor" type="number" min="${classificado.valorOferta}" title="Oferta deve ser maior que última oferta.">
												</c:if>
											</div>
											<button type="submit" class="btn btn-primary pull-right">Ofertar</button>
										</form>
										</c:if>
										<c:if test="${empty usuarioAutenticado or usuarioAutenticado.papel.nivel!=1000}">
											<div class="alert alert-info">
												<p>Somente leitores autenticados podem realizar ofertas.</p>
											</div>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
		<c:import url="../footer.jsp"></c:import>
	</div>
</body>
</html>