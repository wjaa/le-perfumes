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
	<script type="text/javascript" src="pages/jquery-ui-1.8.6.min.js"></script>
	<script type="text/javascript" src="pages/jquery.ui.datapicker-pt-BR.js"></script>
	<link href="pages/css/jquery-ui.css" rel="stylesheet" type="text/css" />

	<style type="text/css">
	
		.data{
			background-color:#F0F0F0 ; 
			margin: 0;
			padding: 0;
			font-family: Arial,Helvetica,sans-serif;
    		border: 1px solid #CDCDCD;
		}
	
	</style>

</head>
<body>
	<div id="DivGeral">
	
	<!-- menu -->
	<wjaa:menu/>
	
	<!-- feedback -->
	<wjaa:feedback descricao="Home\Administração Sistema\Lote\Busca"/>
	
	<div id="DivConteudo">
<!--  	<h1>Sistema de Controle "</h1>-->

	<div id="divConteudo">
		<div id="divTextoConteudo">Busca de Lote</div>
		<br>
		
<form action="manterLote.do?dispatch=search" method="post">
			
			<td >&nbsp; Data compra:&nbsp; </td>
			<td>&nbsp; <input type="text" id="dataInicio" name="dataInicio" class="data" size="10" value="${dataInicio}"> &nbsp;até&nbsp; <input type="text" id="dataFim" name="dataFim" class="data" size="10" value="${dataFim}"></td>
			<td >&nbsp; Fornecedor:&nbsp; </td>
			<td>
				&nbsp; <select id="paramFornecedor" name="paramFornecedor">
				
						<option value="">...</option>
						<c:forEach var="forn" items="${fornecedores}">
							<c:set var="selected" value=""></c:set>
							
							<c:if test="${paramFornecedor == forn.id}">
								<c:set var="selected" value="selected"></c:set>
							</c:if>
						
							<option value="${forn.id}" ${selected}>${forn.nome}</option>
						</c:forEach>
					</select>
			</td>
			<td>&nbsp; <input type="submit" value="Pesquisar Fornecedor"  class="button" > </td> 
			
	
</form>	
<br>

<center>
<div> <!-- Div display tag -->

<display:table id="lote" name="${lotes}" sort="list" pagesize="5" export="false"  class="displaytag"
requestURI="manterLote.do?dispatch=search">

	<display:column property="id" title="Id Lote" sortable="true"  />
	<display:column property="strDataCompra" title="Data Compra" sortable="true"  />
	<display:column property="observacao" title="Obs" sortable="false"  />
	<display:column title="Ação"><a href="manterLote.do?dispatch=createEdit&idLote=${lote.id}">Alterar</a>&nbsp;&nbsp;<a href="#" onclick="distribuir(${lote.id});">Distribuir</a>&nbsp;&nbsp;<a href="#" onclick="removerLote(${lote.id});">Remover</a></display:column>
    
</display:table>


</div> <!-- FIM Div display tag -->			

</center>
	
	</div>
	</div>
	
		<!-- rodape -->
		<wjaa:rodape/>
	</div>
	<div id="popup" class="selector" style="display: none;">&nbsp;</div>
	</body>

</html>

<script type="text/javascript">

	function removerLote(idLote){
		jConfirm('Deseja realmente remover esse lote?', 'Pergunta', function(r) {
			
			if(r){

				$.post("/controle/manterLote.do?",{dispatch: "remover",
					idLote: idLote},
		
					function(data){
					
						if(data == 'true'){
							document.location.href = "manterLote.do?dispatch=search&dataInicio=${requestScope.dataInicio}&dataFim=${requestScope.dataFim}&paramFornecedor=${requestScope.paramFornecedor}";
						}
						
					}
				);
			}
				
				
		});	
	}

	function distribuir(idLote){
		
		var urlEstoque = 'manterEstoque.do?dispatch=controlar&por=1&idLote=' + idLote + '&dataInicio=${requestScope.dataInicio}&dataFim=${requestScope.dataFim}&paramFornecedor=${requestScope.paramFornecedor}';
		$.ajax({
			  url: urlEstoque ,
			  success: function(data) {
			    $("#popup").html(data);
			    $("#popup").dialog({ width: 600, modal: true, title: "Distribuição de perfume por vendedor" });
 
		  }
		});
		 
		
	}
	$(".data").datepicker({ 
		autoSize: true, 
		dateFormat: 'dd/mm/yy',
		gotoCurrent: true,
	   	showOn: 'both',
	   	showAnim: 'drop',
	    prevText: 'Anterior',
	    nextText: 'Próximo',
	    autoSize: false,
	    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	   dayNamesMin: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb']
		});
</script>