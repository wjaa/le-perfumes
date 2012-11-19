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
	<wjaa:feedback descricao="Home\Perfume\Busca"/>
	
	<div id="DivConteudo">
<!--  	<h1>Sistema de Controle "</h1>-->

	<div id="divConteudo">
		<div id="divTextoConteudo">Busca de Perfumes </div>
		<br>
		<br>
		<input type="button" class="button buttonNew" value="Criar um novo perfume" onclick="window.location.href='cadastroPerfume.do'"/>			
		
		<form action="manterPerfume.do?dispatch=buscarPerfume" method="post">
			
			<table>
				<tr>
					<td Class="Fonte01">&nbsp;&nbsp;&nbsp;Nome</td>
					<td Class="Fonte01">&nbsp;&nbsp;&nbsp;Marca</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;<input type="text" id="nome" name="nome" class="input" size="30" class="input"></td>
					<td>&nbsp;&nbsp;<input type="text" id="marca" name="marca" class="input" size="30" class="input"></td>
				</tr>
				<tr>
					<td height="50px;">&nbsp; <input type="submit" value="Pesquisar Perfumes"  class="button" > </td>		
				</tr>
			</table>
	
		</form>	
<br>


<div> <!-- Div display tag -->

<display:table id="listPerf" name="${modeloBusca.perfumeVo}" sort="list" pagesize="5" export="false"  class="displaytag"
requestURI="manterPerfume.do?dispatch=buscarPerfume">

	<display:column property="idPerfume" title="#" sortable="true"/>
	<display:column property="nome" title="Nome Perfume" sortable="true"  />
	<display:column property="marca" title="Marca Perfume" sortable="true"  />
	<display:column property="tamanho" title="Tamanho(ml)" sortable="true"  />
	<display:column property="tipo" title="Tipo Perfume" sortable="true"  />
	<display:column title="Ação">
		<input type="button" value="Alterar" onclick="window.location.href='manterPerfume.do?dispatch=editarPerfume&idPerfume=${listPerf.idPerfume}'" class="button"/>
		&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='manterPerfume.do?dispatch=editarPerfume&idPerfume=${listPerf.idPerfume}'" class="button"/>
		<a href="#" onclick="removerPerfume(${listPerf.idPerfume})">Remover</a>
	</display:column>
	

</display:table>


</div> <!-- FIM Div display tag -->			


	
	</div>
	</div>
	
		<!-- rodape -->
		<wjaa:rodape/>
	</div>
	
	</body>

<script type="text/javascript">

function removerPerfume(idPerfume){
	jConfirm('Deseja realmente remover esse perfume?', 'Pergunta', function(r) {
		
		if(r){

			$.post("/controle/manterPerfume.do?",{dispatch: "removerPerfume",
				idPerfume: idPerfume},
	
				function(data){
				
					if(data == 'true'){
						document.location.href = "manterPerfume.do?dispatch=buscarPerfume&nome=${requestScope.perfumeForm.nome}&marca=${requestScope.perfumeForm.marca}";
					}
					
				}
			);
		}
			
			
	});	
}


</script>


</html>