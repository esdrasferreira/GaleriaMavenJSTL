<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Produtos Encontrados</title>
</head>
<body>

	<c:catch var="usuario"></c:catch>



	<div class="container">
		<div class="row">
			<nav class="navbar navbar-sticky-top navbar-light bg-light">
				<span class="navbar-brand mb-0 h1">Produtos Encontrados</span>
			</nav>
		</div>
		<div class="row">
			<br />
			<h6 style="color: blue;">
				Usuário logado:
				${usuario.usuario}
			</h6>
		</div>

	</div>

	<form action="produto-controller" method="get">
		<div class="container">

			<div class="form-inline">
				<div class="row">
					<label for="inputPassword2" class="sr-only">procurar</label> <input
						type="text" class="form-control" name="produtoSearch"
						id="${usuario.id}" placeholder="texto" value="">
					<button type="submit" class="btn btn-primary mb-2">Realizar
						Procura</button>
					<input type="hidden" name="comando" value="procura">

				</div>
			</div>

		</div>

	</form>



	<div class="container">
		<table class="table table-bordered table-dark">
			<thead class="thead-dark">
				<tr>
						<th scope="col">ID</th>
						<th scope="col">Produto</th>
						<th scope="col">Imagem</th>
						<th scope="col">Alterar nome produto</th>
						<th scope="col">Excluir produto</th>
						<th scope="col">Adicionar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="produto" items="${produtoList}">
				
				<tr>
						<td>${produto.id}</td>
						<td>${produto.produto}</td>
						<td>${produto.imagem}</td>
						<td><a
							href="produto-controller?comando=verimagen&idProduto=${produto.id}">link</a></td>
						<td><a
							href="produto-controller?comando=atualizar&idProduto=${produto.id}">Atualizar</a>
						</td>
						<td><a
							href="produto-controller?comando=excluir&idProduto=${produto.id}">Excluir</a>
						</td>
						<td>
						<a
							href="produto-controller?comando=imagem&idProduto=${produto.id}">Add imagem</a>
						</td>
					</tr>
				
					</c:forEach>



			</tbody>
		</table>
		<h6 style="color: white;">Páginas: 
			<c:forEach begin="1" end="${numPaginas}" var="i">
			
	<a href="produto-controller?numpagina=${i}">${i} </a> &nbsp;
	
	</c:forEach>
			
			</h6>
	</div>

	<div class="container">

		<div class="row" style="margin: 5 mm;">
			<a class="btn btn-primary" href="produto-controller?comando=add"
				role="button">Clique aqui para adicionar um produto...</a>

		</div>
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