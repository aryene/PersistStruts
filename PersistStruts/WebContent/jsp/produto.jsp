<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tela Cliente</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>


<div class="container">
<br>
<s:form namespace="/produto"  action="cadastraProduto" cssClass="form-horizontal well" theme="simple">

 <div class="form-group">
  	<label class="col-sm-2 control-label">Produto:</label>
 <div class="col-sm-10">
           <s:textfield  type="text" name="produto.descricao" required="required" cssClass="form-control" />
     
  </div>
</div>
 <div class="form-group">
  	<label class="col-sm-2 control-label">Valor R$:</label>
 <div class="col-sm-10">
                 <s:textfield  type="text" name="produto.valor" required="required" cssClass="form-control" />
      
  </div>
</div>	

 <div class="form-group">
  	<label class="col-sm-2 control-label">Fornecedor do Produto:</label>
 <div class="col-sm-10">
<%-- <input type="hidden" name="fornecedor" value="${listaFornecedor}"> --%>
       <select class="form-control" name="produto.fornecedor.id" >
      <c:forEach items="${listaFornecedor}" var="f">
		<option value="${f.id}" >${f.nome}</option>
		<br>
      </c:forEach>
      </select> 
      
      
      
      
  </div>
</div>	
 

	
<div align="center">
<input type="submit" class="btn btn-primary" value="Cadastra"  >
<a href="inicio" class="btn btn-success" >Voltar </a>
</div>
</s:form>
	
	
	
	
	
<table class="table table-bordered table-hover">
 <thead>
        <tr>
          <th>id</th>
          <th>Descricao</th>
           <th>Valor</th>
          <th style="text-align: center">Deletar</th>
          <th style="text-align: center">Editar</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${produtos}" var="c" >
		<tr>
      	<td>
      		${c.id}
      	</td>
      	<td >
      	${c.descricao}
      	</td>
      	 	<td >
      	${c.valor}
      	</td>
      	<td style="text-align: center">
      	<s:form action="deletarProduto" namespace="/produto" >
      	<input type="hidden" value="${c.id}" name="produto.id">
      	<button type="submit" class="btn btn-danger" value="del" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
      	</s:form>
      	</td>
      	<td style="text-align: center">
      	<s:form action="alterarProduto" namespace="/produto" >
      	<input type="hidden" value="${c.id}" name="produto.id">
      	<button type="submit" class="btn btn-success"  ><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button>
      	</s:form>
      	</td>
      	
      </tr>
		</c:forEach>
	
      
      
      
      
      </tbody>




</table> 	


	

</div>
</body>
</html>