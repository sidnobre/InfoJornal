<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-3 column">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="text-center">Seções</h3>
		</div>
		<div class="list-group">
			<c:forEach items="${secaoList}" var="secao" >
				<a href="<c:url value='/noticia/listar/${secao.id}'/>" class="list-group-item">${secao.titulo}</a>
			</c:forEach>
		</div>
	</div>
	
	<!-- <div class="panel panel-warning">
		<div class="panel-heading">
			<h3 class="text-center">TESTES</h3>
		</div>
		<ul class="list-group">
			<li class="list-group-item"><a href="<c:url value='/secao/formulario'/>">Adicionar Seção</a></li>
    		<li class="list-group-item"><a href="<c:url value='/noticia/buscar'/>">Buscar Notícia</a></li>
    		<li class="list-group-item"><a href="<c:url value='/usuario/formularioJornalista'/>">Adicionar Jornalista</a></li>
           	<li class="list-group-item"><a href="<c:url value='/usuario/formularioEditor'/>">Adicionar Editor</a></li>
           	<li class="list-group-item"><a href="<c:url value='/classificado/formulario'/>">Adicionar Classificado</a></li>
		</ul>
	</div> -->
	
</div>