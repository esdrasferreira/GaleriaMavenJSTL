
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Produtos</title>
</head>
<body>

	<c:catch var="usuario"></c:catch>



	<div class="container">
		<div class="row">
			<nav class="navbar navbar-sticky-top navbar-light bg-light">
				<span class="navbar-brand mb-0 h1">PRODUCT UPDATE</span>
			</nav>
		</div>
		<div class="row">
			<br />
			<h6 style="color: blue; font-weight: bold;">
				Current user:
				${usuario.usuario}
			</h6>
		</div>

	</div>


	<nav class="navbar navbar-light bg-light">
		<div class="row">
			<div class="col" style="column-width: 10cm;"></div>

			<form class="form-inline" action="produto-controller" method="post">
				<input type="hidden" name="idProduto"
					value="${usuario.idproduto}"> <input type="hidden"
					name="comando" value="update"> <input
					class="form-control mr-sm-2" type="text" name="novoProduto"
					value="${usuario.produto}" style="background-color: white;"
					aria-label="Salvar">

				<button class="btn btn-outline-success my-2 my-sm-0"
					style="background-color: aqua;" type="submit">Salvar</button>
			</form>
		</div>


	</nav>
	<div class="container">
	<label style="font-size: large; font-weight: bolder; color: red;">
	<%
			String erro = (String) request.getAttribute("erros");
			if (erro != null) {
				out.println(erro);
				out.println("<br>");
			}
		%>
	
	</label>
		
	</div>



	<div class="container">


		<div class="row">
			<br />
		</div>
		<div class="row" style="margin: 5 mm;">
			<a class="btn btn-primary" href="produto-controller?comando=produtos"
				role="button">Visualizar todos os produtos</a>

		</div>
		<div class="row">
			<br />
		</div>
		<div class="row" style="font-style: italic;">
			<a class="btn btn-primary" href="login-controller?parametro=logout"
				role="button">Logout</a>
		</div>
	</div>




</body>
</html>