<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<html>
<head>
<wjaa:header></wjaa:header>
</head>
<body>
	
</body>
</html>
<script>
	jConfirm('Deseja criar outro vendedor?', 'VENDEDOR CADASTRADO COM SUCESSO!', function(r) {
		if(r){
			window.location.href="/controle/cadastroVendedor.do";
		}else{
			window.location.href="/controle/buscaVendedor.do";
		}	
	});

</script>