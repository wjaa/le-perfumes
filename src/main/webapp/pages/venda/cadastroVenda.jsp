<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"  prefix="html"%>

<c:set var="vendaForm" value="${requestScope.vendaForm}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="br.com.wjaa.controller.impl.VendaForm"%><html>
<head>
	<!-- cabeçalho com javascript e stilos -->
	<wjaa:header/>
	<script type="text/javascript" src="pages/jquery-ui-1.8.6.min.js"></script>
	<script type="text/javascript" src="pages/jquery.ui.datapicker-pt-BR.js"></script>
	<link href="pages/css/jquery-ui.css" rel="stylesheet" type="text/css" />

	<style type="text/css">
	
		.valores{
			border: 1px solid #cdcdcd;
		}
		
		.dia{
			border: 1px solid #cdcdcd;
		}
		
		.data{
			background-color:#F0F0F0 ; 
			margin: 0;
			padding: 0;
			font-family: Arial,Helvetica,sans-serif;
    		border: 1px solid #CDCDCD;
    		
		}
		
		.dataPgto{
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
		<wjaa:feedback descricao="Home\Administração Sistema\Venda\Cadastro"/>
		
		<div id="DivConteudo">
	
			<div id="divConteudo">
				<div id="divTextoConteudo">Cadastro de Venda</div>
				<br><br>
				<html:form action="/manterVenda.do?dispatch=save" onsubmit="return onSubmit();" >
					<input type="hidden" name="id" value="${vendaForm.id}"></input>
					<table>
					<tr>
					<td>
						<table>
							<tr>
								<td colspan="3" align="center"><div style="display: none; color: red;" id="msgErro">Verifique os campos em vermelho</div></td>
							</tr>
							
							<tr>
								<td align="right" id="fieldDataVenda" >Data venda:</td>
								<td>&nbsp;&nbsp;<input type="text" id="dataVendaStr" name="dataVendaStr" value="${vendaForm.dataVendaStr}" class="data" readonly="readonly" size="10"></input></td>
							</tr>
						
							<tr>
								<td align="right" id="fieldCliente">Cliente:</td>
								<td>&nbsp;&nbsp;<select name="idCliente" id="idCliente" >
										<option value="-1" >...</option>
										<c:forEach var="c" items="${vendaForm.clientes}">
											<c:set var="selectCliente" value=""/>
											<c:if test="${vendaForm.idCliente == c.idCliente}">
												<c:set var="selectCliente" value="selected"/>
											</c:if>
											<option value="${c.idCliente}" ${selectCliente} >${c.nomeFull}</option>
										</c:forEach>
									</select>
								
								 </td>
							</tr>
							
							<tr>
								<td align="right" id="fieldVendedor">Vendedor:</td>
								<td>&nbsp;&nbsp;<select name="idVendedor" id="idVendedor">
										<option value="-1" >...</option>
										<c:forEach var="v" items="${vendaForm.vendedores}">
											<c:set var="selectVendedor" value=""/>
											<c:if test="${vendaForm.idVendedor == v.id}">
												<c:set var="selectVendedor" value="selected"/>
											</c:if>
											<option value="${v.id}" ${selectVendedor}>${v.nome}</option>
										</c:forEach>
									</select>
								
								 </td>
							</tr>
							
							<tr>
								<td align="right" id="fieldFormaPagamento">Forma Pagamento:</td>
								<td>&nbsp;&nbsp;<select id="idFormaPagamento" name="idFormaPagamento" >
										<option value="-1">...</option>
										<c:set var="selectedAVista" value="" ></c:set>
										<c:if test="${vendaForm.idFormaPagamento == 1 }">
											<c:set var="selectedAVista" value="selected"></c:set>
										</c:if>
										<c:set var="selectedAPrazo" value="" ></c:set>
										<c:if test="${vendaForm.idFormaPagamento == 2 }">
											<c:set var="selectedAPrazo" value="selected"></c:set>
										</c:if>
										<option value="1" ${selectedAVista}>À vista</option>
										<option value="2" ${selectedAPrazo}>A prazo</option>
									</select>
								 </td>
							</tr>
							<tr height="10px"><td>&nbsp;</td></tr>
							<tr id="diasPrazo">
								<td align="right">Datas Prazo:</td>
								<td>&nbsp;&nbsp;<img src="pages/images/addBtn.png" alt="Adicionar novo prazo" title="Adicionar novo prazo" style="cursor: pointer;" onclick="addPrazo()"/><span style="font-size: small; color: green">&nbsp;Adicionar um novo prazo.</span>
									<table id="tbPrazos" class="displaytag">
										<thead>
											<tr>
												<th width="30px">Dias</th>
												<th width="80px">Data Vencimento</th>
												<th width="80px">Ação</th>
											</tr>
										</thead>
										<tbody id="prazos">
											<c:set var="count" value="1"></c:set>
											
										<c:set var="sizePrazos" value="${fn:length(vendaForm.vendaPrazo)}" />
										<c:if test="${sizePrazos > 0}">
											<c:forEach var="dia" items="${vendaForm.vendaPrazo}">
												<tr id="trPrazo${count}">
													<td><input type="text" name="diaPrazo${count}" style="width: 30px;" class="dia" onkeyup="calcDate(this, 'data${count}')" value="${dia.dias}"></input></td>
													<td><input type="text" id="data${count}" name="dataPrazo${count}" class="data" readonly="readonly" value="${dia.dataVencimentoStr}"></input></td>
													<td align="center"><img src="pages/images/removeBtn.png"  style="cursor: pointer;" onclick="removePrazo('trPrazo${count}');"></img></td>
													<c:set var="count" value="${count+1}"></c:set>
												</tr>
											</c:forEach>
										</c:if>
										
										<!-- criando 3 prazos default -->	
										<c:if test="${sizePrazos == 0}">
											
											<tr id="trPrazo1">
												<td><input type="text" id="diaPrazo1" name="diaPrazo1" style="width: 30px;" class="dia" value="15" onkeyup="calcDate(this, 'data1')" ></input></td>
												<td><input type="text" id="data1" name="dataPrazo1" class="data" readonly="readonly"></input></td>
												<td align="center"><img src="pages/images/removeBtn.png"  style="cursor: pointer;" onclick="removePrazo('trPrazo1');"></img></td>
											</tr>
											
											<tr id="trPrazo2">
												<td><input type="text" id="diaPrazo2" name="diaPrazo2" style="width: 30px;" class="dia" value="30" onkeyup="calcDate(this, 'data2')" ></input></td>
												<td><input type="text" id="data2" name="dataPrazo2" class="data" readonly="readonly"></input></td>
												<td align="center"><img src="pages/images/removeBtn.png"  style="cursor: pointer;" onclick="removePrazo('trPrazo2');"></img></td>
											</tr>
											
											<tr id="trPrazo3">
												<td><input type="text" id="diaPrazo3" name="diaPrazo3" style="width: 30px;" class="dia" value="45" onkeyup="calcDate(this, 'data3')" ></input></td>
												<td><input type="text" id="data3" name="dataPrazo3" class="data" readonly="readonly"></input></td>
												<td align="center"><img src="pages/images/removeBtn.png"  style="cursor: pointer;" onclick="removePrazo('trPrazo3');"></img></td>
											</tr>
										
										</c:if>
										</tbody>
									</table> 
								</td>
							</tr>
							<tr height="10px"><td>&nbsp;</td></tr>
							<tr>
								<td align="right">Observação:</td>
								<td>&nbsp;&nbsp;<textarea name="obs" cols="20" rows="4" class="input" >${vendaForm.obs}</textarea> </td>
							</tr>
						</table>
						</td>
						<td width="50px">&nbsp;&nbsp;&nbsp;</td>
						<td valign="top">
							<table width="100%" height="200" class="displaytag">
								<tr>
									<td valign="top">
										<div>
											<select multiple="multiple" style="width: 100%; height: 100px" ondblclick="addPerfume(this);" class="input">
												<c:forEach var="p" items="${vendaForm.perfumes}">
													<option value="${p.id}">${p.nome}&nbsp;-&nbsp;${p.tamanho}ml</option>
												</c:forEach>
											</select>
										</div>
									</td>
								</tr>
								<tr>	
									
									<td valign="top">
										<table id="tbPerfumes" width="100%" class="displaytag">
											<thead>
												<tr>
													<th width="45%">Nome Perfume</th>
													<th width="25%">Preço Unit</th>
													<th width="25%">Qtde</th>
													<th width="5%">Ação</th>
												</tr>
											</thead>
											<tbody id="perfumes">
												<c:forEach var="prod" items="${vendaForm.vendaItem}">
													<tr id="trPerfume${prod.idPerfume}">
											 			<td>${prod.nomePerfume}</td>
										 	 			<td align="center"><input class="valores" name="preco;${prod.idPerfume}" type="text" value="${prod.precoUnitarioStr}" onblur="calculaTotal()"></input></td>
											 			<td align="center"><input id="qtde${prod.idPerfume}" name="quantidade;${prod.idPerfume}" type="text" value="${prod.qtde}" onblur="calculaTotal()"></input></td>
											 			<td align="center"><img src="pages/images/removeBtn.png"  style="cursor: pointer;" onclick="removePerfume(${prod.idPerfume})"></img></td>
											 			<input id="perfume${prod.idPerfume}" name="perfume" type="hidden" value="${prod.idPerfume}" />
										 			</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<td >&nbsp;</td>
													<td colspan="3" ><div id="totalLote" style="color: blue">R$ 0.00</div></td>
												</tr>
											</tfoot>
										</table>
									</td>
									
								</tr>
						
							</table>
							
						
						</td>
						</tr>
						</table>
					<br>
					
					
						<br>
					<table width="100%">
						<tr>
							<td height="45" align="center" ><input type="button" value="Salvar Venda" class="button" onclick="salvar();"> </td>	
						</tr>	
					</table>
					
				</html:form>
			</div>
		</div>
		
		<!-- rodape -->
		<wjaa:rodape/>
		
	</div>
</body>
</html>
<script>

	function salvar(){

		if ( onSubmit() ){
			var str = $("form").serialize();
			$.ajax({
				url: 'manterVenda.do?dispatch=save&' + str,
				success: function(data) {
			    	$("body").html(data);
				},
				error:function (xhr, ajaxOptions){
					jAlertte(xhr.responseText,'ERRO');
				  }
			});
		}
		
	}	

	$(function(){
		adicionaMask();
		calculaTotal();
	});

	function adicionaMask(){
		$(".valores").maskMoney({symbol:"R$",decimal:",",thousands:"."});
	}

	function calculaTotal(){
		var total = 0.0;
		$(".valores").each(function(i){
			var preco = 0.0;
			var qtde = 0;

			if (this.value != null && this.value != ''){
				var precoStr = this.value.replace("R$ ", "");
				preco = parseFloat(convertDouble(precoStr)); 
			}

			var qtdeStr = $("#qtde" + this.name.split(";")[1]).val();
			if (qtdeStr != null && qtdeStr != '' ){
				qtde = parseInt(qtdeStr);
			}	
			
            total += preco * qtde;
		});	
		$("#totalLote").html(total);
		$('#totalLote').formatCurrency({symbol:"R$ ", digitGroupSymbol:".", decimalSymbol:","});
		
		
	}

	function convertDouble(d){
		if (d == null || d == ''){
			return d;
		}
		
		d = d.replace(".","");
	    return d.replace(",",".");
	}	
	

	function onSubmit(){
		

		if ( $("#dataVendaStr").val() == null || $("#dataVendaStr").val() == '' ){
			$("#fieldDataVenda").css("color","red");
			$("#msgErro").slideDown("slow");
			return false;
		}else{
			$("#fieldDataVenda").css("color","black");
		}	 

		if ( $("#idCliente").val() == null || $("#idCliente").val() == -1 ){
			$("#fieldCliente").css("color","red");
			$("#msgErro").slideDown("slow");

			return false;
		}else{
			$("#fieldCliente").css("color","black");
		}

		if ( $("#idVendedor").val() == null || $("#idVendedor").val() == -1 ){
			$("#fieldVendedor").css("color","red");
			$("#msgErro").slideDown("slow");

			return false;
		}else{
			$("#fieldVendedor").css("color","black");
		}

		if ( $("#idFormaPagamento").val() == null || $("#idFormaPagamento").val() == -1 ){
			$("#fieldFormaPagamento").css("color","red");
			$("#msgErro").slideDown("slow");

			return false;
		}else{
			$("#fieldFormaPagamento").css("color","black");
		}

		if (this.validaDataPrazo()){
			jAlertte('Dias ou data de prazo não foi preenchido!', 'ERRO');
			return false;
		}

		if (this.validaDataInferior()){
			jAlertte('Alguma data de prazo está inferior a data da venda!', 'ERRO');
			return false;
		}

		if (this.validaPrecosProdutos()){
			jAlertte('Preço ou quantidade de perfumes não foi preenchido!', 'ERRO');
			return false;	
		}
		$("#fieldFornecedor").css("color","black");
		$("#msgErro").hide();
		return true;
	}


	function validaDataPrazo(){
		var retorno = false;

		if ($("#idFormaPagamento").val() == 2){
			$(".dia").each(function(i){
				
				if (this.value == null || this.value == ''){
					retorno = true;
				}
			});

			$(".data").each(function(i){
				
				if (this.value == null || this.value == ''){
					retorno = true;
				}
			});	

			var rowCount = $('#tbPrazos tr').length;
			if (rowCount == 1){
			  	retorno = true;
			}	

		}

		return retorno;
	}

	function validaDataInferior(){
		var retorno = false;

		if ($("#idFormaPagamento").val() == 2){
			$(".data").each(function(i){
				var dataPrazo = $("#" + this.id).datepicker( "getDate" );
				
				var dataVenda = $("#dataVendaStr").datepicker( "getDate" );
				if (dataPrazo.getTime() < dataVenda.getTime()){
					retorno = true;
				}
			});
		}

		return retorno;
	}
	
	function validaPrecosProdutos(){
		var retorno = false;
		$(".valores").each(function(i){
			
			if (this.value == null || this.value == ''){
				retorno = true;
			}
	
			var qtdeStr = $("#qtde" + this.name.split(";")[1]).val();
			if (qtdeStr == null || qtdeStr == '' ){
				retorno = true;
				$("#qtde" + this.name.split(";")[1]).focus();
			}
			
		});

		var rowCount = $('#tbPerfumes tr').length;
		if (rowCount == 2){
		  	retorno = true;
		}	
			
		return retorno;			
	}

	function addPerfume(comboPerfume){
		var perfume = comboPerfume.options[comboPerfume.selectedIndex];
		var idPerfume = perfume.value;
		if ($("#perfume" + idPerfume).length == 0 ){
			
			var nomePerfume = perfume.text;
			$("#perfumes").append("<tr id=\"trPerfume" + idPerfume +  "\">" +
									 "<td> " + nomePerfume  + "</td>" +
								 	 "<td align=\"center\"><input id=\"preco" + idPerfume + "\" onblur=\"calculaTotal()\" class=\"valores\" name=\"preco;" + idPerfume + "\" type=\"text\"></input></td>" +
									 "<td align=\"center\"><input id=\"qtde" + idPerfume + "\"  onblur=\"calculaTotal()\" name=\"quantidade;" + idPerfume + "\" type=\"text\"></input></td>" +
									 "<td align=\"center\"><img src=\"pages/images/removeBtn.png\"  style=\"cursor: pointer;\" onclick=\"removePerfume(" + idPerfume + " )\"></img></td>" +
									 "<input id=\"perfume" + idPerfume + "\"  name=\"perfume\" type=\"hidden\" value=\"" + idPerfume + "\">" +
								 "</tr>");

			$("#preco" + idPerfume).maskMoney({symbol:"R$",decimal:",",thousands:"."});
		}else{
			jAlertte('Perfume já foi adicionado!', 'Informação');
		}  
		
		
	}

	function removePerfume(idPerfume){

		jConfirm('Deseja remover esse perfume do lote?', 'Dúvida!', function(r) {
			if(r){
				//removendo o tr
				$("#trPerfume" + idPerfume).remove();

				//removendo o hidden 
				$("#perfume" + idPerfume).remove();

				calculaTotal();
			}
		});
		
	}

    <c:if test="${sizePrazos == 0}">
		var prazo = 4;
	</c:if>
	<c:if test="${sizePrazos > 0}">
		var prazo = ${count} + 1;
	</c:if>	
	function addPrazo(){
		prazo++;
		$("#prazos").append("<tr id=\"trPrazo" + prazo + "\">" + 
							"<td><input  id=\"diaPrazo" + prazo + "\" name=\"diaPrazo" + prazo + "\"  type=\"text\" class=\"dia\" style=\"width: 30px;\" onkeyup=\"calcDate(this, 'data" + prazo + "')\"></input></td>" +
							"<td><input id=\"data" + prazo + "\" name=\"dataPrazo" + prazo + "\" type=\"text\" class=\"data\" readonly=\"readonly\"></input></td>" +
							"<td align=\"center\"><img src=\"pages/images/removeBtn.png\"  style=\"cursor: pointer;\" onclick=\"removePrazo('trPrazo" + prazo + "' )\"></img></td>" +
							"</tr>");
		$(".data").datepicker({ 
			autoSize: true, 
			dateFormat: 'dd/mm/yy',
			gotoCurrent: true,
		   	showAnim: 'drop',
		    prevText: 'Anterior',
		    nextText: 'Próximo',
		    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		   dayNamesMin: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
		   		onClose: function(dateText, inst) { 
			   		var idData = inst.id;
			   		var idDia = "diaPrazo" + idData.replace("data","");
			   		calcDias(idData,idDia); 
			   }       	   
			});
	}

	function removePrazo(idPrazo){
		jConfirm('Deseja remover esse esse prazo da venda?', 'Dúvida!', function(r) {
			if(r){
				//removendo o tr
				$("#" + idPrazo).remove();
			}
		});
	}

	function changeFormaPagamento(){
		if ($("#idFormaPagamento option:selected").val() == 2){
			 $("#diasPrazo").show();
		 }else{
			 $("#diasPrazo").hide();
		 }
	}

	function calcDate(dias, idData){
		var dateVenda = $("#dataVendaStr").datepicker( "getDate" );
		//dia 19/02/2011 tem um bug.
		
		var dateCalc = dateVenda.getTime() + (86400000 * dias.value);
		var novaData = new Date(dateCalc);
		//novaData.setMilliseconds(dateCalc);
		
		$("#" + idData).datepicker("setDate",novaData);	
	}

	function calcDias(idData, idDia){
		var dateVenda = $("#dataVendaStr").datepicker( "getDate" );
		var data = $("#"+idData).datepicker( "getDate" );
		
		var dias = (data.getTime() - dateVenda.getTime() ) / 1000 / 60 / 60 / 24 ;
		$("#" + idDia).val(Math.round(dias));	
	}

	$("#idFormaPagamento").change(function(){
		changeFormaPagamento();
	});


	changeFormaPagamento();
	
	$(".data , .dataPgto").datepicker({ 
		autoSize: true, 
		dateFormat: 'dd/mm/yy',
		gotoCurrent: true,
	   	showAnim: 'drop',
	    prevText: 'Anterior',
	    nextText: 'Próximo',
	    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	   dayNamesMin: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
	   		onClose: function(dateText, inst) { 
		   		var idData = inst.id;
		   		var idDia = "diaPrazo" + idData.replace("data","");
		   		calcDias(idData,idDia); 
		   }       	   
		});
	
	
	var idVenda = '${vendaForm.id}';
	if(idVenda == '' || idVenda < 1){
		$(".data").datepicker( "setDate" , new Date());
	}
	
	var ehNovo = ${sizePrazos};

	if ( ehNovo == 0 ){
		$(".dia").keyup();
	}
	
			
	 
	
		
</script>	
