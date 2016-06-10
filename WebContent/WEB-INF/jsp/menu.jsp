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
</div>