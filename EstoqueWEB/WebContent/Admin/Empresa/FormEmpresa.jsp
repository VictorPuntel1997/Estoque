<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>Form Empresa </title> 
   <jsp:include page="../Fragmentos/Recursos.jspf"></jsp:include> 
     
</head> 
<body> 
<jsp:include page="../Fragmentos/Cabecalho.jspf"></jsp:include>
 <p>${requestScope.erro}</p>
 
 <form action="EmpresaServlet" method="post">
        <input type="hidden" value="gravar" name="oper">

		<div class="container">


			<div class="form-group">
				<label>Id</label> 
				<input type="text" name="id" readonly="readonly" 
					class="form-control" placeholder="Auto"
					value="${requestScope.empresa.id}">
			</div>

			<div class="form-group">
				<label>Nome</label> <input type="text" name="nome" require
					class="form-control" placeholder="Informe o Nome da Empresa"
					value="${requestScope.empresa.nome}">
			</div>
			
			<div class="form-group">
				<label>Endereço</label> <input type="text" name="endereco" required
					class="form-control" placeholder="Informe o endereco"
					value="${requestScope.empresa.endereco}">
			</div>
			<div class="form-group">
				<label>Telefone</label> <input type="text" name="telefone" required
					class="form-control" placeholder="Informe o telefone"
					value="${requestScope.empresa.telefone}">
			</div>
			
			<div class="form-group">
				<label>CNPJ</label> <input type="text" name="cnpj" required
					class="form-control" placeholder="Informe o CNPJ"
					value="${requestScope.empresa.cnpj}">
			</div>
			
			<div class="form-group">
				<input type="submit" value="Gravar" class="btn btn-info pull-center">
				<input type="button" value="Cancelar" class="btn btn-info pull-center" onclick="location='EmpresaServlet'">
			</div>


		</div>
    
</body> 
</html> 