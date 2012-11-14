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
			<li>
				<a href="#" class="item popular">Administração Sistema</a> <!-- titulo menu 1 -->
				<ul>
					<li><a href="cadastroUsuario.do">Cadastro Usuários</a> </li>
					<li><a href="buscaUsuario.do">Buscar Usuários</a> </li>
					<li><a href="cadastroCliente.do">Cadastro Cliente</a> </li>
					<li><a href="buscaCliente.do">Buscar Cliente</a> </li>
					<li><a href="cadastroPerfume.do">Cadastro Perfume</a> </li>
					<li><a href="buscaPerfume.do">Buscar Perfume</a> </li>
					<li><a href="cadastroFornecedor.do">Cadastro Fornecedor</a> </li>
					<li><a href="buscaFornecedor.do">Buscar Fornecedor</a> </li>
					<li><a href="cadastroVendedor.do">Cadastro Vendedor</a> </li>
					<li><a href="buscaVendedor.do">Buscar Vendedor</a> </li>
				</ul>
			</li>
			<li>
				<a href="#" class="item popular">Lote</a>
				<ul>
					<li><a href="manterLote.do?dispatch=createEdit">Criar Lote</a> </li>
					<li><a href="manterLote.do?dispatch=search">Buscar Lote</a> </li>
				</ul>
			</li>
			<li>
				<a href="#" class="item popular">Estoque</a>
				<ul>
					<li><a href="controlarEstoque.do">Controlar Estoque</a> </li>
				</ul>
			</li>
			<li>
				<a href="#" class="item popular">Venda</a>
				<ul>
					<li><a href="manterVenda.do?dispatch=createEdit">Criar Venda</a> </li>
					<li><a href="manterVenda.do?dispatch=search">Buscar Venda</a> </li>
				</ul>
			</li>
			<li>
				<a href="relatorio.jsp" class="item popular">Relatórios</a>
			</li>
			<li>
				<a href="sair.action">Sair</a>
			</li>
		</ul>	
		
		
		<br style="clear: left" />
	</div>
	
	
</div>
