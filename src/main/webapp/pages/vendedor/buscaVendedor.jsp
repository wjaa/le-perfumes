<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>

<c:set var="models" value="${requestScope.models}" />

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
	<wjaa:feedback descricao="Home\Administração Sistema\Vendedor\Busca"/>
	
	<div id="DivConteudo">
<!--  	<h1>Sistema de Controle "</h1>-->

	<div id="divConteudo">
		<div id="divTextoConteudo">Busca de Vendedores</div>
		<br>
		<br>
		<input type="button" class="button buttonNew" value="Criar um novo vendedor" onclick="window.location.href='cadastroVendedor.do'"/>
		
<form action="manterVendedor.do?dispatch=list" method="post">
			<table>
				<tr>
					<td class="Fonte01">&nbsp;&nbsp;&nbsp;Nome </td>
				</tr>
				<tr>
					<td >&nbsp; <input type="text" id="nome" name="nome" class="input" size="30"></td>
				</tr>
				<tr>
					<td height="50px;">&nbsp; <input type="submit" value="Pesquisar Vendedor"  class="button" > </td> 
				</tr>
			</table>
			
	
</form>	
<br>


<div> <!-- Div display tag -->

<display:table id="vend" name="${models}" sort="list" pagesize="5" export="false"  class="displaytag"
requestURI="manterFornecedor.do?dispatch=buscar">

	<display:column property="id" title="Id Vendedor" sortable="true"  />
	<display:column property="nome" title="Nome Vendedor" sortable="true"  />
	<display:column property="telefone" title="Telefone" sortable="true"  />
	<display:column title="Ação">
		<input type="button" class="button"  onclick="window.location.href='manterVendedor.do?dispatch=viewCreate&idVendedor=${vend.id}'" value="Alterar"/>
		&nbsp;
		&nbsp;
		<input type="button" class="button" onclick="removerVendedor(${vend.id});" value="Remover"/>
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

	function removerVendedor(idVendedor){
		jConfirm('Deseja realmente remover esse vendedor?', 'Pergunta', function(r) {
			
			if(r){

				$.post("/controle/manterVendedor.do?",{dispatch: "remove",
					idVendedor: idVendedor},
		
					function(data){
					
						if(data == 'true'){
							document.location.href = "manterVendedor.do?dispatch=list&nome=${requestScope.pnome}";
						}
						
					}
				);
			}
				
				
		});	
	}
</script>