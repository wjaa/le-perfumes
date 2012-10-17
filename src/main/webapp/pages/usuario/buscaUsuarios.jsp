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
	<wjaa:feedback descricao="Home\Administração Sistema\Usuário\Busca"/>
	
	<div id="DivConteudo">
<!--  	<h1>Sistema de Controle "</h1>-->

	<div id="divConteudo">
		<div id="divTextoConteudo">Busca de Usuários do Sistema</div>
		<br>
		
<form action="manterUsuario.do?dispatch=buscarUsuario" method="post">
			
			<td >&nbsp; Nome:&nbsp; </td>
			<td>&nbsp; <input type="text" id="nome" name="nome" class="input" size="30"></td>
			<td>&nbsp; <input type="submit" value="Pesquisar Usuário"  class="button" > </td> 
			
	
</form>	
<br>

<center>
<div> <!-- Div display tag -->

<display:table id="listUser" name="${modeloBusca.consultaUsuarioVo}" sort="list" pagesize="5" export="false"  class="displaytag"
requestURI="manterUsuario.do?dispatch=buscarUsuario">

	<display:column property="idUsuario" title="Id Usuário" sortable="true"  />
	<display:column property="nomeFull" title="Nome Usuário" sortable="true"  />
	<display:column property="nome" title="Login Usuário" sortable="true"  />
	<display:column title="Ação"><a href="manterUsuario.do?dispatch=editar&idUsuario=${listUser.idUsuario}">Alterar</a>&nbsp;&nbsp;<a href="#" onclick="removerUsuario(${listUser.idUsuario});">Remover</a></display:column>

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

	function removerUsuario(idUsuario){
		jConfirm('Deseja realmente remover esse usuário?', 'Pergunta', function(r) {
			
			if(r){

				$.post("/controle/manterUsuario.do?",{dispatch: "removerUsuario",
					idUsuario: idUsuario},
		
					function(data){
					
						if(data == 'true'){
							document.location.href = "manterUsuario.do?dispatch=buscarUsuario&nome=${requestScope.paramBusca}";
						}
						
					}
				);
			}
				
				
		});	
	}
</script>