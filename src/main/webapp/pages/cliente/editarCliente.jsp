<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>

<c:set var="cliente" value="${clienteVo}" />

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
		var cpf = $("#cpf").val();
		var dddFone1 = $("#dddFone1").val();
		var fone1 = $("#fone1").val();
		var dddFone2 = $("#dddFone2").val();
		var fone2 = $("#fone2").val();
		var dataNascimento = $("#dataNascimento").val();
		var email = $("#email").val();
		var contato = $("#contato").val();
		var sexo = $("#sexo").val();
		var localTRabalho = $("#localTRabalho").val();
		var loja = $("#loja").val();
		var logra = $("#logra").val();
		var numero = $("#numero").val();
		var comple = $("#comple").val();
		var bairro = $("#bairro").val();
		var estado = $("#estado").val();
		var cidade = $("#cidade").val();
		var cep = $("#cep").val();
		var status = $("#status").val();
		var idCli = $("#idCli").val();

		//divs de atenção
		
		var divRetorno = $("#divRetorno");
		var divCliente = $("#divCliente");
		

	
		//nome
		if(nome == ""){
			document.getElementById('fieldNome').style.color = '#FF0000';
			retorno = false;
		}else{
			document.getElementById('fieldNome').style.color = '';
			//retorno = true;
		}
		
		//cpf
		if(cpf == ""){
			document.getElementById('fieldCpf').style.color = '#FF0000';
			retorno = false;
		}else{
			document.getElementById('fieldCpf').style.color = '';
			//retorno = true;
		}
		
		//dddFone1
		if(fone1.length < 9 || dddFone1 == "" || fone1 == ""){
			document.getElementById('fieldFone1').style.color = '#FF0000';
			retorno = false;
		}else{
			document.getElementById('fieldFone1').style.color = '';
			//retorno = true;
		}

		
		//contato
		if(contato == ""){
			document.getElementById('fieldContato').style.color = '#FF0000';
			retorno = false;
		}else{
			document.getElementById('fieldContato').style.color = '';
			//retorno = true;
		}
		
		//localTRabalho
		if(localTRabalho == ""){
			document.getElementById('fieldTrab').style.color = '#FF0000';
			retorno = false;
		}else{
			document.getElementById('fieldTrab').style.color = '';
			//retorno = true;
		}
		
		//loja
		if(loja == ""){
			document.getElementById('fieldLoja').style.color = '#FF0000';
			retorno = false;
		}else{
			document.getElementById('fieldLoja').style.color = '';
			//retorno = true;
		}

		//email
		
		/*regex validacao de email 
		var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		var valido = filter.test(email);
		
		if(!valido){
			document.getElementById('fieldEmail').style.color = '#FF0000';
			retorno = false;
		}else{
			document.getElementById('fieldEmail').style.color = '';
			retorno = true;
		}*/ 


		if(!retorno){
			divRetorno.slideDown("slow");
		}

	
		if(retorno){
			$.post("/controle/manterCliente.do?",{dispatch: "editar",
				nome : nome ,
				cpf : cpf ,
				dddFone1 : dddFone1 ,
				fone1 : fone1 ,
				dddFone2 : dddFone2 ,
				fone2 : fone2 ,
				dataNascimento : dataNascimento ,
				sexo : sexo ,
				email : email ,
				contato : contato ,
				localTRabalho : localTRabalho ,
				loja : loja ,
				logra : logra ,
				numero : numero ,
				comple : comple ,
				bairro : bairro ,
				estado : estado ,
				cidade : cidade ,
				status: status,
				cep : cep,
				idCli: idCli },

					function(data){
					
					if(data == 'erro'){
						
						jAlertte('Não foi possível realisar a operação, entre em contato com o administrador do sistema', 'ERRO DE OPERAÇÃO');
						
					}else{
						if(data == 'true'){
							divCliente.slideDown("slow");
							divCliente.hide();
							
						}else{
							jConfirm('Deseja criar um novo cliente?', 'Cliente salvo com sucesso!', function(r) {
									if(r){
										window.location.href="/controle/cadastroCliente.do";
									}else{
										window.location.href="/controle/buscaCliente.do";
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
	<wjaa:feedback descricao="Home\Administração Sistema\Cliente\Cadastro" />
	
	<div id="DivConteudo">
<!--  	<h1>Sistema de Controle "</h1>-->

	<div id="divConteudo">
		<div id="divTextoConteudo">Cadastro de Clientes</div><br>
		<div id="divRetorno" style="display:none;"><font color="red" size="3" >* Verifique os campos em Vermelho</font></div>
		<br><br>
<center>
	
	<center><div id="divCliente" style="display:none;"><font color="red" size="4" >Cliente já Cadastrado no Banco de Dados</font></div></center>
	
	
<form action="">	

	<input type="hidden" value="${cliente.idCliente }" id="idCli" name="idCli" >
	
	<table align="center" >
	
		<tr>
			<td id="fieldNome" class="Fonte01" colspan="2">Nome </td>
			<td id="fieldCpf" class="Fonte01" >Cpf</td>
			
		</tr>
		
		<tr>
			<td colspan="2"><input type="text" id="nome" name="nome" class="input" size="60" value="${cliente.nomeFull}">&nbsp;&nbsp;&nbsp; </td>
			<td><input type="text" id="cpf" name="cpf" class="input" value="${cliente.cpf}"> </td>
		</tr>
		<tr><td></td></tr>
		<tr>
			<td id="fieldFone1" class="Fonte01" >Telefone 1 </td>
			<td class="Fonte01" >Telefone 2 </td>
			<td class="Fonte01" >Data Nascimento </td>
		</tr>
			
		<tr>
			<td><input type="text" id="dddFone1" class="input" size="3" value="${cliente.dddFone1}" > &nbsp;<input type="text" id="fone1" class="input" value="${cliente.fone1}"> </td>
			<td><input type="text" id="dddFone2" class="input" size="3" value="${cliente.dddFone2}" > &nbsp;<input type="text" id="fone2" class="input" value="${cliente.fone2}">&nbsp; </td>
			<td>&nbsp;<input type="text" id="dataNascimento" class="input" size="10" value="${cliente.mokDataNascimento}"> </td>
		</tr>	
		<tr><td></td></tr>
		<tr>
			<td id="fieldEmail" class="Fonte01"  >E-mail</td>
			<td id="fieldContato" class="Fonte01" >Contato</td>
			<td class="Fonte01" >Sexo</td>
		</tr>
		
		<tr>
			<td colspan="1"> <input type="text" id="email" class="input" size="33" value="${cliente.email}">&nbsp;&nbsp;&nbsp;</td>
			<td> 
				<select id="contato" class="input">
					<c:if test="${cliente.contato == 'Leandro'}">
						<option value="Leandro"  selected="selected">&nbsp; Leandro &nbsp;</option>	
						<option value="Junior" >&nbsp; Junior&nbsp; </option>
					</c:if>
					<c:if test="${cliente.contato == 'Junior'}">
						<option value="Junior" selected="selected">&nbsp; Junior&nbsp; </option>
						<option value="Leandro"  selected="selected">&nbsp; Leandro &nbsp;</option>	
					</c:if>
				</select>
			</td>
			<td align="left">
				<select id="sexo" class="input">
					<c:if test="${cliente.sexo == 0}">
						<option value="0" selected="selected">&nbsp; Masculino &nbsp;</option>	
						<option value="1">&nbsp; Feminino &nbsp; </option>
					</c:if>
					<c:if test="${cliente.sexo == 1}">
						<option value="1" selected="selected">&nbsp; Feminino &nbsp; </option>
						<option value="0" >&nbsp; Masculino &nbsp;</option>	
					</c:if>
				</select>		
			</td>
		</tr>
		<tr><td></td></tr>
		
		<tr>
			<td id="fieldTrab" class="Fonte01"  >Local Trabalho</td>
			<td id="fieldLoja" class="Fonte01" colspan="2" >Loja</td>
		</tr>
		<tr>
			<td><textarea id="localTRabalho" rows="2" cols="30" class="input" >${cliente.localTrabalho}</textarea>&nbsp;&nbsp;&nbsp;</td>
			<td colspan="2"> <textarea id="loja" rows="2" cols="30" class="input" >${cliente.loja}</textarea></td>
		</tr>
		
		<tr>
			<td class="Fonte01" colspan="2" >Logradouro</td>
			<td class="Fonte01"  >Número</td>
		</tr>
		<tr>
			<td colspan="2"><input type="text" id="logra" class="input" size="60" value="${cliente.endLogradouro}"></td>
			<td ><input type="text" id="numero" class="input" size="15" value="${cliente.endNumero}"></td>
		</tr>	
		
		<tr>
			<td class="Fonte01"  >Complemento</td>
			<td class="Fonte01"  >Bairro</td>
			<td class="Fonte01" >UF</td>
		</tr>
		<tr>
			<td><input type="text" id="comple" class="input" size="40" value="${cliente.endComplemento}"></td>
			<td><input type="text" id="bairro" class="input" size="15" value="${cliente.endBairro}"></td>
			<td>
				<select id="estado">
						<c:if test="${cliente.endEstado == 'SP'}">
							<option value="SP" selected="selected">SP</option>
							<option value="RJ">RJ</option>
							<option value="MG">MG</option>
							<option value="ES">ES</option>
						</c:if>
						<c:if test="${cliente.endEstado == 'RJ'}">
							<option value="SP">SP</option>
							<option value="RJ" selected="selected">RJ</option>
							<option value="MG">MG</option>
							<option value="ES">ES</option>
						</c:if>
						
					<c:if test="${cliente.endEstado == 'MG'}">
							<option value="SP">SP</option>
							<option value="RJ">RJ</option>
							<option value="MG" selected="selected">MG</option>
							<option value="ES">ES</option>
						</c:if>						
					
					<c:if test="${cliente.endEstado == 'ES'}">
							<option value="SP">SP</option>
							<option value="RJ">RJ</option>
							<option value="MG">MG</option>
							<option value="ES" selected="selected">ES</option>
						</c:if>
				</select>
			</td>
		</tr>
		
		<tr>
			<td class="Fonte01"  >Cidade</td>
			<td class="Fonte01"  >Cep</td>
			<td class="Fonte01"  >Status</td>
		</tr>
		
		<tr>
			<td><input type="text" id="cidade" class="input" size="40" value="${cliente.endCidade}"></td>
			<td><input type="text" id="cep" class="input" size="9" value="${cliente.endCep}"></td>
			<td>
				<select id="status" class="input">
					<c:if test="${cliente.status == 1}">
						<option value="1" selected="selected">&nbsp; Ativo&nbsp; </option>
						<option value="1">Inativo</option>
					</c:if>
					<c:if test="${cliente.status == 0}">
						<option value="1">Ativo</option>
						<option value="1"selected="selected">&nbsp; Inativo&nbsp; </option>
					</c:if>
				</select>
			
			</td>
		</tr>
		
		<tr>
			<td height="45" colspan="3" align="center"><input type="button" value="Salvar Cliente" onclick="validaform();" class="button"> </td>	
		</tr>		
	</table>
</form>	
	
	
	
	


</center>
		

				
	
	</div>
	</div>
	
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