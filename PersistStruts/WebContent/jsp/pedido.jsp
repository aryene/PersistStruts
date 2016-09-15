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


<script type="text/javascript">
            $(function () {
     
                $('#datepicker').datepicker();
            });
        </script>
</head>

<body>


<div class="container">
<br>

	
<s:form action="cadastraPedido" namespace="/pedido" class="form-horizontal" theme="simple">
 
 <div class="form-group">
  	<label class="col-sm-2 control-label">Cliente:</label>
 <div class="col-sm-10">
            <select class="form-control" name="pedido.cliente.id"  >
      <c:forEach items="${listaCliente}" var="c">
		<option value="${c.id}" >${c.nome}</option>
		<br>
      </c:forEach>
      </select> 
  </div>
</div>
 <div class="form-group">
  	<label class="col-sm-2 control-label">Data:</label>
 	 <div class="col-sm-10">
         <input type="text" name="pedido.data" id="datepicker"  class="form-control" />
  </div>
</div>	

<table class="table table-bordered table-hover">
 <thead>
        <tr>
          <th>id</th>
          <th>Descricao</th>
           <th>Valor</th>
          <th style="text-align: center;width: 10px; " >Quantidade</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${listaProduto}" varStatus="i" var="c" >
		<tr>
      	<td>
      		${c.id}
      		  	<input type="hidden" name="listaItem[${i.index}].pk.produtoId" value="${c.id}" >
      		<%--   	<input type="hidden" name="listaItem[${i.index}].produto.produtoId" value="${c.id}" >
      		 --%>  	
      	</td>
      	<td >
      	${c.descricao}
      	</td>
      	 	<td >
      	${c.valor}
      	      	<input type="hidden" name="listaItem[${i.index}].valor" value="${c.valor}" >
      	</td>
      	<td style="text-align: center">
         	<input type="text" name="listaItem[${i.index}].quantidade"  class="form-control" />
      	</td>
      </tr>
		</c:forEach>     
      </tbody>




</table> 





	<div align="center">
<input type="submit" class="btn btn-primary" value="Cadastra Pedido "  >
<a href="telaPedido" class="btn btn-success" >Voltar </a>
</div>
</s:form>



 

      <%-- 		 
	
	<c:if test="${pedido != null}">


${pedido.data}


<table class="table table-bordered">
 <thead>
        <tr>
          <th>id</th>
          <th>Produto</th>
          <th>Valor Unitario</th>
          <th>Quantidade</th>
          <th>Add</th>
        </tr>
      </thead>
      <tbody>
      <c:set var="cont" value="0" ></c:set>
      <c:forEach items="${listaProduto}" var="p">
      	<tr>
      	<form action="adicionaItemPedido">
      		<td>${p.id}</td>
      		<td>${p.descricao}</td>
      		<td>${p.valor}</td>
      		<td><input type="text" name="quantidade"> </td>
      		<td><input type="submit" value="Comprar" > </td>
      		<input type="hidden" name="pk.pedidoId" value="${pedido.id}" >
   			<input type="hidden" name="pk.produtoId" value="${p.id}" >
       		</form> 
      	</tr>
      		${cont }---conta
      	<c:set var="cont" value="${cont+1 }" ></c:set>
      
      </c:forEach>
      </tbody>
  
</table










	<div align="center">
<a href="index" class="btn btn-success" >Voltar </a>
</div>

 </c:if>
 
 	<c:if test="${pedido != null}">
 
 <form action="adicionaPedidoGeral">

	 <table class="table table-bordered">
	 <thead>
	        <tr>
	          <th>id</th>
	          <th>Produto</th>
	          <th>Valor Unitario</th>
	          <th>Quantidade</th>
	        </tr>
	      </thead>
	      <tbody>
	      <c:set var="cont" value="0" ></c:set>
	      <c:forEach items="${listaProduto}"  var="p" varStatus="i">
	      	<tr>
	       		<td>${p.id}</td>
	      		<td>${p.descricao}</td>
	      		<td>${p.valor}</td>
	      		<td><input type="text" name="itemPedidos[${i.index}].quantidade"> </td>
	   			<input type="hidden" name="itemPedidos[${i.index}].pk.pedidoId" value="${pedido.id}" >
	   			<input type="hidden" name="itemPedidos[${i.index}].pk.produtoId" value="${p.id}" >
	       		</form> 
	      	</tr>
	   
	      </c:forEach>
	      </tbody>
	  
	</table> 
	<input type="hidden" name="id" value="${pedido.id}" >
	<input type="hidden" name="cliente.id" value="${pedido.cliente.id}" >
	<input type="submit" value="Compra Geral" > s${pedido.id}
	
	</form>
 </c:if>
 
 
 
 
 

 
 <c:forEach items="${pedido.itemPedidos}" var="i">
${i.produto.descricao}
</c:forEach>
  --%>


</body>
</html>