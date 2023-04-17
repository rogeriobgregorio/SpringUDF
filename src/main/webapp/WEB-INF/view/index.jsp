<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/normalize.css"></c:url>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="./resources/css/styles.css"></c:url>'>
<title>Funcionários e Dependentes</title>
</head>
<body>
	<h1>Funcionários e Dependentes</h1>

	<form action="index" method="post">
		<p>
			<button type="submit" name="botao">Listar
				Funcionários e Dependentes</button>
		</p>
	</form>

	<table>
		<thead>
			<tr>
				<th>Funcionário</th>
				<th>Dependentes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="funcionario" items="${funcionarios}">
				<tr>
					<td>${funcionario.nome}(R$${funcionario.salario})</td>
					<td>
						<ul>
							<c:forEach var="dependente" items="${funcionario.dependentes}">
								<li>${dependente.nome}(R$${dependente.salario})</li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="index" method="post">
		<p>
			<label for="codigo">Código do Funcionário:</label> <input
				type="number" name="codigo" id="codigo" required>
			<button type="submit" name="botao">Calcular
				Salários</button>
		</p>
	</form>

	<c:if test="${not empty somaSalarios}">
		<p>O somatório dos salários é: R$ ${somaSalarios}</p>
	</c:if>

</body>
</html>