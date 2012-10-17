<%@ attribute name="texto" required="true" %>
<%@ attribute name="style" required="false" %>
<div class="bordaBox" style="${style}">
	<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b>
	<div class="conteudo">
		${texto}
	</div>
	<b class="b4"></b><b class="b3"></b><b class="b2"></b><b class="b1"></b>
</div>	