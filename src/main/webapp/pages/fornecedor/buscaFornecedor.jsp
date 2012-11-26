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
		<br>
		<input type="button" class="button buttonNew" value="Criar um novo fornecedor" onclick="window.location.href='cadastroFornecedor.do'"/>
		
<form action="manterFornecedor.do?dispatch=buscar" method="post">
		<table>
			<tr>
				<td Class="Fonte01">&nbsp;&nbsp;&nbsp; Nome&nbsp; </td>
			</tr>
			<tr>
				<td>&nbsp; <input type="text" id="nome" name="nome" class="input" size="30"></td>
			</tr>
			<tr>
				<td  height="50px;">&nbsp; <input type="submit" value="Pesquisar Fornecedor"  class="button" > </td>
			</tr> 
		</table>	
	
</form>	
<br>

<div> <!-- Div display tag -->

<display:table id="fornec" name="${listModel}" sort="list" pagesize="5" export="false"  class="displaytag"
requestURI="manterFornecedor.do?dispatch=buscar">

	<display:column property="id" title="Id Fornecedor" sortable="true"  />
	<display:column property="nome" title="Nome Fornecedor" sortable="true"  />
	<display:column property="endereco" title="Endereco" sortable="true"  />
	<display:column property="telefone1" title="Telefone" sortable="true"  />
	<display:column property="telefone2" title="Outro Telefone" sortable="true"  />
	<display:column title="Ação">
		<input type="button" class="button" onclick="window.location.href='manterFornecedor.do?dispatch=editar&idFornecedor=${fornec.id}'" value="Alterar"/>
		&nbsp;
		&nbsp;
		<input type="button" class="button" href="#" onclick="removerFornecedor(${fornec.id});" value="Remover"/>
	</display:column>

</display:table>


</div> <!-- FIM Div display tag -->			
	
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