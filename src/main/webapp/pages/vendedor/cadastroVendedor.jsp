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

</head>

<body>
	<div id="DivGeral">
		<!-- menu -->
		<wjaa:menu/>
		
		<!-- feedback -->
		<wjaa:feedback descricao="Home\Administração Sistema\Vendedor\Cadastro"/>
		
		<div id="DivConteudo">
	
			<div id="divConteudo">
				<div id="divTextoConteudo">Cadastro de Vendedores</div>
				<br><br>
				<html:form action="/manterVendedor.do" onsubmit="return onSubmit();" >
					<html:hidden property="dispatch" value="saveEdit"/>
					<html:hidden property="id" value="${model.id}"/>
					<table align="center">
						<tr>
							<td colspan="3" align="center"><div style="display: none; color: red;" id="msgErro">Verifique os campos em vermelho</div></td>
						</tr>
						<tr>
							<td align="right" class="Fonte01" id="fieldNome">Nome:</td>
							<td align="right" class="Fonte01">&nbsp;&nbsp;</td>
							<td><html:text  styleClass="input" property="nome" value="${model.nome}" size="50" maxlength="50" /></td>
						</tr>
						
						<tr>
							<td align="right" class="Fonte01">Telefone:</td>
							<td align="right" class="Fonte01">&nbsp;&nbsp;</td>
							<td><html:text styleClass="input" property="telefone"  value="${model.telefone}" size="13" maxlength="13"/></td>
						</tr>
						
						<tr>
							<td colspan="3" align="center"><html:submit styleClass="button" value="Salvar" /> </td>
							
							
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

<script type="text/javascript" language="javascript">

	var c = document.forms[0];

	MaskInput(c.telefone, "(99)9999-9999");


	function onSubmit(){
		var nome = $("input[name$='nome']").val();

		if (nome == null || nome == '' ){
			$("#fieldNome").css("color","red");
			$("#msgErro").slideDown("slow");
			return false;
		}else{
			$("#fieldNome").css("color","black");
			$("#msgErro").hide();
		}
			
		return true;	
	}	
		

</script>