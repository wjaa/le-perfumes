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
	<wjaa:feedback descricao="Home\Administração Sistema\Venda\Busca"/>
	
	<div id="DivConteudo">
<!--  	<h1>Sistema de Controle "</h1>-->

	<div id="divConteudo">
		<div id="divTextoConteudo">Busca de Vendas</div>
		<br>
		
<form action="manterVenda.do?dispatch=search" method="post">
		<table>
		<tr>
			<td >&nbsp; Periodo Venda:&nbsp; </td>
			<td valign="bottom">&nbsp; <input type="text" id="dataInicio" class="data" name="dataInicio" class="input" size="10" value="${requestScope.dataInicio}">&nbsp;<img align="bottom" src="pages/images/clear.png" alt="Limpar data" title="Limpar data" style="cursor: pointer;" onclick="$('#dataInicio').val('');"></img>&nbsp;&nbsp;Até&nbsp;<input type="text" id="dataFim" class="data" name="dataFim" class="input" size="10" value="${requestScope.dataFim}">&nbsp;<img src="pages/images/clear.png" alt="Limpar data" title="Limpar data" style="cursor: pointer;" onclick="$('#dataFim').val('');"></img></td>
			<td >&nbsp; Vendedor:&nbsp; </td>
			<td>
				&nbsp; <select id="idVendedor" name="idVendedor">
				
						<option value="">...</option>
						<c:forEach var="v" items="${vendedores}">
							<c:set var="selected" value=""></c:set>
							
							<c:if test="${requestScope.idVendedor == v.id}">
								<c:set var="selected" value="selected"></c:set>
							</c:if>
							<option value="${v.id}" ${selected}>${v.nome}</option>
						</c:forEach>
					</select>
			</td>
			<td >&nbsp; Clientes:&nbsp; </td>
			<td>
				&nbsp; <select id="idCliente" name="idCliente">
				
						<option value="">...</option>
						<c:forEach var="c" items="${clientes}">
						
							<c:set var="selected" value=""></c:set>
							
							<c:if test="${requestScope.idCliente == c.idCliente}">
								<c:set var="selected" value="selected"></c:set>
							</c:if>
						
							<option value="${c.idCliente}" ${selected}>${c.nomeFull}</option>
						</c:forEach>
					</select>
			</td>
			<td >&nbsp; Status:&nbsp; </td>
			<td>
				&nbsp; <select id="idStatus" name="idStatus">
				
						<c:set var="selectedA" value=""></c:set>
						<c:set var="selectedAT" value=""></c:set>
						<c:set var="selectedL" value=""></c:set>
							
						<c:if test="${requestScope.idStatus == 0}">
							<c:set var="selectedA" value="selected"></c:set>
						</c:if>
						<c:if test="${requestScope.idStatus == 2}">
							<c:set var="selectedAT" value="selected"></c:set>
						</c:if>
						<c:if test="${requestScope.idStatus == 3}">
							<c:set var="selectedL" value="selected"></c:set>
						</c:if>
				
						<option value="">Todos</option>
						<option value="0" ${selectedA}>Aberto</option>
						<option value="2" ${selectedAT}>Atrasado</option>
						<option value="3" ${selectedL}>Liquidado</option>
						
					</select>
			</td>
			
		</tr>
		<tr height="10px"><td></td></tr>
		<tr>
			<td colspan="10" align="center">&nbsp; <input type="submit" value="Pesquisar Fornecedor"  class="button" > </td>
		</tr> 
		</table>
	
</form>	
<br>

<center>
<div> <!-- Div display tag -->
<table class="displaytag" align="center">
		<thead>
			<tr><th colspan="3" align="center">Status legenda</th></tr>
		</thead>
		<tr>
			
			<td style="background-color: #a8ff81;">Aberto</td>
			
			<td style="background-color: #FA8E8E;">Atrasado</td>
			
			<td style="background-color: #aaccff;">Liquidado</td>

			
		</tr>
	
	</table>
	<br></br>
