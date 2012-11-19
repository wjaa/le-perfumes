<div id="DivGeralTopo">
<div id="DivLogo"><img src="pages/images/logo_menor.png" title="HUB7" width="80" height="80" border="0" /></div>
<div id="header"><br></br></div>

	<!-- MENU FIM -->
	<div id="menu_msg_usuario">
	   Olá ${sessionScope.usuario.nomeUsuario}
	</div>
	<br>
	<br>
	<br>
	<!-- MENU INICIO -->
	<div>
		
		<!-- Administracao -->
		<ul id="accordion">
			<li class="popular">
				<a href="#" class="item popular">Administração Sistema</a> <!-- titulo menu 1 -->
				<ul>
					<li><a href="buscaUsuario.do">Cadastro de Usuários</a> </li>
					<li><a href="buscaCliente.do">Cadastro de Cliente</a> </li>
					<li><a href="buscaPerfume.do">Cadastro de Perfume</a> </li>
					<li><a href="buscaFornecedor.do">Cadastro de Fornecedor</a> </li>
					<li><a href="buscaVendedor.do">Cadastro de Vendedor</a> </li>
				</ul>
			</li>
			<li class="popular">
				<a href="#" class="item popular">Lote</a>
				<ul>
					<li><a href="manterLote.do?dispatch=search">Cadastro de Lote</a> </li>
				</ul>
			</li>
			<li class="popular">
				<a href="#" class="item popular">Estoque</a>
				<ul>
					<li><a href="controlarEstoque.do">Controlar Estoque</a> </li>
				</ul>
			</li>
			<li class="popular">
				<a href="#" class="item popular">Venda</a>
				<ul>
					<li><a href="manterVenda.do?dispatch=search">Cadastro de Vendas</a> </li>
				</ul>
			</li>
			<li class="popular">
				<a href="relatorio.jsp" class="item popular">Relatórios</a>
			</li>
			<li class="popular">
				<a style="color:white;" class="sair" href="sair.action">Sair</a>
			</li>
		</ul>	
		
		
		<br style="clear: left" />
	</div>
	
	
</div>
