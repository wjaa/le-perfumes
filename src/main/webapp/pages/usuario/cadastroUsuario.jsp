<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>

<c:set var="model" value="${modelo.usuarioVo}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- cabeçalho com javascript e stilos -->
	<wjaa:header/>
	<script type="text/javascript">
	

	function validaform(){
		
		var retorno = true;
		var chamaAjax = false;
		var idUsuario = "${model.idUsuarioGi}";
		//campos do form
		var nomeFull = $("#nomeFull").val();
		var nome = $("#nome").val();
		var senha = "";
		var senhaConfirm = "";
		var email = $("#email").val().replace(/ /g, "");

		//divs de atenção
		var divNomeFull = $("#divNomeFull");
		var divNome = $("#divNome");
		var divSenha = $("#divSenha");
		var divSenhaConfirm = $("#divSenhaConfirm");
		var divEmail = $("#divEmail");
		var divSenhaDiferente = $("#divSenhaDiferente");
		var divUser  = $("#divUser");
		var divCadastro = $("#divCadastro");

		
		//nome full
		if(nomeFull == ""){
			divNomeFull.slideDown("slow");
			retorno = false;
		}else{
			divNomeFull.hide();
		}
		//nome
		if(nome == ""){
			divNome.slideDown("slow");
			retorno = false;
		}else{
			divNome.hide();
		}

		if (senhaIsShow()){
			senha = $("#senha").val().replace(/ /g, "");
			senhaConfirm = $("#senhaConfirm").val().replace(/ /g, "");

			if(senha != senhaConfirm){
				divSenhaDiferente.slideDown("slow");
				retorno = false;
			}else{
				divSenhaDiferente.hide();
			}
			
			//senha
			if(senha == ""){
				divSenha.slideDown("slow");
				retorno = false;
			}else{
				divSenha.hide();
			}
			//confirma senha
			if(senhaConfirm == ""){
				divSenhaConfirm.slideDown("slow");
				retorno = false;
			}else{
				divSenhaConfirm.hide();
			}

			
		}

		

		//email
		
		/*regex validacao de email*/  
		var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		var valido = filter.test(email);
		
		if(!valido){
			divEmail.slideDown("slow");
			retorno = false;
		}else{
			divEmail.hide();
		}
		
		divUser.hide();
		if(retorno){
			$.post("/controle/manterUsuario.do?",{dispatch: "salvar",
					idUsuario: idUsuario,
					nomeFull: nomeFull ,
					nome: nome,
					senha: senha,
					senhaConfirm: senhaConfirm,
					email: email },
		
					function(data){
						
					
						if(data == 'true'){
							divUser.slideDown("slow");
							
						}else{
							
							//divCadastro.slideDown("slow");
							
							jConfirm('Deseja criar um novo usuário?', 'USUÁRIO SALVO COM SUCESSO!', function(r) {
								
									if(r){
										window.location.href="/controle/cadastroUsuario.do";
									}else{
										window.location.href="/controle/buscaUsuario.do";
									}	
							});
									
				
									
							
						}
									
						
					}
				);
			}


		
		
	}

	function senhaIsShow(){
		if (document.getElementById("idMudarSenha") == null){
			return true;
		}else{
			
			if ($('#idMudarSenha').is(':visible') ){
				return true;
			}else{
				return false;
			}	
		}
		
		
	}	
	
	function mostrarMudarSenha(mudar){
		if (mudar){
			$("#idMudarSenha").show();
			$("#idMostraLinkMudar").hide();
		}else{
			$("#idMudarSenha").hide();
			$("#idMostraLinkMudar").show();
		}		
		
	}	

</script>
	






</head>
<body>
	<div id="DivGeral">
	<!-- menu -->
	<wjaa:menu/>
	
	<!-- feedback -->
	<wjaa:feedback descricao="Home\Administração Sistema\Usuário\Cadastro"/>
	
	<div id="DivConteudo">
<!--  	<h1>Sistema de Controle "</h1>-->

	<div id="divConteudo">
		<div id="divTextoConteudo">Cadastro de Usuários</div>
		<br><br>
