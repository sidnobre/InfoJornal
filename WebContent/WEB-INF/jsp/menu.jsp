<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-3 column">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="text-center">Seções</h3>
		</div>
		<div class="list-group">
			<!-- <a href="<c:url value='/noticia/listar'/>" class="list-group-item">Todas</a> -->
			<c:forEach items="${secaoList}" var="secao" >
				<a href="<c:url value='/noticia/listar/${secao.id}'/>" class="list-group-item">${secao.titulo}</a>
			</c:forEach>
			<!--<a href="<c:url value='/secao/formulario'/>" class="list-group-item">Adicionar Seção</a>-->
		</div>
	</div>
</div>