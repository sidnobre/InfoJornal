<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row clearfix fundo">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					<strong>QUIXADÁ News!</strong>  <small><em>Informação regional e mundial</em></small>
				</h1>
			</div>
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="<c:url value='/'/>">Início</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="<c:url value='/classificado/listar'/>">Classificados</a>
						</li>
						<li>
							<a href="#">Contato</a>
						</li>
					</ul>
					<div class="modal fade" id="modal-container-577817" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
							 		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">Realizar LogIn</h4>
								</div>
								<div class="modal-body">
									<form action="<c:url value='/autenticacao/login'/>" class="form-horizontal" role="form" method="post">
										<div class="form-group">
					 						<label for="inputLogin" class="col-sm-2 control-label">Login</label>
											<div class="col-sm-10">
												<input class="form-control" id="inputLogin" type="text" name="usuario.login" autofocus="autofocus">
											</div>
										</div>
										<div class="form-group">
					 						<label for="inputSenha" class="col-sm-2 control-label">Senha</label>
											<div class="col-sm-10">
												<input class="form-control" id="inputSenha" type="password" name="usuario.senha">
											</div>
										</div>
										<div class="form-group">
					 						<label for="inputPapel" class="col-sm-2 control-label">Tipo de Usuário</label>
											<div class="col-sm-10">
												<select class="form-control" id="inputPapel" name="papel">
													<option value="1">Leitor</option>
													<option value="2">Jornalista</option>
													<option value="3">Editor</option>
												</select>
											</div>
										</div>
										<div class="modal-footer">
											<div class="form-group">
												<div class="col-sm-offset-2 col-sm-10">
													<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						 							<button type="submit" class="btn btn-primary">LogIn</button>
												</div>
											</div>
							 				<!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> <button type="button" class="btn btn-primary">Save changes</button>-->
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					
					<c:if test="${empty usuarioAutenticado or not usuarioAutenticado.autenticado}">
						<!--<h3>Você não está autenticado no sistema.</h3>-->
				
						<ul class="nav navbar-nav navbar-right">
							<li>
								<a id="modal-577817" href="#modal-container-577817" role="button" class="btn" data-toggle="modal">LogIn</a>
							</li>
							<li>
								<a id="btnCadastro" href="<c:url value='/usuario/formularioLeitor'/>" role="button" class="btn">Cadastrar-se</a>
							</li>
							<!--<li>
								<a id="btnCadastro" href="<c:url value='/usuario/formularioJornalista'/>" role="button" class="btn">Cadastrar Jornalista</a>
							</li> -->
						</ul>
					</c:if>
					
					<c:if test="${usuarioAutenticado.autenticado}">
						<c:if test="${usuarioAutenticado.papel.nivel == 1000}">
							<ul class="nav navbar-nav navbar-right">
         						<li class="dropdown" style="min-width:175px"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${usuarioAutenticado.nome}<span class="caret"></span></a>
          							<ul class="dropdown-menu" role="menu" style="min-width: 175px">
           					 			<li><a href="<c:url value='/autenticacao/logout'/>">Sair</a></li>
          							</ul>
          						</li>
          						<li>
          							<a>[ ${usuarioAutenticado.papel.descricao} ]</a>
          						</li>
        					</ul>
						</c:if>
						
						<c:if test="${usuarioAutenticado.papel.nivel == 2000}">
							<ul class="nav navbar-nav navbar-right">
         						<li class="dropdown" style="min-width:200px"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${usuarioAutenticado.nome}<span class="caret"></span></a>
          							<ul class="dropdown-menu" role="menu" style="min-width: 200px">
            							<li><a href="<c:url value='/noticia/formulario'/>">Adicionar Notícia</a></li>
           					 			<li class="divider"></li>
           					 			<li><a href="<c:url value='/autenticacao/logout'/>">Sair</a></li>
          							</ul>
          						</li>
          						<li>
          							<a>[ ${usuarioAutenticado.papel.descricao} ]</a>
          						</li>
        					</ul>
						</c:if>
						
						<c:if test="${usuarioAutenticado.papel.nivel == 3000}">
							<ul class="nav navbar-nav navbar-right">
         						<li class="dropdown" style="min-width:200px"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${usuarioAutenticado.nome}<span class="caret"></span></a>
          							<ul class="dropdown-menu" role="menu" style="min-width: 200px">
           					 			<li><a href="<c:url value='/secao/formulario'/>">Adicionar Seção</a></li>
            							<li><a href="<c:url value='/usuario/formularioJornalista'/>">Adicionar Jornalista</a></li>
            							<li><a href="<c:url value='/classificado/formulario'/>">Adicionar Classificado</a></li>
           					 			<li class="divider"></li>
           					 			<li><a href="<c:url value='/autenticacao/logout'/>">Sair</a></li>
          							</ul>
          						</li>
          						<li>
          							<a>[ ${usuarioAutenticado.papel.descricao} ]</a>
          						</li>
        					</ul>
						</c:if>
					</c:if>
				</div>
			</nav>
		</div>
	</div>