<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html> 
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Produto</title>
<jsp:include page="../Fragmentos/Recursos.jspf"></jsp:include> 
</head> 
<body>
<jsp:include page="../Fragmentos/Cabecalho.jspf"></jsp:include> 
<div class="container">
		<h2>Manutenção de Produto</h2>
		<a href="ProdutoServlet?oper=novo" class="btn btn-info pull-right" title="Novo">Novo</a>
		
		<p>${requestScope.erro}</p>	
		
		<table id="example" class="table table-bordered table-hover">
			<thead>
				<th>#</th>
				<th>Nome</th>
				<th>Quantidade</th>
				<th>Preço</th>
				<th>Empresa</th>
				<th></th>
				<th></th>
			</thead>

			<c:forEach var="produto" items="${sessionScope.produtos}"
				varStatus="status">
				<tr>
					<td>${produto.id}</td>
					<td>${produto.nome}</td>
					<td>${produto.quantidade}</td>
					<td>${produto.preco}</td>
					<td>${produto.empresa.nome}</td>
					<td align="center">
					    <input type="button" value="Alterar" class="btn btn-info pull-center"
						onclick="location='ProdutoServlet?oper=alterar&id=${produto.id}';">
					</td>
					<td align="center">
					    <input type="button" value="Excluir" class="btn btn-danger pull-center" 
						onclick="if (confirm('Confirma exclusão?')) location='ProdutoServlet?oper=excluir&id=${produto.id}';">

					</td>
				</tr>
			</c:forEach>

		</table>
    
</body> 
</html> 