<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Ler Notícia</title>
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

<div id="fb-root"></div>
<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1666563520239765',
      xfbml      : true,
      version    : 'v2.3'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/pt_BR/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>



	<div class="container">
	<c:import url="../header.jsp"></c:import>
	<div class="row clearfix fundo" style="padding-bottom:35px;">
		<c:import url="../menu.jsp"></c:import>
		<div class="col-md-9 column">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<ul class="breadcrumb">
						<li>
							<a href="<c:url value='/'/>">Início</a> <span class="divider">/</span>
						</li>
						<li>
							<a href="<c:url value='/noticia/listar/${noticia.secao.id}'/>">${noticia.secao.titulo}</a> <span class="divider">/</span>
						</li>
						<li class="active">
							${noticia.titulo}
						</li>
						<li>
					</ul>
					<h4 class="pull-right">
						<span class="label label-info"><fmt:formatDate value="${noticia.data}" pattern="dd/MM/yyyy"/></span>
					</h4>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-6 column">
					<img class="img-rounded center-block" alt="140x140" width="350" height="250" src="<c:url value='/noticia/imagem/${noticia.imagem}'/>">
				</div>
				<div class="col-md-6 column">
					<h1 class="text-primary">
						${noticia.titulo}
					</h1>
					<h4 class="text-muted">
						${noticia.subtitulo}
					</h4>
					<blockquote class="pull-left">
						<small><cite>${noticia.autor.nome}</cite></small>
					</blockquote>
					<c:if test="${(usuarioAutenticado.usuario.id == noticia.autor.id and usuarioAutenticado.papel.nivel == 2000) or usuarioAutenticado.papel.nivel == 3000}">
						<!--<a id="modal-65558" href="#modal-container-65558" role="button" class="btn" data-toggle="modal">Launch demo modal</a>-->
						<a id="modal-65558" class="btn btn-primary" role="button" href="#modal-container-65558" data-toggle="modal">Remover Notícia</a>
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
						<!--<a class="btn btn-primary" role="button" href="<c:url value='/usuario/remover/${noticia.id}'/>">Remover Notícia</a>-->
					</c:if>
				</div>
			</div>
			<div class="row clearfix" style="padding-top:30px;padding-bottom:20px;">
				<div class="col-md-12 column">
					<p style="text-align:justify; text-indent:50px; padding-left:25px; padding-right:25px;">
						${noticia.texto}
					</p>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-1 column"></div>
				<div class="col-md-5 column">
					<h2>Comentários</h2>
					<script type="text/javascript">
						jQuery(document).ready(function() {
  							jQuery('#fbcomments').attr('data-href', document.domain + window.location.pathname);
						});
					</script>
					<div id="fbcomments" class="fb-comments" data-href="" data-numposts="3" data-colorscheme="light"></div>
				<div class="col-md-1 column"></div>
			</div>
		</div>
	</div>
</div>
<c:import url="../footer.jsp"></c:import>
</div>
</body>
</html>