<div id="DivGeralTopo">
<div id="DivLogo"><img src="pages/images/logo_menor.png" title="HUB7" width="80" height="80" border="0" /></div>
<div id="header"><br></br></div>

	<!-- MENU FIM -->
	<div id="menu_msg_usuario">
	   Ol� ${sessionScope.usuario.nomeUsuario}
	</div>

	<!-- MENU INICIO -->
	<div id="myslidemenu" class="jqueryslidemenu">
		
		<!-- Administracao -->
		<ul>
			<li><a href="#">Administra��o Sistema</a> <!-- titulo menu 1 -->
				<ul>
					<!-- Usuario -->
					<li><a href="#">Usu�rio</a>
						<ul>
							<li><a href="cadastroUsuario.do">Cadastro Usu�rios</a> </li>
							<li><a href="buscaUsuario.do">Buscar Usu�rios</a> </li>
						</ul>
					</li>
					<!-- Cliente -->
					<li><a href="#">Cliente</a>
						<ul>
							<li><a href="cadastroCliente.do">Cadastro Cliente</a> </li>
							<li><a href="buscaCliente.do">Buscar Cliente</a> </li>
						</ul>
					</li>
					<li><a href="#">Perfumes</a>
						<ul>
							<li><a href="cadastroPerfume.do">Cadastro Perfume</a> </li>
							<li><a href="buscaPerfume.do">Buscar Perfume</a> </li>
						</ul>
					</li>
					<li><a href="#">Fornecedor</a>
						<ul>
							<li><a href="cadastroFornecedor.do">Cadastro Fornecedor</a> </li>
							<li><a href="buscaFornecedor.do">Buscar Fornecedor</a> </li>
						</ul>
					</li>
					<li><a href="#">Vendedor</a>
						<ul>
							<li><a href="cadastroVendedor.do">Cadastro Vendedor</a> </li>
							<li><a href="buscaVendedor.do">Buscar Vendedor</a> </li>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
		
		<ul>
			<li><a href="#">Lote</a>
				<ul>
					<li><a href="manterLote.do?dispatch=createEdit">Criar Lote</a> </li>
					<li><a href="manterLote.do?dispatch=search">Buscar Lote</a> </li>
				</ul>
			</li>
		</ul>
		
		<ul>
			<li><a href="#">Estoque</a>
				<ul>
					<li><a href="controlarEstoque.do">Controlar Estoque</a> </li>
				</ul>
			</li>
		</ul>
		
		<ul>
			<li><a href="#">Venda</a>
				<ul>
					<li><a href="manterVenda.do?dispatch=createEdit">Criar Venda</a> </li>
					<li><a href="manterVenda.do?dispatch=search">Buscar Venda</a> </li>
				</ul>
			</li>
		</ul>
		
		<ul>
			<li>
				<a href="relatorio.jsp">Relat�rios</a>
			</li>
		</ul>
		
		<ul>
			<li>
				<a href="sair.action">Sair</a>
			</li>
		</ul>	
		
		
		<br style="clear: left" />
	</div>
	
	
</div>