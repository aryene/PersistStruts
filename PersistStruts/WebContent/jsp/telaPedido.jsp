<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"Pedido content="text/html; charset=UTF-8">
<title>Tela Pedido</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>


</head>

<body>


<div class="container">
<br>

	
<s:form action="novoPedido" namespace="/pedido" class="form-horizontal" theme="simple">
	<button type="submit" class="btn btn-primary btn-lg btn-block">Novo Pedido</button>
</s:form>

<br>
<br>
	<c:if test="${listaPedido != null}">


<table class="table table-bordered">
 <thead>
        <tr>
          <th>id</th>
          <th>Cliente</th>
          <th>Produto</th>
          <th>Data</th>
          <th>Excluir</th>
        </tr>
      </thead>
      <tbody>
      <c:set var="cont" value="0" ></c:set>
      <c:forEach items="${listaPedido}" var="p">
      	<tr>
     		<td>${p.id}</td>
      		<td>${p.cliente.nome}</td>
      		<td>
      		 <c:forEach items="${p.itemPedidos}" var="i">
      		 		${i.produto.descricao }&nbsp;&nbsp; - &nbsp;&nbsp; R$${i.valor } 
      		 		<br>
      		 </c:forEach>
      		</td>
      		<td>
			${p.data }
			</td>
      		<td>
				<s:form action="excluirPedido" namespace="/pedido">
      				<input type="hidden" value="${p.id}" name="pedido.id">
      				<button type="submit" class="btn btn-danger" value="del" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
      			</s:form>
			</td>
       		
      	</tr>
      </c:forEach>
      </tbody>
  
</table>
</c:if>
</div>




<div align="center">
	<a href="inicio" class="btn btn-success" >Voltar </a>
</div>

</body>
</html>