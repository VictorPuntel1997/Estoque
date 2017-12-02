<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>List Empresa</title> 
   <jsp:include page="../Fragmentos/Recursos.jspf"></jsp:include>
   
</head> 
<body> 
    <jsp:include page="../Fragmentos/Cabecalho.jspf"></jsp:include>
	
	<div class="container">
		<h2>Manutenção de Empresa</h2>
		<a href="EmpresaServlet?oper=novo" class="btn btn-info pull-right" title="Novo">Novo</a>
		
		<p>${requestScope.erro}</p>	
		
		<table id="example" class="table table-bordered table-hover">
			<thead>
				<th>#</th>
				<th>Nome</th>
				<th>Endereço</th>
				<th>Telefone</th>
				<th>CNPJ</th>
				<th></th>
				<th></th>
			</thead>

			<c:forEach var="empresa" items="${sessionScope.empresas}"
				varStatus="status">
				<tr>
					<td>${empresa.id}</td>
					<td>${empresa.nome}</td>
					<td>${empresa.endereco}</td>
					<td>${empresa.telefone}</td>
					<td>${empresa.cnpj}</td>
					<td align="center">
					    <input type="button" value="Alterar" class="btn btn-info pull-center"
						onclick="location='EmpresaServlet?oper=alterar&id=${empresa.id}';">
					</td>
					<td align="center">
					    <input type="button" value="Excluir" class="btn btn-danger pull-center" 
						onclick="if (confirm('Confirma exclusão?')) location='EmpresaServlet?oper=excluir&id=${empresa.id}';">

					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body> 
</html> 