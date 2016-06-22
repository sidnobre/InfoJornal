<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Esqueci a Senha</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<meta name="description" content="">
  	<meta name="author" content="">

	<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
	<link href="<c:url value='/css/estilo.css'/>" rel="stylesheet">
  
	<!--<link rel="shortcut icon" href="<c:url value='/img/quixada.png'/>"> -->
  
	<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"> </script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
</head>

<body>
<div class="container">
	<c:import url="../header.jsp"></c:import>

	<div class="row clearfix well">
		<div id="loginbox" style="margin-top:20px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
        	<div class="panel panel-info">
            	<div class="panel-heading">
                	<div class="panel-title"><h3>Realizar Login</h3></div>
                    	<div style="float:right; font-size: 90%; position: relative; top:-10px"><a href="<c:url value='/usuario/esqueciSenha'/>">Esqueceu sua senha?</a></div>
					</div>

					<div style="padding-top:30px" class="panel-body" >

						<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

						<form id="loginform" action="<c:url value='/autenticacao/login'/>" class="form-horizontal" role="form" method="post">
							
							<label for="inputLogin">Login</label>
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
								<input id="inputLogin" type="text" class="form-control" name="usuario.login" autofocus="autofocus">                                        
							</div>
							
							<label for="inputSenha">Senha</label>
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
								<input id="inputSenha" type="password" class="form-control" name="usuario.senha">
							</div>
							
							<label for="inputPapel">Tipo</label>
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span>
								<!--<div class="col-sm-10">-->
									<select class="form-control" id="inputPapel" name="papel">
										<option value="1">Leitor</option>
										<option value="2">Jornalista</option>
										<option value="3">Editor</option>
									</select>
								<!--</div>-->
							</div>

							<div style="margin-top:10px" class="form-group">
								<div class="col-sm-12 controls">
									<!--<a href="<c:url value='/autenticacao/login'/>" class="btn btn-primary pull-right">Login</a> -->
									<button type="submit" class="btn btn-primary btn-lg pull-right">Login</button>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-12 control">
									<div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
										Ainda não é cadastrado? 
										<a href="<c:url value='/usuario/formularioLeitor'/>">Cadastre-se</a>
									</div>
								</div>
							</div>    
						</form>
					</div>
				</div>  
			</div> 
		</div>
	</div>
</body>
</html>