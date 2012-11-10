<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="./arquivos/css/geral.css" rel="stylesheet" type="text/css" />

<script language="JavaScript" src="pages/jquery-1.4.4.min.js" type="text/JavaScript"></script>


<script type="text/javascript">

	function validaResposta(){
		var retorno = false;
		var chamaAjax = false;
		var login = $("#login").val().replace(/ /g, "");
		var senha = $("#senha").val().replace(/ /g, "");
		var senhaErrada = $("#divSenhaErrada");

		var divLogin = $("#userForm");
		var divSenha = $("#senhaForm");
		

		if(login == ""){
			divLogin.slideDown("slow");
		}else{
			divLogin.hide();
		}
		if(senha == ""){
			divSenha.slideDown("slow");
		}else{
			divSenha.hide();
		}

		if(login != "" && senha != ""){
			$.post("loginUsuario.action?",{dispatch: "verificaUsuario", login: login , senha: senha  },
		
					function(data){
						
						if(data == "error" ){
                   			// $("#divCarregando").hide();
                    		//	senhaErrada.slideDown("slow");
                    			//senhaErrada.hide();		
							retorno = true;   
                            document.forms[0].submit();
                		}else{
                			if(data=="logado"){
                                retorno = true;   
                                document.forms[0].submit();
                            }
                    		}				
						
					}
				);
			}
	
		return retorno;
		
	}

	function logou(){

		var erroLogin = "${requestScope.erro}"; 
		if (erroLogin == "erro"){
			var divErro = $("#userPassInvalido");
			divErro.slideDown("slow");
		}

	}

</script>

<style>
.bordaBoxLogin {bbackground: ttransparent; width:50%;}
.bordaBoxLogin .b1, .bordaBoxLogin .b2, .bordaBoxLogin .b3, .bordaBoxLogin .b4, .bordaBoxLogin .b1b, .bordaBoxLogin .b2b, .bordaBoxLogin .b3b, .bordaBoxLogin .b4b {display:block; overflow:hidden; font-size:1px;}
.bordaBoxLogin .b1, .bordaBoxLogin .b2, .bordaBoxLogin .b3, .bordaBoxLogin .b1b, .bordaBoxLogin .b2b, .bordaBoxLogin .b3b {height:1px;}
.bordaBoxLogin .b2, .bordaBoxLogin .b3, .bordaBoxLogin .b4 {background:#CECECE; border-left:1px solid #999; border-right:1px solid #999;}
.bordaBoxLogin .b1 {margin:0 5px; background:#999;}
.bordaBoxLogin .b2 {margin:0 3px; border-width:0 2px;}
.bordaBoxLogin .b3 {margin:0 2px;}
.bordaBoxLogin .b4 {height:2px; margin:0 1px;}
.bordaBoxLogin .conteudoLogin {padding:5px;display:block; background:#CECECE; border-left:1px solid #999; border-right:1px solid #999;}
</style>

</head>
<body>

<div id="DivGeral" align="center">
	
	
	<div align="center" style="margin-top: 150px">
	
	<div class="bordaBoxLogin">
	<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
	<div class="conteudoLogin">
		<form id="form" name="form" action="loginUsuario.action?dispatch=login" method="post" onsubmit="return validaResposta(this);" >
			<table>
				<tr>
				  <td>
					<img src="./pages/images/logo.png" title="HUB7" width="128" height="128" />  
				  </td>
				  
				  <td>
						<table align="center" >
				
							<tr>
								<td class="Fonte01" colspan="2"><div id="userPassInvalido" style="display:none;"><font color="red" size="2" >Usuário ou senha inválida!</font></div></td>
								
							</tr>
							<tr>
								<td class="Fonte01">Login:&nbsp;&nbsp;</td>
								<td><input type="text" name="login" id="login"  /><div id="userForm" style="display:none;"><font color="red" size="2" >Usuário em Branco</font></div></td>
							</tr>
							<tr>
								<td class="Fonte01" >Senha:&nbsp;&nbsp;</td>
								<td><input type="password" name="senha" id="senha" /><div id="senhaForm" style="display:none;"><font color="red" size="2" >Senha em Branco</font></div></td>
								
							</tr>
							<tr height="10px"><td>&nbsp;</td></tr>
							<tr>
								<td colspan="2" align="center"><input type="submit" value="Logar" id="logar" name="logar" onclick="validaResposta();"  class="button"> </td>
							</tr>
						</table>	  
				  
				  </td>
				</tr>
			</table>
			
		</form>
	</div>
	<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
	</div>
	
	
	
	
	<div id="divSenhaErrada" style="border:1px solid #1a6780; display:none; margin:10px; padding:10px; background-color:#e3eff3;">		
	<table align="center">
		<tr>
			<td><font color="red">Usuário ou Senha Inválidos </font> </td>
		</tr>
	</table>
	</div>
	
	<br><br><br><br><br><br><br><br><br><br>
	
</div>
	
	<!-- rodape -->
	<wjaa:rodape/> 
	
</div>









</body>
</html>

<script>
	//verificando se logou
	logou();
</script>