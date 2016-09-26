<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%> 

<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tela Fornecedor</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
<br>
<s:form namespace="/fornecedor"  action="cadastraFornecedor" cssClass="form-horizontal" theme="simple" >
 <div class="form-group">
  	<label class="col-sm-2 control-label">Nome Fornecedor:</label>
 <div class="col-sm-10">
     <!-- <input type="text" name="fornecedor.nome" required="required" class="form-control" >  -->
       <s:textfield  type="text" cssClass="form-control"  name="fornecedor.nome" required="required" />
   </div>
</div>
 
<div align="center">
<input type="hidden" value="${fornecedor.id}" name="fornecedor.id">
<input type="submit" class="btn btn-primary" value="Cadastra Fornecedor"  >
<a href="inicio" class="btn btn-success" >Voltar </a>
</div>

</s:form>


<s:actionmessage cssClass="alert alert-success" />


	
<table class="table table-bordered table-hover">
 <thead>
        <tr>
          <th>id</th>
          <th>Nome</th>
          <th style="text-align: center">Deletar</th>
          <th style="text-align: center">Editar</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${fornecedores }" var="f" >
		<tr>
      	<td>
      		${f.id}
      	</td>
      	<td >
      	${f.nome}
      	</td>
      	 	
      	<td style="text-align: center">
      	<s:form action="deletarFornecedor" namespace="/fornecedor">
      	<input type="hidden" value="${f.id}" name="fornecedor.id">
      	<button type="submit" class="btn btn-danger" value="del" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
      	</s:form>
      	</td>
      	<td style="text-align: center">
      	<s:form action="alterarFornecedor" namespace="/fornecedor">
      	<input type="hidden" value="${f.id}" name="fornecedor.id">
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