<center>

	
	<div id="divUser" style="display:none;"><font color="red" size="3" >Usuário já Cadastrado! Procure-o na busca de usuários.</font></div></center>
	<table>
		<tr>
			<td align="right" Class="Fonte01">Nome Usuário:&nbsp;&nbsp; </td>  
			<td><input type="text" id="nomeFull" name="nomeFull" class="input" size="30" value="${model.nomeFull}"></td>
			<td><div id="divNomeFull" style="display:none;"><font color="red" size="2" >Nome em Branco</font></div></td>
		</tr>
		<tr>
			<td align="right" Class="Fonte01">Login:&nbsp;&nbsp; </td>
			<td><input type="text" id="nome" name="nome" class="input" value="${model.nome}"></td>
			<td><div id="divNome" style="display:none;"><font color="red" size="2" >Login em Branco</font></div></td>
		</tr>
		
		<c:if test="${model == null}">
			<tr>
				<td align="right" Class="Fonte01">Senha:&nbsp;&nbsp; </td>
				<td><input type="password" id="senha" name="senha" class="input"></td>
				<td>
				<div id="divSenha" style="display:none;"><font color="red" size="2" >Senha em Branco</font></div>
				<div id="divSenhaDiferente" style="display:none;"><font color="red" size="2" >As senha não são Iguais</font></div>
				</td>
			</tr>	
			<tr>	
				<td align="right" Class="Fonte01">Confirme:&nbsp;&nbsp; </td>
				<td><input type="password" id="senhaConfirm" name="senhaConfirm" class="input"></td>
				<td><div id="divSenhaConfirm" style="display:none;"><font color="red" size="2" >Confirme a sua senha</font></div> </td>
			</tr>
		</c:if>
		<c:if test="${model != null}">
			<tr id="idMostraLinkMudar">
				<td colspan="3" align="center"><a href="#" onclick="mostrarMudarSenha(true);" >Deseja mudar senha? </a></td>
			</tr>
			<tr>
				<td colspan="3">
					<table id="idMudarSenha" style="display:none;">
						<tr>
							<td colspan="3" align="center"><a href="#" onclick="mostrarMudarSenha(false);" >Não quero mudar senha! </a></td>
						</tr>
						<tr>
							<td align="right" Class="Fonte01">Senha:&nbsp;&nbsp; </td>
							<td><input type="password" id="senha" name="senha" class="input"></td>
							<td>
							<div id="divSenha" style="display:none;"><font color="red" size="2" >Senha em Branco</font></div>
							<div id="divSenhaDiferente" style="display:none;"><font color="red" size="2" >As senha não são Iguais</font></div>
							</td>
						</tr>	
						<tr>	
							<td align="right" Class="Fonte01">Confirme:&nbsp;&nbsp; </td>
							<td><input type="password" id="senhaConfirm" name="senhaConfirm" class="input"></td>
							<td><div id="divSenhaConfirm" style="display:none;"><font color="red" size="2" >Confirme a sua senha</font></div> </td>
						</tr>
					</table>
				
				</td>
			</tr>	
		</c:if>
		<tr>
			<td align="right" Class="Fonte01">Email:&nbsp;&nbsp; </td>
			<td><input type="text" id="email" name="email" class="input" size="30" value="${model.email}"></td>
			<td><div id="divEmail" style="display:none;"><font color="red" size="2" >Email em Branco ou Inválido</font></div></td>
		</tr>
		<tr>
			<td><br></td>
		</tr>
		<tr>
			<td colspan="3" align="center">
			<table>
				<tr>
					<td></td>
					<td>
						<input type="button" value="Voltar" onclick="window.location.href='buscaUsuario.do'" class="button">
						&nbsp;&nbsp;
						<input type="button" value="Salvar Usuário" onclick="validaform();" class="button" >
					</td>
				</tr>
			</table>
			</td>
			
		</tr>
	</table>

	</div>
	</div>
	
		<!-- rodape -->
		<wjaa:rodape/>
	</div>
	
	</body>

</html>