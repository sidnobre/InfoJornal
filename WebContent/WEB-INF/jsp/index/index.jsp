<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  
	<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"> </script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
</head>

<body>
<div class="container">

	<jsp:include page="../header.jsp"></jsp:include>
	
	<div class="row clearfix fundo" style="padding-bottom:35px;">
		<jsp:include page="../menu.jsp"></jsp:include>
		<div class="col-md-9 column">
			<div class="row clearfix">
				<c:import url="alerts.jsp"></c:import>
				<h2 class="text-primary text-center">EM DESTAQUE</h2>
				<c:forEach var="noticia" items="${noticiaList}">
					<div class="col-md-4 column altura-min">
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
	</div>
	
	<jsp:include page="../footer.jsp"></jsp:include>
	
</div>
</body>
</html>
