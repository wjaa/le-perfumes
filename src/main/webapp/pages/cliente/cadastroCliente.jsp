<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>

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
		var localTrab = $("#localTrab");
		var loja = $("#loja").val();
		var logra = $("#logra").val();
		var numero = $("#numero").val();
		var comple = $("#comple").val();
		var bairro = $("#bairro").val();
		var estado = $("#estado").val();
		var endCidade = $("#endCidade").val();
		var cep = $("#cep").val();
		var status  = $("#status").val();

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
		if(localTrab == ""){
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

		
		if(!retorno){
			divRetorno.slideDown("slow");
		}

		var str = $("form").serialize();
		if(retorno){
			$.post("manterCliente.do?dispatch=salvar&" + str,
					function(data){
					
						if(data == 'true'){
							divCliente.slideDown("slow");
							
						}else{
							jConfirm('Deseja criar outro cliente?', 'CLIENTE CADASTRADO COM SUCESSO', function(r) {
									if(r){
										window.location.href="cadastroCliente.do";
									}else{
										window.location.href="buscaCliente.do";
									}	
							});
									
				
									
							
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

	
	<div id="divCliente" style="display:none;"><font color="red" size="4" >Cliente já Cadastrado no Banco de Dados</font></div>
	
	
<form action="">	
	<table>
	
		<tr>
			<td id="fieldNome" class="Fonte01" colspan="2">Nome </td>
			<td id="fieldCpf" class="Fonte01" >Cpf</td>
			
		</tr>
		
		<tr>
			<td colspan="2"><input type="text" id="nome" name="nome" class="input" size="60">&nbsp;&nbsp;&nbsp; </td>
			<td><input type="text" id="cpf" name="cpf" class="input"> </td>
		</tr>
		<tr><td></td></tr>
		<tr>
			<td id="fieldFone1" class="Fonte01" >Telefone 1 </td>
			<td class="Fonte01" >Telefone 2 </td>
			<td class="Fonte01" >Data Nascimento </td>
		</tr>
			
		<tr>
			<td><input type="text" id="dddFone1" name="dddFone1" class="input" size="3">&nbsp;<input type="text" id="fone1" name="fone1" class="input"> </td>
			<td><input type="text" id="dddFone2" name="dddFone2" class="input" size="3">&nbsp;<input type="text" id="fone2" name="fone2" class="input">&nbsp; </td>
			<td>&nbsp;<input type="text" id="dataNascimento" name="dataNascimento" class="input" size="10"> </td>
		</tr>	
		<tr><td></td></tr>
		<tr>
			<td id="fieldEmail" class="Fonte01"  >E-mail</td>
			<td id="fieldContato" class="Fonte01" >Contato</td>
			<td class="Fonte01" >Sexo</td>
		</tr>
		
		<tr>
			<td colspan="1"> <input type="text" id="email" name="email" class="input" size="33">&nbsp;&nbsp;&nbsp;</td>
			<td> 
				<select id="contato" name="contato" class="input">
					<option></option>
					<option value="Leandro" >Leandro&nbsp;</option>
					<option value="Junior">Junior&nbsp; </option>
				</select>
			</td>
			<td align="left">
				<select id="sexo" name="sexo" class="input">
					<option  ></option>
					<option value="0" >Masculino &nbsp;</option>
					<option value="1">Feminino &nbsp; </option>
				</select>		
			</td>
		</tr>
		<tr><td></td></tr>
		
		<tr>
			<td id="fieldTrab" class="Fonte01"  >Local Trabalho</td>
			<td id="fieldLoja" class="Fonte01" colspan="2" >Loja</td>
		</tr>
		<tr>
			<td><textarea id="localTrab" name="localTrab" rows="2" cols="30" class="input"></textarea></td>
			<td colspan="2"> <textarea id="loja" name="loja" rows="2" cols="30" class="input"></textarea></td>
		</tr>
		
		<tr>
			<td class="Fonte01" colspan="2" >Logradouro</td>
			<td class="Fonte01"  >Número</td>
		</tr>
		<tr>
			<td colspan="2"><input type="text" id="logra" name="logra"  class="input" size="60"></td>
			<td ><input type="text" id="numero" name="numero" class="input" size="15"></td>
		</tr>	
		
		<tr>
			<td class="Fonte01"  >Complemento</td>
			<td class="Fonte01"  >Bairro</td>
			<td class="Fonte01" >UF</td>
		</tr>
		<tr>
			<td><input type="text" id="comple" name="comple" class="input" size="40"></td>
			<td><input type="text" id="bairro" name="bairro" class="input" size="15"></td>
			<td>
				<select id="estado" name="estado">
					<option>&nbsp;Selecione&nbsp;</option>
					<option value="SP" selected="selected">SP</option>
					<option value="RJ">RJ</option>
					<option value="MG">MG</option>
					<option value="ES">ES</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td class="Fonte01"  >Cidade</td>
			<td class="Fonte01"  >Cep</td>
			<td class="Fonte01"  >Status</td>
		</tr>
		
		<tr>
			<td><input type="text" id="endCidade" name="endCidade" class="input" size="40" value="São Paulo"></td>
			<td><input type="text" id="cep" name="cep" class="input" size="11"></td>
			<td>
				<select id="status" name="status" class="input">
					
						<option value="0" selected="selected">Ativo</option>
						<option value="1">Inativo</option>
					
		
				</select>
			
			</td>
		</tr>
		
		<tr>
			<td height="45" colspan="3" align="center">
				<input type="button" value="Voltar" onclick="window.location.href='buscaCliente.do'" class="button"/>
				&nbsp;
				&nbsp;	
				<input type="button" value="Salvar Cliente" onclick="validaform();" class="button"/> 
			</td>	
		</tr>		
	</table>
</form>	
	
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