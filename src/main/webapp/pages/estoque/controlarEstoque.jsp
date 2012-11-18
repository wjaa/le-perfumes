<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>

<c:set var="fornecedores" value="${requestScope.fornecedores}" />
<c:set var="lotes" value="${requestScope.lotes}" />

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
	<wjaa:feedback descricao="Home\Administração Sistema\Estoque\Controle"/>
	
	<div id="DivConteudo">
<!--  	<h1>Sistema de Controle "</h1>-->

	<div id="divConteudo">
		<div id="divTextoConteudo">Controle de estoque</div>
		<br>
		
<form action="manterEstoque.do?dispatch=controlar" method="post">
			<table>
			<tr>
			<td >&nbsp; Grupo:&nbsp; </td>
			<td>&nbsp; <input type="radio" id="porPerfume" name="por" class="input" size="30" value="3" checked="checked">Perfume</input></td>
			<td>&nbsp; <input type="radio" id="porVendedor" name="por" class="input" size="30" value="2">Vendedor</input></td>
			<td>&nbsp; <input type="submit" value="Buscar"  class="button"> </td>
			</tr> 
			</table>
	
<br>
</form>	



<c:if test="${por == 2}">
	
	
	<div class="displayTag"> <!-- Div display tag -->
	
	

	<display:table id="estoque" name="${model}" sort="list" pagesize="15" export="false"  class="displaytag"
	requestURI="manterEstoque.do?dispatch=controlar">
	
				
		<display:column property="nomePerfume" title="Perfume" sortable="true" style="${cor}" />
		<display:column property="nomeVendedor" title="Vendedor" sortable="true" style="${cor}" />
		<display:column property="qtde" title="Qtde Vendedor" sortable="false" style="${cor}" />
	
	</display:table>

</c:if>

<c:if test="${por == 3}">
	
	<div class="displayTag"> <!-- Div display tag -->
	
	
	
	<display:table id="estoque" name="${model}" sort="list" pagesize="15" export="false"  class="displaytag"
	requestURI="manterEstoque.do?dispatch=controlar">
	
				
		<display:column property="nomePerfume" title="Perfume" sortable="true" style="${cor}" />
		<display:column property="qtde" title="Qtde" sortable="false" style="${cor}" />
	
	</display:table>

</c:if>

</div> <!-- FIM Div display tag -->			
<br></br>
	
	</div>
	</div>
	
		<!-- rodape -->
		<wjaa:rodape/>
	</div>
	
	</body>

</html>

<script type="text/javascript">
    var por = "${por}";
	if (por == 3 ){
		$("#porPerfume").attr("checked", "checked");
	}	

	if (por == 2 ){
		$("#porVendedor").attr("checked", "checked");
	}
	



	function removerLote(idLote){
		jConfirm('Deseja realmente remover esse lote?', 'Pergunta', function(r) {
			
			if(r){

				$.post("/controle/manterLote.do?",{dispatch: "remover",
					idLote: idLote},
		
					function(data){
					
						if(data == 'true'){
							document.location.href = "manterLote.do?dispatch=buscar&paramData=${requestScope.paramData}&paramFornecedor=${requestScope.paramFornecedor}";
						}
						
					}
				);
			}
				
				
		});	
	}

</script>