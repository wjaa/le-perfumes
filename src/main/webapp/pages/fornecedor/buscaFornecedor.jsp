<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>

<c:set var="listModel" value="${requestScope.listFornecedorVo}" />

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
	<wjaa:feedback descricao="Home\Administração Sistema\Fornecedor\Busca"/>
	
	<div id="DivConteudo">
<!--  	<h1>Sistema de Controle "</h1>-->

	<div id="divConteudo">
		<div id="divTextoConteudo">Busca de Fornecedores</div>
		<br>
		
<form action="manterFornecedor.do?dispatch=buscar" method="post">
			
			<td >&nbsp; Nome:&nbsp; </td>
			<td>&nbsp; <input type="text" id="nome" name="nome" class="input" size="30"></td>
			<td>&nbsp; <input type="submit" value="Pesquisar Fornecedor"  class="button" > </td> 
			
	
</form>	
<br>

<center>
<div> <!-- Div display tag -->

<display:table id="fornec" name="${listModel}" sort="list" pagesize="5" export="false"  class="displaytag"
requestURI="manterFornecedor.do?dispatch=buscar">

	<display:column property="id" title="Id Fornecedor" sortable="true"  />
	<display:column property="nome" title="Nome Fornecedor" sortable="true"  />
	<display:column property="endereco" title="Endereco" sortable="true"  />
	<display:column property="telefone1" title="Telefone" sortable="true"  />
	<display:column property="telefone2" title="Outro Telefone" sortable="true"  />
	<display:column title="Ação"><a href="manterFornecedor.do?dispatch=editar&idFornecedor=${fornec.id}">Alterar</a>&nbsp;&nbsp;<a href="#" onclick="removerFornecedor(${fornec.id});">Remover</a></display:column>

</display:table>


</div> <!-- FIM Div display tag -->			

</center>
	
	</div>
	</div>
	
		<!-- rodape -->
		<wjaa:rodape/>
	</div>
	
	</body>

</html>

<script type="text/javascript">

	function removerFornecedor(idFornecedor){
		jConfirm('Deseja realmente remover esse fornecedor?', 'Pergunta', function(r) {
			
			if(r){

				$.post("/controle/manterFornecedor.do?",{dispatch: "remover",
					idFornecedor: idFornecedor},
		
					function(data){
					
						if(data == 'true'){
							document.location.href = "manterFornecedor.do?dispatch=buscar&nome=${requestScope.paramBusca}";
						}
						
					}
				);
			}
				
				
		});	
	}
</script>