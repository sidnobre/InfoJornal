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

	<!-- <link rel="shortcut icon" href="<c:url value='/img/quixada.png'/>"> -->

	<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jquery.maskedinput.min.js'/>"></script>
</head>

<body>
	<div class="container">
		<c:import url="../header.jsp"></c:import>
		<div class="row clearfix well">
			<div class="col-md-12 column">
				<h3 class="text-center text-primary">Resultado da busca</h3>
				<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>Autor</th>
						<th>Título</th>
						<th>Data</th>
						<th>Editar</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${noticiaList}" var="noticia">
						<tr>
							<td>
								${noticia.autor.nome}
							</td>
							<td>
								<a href="<c:url value='/noticia/ler/${noticia.id}'/>">${noticia.titulo}</a>
							</td>
							<td>
								<fmt:formatDate value="${noticia.data}" pattern="dd/MM/yyyy"/>
							</td>
							<c:choose>
								<c:when test="${(usuarioSessao.usuario.id == noticia.autor.id and usuarioSessao.papel.nivel == 2000) or usuarioSessao.papel.nivel == 3000}">
									<td>
										<a class="btn btn-sm btn-block btn-success" role="button" href="<c:url value='/noticia/editar/${noticia.id}'/>" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></a>
									</td>
									<td>
										<a id="modal-${noticia.id}" class="btn btn-sm btn-block btn-danger" role="button" href="#modal-container-${noticia.id}" data-toggle="modal"><span class="glyphicon glyphicon-trash"></span></a>
										<div class="modal fade" id="modal-container-${noticia.id}" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
							 							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
														<h4 class="modal-title" id="myModalLabel">Confirmação</h4>
													</div>
													<div class="modal-body">
														Confirma a remoção da notícia?
													</div>
													<div class="modal-footer">
														<form action="<c:url value='/noticia/remover/${noticia.id}'/>">
															<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
															<button type="submit" class="btn btn-danger">Remover</button>
														</form>
													</div>
												</div>
											</div>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<a class="btn btn-sm btn-block btn-success disabled" role="button" href="#" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></a>
									</td>
									<td>
										<a class="btn btn-sm btn-block btn-danger disabled" role="button" href="#" data-toggle="modal"><span class="glyphicon glyphicon-trash"></span></a>
									</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
			
			
			<div class="modal fade" id="modal-container-65558" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
							 			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<h4 class="modal-title" id="myModalLabel">Confirmação</h4>
									</div>
									<div class="modal-body">
										Confirma a remoção da notícia?
									</div>
									<div class="modal-footer">
										<form action="<c:url value='/noticia/remover/${noticia.id}'/>">
											<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
											<button type="submit" class="btn btn-primary">Remover</button>
										</form>
									</div>
								</div>
							</div>
						</div>
			
			
			
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-6">
					<ul class="pagination pagination-lg">
						<li><a href="#">Prev</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">Next</a></li>
					</ul>
				</div>
				<div class="col-md-2"></div>
			</div> 
		</div>
	</div>
</div>
			</div>
		</div>
	</div>
</body>
</html>