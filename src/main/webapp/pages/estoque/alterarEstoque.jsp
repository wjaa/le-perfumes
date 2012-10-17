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

	<style type="text/css">
	
		.valores{
			border: 1px solid #cdcdcd;
			width: 50px;
		}
		
		.valoresSaida{
			border: 1px solid #cdcdcd;
			width: 50px;
		}
	
	</style>


</head>

<body>
	<div id="DivGeral">
		<!-- menu -->
		<wjaa:menu/>
		
		<!-- feedback -->
		<wjaa:feedback descricao="Home\Lote\Distribuição\Distribuir perfumes"/>
		
		<div id="DivConteudo">
	
			<div id="divConteudo">
				<div id="divTextoConteudo">Distribuir perfumes</div>
				<br>
				<br>
					<table>
						<tr>
							<td class="Fonte01">
								Distribuir outro perfume:&nbsp;&nbsp;<select class="input" id="perfumesChange" onchange="mudarPefume(this);">
									<c:forEach var="lp" items="${allPerfumes.loteProdutoForm}" >
										<c:set var="selected" value=""></c:set>
										<c:if test="${lp.idPerfume == lote.idPerfume}">
											<c:set var="selected" value="selected"></c:set>
										</c:if>
										<option ${selected} value="manterEstoque.do?dispatch=alterar&idLote=${allPerfumes.id}&idPerfume=${lp.idPerfume}&qtdeMax=${lp.quantidade}">${lp.nomePerfume}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</table>
					<br>
					<table class="displaytag" align="center" >
						<thead>
							<tr>
								<th>ID do Lote</th>
								<th>Data da Compra</th>
								<th>Obs</th>
								<th >Nome Perfume</th>
								<th>Quantidade Total</th>
							</tr>
						</thead>												
						
						<tr>	
							<td>${lote.id}</td>
							<td>${lote.strDataCompra}</td>
							<td>${lote.observacao}</td>
							<td>${lote.nomePerfume}</td>
							<td>${lote.qtdeParcial}</td>
							<input type="hidden" id="qtdeMax" value="${lote.qtdeParcial}"/>
						
						</tr>
					</table>
					<br>
					<br>
					<html:form action="/manterEstoque.do?dispatch=save" onsubmit="return onSubmit();" >
						
					<table width="100%" >
						<thead>
							<tr>
								<th><wjaa:hint texto="Distribua aqui os perfumes desse lote para cada vendedor." style="width:50%;" />						
								<th><wjaa:hint texto="Ajuste aqui os perfumes que foram quebrados, extraviados ou perdidos."/>
							</tr>	
						</thead>
						<tr>
							<td valign="top">
								<table width="100%" class="displaytag" >
									<thead>
										<tr>
											<th>Vendedores</th>						
											<th>Divisão do Lote</th>
										</tr>	
									</thead>	
										<tr>
											<td valign="top">
												<div>
													<select multiple="multiple" style="width: 100%; height: 100%" ondblclick="addVendedor(this);" class="input">
														<c:forEach var="v" items="${vendedores}">
															<option value="${v.id}">${v.nome}</option>
														</c:forEach>
													</select>
												</div>
											</td>
											
											
											<td valign="top">
												
													<input type="hidden" name="idPerfume" value="${lote.idPerfume}"/>
													<input type="hidden" name="idLote" value="${lote.id}"/>
											
													<table class="displaytag">
														<thead>
															<tr>
																<th width="110px">Nome Vendedor</th>
																<th width="70px">Quantidade</th>
																<th width="40px">Ação</th>
															</tr>
														</thead>
														<tbody id="vendedores">
															<c:forEach var="entrada" items="${listaEntradaVendedores.estoqueEntradaForm}">
																<c:forEach var="vend" items="${entrada.vendedores}">
																	<tr id="trVendedor${vend.id}">
															 			<td>${vend.nome}</td>
															 			<td align="center"><input id="idVendedor${vend.id}" name="idVendedor;${vend.id}" type="text" value="${vend.qtde}" class="valores"></input></td>
															 			<td align="center"><img src="pages/images/removeBtn.png"  style="cursor: pointer;" onclick="removeVendedor(${vend.id})"></img></td>
														 			</tr>
													 			</c:forEach>
															</c:forEach>
														</tbody>
													</table>
				
											</td>
										</tr>	
								
								</table>
							</td>
							
							<td valign="top">
								<table width="100%" class="displaytag" >
									<thead>
										<tr>
											
											<th style="background-color: #A2F2A5;">Vendedores</th>
											<th style="background-color: #A2F2A5;">Ajuste de saida</th>
										</tr>
										
									</thead>
								<tr>	
									<td valign="top">
										<div>
											<select multiple="multiple" style="width: 100%; height: 100%" ondblclick="addVendedorAjuste(this);" class="input">
												<c:forEach var="v" items="${vendedores}">
													<option value="${v.id}">${v.nome}</option>
												</c:forEach>
											</select>
										</div>
									</td>
									<td valign="top">
										<table  width="100%" class="displaytag">
											<thead>
												<tr>
													<th width="110px" style="background-color: #A2F2A5;">Nome Vendedor</th>
													<th width="70px" style="background-color: #A2F2A5;">Quantidade</th>
													<th width="110px" style="background-color: #A2F2A5;">Obs</th>
													<th width="40px" style="background-color: #A2F2A5;">Ação</th>
												</tr>
											</thead>
											<tbody id="vendedoresAjuste">
												<c:forEach var="saida" items="${listaAjusteVendedores.estoqueAjusteSaidaForm}">
													<tr id="trVendedorAjuste${saida.idVendedor}">
											 			<td>${saida.nomeVendedor}</td>
											 			<td align="center"><input id="idVendedorSaida${entrada.idVendedor}" name="idVendedorSaida;${saida.idVendedor}" type="text" value="${saida.qtde}" class="valoresSaida"></input></td>
											 			<td align="center"><textarea id="idVendedorSaidaObs${entrada.idVendedor}" name="idVendedorSaidaObs;${saida.idVendedor}" >${saida.obs}</textarea></td>
											 			<td align="center"><img src="pages/images/removeBtn.png"  style="cursor: pointer;" onclick="removeVendedorAjuste(${saida.idVendedor})"></img></td>
										 			</tr>
												</c:forEach>
											</tbody>
										</table>
									</td>
								
						
										
									</tr>
								</table>
							</td>
						</tr>
						
						
						
							
					
					</table>
  				 </html:form>
						<br>
					<table width="100%">
						<tr>
							<td height="45" align="center" ><input type="button" value="Voltar" class="button" onclick="voltar();">&nbsp;&nbsp;&nbsp;<input type="button" value="Salvar Lote" class="button" onclick="validate();"> </td>	
						</tr>	
					</table>
					
				
			</div>
		</div>
		
		<!-- rodape -->
		<wjaa:rodape/>
		
	</div>
