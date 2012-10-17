<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>

<c:set var="perf" value="${perfumeVo}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- cabeçalho com javascript e stilos -->
	<wjaa:header/>


	<script type="text/javascript">

		


	function validaform(){
		
		
		var retorno = true;
		var chamaAjax = false;

		//campos do form
		var nome = $("#nome").val();
		var marca = $("#marca").val();
		var tipo = $("#tipo").val();
		var tamanho = $("#tamanho").val();
		var observ = $("#observ").val();
		var idPerfume = $("#idPerfume").val();
		

		//divs de atenção
		var divRetorno = $("#divRetorno");
	
		//nome
		if(nome == ""){
			document.getElementById('fieldNome').style.color = '#FF0000';
			retorno = false;
		}else{
			document.getElementById('fieldNome').style.color = '';
			//retorno = true;
		}
		
		//marca
		if(marca == ""){
			document.getElementById('fieldMarca').style.color = '#FF0000';
			retorno = false;
		}else{
			document.getElementById('fieldMarca').style.color = '';
			//retorno = true;
		}
		
		//tipo
		if(tipo == ""){
			document.getElementById('fieldTipo').style.color = '#FF0000';
			retorno = false;
		}else{
			document.getElementById('fieldTipo').style.color = '';
			//retorno = true;
		}

		
		//tamanho
		if(tamanho == ""){
			document.getElementById('fieldTamanho').style.color = '#FF0000';
			retorno = false;
		}else{
			document.getElementById('fieldTamanho').style.color = '';
			//retorno = true;
		}
		
		
		if(!retorno){
			divRetorno.slideDown("slow");
		}

	
		if(retorno){
			$.post("/controle/manterPerfume.do?",{dispatch: "editar",
				nome: nome,
				marca: marca,
				tipo: tipo,
				tamanho: tamanho,
				idPerfume :idPerfume,
				observ: observ },

					function(data){
					if(data == 'erro'){
						jAlertte('Não foi possível realisar a operação, entre em contato com o administrador do sistema', 'ERRO DE OPERAÇÃO');
					}else{
						if(data == 'true'){
							
						}else{
							jConfirm('Deseja cadastrar outro perfume?', 'PERFUME SALVO COM SUCESSO!', function(r) {
									if(r){
										window.location.href="/controle/cadastroPerfume.do";
									}else{
										window.location.href="/controle/buscaPerfume.do";
									}	
							});
						}
					}
				}
				);
			}

	}

</script>
	






</head>
<body>
	<div id="DivGeral">
	<!-- menu -->
	<wjaa:menu/>
	
	<!-- feedback -->
	<wjaa:feedback descricao="Home\Administração Sistema\Perfume\Cadastro"/>
	
	<div id="DivConteudo">
<!--  	<h1>Sistema de Controle "</h1>-->

	<div id="divConteudo">
		<div id="divTextoConteudo">Cadastro de Perfumes</div><br>
		<div id="divRetorno" style="display:none;"><font color="red" size="3" >* Verifique os campos em Vermelho</font></div>
		<br><br>
<center>

	
<form action="">	

	<input type="hidden" value="${perf.idPerfume }" id="idPerfume" name="idPerfume" >


	<table align="center" >
		<tr>
			<td id="fieldNome" class="Fonte01">Nome </td>
			<td id="fieldMarca" class="Fonte01">Marca </td>
		</tr>		
		<tr>
			<td><input type="text" id="nome" name="nome" class="input" size="50" value="${perf.nome}">&nbsp;</td>
			<td><input type="text" id="marca" name="marca" class="input" size="30" value="${perf.marca}"></td>
		</tr>
	
		<tr><td></td></tr>
		<tr>
			<td id="fieldTipo" class="Fonte01" >Tipo Perfume</td>
			<td id="fieldTamanho" class="Fonte01" >Tamanho (ml)</td>
		</tr>
			
		<tr>
			<td> 
				<select id="tipo" class="input">
					<option  ></option>
					<c:if test="${perf.tipo == 'Masculino'}">
						<option value="Masculino"  selected="selected">&nbsp; Masculino &nbsp;</option>	
						<option value="Feminino">&nbsp; Feminino&nbsp; </option>
						<option value="Unisexy" >&nbsp; Unisexy &nbsp;</option>
					</c:if>
					<c:if test="${perf.tipo == 'Feminino'}">
						<option value="Masculino" >&nbsp; Masculino &nbsp;</option>	
						<option value="Feminino"  selected="selected">&nbsp; Feminino&nbsp; </option>
						<option value="Unisexy" >&nbsp; Unisexy &nbsp;</option>
					</c:if>
					<c:if test="${perf.tipo == 'Unisexy'}">
						<option value="Masculino">&nbsp; Masculino &nbsp;</option>	
						<option value="Feminino">&nbsp; Feminino&nbsp; </option>
						<option value="Unisexy" selected="selected">&nbsp; Unisexy &nbsp;</option>
					</c:if>
				</select>
			</td>
			<td><input type="text" id="tamanho" class="input" size="5" value="${perf.tamanho}">&nbsp;</td>
			
			</tr>	
		<tr><td></td></tr>
		<tr><td></td></tr>
		
		<tr>
			<td class="Fonte01" >Observação</td>
		</tr>
		<tr>
			<td><textarea id="observ" rows="2" cols="30" class="input" >${perf.observacao}</textarea>&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<br>
		<tr>
			<td height="45" colspan="3" align="center"><input type="button" value="Salvar Perfume" onclick="validaform();" class="button"> </td>	
		</tr>		
	</table>
</form>	

</center>
		
	
	<!-- rodape -->
	<wjaa:rodape/>
	
	</div>
	
	
		
	
	</body>
	

<script type="text/javascript">

var c = document.forms[0];

MaskInput(c.cpf, "999.999.999-99");
MaskInput(c.dddFone1, "99");

MaskInput(c.dddFone1, "99");
MaskInput(c.fone1, "9999-9999");
MaskInput(c.dddFone2, "99");
MaskInput(c.fone2, "9999-9999");
MaskInput(c.dataNascimento, "99/99/9999");
MaskInput(c.cep, "99999-999");


</script>
	
	
	

</html>