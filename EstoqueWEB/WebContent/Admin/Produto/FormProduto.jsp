<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>Form Produto</title>
   <jsp:include page="../Fragmentos/Recursos.jspf"></jsp:include> 
     
</head> 
<body> 
<jsp:include page="../Fragmentos/Cabecalho.jspf"></jsp:include>
 <p>${requestScope.erro}</p>
 <form action="ProdutoServlet" method="post">
        <input type="hidden" value="gravar" name="oper">

		<div class="container">


			<div class="form-group">
				<label>Id</label> 
				<input type="text" name="id" readonly="readonly" 
					class="form-control" placeholder="Auto"
					value="${requestScope.produto.id}">
			</div>

			<div class="form-group">
				<label>Nome</label> <input type="text" name="nome" require
					class="form-control" placeholder="Informe o Nome do Produto"
					value="${requestScope.produto.nome}">
			</div>
			<div class="form-group">
				<label>Quantidade</label> <input type="text" name="quantidade" required
					class="form-control" placeholder="Informe a Quantidade"
					value="${requestScope.produto.quantidade}">
			</div>
			<div class="form-group">
				<label>Preço</label> <input type="text" name="porte" required
					class="form-control" placeholder="Informe o preço"
					value="${requestScope.produto.preco}">
			
			<div class="form-group">
				<label>Empresa</label> 
				<select name="empresa" class="form-control">
					<c:forEach var="empresa" items="${requestScope.empresas}" varStatus="status">
				    	<c:choose> 
				    		<c:when test="${requestScope.produto.empresa.id == empresa.id}">
				    		    <option value="${empresa.id}" selected="selected">${empresa.nome}</option>
				    		</c:when>
				    	    <c:otherwise>
				    	        <option value="${empresa.id}">${empresa.nome}</option>    
				    	    </c:otherwise>
				    	</c:choose>
				    </c:forEach>
				</select>
			</div>
			
			

			<div class="form-group">
				<input type="submit" value="Gravar" class="btn btn-info pull-center">
				<input type="button" value="Cancelar" class="btn btn-info pull-center" onclick="location='ProdutoServlet'">
			</div>


		</div>
		
</body>
    
</body> 
</html> 