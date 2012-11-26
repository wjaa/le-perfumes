<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"  prefix="html"%>

<c:set var="model" value="${requestScope.fornecedorVo}"></c:set>
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
		<wjaa:feedback descricao="Home\Administração Sistema\Fornecedor\Cadastro"/>
		
		<div id="DivConteudo">
	
			<div id="divConteudo">
				<div id="divTextoConteudo">Cadastro de Fornecedores</div>
				<br><br>
				<html:form action="/manterFornecedor.do" onsubmit="return onSubmit();" >
					<html:hidden property="dispatch" value="salvar"/>
					<html:hidden property="id" value="${model.id}"/>
					<table align="center">
						<tr>
							<td colspan="3" align="center"><div style="display: none; color: red;" id="msgErro">Verifique os campos em vermelho</div></td>
						</tr>
						<tr>
							<td align="right" class="Fonte01" id="fieldNome">Nome:</td>
							<td align="right" class="Fonte01">&nbsp;&nbsp;</td>
							<td><html:text  styleClass="input" property="nome" value="${model.nome}" size="40" /></td>
						</tr>
						
						<tr>
							<td align="right" class="Fonte01">Endereço:</td>
							<td align="right" class="Fonte01">&nbsp;&nbsp;</td>
							<td><html:text styleClass="input" property="endereco"  value="${model.endereco}" size="70"/></td>
						</tr>
						
						<tr>
							<td align="right" class="Fonte01">Telefone:</td>
							<td align="right" class="Fonte01">&nbsp;&nbsp;</td>
							<td><html:text styleClass="input" property="telefone1" value="${model.telefone1}"  size="13" /></td>
						</tr>
						
						<tr>
							<td align="right" class="Fonte01">Outro Telefone:</td>
							<td align="right" class="Fonte01">&nbsp;&nbsp;</td>
							<td><html:text  styleClass="input" property="telefone2" value="${model.telefone2}"  size="13" /></td>
						</tr>
						
						<tr>
							<td align="right" class="Fonte01">Email:</td>
							<td align="right" class="Fonte01">&nbsp;&nbsp;</td>
							<td><html:text styleClass="input" property="email" size="40"  value="${model.email}"  /></td>
						</tr>
						
						<tr>
							<td align="right" class="Fonte01">Site:</td>
							<td align="right" class="Fonte01">&nbsp;&nbsp;</td>
							<td><html:text  styleClass="input" property="site" size="50"  value="${model.site}"  /></td>
						</tr>
						
						<tr>
							<td align="right" class="Fonte01">Dados Pagamento:</td>
							<td align="right" class="Fonte01">&nbsp;&nbsp;</td>
							<td><html:textarea  styleClass="input" property="dadosPagamento" cols="50" rows="4"  value="${model.dadosPagamento}" /></td>
						</tr>
						
						
						<tr>
							<td align="right" class="Fonte01">Observacao:</td>
							<td align="right" class="Fonte01">&nbsp;&nbsp;</td>
							<td><html:textarea styleClass="input" property="observacao" cols="50" rows="4"  value="${model.observacao}" /></td>
						</tr>
						<tr height="30">
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<input type="button" class="button" value="Voltar" onclick="window.location.href='buscaFornecedor.do'" />
								&nbsp;
								&nbsp;
								<html:submit styleClass="button" value="Salvar" /> 
							</td>
							
							
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

	MaskInput(c.telefone1, "(99)9999-9999");
	MaskInput(c.telefone2, "(99)9999-9999");



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