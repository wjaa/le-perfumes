<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"  prefix="html"%>

<c:set var="model" value="${requestScope.model}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
		<wjaa:feedback descricao="Home\Administração Sistema\Usuário\Cadastro"/>
		
		<div id="DivConteudo">
	
			<div id="divConteudo">
				<div id="divTextoConteudo">Cadastro de Lote</div>
				<br><br>
				<html:form action="/manterLote.do?dispatch=save" onsubmit="return onSubmit();" >
					<input type="hidden" name="id" value="${model.id}"></input>
					<table>
						<tr>
							<td colspan="3" align="center"><div style="display: none; color: red;" id="msgErro">Verifique os campos em vermelho</div></td>
						</tr>
						
						<tr>
							<td align="right" >ID do Lote:</td>
							<td>&nbsp;&nbsp;${model.id}</td>
						</tr>
					
						<tr>
							<td align="right" id="fieldDataCompra">Data:</td>
							<td>&nbsp;&nbsp;<input id="dataCompra" class="data" type="text" name="strDataCompra" value="${model.strDataCompra}" size="10"/> </td>
						</tr>
						
						<tr>
							<td align="right" id="fieldFornecedor">Fornecedor:</td>
							<td>&nbsp;&nbsp;<select id="fornecedor" name="idFornecedor" class="input">
									<option value="-1">...</option>
									<c:set var="selected" ></c:set>
									<c:forEach var="forc" items="${model.fornecedores}">
										<c:if test="${forc.id == model.idFornecedor}">
											<c:set var="selected" value="selected" ></c:set>
										</c:if>
										<c:if test="${forc.id != model.idFornecedor}">
											<c:set var="selected" value="" ></c:set>
										</c:if>
										<option value="${forc.id}" ${selected}>${forc.nome}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						
						<tr>
							<td align="right">Observacao:</td>
							<td>&nbsp;&nbsp;<textarea name="observacao" cols="20" rows="4" class="input" >${model.observacao}</textarea> </td>
						</tr>
					</table>
					<br>
					
					<table width="100%" height="200" class="displaytag">
						<tr>
							<td valign="top">
								<div>
									<select multiple="multiple" style="width: 100%; height: 100px" ondblclick="addPerfume(this);" class="input">
										<c:forEach var="p" items="${model.perfumes}">
											<option value="${p.id}">${p.nome}&nbsp;-&nbsp;${p.tamanho}ml</option>
										</c:forEach>
									</select>
								</div>
							</td>
							
							
							<td valign="top">
								<table width="100%" class="displaytag">
									<thead>
										<tr >
											<th width="45%">Perfume</th>
											<th width="25%">Preço compra</th>
											<th width="25%">Quantidade</th>
											<th width="5%">Ação</th>
										</tr>
									</thead>
									<tbody id="perfumes">
										<c:forEach var="prod" items="${model.loteProdutoForm}">
											<tr id="trPerfume${prod.idPerfume}">
									 			<td>${prod.nomePerfume} - ${prod.quantidade}ml</td>
								 	 			<td align="center"><input class="valores" name="preco;${prod.idPerfume}" type="text" value="${prod.preco}" onblur="calculaTotal()"></input></td>
									 			<td align="center"><input id="qtde${prod.idPerfume}" name="quantidade;${prod.idPerfume}" type="text" value="${prod.quantidade}" onblur="calculaTotal()"></input></td>
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
						<br>
					<table width="100%">
						<tr>
							<td height="45" align="center" ><input type="submit" value="Salvar Lote" class="button"> </td>	
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
				preco = parseFloat(precoStr.replace(",",".")); 
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
	

	function onSubmit(){
		

		if ( $("#dataCompra").val() == null || $("#dataCompra").val() == '' ){
			$("#fieldDataCompra").css("color","red");
			$("#msgErro").slideDown("slow");
			return false;
		}else{
			$("#fieldDataCompra").css("color","black");
		}	 

		if ( $("#fornecedor").val() == null || $("#fornecedor").val() == -1 ){
			$("#fieldFornecedor").css("color","red");
			$("#msgErro").slideDown("slow");

			return false;
		}

		if (this.validaPrecosProdutos()){
			jAlertte('Preço ou quantidade não foi preenchido!', 'ERRO');
			return false;	
		}
		$("#fieldFornecedor").css("color","black");
		$("#msgErro").hide();
		return true;
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
