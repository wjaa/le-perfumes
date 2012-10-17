<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>


<c:set var="modelo" value="${requestScope.modeloBusca}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<!-- cabeçalho com javascript e stilos -->
	<wjaa:header/>

</head>
<body>
	<div id="DivGeral">
	
	<!-- menu -->
	<wjaa:menu/>
	
	<!-- feedback -->
	<wjaa:feedback descricao="Home\Clientes\Busca" />
	
	<div id="DivConteudo">

	<div id="divConteudo">
		<div id="divTextoConteudo">Busca de Clientes </div>
		<br>
		
		<form action="manterCliente.do?dispatch=buscarCliente" method="post">
			
			<table>
				<tr>
					<td Class="Fonte01">&nbsp;&nbsp;&nbsp;Nome</td>
					<td Class="Fonte01">&nbsp;&nbsp;&nbsp;Cpf</td>
					<td Class="Fonte01">&nbsp;&nbsp;&nbsp;Fone</td>
					<td Class="Fonte01">&nbsp;&nbsp;&nbsp;Local Trabalho</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;<input type="text" id="nome" name="nome" class="input" size="30" class="input"></td>
					<td>&nbsp;&nbsp;<input type="text" id="cpf" name="cpf" class="input" size="30" class="input"></td>
					<td>&nbsp;&nbsp;<input type="text" id="fone" name="fone" class="input" size="30" class="input"></td>
					<td>&nbsp;&nbsp;<input type="text" id="localTrab" name="localTrab" class="input" size="30" class="input"></td>
					
				</tr>
				<tr>
					<td>&nbsp; <input type="submit" value="Pesquisar Cliente"  class="button" > </td>		
				</tr>
			</table>
			
			 
			
	
</form>	
<br>

<center>
<div> <!-- Div display tag -->

<display:table id="listCliente" name="${modeloBusca.clienteVo}" sort="list" pagesize="5" export="false"  class="displaytag"
requestURI="manterCliente.do?dispatch=buscarCliente">

	<display:column property="idCliente" title="Id" sortable="true"/>
	<display:column property="nomeFull" title="Nome" sortable="true"  />
	<display:column property="cpf" title="Cpf" sortable="true"  />
	<display:column property="fone1" title="Fone 1" sortable="true"  />
	<display:column property="fone2" title="Fone 2" sortable="true"  />
	<display:column property="contato" title="Contato" sortable="true"  />
	<display:column title="Ação"><a href="manterCliente.do?dispatch=editarCliente&idCliente=${listCliente.idCliente}">Alterar</a>&nbsp;&nbsp;<a href="#" onclick="removerCliente(${listCliente.idCliente});">Remover</a></display:column>
	

</display:table>


</div> <!-- FIM Div display tag -->			

</center>
	
	</div>
	</div>
	
		<!-- rodape -->
		<wjaa:rodape/>
	</div>
	
	</body>

<script type="text/javascript">

var c = document.forms[0];

MaskInput(c.cpf, "999.999.999-99");


function removerCliente(idCliente){
	jConfirm('Deseja realmente remover esse cliente?', 'Pergunta', function(r) {
		
		if(r){

			$.post("/controle/manterCliente.do?",{dispatch: "removerCliente",
				idCliente: idCliente},
	
				function(data){
				
					if(data == 'true'){
						document.location.href = "manterCliente.do?dispatch=buscarCliente&cpf=${requestScope.formCliente.cpf}&nome=${requestScope.formCliente.nomeFull}&fone=${requestScope.formCliente.fone1}&localTrab=${requestScope.formCliente.localTrabalho}";
					}
					
				}
			);
		}
			
			
	});	
}



</script>


</html>