<display:table id="venda" name="${vendas}" sort="list" pagesize="10" export="false"  class="displaytag"
requestURI="manterVenda.do?dispatch=search" >
	<c:set var="color" value=""></c:set>

	<c:if test="${venda.statusVenda == 0}">
		<c:set var="color" value="background-color: #a8ff81;"/>
	</c:if>
	
	<c:if test="${venda.statusVenda == 1}">
		<c:set var="color" value="background-color: #ffee66;"/>
	</c:if>
	
	<c:if test="${venda.statusVenda == 2}">
		<c:set var="color" value="background-color: #FA8E8E;"/>
	</c:if>
	
	<c:if test="${venda.statusVenda == 3}">
		<c:set var="color" value="background-color: #aaccff;"/>
	</c:if>

	<display:column property="dataVendaStr" title="Data Venda" sortable="true" style="${color}" />
	<display:column property="nomeCliente" title="Nome Cliente" sortable="true" style="${color}" />
	<display:column property="loja" title="Loja Cliente" sortable="true" style="${color}" />
	<display:column property="nomeVendedor" title="Nome Vendedor" sortable="true" style="${color}" />
	<display:column title="Perfumes" sortable="true" style="${color}"  >
		<display:table id="i" name="${venda.vendaItem}" sort="list" pagesize="10" export="false"  class="displaytag" style="border:0px">
			<display:column property="nomePerfume" title="Nome Perfume" sortable="true" style="${color}"  />
			<display:column property="precoUnitarioStr" title="Preco Unitário" sortable="true" style="${color}" />
		</display:table>
	</display:column>
	
	<display:column title="Prazos" sortable="true" style="${color}" >
		<display:table id="p" name="${venda.vendaPrazo}" sort="list" pagesize="10" export="false"  class="displaytag" style="border:0px">
			<c:set var ="decoration" value=""></c:set>
			
			
			
			<c:if test="${p.pago}">
				<c:set var="decoration" value="text-decoration: line-through;"></c:set>
			</c:if>
			
			<c:if test="${p.vencida}">
				<c:set var="decoration" value="border-style:solid; border-width:1px; border-color:red;"></c:set>
			</c:if>
			<c:if test="${venda.statusVenda == 3}">
				<c:set var="decoration" value="text-decoration: line-through;"></c:set>
			</c:if>
			
			<display:column property="dataVencimentoStr" title="Data Vencimento" sortable="true" style="${color}  ${decoration}"  />
		</display:table>
	</display:column>
	<display:column title="Ação" style="${color}"><a href="manterVenda.do?dispatch=createEdit&idVenda=${venda.id}">Alterar</a>&nbsp;&nbsp;<a href="#" onclick="lancarPagamentos(${venda.id});">Pagamentos</a>&nbsp;&nbsp;<a href="#" onclick="removerVenda(${venda.id});">Remover</a></display:column>

</display:table>
	<br><br>
	


</div> <!-- FIM Div display tag -->			

</center>
	
	</div>
	</div>
	
		<!-- rodape -->
		<wjaa:rodape/>
		<div id="popup" class="selector" style="display: none;">&nbsp;</div>

	</div>
	
	</body>

</html>

