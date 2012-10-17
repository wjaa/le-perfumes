<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<html>
<head>
	<link href="./arquivos/css/displaytag.css" rel="stylesheet" type="text/css" />
	<style>
		span.pagebanner {
    		display: none;
	    	margin: 10px 0 0px 0;
    		padding: 0px 0px 0px 0;
		}
		span.pagelinks {
    		display: none;
	    	margin: 10px 0 0px 0;
    		padding: 0px 0px 0px 0;
		}
	</style>
</head>

<body>
<display:table id="lote" name="${model}" sort="list" pagesize="15" export="false"  class="displaytag"
	requestURI="manterEstoque.do?dispatch=controlar" >
	
		<display:setProperty name="basic.show.header" value="false" />
		<display:column title="Itens">
		<display:table id="estoqueEntrada" name="${lote.estoqueEntradaForm}"  pagesize="15" class="displaytag" >
			<display:column property="qtdeLote" title="Qtde Lote" sortable="false" />
			<display:column  property="nomePerfume" title="Perfume" sortable="true"  style="width:220px;"  />
			<display:column title="Itens">
			<display:table id="vendedor" name="${estoqueEntrada.vendedores}"  pagesize="15" class="displaytag" style="background-color: #9AC0CD;" >
				<display:setProperty name="basic.show.header" value="false" />
				
				<display:column property="nome" title="Vendedor" sortable="true" style="width:100px; background-color: #fff"/>
				<display:column property="qtde"  sortable="false" style="width:30px; background-color: #fff" />
			</display:table>
			</display:column>
			
			<display:column title="Ação"><a href="manterEstoque.do?dispatch=alterar&idLote=${lote.id}&idPerfume=${estoqueEntrada.idPerfume}&qtdeMax=${lote.qtdeParcial}&dataInicio=${requestScope.dataInicio}&dataFim=${requestScope.dataFim}&paramFornecedor=${requestScope.paramFornecedor}">Alterar</a></display:column>
		</display:table>
		</display:column>
		
	
</display:table>
</body>
</html>