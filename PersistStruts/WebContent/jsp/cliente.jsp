<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<tiles:insertDefinition name="padrao">

<tiles:putAttribute name="corpo">

<h2>Cadastra Cliente</h2>

<s:form namespace="/cliente"  action="cadastraCliente" cssClass="form-horizontal well" theme="simple">
 <div class="form-group">
  	<label class="col-sm-2 control-label">Nome:</label>
 <div class="col-sm-10">
    <s:textfield  type="text" name="cliente.nome" required="required" cssClass="form-control" />
</div>
</div>



 <div class="form-group <s:if test="fieldErrors.containsKey('cliente.cpf')">has-error</s:if>">
  	<label class="col-sm-2 control-label">CPF:</label>
 <div class="col-sm-10">
          <s:textfield  type="text" name="cliente.cpf" cssClass="form-control  " />
          <s:fielderror fieldName="cliente.cpf"  cssClass="alert alert-danger"/>
          
      
  </div>
</div>	
 <div class="form-group">
  	<label class="col-sm-2 control-label">CNPJ:</label>
 <div class="col-sm-10">
     <s:textfield  type="text" name="cliente.cnpj" cssClass="form-control" />
  </div>
</div>	
 <div class="form-group">
  	<label class="col-sm-2 control-label">Tipo Cliente:</label>
 <div class="col-sm-10">
      <s:textfield  type="text" name="cliente.tipoCliente" required="required" cssClass="form-control" />
  </div>
</div>	
<div align="center">
<input type="hidden" value="${cliente.id}" name="cliente.id">
<input type="submit" class="btn btn-primary" value="Cadastra Usuario "  >
<a href="inicio" class="btn btn-success" >Voltar </a>
</div>

</s:form>
	
<s:actionmessage cssClass="alert alert-success" />
	 	

	<br><br>

		<%-- <s:form namespace="/cliente" action="pesquisarClienteNome">
			<div class="input-group" align="center">
				<input type="text" class="form-control" name="cliente.nome"
					placeholder="Nome Cliente">
				<div class="input-group-btn">
					<button class="btn btn-default glyphicon glyphicon-search"
						type="submit"></button>
				</div>
			</div>
		</s:form> --%>



	
<table class="table table-bordered table-hover">
 <thead>
        <tr>
          <th>id</th>
          <th>Nome</th>
           <th>CPF</th>
          <th style="text-align: center">Deletar</th>
          <th style="text-align: center">Editar</th>
           <th style="text-align: center">Imprimir</th>
           <th style="text-align: center">Imprimir Cone</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${listaCliente}" var="c" >
		<tr>
      	<td>
      		${c.id}
      	</td>
      	<td >
      	${c.nome}
      	</td>
      	 	<td >
      	${c.cpf}
      	</td>
      	<td style="text-align: center">
      	<s:form action="deleteCliente" namespace="/cliente">
      	<input type="hidden" value="${c.id}" name="cliente.id">
      	<button type="submit" class="btn btn-danger" value="del" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
      	</s:form>
      	</td>
      	<td style="text-align: center">
      	<s:form action="atualizaCliente" namespace="/cliente">
      	<input type="hidden" value="${c.id}" name="cliente.id">
      	<button type="submit" class="btn btn-success"  ><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button>
      	</s:form>
      	</td>
      	<td style="text-align: center">
      	<s:form action="processaRel" namespace="/cliente">
      	<input type="hidden" value="${c.id}" name="id">
      	<input type="hidden" value="rel02" name="codigo">
      
      	<button type="submit" class="btn btn-primary"  ><span class="glyphicon glyphicon-print" aria-hidden="true"></span></button>
      	</s:form>
      	</td>
      		<td style="text-align: center">
      			<s:form action="processaRel!relConection" >
      				<input type="hidden" value="${c.id}" name="id">
      				<input type="hidden" value="rel03" name="codigo">
     	     		<button type="submit" class="btn btn-primary"  ><span class="glyphicon glyphicon-print" aria-hidden="true"></span></button>
      			</s:form>
      		</td>
      	
      </tr>
		</c:forEach>
	
      
      
      
      
      </tbody>




</table>

	</tiles:putAttribute>
	</tiles:insertDefinition>
