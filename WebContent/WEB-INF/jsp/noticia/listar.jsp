<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>News!</title>
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
		<div class="row clearfix fundo" style="padding-bottom:35px;">
			<c:import url="../menu.jsp"></c:import>
			<div class="col-md-9 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value='/' />">Início</a> <span class="divider">/</span></li>
					<li class="active">${secao.titulo}</li>
				</ul>
				<!--  <h3 class="success">${vmessages.success.from('noticia.sucesso')}</h3>-->
				<c:forEach items="${noticiaList}" var="noticia">
					<div class="col-md-4 column">
						<a href="<c:url value="/noticia/ler/${noticia.id}"/>">
							<img class="img-rounded center-block" alt="140x140" width="140" height="140" src="<c:url value='/noticia/imagem/${noticia.imagem}'/>">
						</a>
						<h3 class="text-primary text-center">
							<a href="<c:url value="/noticia/ler/${noticia.id}"/>">${noticia.titulo}</a>
						</h3>
						<h5 class="text-muted text-center">
							<a href="<c:url value="/noticia/ler/${noticia.id}"/>">${noticia.subtitulo}</a>
						</h5>
					</div>
				</c:forEach>
			</div>
		</div>
		<c:import url="../footer.jsp"></c:import>
	</div>
</body>
</html>