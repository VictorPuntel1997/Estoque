<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<!-- Bootstrap -->
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Estilos personalizados da página -->
<link href="resources/estilos.css" rel="stylesheet">
<!-- jQuery (necessário para os plugins Javascript do Bootstrap) -->
<script src="resources/jquery.min.js"></script>
<!-- Incluir plugins do Bootstrap -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<form action="LoginServlet" method="post">
	<div class="panel panel-default" style="width: 300px;">
		<div class="panel-heading">
			<!-- cabeçalho do painel -->
		</div>
		<div class="panel-body">
			<div class="panel-body">
				<div class="row">
					<div>
						<label for="id">Login:</label> <input type="text" name="login"
							class="form-control" placeholder="Login">
					</div>
				</div>

				<div class="row">
					<div>
						<label for="senha">Senha:</label> <input type="password"
							name="senha" id="senha" class="form-control" placeholder="Senha">
					</div>
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<div class="panel-footer">
				<div class="row">
					<div>
						<button type="submit" class="submit btn btn-default btn-lg">
							<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
							Login
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>