<script type="text/javascript">


	function removerVenda(idVenda){
		jConfirm('Deseja realmente remover essa venda?', 'Pergunta', function(r) {
			
			if(r){

				$.post("/controle/manterVenda.do?",{dispatch: "remover",
					idVenda: idVenda},
		
					function(data){
					
						if(data == 'true'){
							document.location.href = "manterVenda.do?dispatch=search&dataInicio=${requestScope.dataInicio}&dataFim=${requestScope.dataFim}&idVendedor=${requestScope.idVendedor}&idCliente=${requestScope.idCliente}";
						}
						
					}
				);
			}
				
				
		});	
	}

	$(".data").datepicker({ 
		autoSize: true, 
		dateFormat: 'dd/mm/yy',
		gotoCurrent: true,
	   	showAnim: 'drop',
	    prevText: 'Anterior',
	    nextText: 'Próximo',
	    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	   dayNamesMin: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb']
		});

	var countA = 0;
	$("span.pagebanner").each(function(i) {
		if (countA > 0 ){
			this.style.display = 'none';
		}
		countA++;
    	
	});
    var countB = 0;
	$("span.pagelinks").each(function(i) {
		if (countB > 0 ){
			this.style.display = 'none';
		}
		countB ++;
    	
	});


	function lancarPagamentos(idVenda){
		
		var urlPgto = 'manterVenda.do?dispatch=pagamentos&dataInicio=${requestScope.dataInicio}&dataFim=${requestScope.dataFim}&idVendedor=${requestScope.idVendedor}&idCliente=${requestScope.idCliente}&idVenda=' + idVenda;
		$.ajax({
			  url: urlPgto ,
			  success: function(data) {
			    $("#popup").html(data);
			    $("#popup").dialog({ width: 700, height:500, modal: true, title: "Lançamento de pagamentos" });


			    $(".data").datepicker({ 
					autoSize: true, 
					dateFormat: 'dd/mm/yy',
					gotoCurrent: true,
				   	showOn: 'both',
				   	showAnim: 'drop',
				    prevText: 'Anterior',
				    nextText: 'Próximo',
				    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
				   dayNamesMin: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb']
				});

			    $(".valores").maskMoney({symbol:"R$",decimal:",",thousands:"."});

			    calculaTotal();
		  	  }

	  	  		
		});
	}


	function removePgto(idPgto){
		$("#" + idPgto).remove();
		$("#tr" + idPgto).remove();
		calculaTotal();
	}	

    var contPgto = 1;
	function addPgto(qtdeParcelas){
		var dataPgto = $("#dataPagamento").val();
		var valorPgto = $("#valorPagamento").val();

		var totalPgtos = $("#tbPgto tr").size() -2;

		if (qtdeParcelas == totalPgtos ){
			jAlertte("Você não pode inserir um novo pagamento!\n O total de parcelas é de <b>" + qtdeParcelas + " x.</b>\n Altere as parcelas da venda ou verifique os pagamentos.",'ERRO');
			return;
		}

		if (dataPgto == null || dataPgto == ''){
			jAlertte("Campo 'Data de Pgto' não foi preenchido!",'ERRO');
			return;
		}

 	    if ( valorPgto == null || valorPgto == '' ){
 	    	jAlertte("Campo 'Valor do Pgto' não foi preenchido!",'ERRO');
 	    	return;
		} 
		
		var html = "<tr id=\"trnovoPgto" + contPgto + "\">" +
					"<td>" + dataPgto +"</td>" +
					"<td><div class=\"valores1\">" + valorPgto +"</div></td>" +
					"<td><img src=\"pages/images/removeBtn.png\" alt=\"Remover pagamento\" title=\"Remover pagamento\" style=\"cursor: pointer;\" onclick=\"removePgto('novoPgto" + contPgto +"')\"/></td>" + 
					"<input type=\"hidden\" id=\"novoPgto" + contPgto + "\" name=\"novoPgto" + contPgto + "\" value=\"" + dataPgto +";"+ valorPgto +"\"></input>" +
					"</tr>";

							
		$("#tbPgto").append(html);
		$("#dataPagamento").val("");
		$("#valorPagamento").val("");
		calculaTotal();
		contPgto ++;
	}

	function calculaTotal(){
		var total = 0.0;
		$(".valores1").each(function(i){
			var preco = 0.0;
			if (this.innerHTML != null && this.innerHTML != ''){
				var precoStr = this.innerHTML;
				preco = parseFloat(convertDouble(precoStr)); 
			}
			
            total += preco;
		});	
		$("#totalPgto").html(total);
		$('#totalPgto').formatCurrency({symbol:"R$ ", digitGroupSymbol:".", decimalSymbol:","});
		var valorVenda = $("#valorVenda").html();
		var saldo = total - parseFloat(convertDouble(valorVenda));
		$("#saldo").html(saldo);
		$('#saldo').formatCurrency({symbol:"R$ ", digitGroupSymbol:".", decimalSymbol:","});

		if (saldo < 0){
			$('#saldo').css("color","red");
		}else{
			$('#saldo').css("color","blue");
		}	
		
	}
	calculaTotal();

	function convertDouble(d){
		if (d == null || d == ''){
			return d;
		}
		d = d.replace(".","");
	    return d.replace(",",".");
	}	
	
</script>