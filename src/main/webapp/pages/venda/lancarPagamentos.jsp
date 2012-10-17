<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<html>
<head>
	<link href="./arquivos/css/displaytag.css" rel="stylesheet" type="text/css" />
	<style>
		
		.data{
			background-color:#F0F0F0 ; 
			margin: 0;
			padding: 0;
			font-family: Arial,Helvetica,sans-serif;
    		border: 1px solid #CDCDCD;
		}
		.valores{
			border: 1px solid #cdcdcd;
		}
		
		.valores1{
			border: 0px solid #cdcdcd;
		}
	</style>
</head>

<body>
<form action="manterVenda.do?dispatch=addPagamentos&idVenda=${pgto.idVenda}" method="post">

<input type="hidden" name="dataInicio" value="${dataInicio}"/>
<input type="hidden" name="dataFim" value="${dataFim}"/>
<input type="hidden" name="idVendedor" value="${idVendedor}"/>
<input type="hidden" name="idCliente" value="${idCliente}"/>
<input type="hidden" name="idStatus" value="${idStatus}"/>

<center>
<table class="displaytag" align="center">
	<thead>
		<tr>
			<th>Data Venda</th>
			<th>Nome Cliente</th>
			<th>Total Venda</th>
			<th>Qtde Parcelas</th>
		</tr>
	</thead>
	<tr>
		<td>${pgto.dataVendaStr}</td>
		<td>${pgto.nomeCliente}</td>
		<td><div id="valorVenda">${pgto.valorStr}</div></td>
		<td>${pgto.qtdeParcela} x</td>
		
	</tr>
</table>
<br></br>
<table cellpadding="2" cellspacing="2" class="displaytag">
	<tr>
		<td colspan="3" align="center" style="font-size: small; color: green"> Preencha os campos para adicionar um novo pagamento.</td>
	</tr>
	<tr height="5px"><td colspan="3">&nbsp;</td></tr>
	
	<tr>
		<td>Data de Pgto: &nbsp; <input type="text" name="dataPagamento" id="dataPagamento" class="data"></input></td>
		<td>Valor do Pgto: &nbsp; <input type="text" name="valorPagamento" id="valorPagamento" class="valores"></input></td>
		<td><img src="pages/images/addBtn.png" alt="Adicionar novo pagamento" title="Adicionar novo pagamento" style="cursor: pointer;" onclick="addPgto(${pgto.qtdeParcela})"/><span>&nbsp;Adicionar novo pagamento.</span></td>
	</tr>

</table>

<br></br>

<table class="displaytag" id="tbPgto">
	<thead>
		<tr>
			<th>Data Pgto</th>
			<th>Valor Pgto</th>
			<th>Ação</th>
		</tr>
	</thead>
	<c:forEach var="p" items="${pgto.pagamentos}">
		<tr id="trpgto${p.id}">
			<td>${p.dataStr}</td>
			<td><div class="valores1">${p.valorStr}</div></td>
			<td><img src="pages/images/removeBtn.png" alt="Remover pagamento" title="Remover pagamento" style="cursor: pointer;" onclick="removePgto('pgto${p.id}')"/></td>
			<input type="hidden" id="pgto${p.id}" name="pgto${p.id}" value="${p.dataStr};${p.valorStr}"></input>
		</tr>
	</c:forEach>
	<tfoot>
		<tr>
			<td colspan="3" align="center" ><div id="totalPgto" style="color: blue">R$ 0.00</div></td>
		</tr>
	</tfoot>
</table>
<br></br>

<div><b>Saldo: <span id="saldo" >0,00</span></b></div>
<br></br>
<div> <input type="submit" value="Salvar Lançamentos"  class="button" ></div>

</center>
</form>
</body>
</html>