</body>
</html>
<script>

	function voltar(){
		window.location.href = "${actionRetorno}";
	}

	function mudarPefume(select){
		window.location.href = select.value;
	}	

	function validate(){
		onSubmit();
	}

	function onSubmit(){
		this.validaValorTotal();
	}

	function validaValorTotal(){
		var total = 0;
		$(".valores").each(function(i){
			
			if (this.value != null || this.value != ''){
				total = total + parseInt(this.value);
			}else{
				this.value = 0;
			}
		});
		
		var qtdeMax = $("#qtdeMax").val();

		if ( qtdeMax == total ){
			submitForm();
			return true;
		}

		var retorno = true;
		if ( qtdeMax > total ){
			jConfirm('O total de perfume dos vendedores é menor que total do lote.\n Deseja continuar?', 'FORNECEDOR CADASTRADO COM SUCESSO!', function(r) {
				if(r){

					submitForm();
					return true;
				}else{
					return false;
				}	
			});
			
		}
		if (qtdeMax < total){
			jAlertte('Os vendedores tem mais perfume do que o lote!', 'ERRO');
			return false;
		}

		return false;
	}


	function submitForm(){
		var str = $("form").serialize();
		$.ajax({
			url: 'manterEstoque.do?dispatch=save&' + str,
			success: function(data) {
				jAlertte("Estoque alterado com sucesso!",'INFO');
			},
			error:function (xhr, ajaxOptions){
				jAlertte(xhr.responseText,'ERRO');
			  }
		});
	}

	function addVendedorAjuste(comboVendedor){
		var vendedor = comboVendedor.options[comboVendedor.selectedIndex];
		var idVendedor = vendedor.value;
		if ($("#idVendedorSaida" + idVendedor).length == 0 ){
			
			var nomeVendedor = vendedor.text;
			$("#vendedoresAjuste").append("<tr id=\"trVendedorAjuste" + idVendedor +  "\">" +
									 "<td> " + nomeVendedor  + "</td>" +
									 "<td align=\"center\"><input id=\"idVendedorSaida" + idVendedor + "\"  name=\"idVendedorSaida;" + idVendedor + "\" type=\"text\" class=\"valoresSaida\"></input></td>" +
									 "<td align=\"center\"><textarea  style=\"width:100%\"  id=\"idVendedorSaidaObs" + idVendedor + "\" name=\"idVendedorSaidaObs;" + idVendedor + "\" ></textarea></td>" +
									 "<td align=\"center\"><img src=\"pages/images/removeBtn.png\"  style=\"cursor: pointer;\" onclick=\"removeVendedorAjuste(" + idVendedor + " )\"></img></td>" +
								 "</tr>");


		}else{
			jAlertte('Vendedor já foi adicionado!', 'Informação');
		}  
		
		
	}

	function addVendedor(comboVendedor){
		var vendedor = comboVendedor.options[comboVendedor.selectedIndex];
		var idVendedor = vendedor.value;
		if ($("#idVendedor" + idVendedor).length == 0 ){
			
			var nomeVendedor = vendedor.text;
			$("#vendedores").append("<tr id=\"trVendedor" + idVendedor +  "\">" +
									 "<td> " + nomeVendedor  + "</td>" +
									 "<td align=\"center\"><input id=\"idVendedor" + idVendedor + "\"  name=\"idVendedor;" + idVendedor + "\" type=\"text\" class=\"valores\"></input></td>" +
									 "<td align=\"center\"><img src=\"pages/images/removeBtn.png\"  style=\"cursor: pointer;\" onclick=\"removeVendedor(" + idVendedor + " )\"></img></td>" +
								 "</tr>");


		}else{
			jAlertte('Vendedor já foi adicionado!', 'Informação');
		}  
		
		
	}

	function removeVendedor(idVendedor){

		jConfirm('Deseja remover esse vendedor da divisão?', 'Dúvida!', function(r) {
			if(r){
				//removendo o tr
				$("#trVendedor" + idVendedor).remove();
			}
		});
		
	}

	function removeVendedorAjuste(idVendedor){

		jConfirm('Deseja remover esse vendedor do ajuste ?', 'Dúvida!', function(r) {
			if(r){
				//removendo o tr
				$("#trVendedorAjuste" + idVendedor).remove();
			}
		});
		
	}

		
</script>	
