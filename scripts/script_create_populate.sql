USE controle;

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ATIVO` bit(1) DEFAULT NULL,
  `CONTATO` varchar(60) DEFAULT NULL,
  `CPF` varchar(14) DEFAULT NULL,
  `DATA_CADASTRO` datetime DEFAULT NULL,
  `DATA_NASCIMENTO` datetime DEFAULT NULL,
  `DDD_FONE1` varchar(2) DEFAULT NULL,
  `DDD_FONE2` varchar(2) DEFAULT NULL,
  `EMAIL` varchar(80) DEFAULT NULL,
  `BAIRRO` varchar(150) DEFAULT NULL,
  `CEP` varchar(10) DEFAULT NULL,
  `CIDADE` varchar(80) DEFAULT NULL,
  `COMPLEMENTO` varchar(150) DEFAULT NULL,
  `ESTADO` varchar(80) DEFAULT NULL,
  `LOGRADOURO` varchar(150) DEFAULT NULL,
  `NUMERO` varchar(10) DEFAULT NULL,
  `FONE1` varchar(9) DEFAULT NULL,
  `FONE2` varchar(9) DEFAULT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL,
  `LOCAL_TRABALHO` varchar(60) DEFAULT NULL,
  `LOJA` varchar(60) DEFAULT NULL,
  `NOME_FULL` varchar(150) DEFAULT NULL,
  `SEXO` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


insert into `cliente`(`id`,`ATIVO`,`CONTATO`,`CPF`,`DATA_CADASTRO`,`DATA_NASCIMENTO`,`DDD_FONE1`,`DDD_FONE2`,`EMAIL`,`BAIRRO`,`CEP`,`CIDADE`,`COMPLEMENTO`,`ESTADO`,`LOGRADOURO`,`NUMERO`,`FONE1`,`FONE2`,`ID_USUARIO`,`LOCAL_TRABALHO`,`LOJA`,`NOME_FULL`,`SEXO`) values (1,1,'Leandro','333.333.333-33',null,null,'11',' ',' ',' ',' ',' ',' ','SP',' ',' ','1111-1111',' ',null,' ','teste','Wagner',null);
insert into `cliente`(`id`,`ATIVO`,`CONTATO`,`CPF`,`DATA_CADASTRO`,`DATA_NASCIMENTO`,`DDD_FONE1`,`DDD_FONE2`,`EMAIL`,`BAIRRO`,`CEP`,`CIDADE`,`COMPLEMENTO`,`ESTADO`,`LOGRADOURO`,`NUMERO`,`FONE1`,`FONE2`,`ID_USUARIO`,`LOCAL_TRABALHO`,`LOJA`,`NOME_FULL`,`SEXO`) values (2,1,'Leandro','222.222.222-22',null,null,'11',' ',' ',' ',' ',' ',' ','SP',' ',' ','1111-1111',' ',null,' ','teste','Renata',null);
insert into `cliente`(`id`,`ATIVO`,`CONTATO`,`CPF`,`DATA_CADASTRO`,`DATA_NASCIMENTO`,`DDD_FONE1`,`DDD_FONE2`,`EMAIL`,`BAIRRO`,`CEP`,`CIDADE`,`COMPLEMENTO`,`ESTADO`,`LOGRADOURO`,`NUMERO`,`FONE1`,`FONE2`,`ID_USUARIO`,`LOCAL_TRABALHO`,`LOJA`,`NOME_FULL`,`SEXO`) values (3,1,'Leandro','393.167.328-08',null,null,'11','11',' ',' ',' ',' ',' ','SP','jesuino nicomedio dos santos','100','4544-4930','6509-6906',null,'fsdafsda','fato mano ','patricia oliveira feliciano',1);
insert into `cliente`(`id`,`ATIVO`,`CONTATO`,`CPF`,`DATA_CADASTRO`,`DATA_NASCIMENTO`,`DDD_FONE1`,`DDD_FONE2`,`EMAIL`,`BAIRRO`,`CEP`,`CIDADE`,`COMPLEMENTO`,`ESTADO`,`LOGRADOURO`,`NUMERO`,`FONE1`,`FONE2`,`ID_USUARIO`,`LOCAL_TRABALHO`,`LOJA`,`NOME_FULL`,`SEXO`) values (4,1,'Leandro','666.666.666-66',null,null,'11',' ',' ',' ',' ',' ',' ','SP',' ',' ','1111-1111',' ',null,' ','Loja do wagnao','Wagner Araujo',null);
insert into `cliente`(`id`,`ATIVO`,`CONTATO`,`CPF`,`DATA_CADASTRO`,`DATA_NASCIMENTO`,`DDD_FONE1`,`DDD_FONE2`,`EMAIL`,`BAIRRO`,`CEP`,`CIDADE`,`COMPLEMENTO`,`ESTADO`,`LOGRADOURO`,`NUMERO`,`FONE1`,`FONE2`,`ID_USUARIO`,`LOCAL_TRABALHO`,`LOJA`,`NOME_FULL`,`SEXO`) values (5,0,'Junior','888.888.888-88',null,null,'22','1','wag182@gmail.com',' ',' ',' ',' ','SP',' ',' ','2222-2222',' ',null,' ','fdsafsfdsfs','fdsafsad',0);
insert into `cliente`(`id`,`ATIVO`,`CONTATO`,`CPF`,`DATA_CADASTRO`,`DATA_NASCIMENTO`,`DDD_FONE1`,`DDD_FONE2`,`EMAIL`,`BAIRRO`,`CEP`,`CIDADE`,`COMPLEMENTO`,`ESTADO`,`LOGRADOURO`,`NUMERO`,`FONE1`,`FONE2`,`ID_USUARIO`,`LOCAL_TRABALHO`,`LOJA`,`NOME_FULL`,`SEXO`) values (6,1,'Leandro','340.154.007-00',null,'1498-08-21 00:00:00','11','12','pauloe@hotmail.com','nlknkln','03202-603',' ','nklnklnk','SP','nnknklnlnn','nklnlknl','7748-4613','1321-5165',null,' ','N JNFNNJ','eliseu perez junior',0);



CREATE TABLE `vendedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `ativo` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


insert into `vendedor`(`id`,`nome`,`telefone`,`ativo`) values (1,'Juninho','(11)1111-1111',1);
insert into `vendedor`(`id`,`nome`,`telefone`,`ativo`) values (2,'Leandro','(22)2222-2224',1);


CREATE TABLE `fornecedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `CONTATO` varchar(80) DEFAULT NULL,
  `DADOS_PAGAMENTO` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `ENDERECO` varchar(200) DEFAULT NULL,
  `NOME` varchar(80) DEFAULT NULL,
  `OBSERVACAO` varchar(255) DEFAULT NULL,
  `SITE` varchar(100) DEFAULT NULL,
  `TELEFONE1` varchar(13) DEFAULT NULL,
  `TELEFONE2` varchar(13) DEFAULT NULL,
  `ATIVO` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


insert into `fornecedor`(`id`,`CONTATO`,`DADOS_PAGAMENTO`,`EMAIL`,`ENDERECO`,`NOME`,`OBSERVACAO`,`SITE`,`TELEFONE1`,`TELEFONE2`,`ATIVO`) values (1,null,'','','','Wagner','','','','',1);
insert into `fornecedor`(`id`,`CONTATO`,`DADOS_PAGAMENTO`,`EMAIL`,`ENDERECO`,`NOME`,`OBSERVACAO`,`SITE`,`TELEFONE1`,`TELEFONE2`,`ATIVO`) values (2,null,'','','','Pedro','','','','',1);
insert into `fornecedor`(`id`,`CONTATO`,`DADOS_PAGAMENTO`,`EMAIL`,`ENDERECO`,`NOME`,`OBSERVACAO`,`SITE`,`TELEFONE1`,`TELEFONE2`,`ATIVO`) values (3,null,'','','','Joao','','','','',1);
insert into `fornecedor`(`id`,`CONTATO`,`DADOS_PAGAMENTO`,`EMAIL`,`ENDERECO`,`NOME`,`OBSERVACAO`,`SITE`,`TELEFONE1`,`TELEFONE2`,`ATIVO`) values (4,null,'á vista','graci@hotmail.com','','graci','','','','',0);
insert into `fornecedor`(`id`,`CONTATO`,`DADOS_PAGAMENTO`,`EMAIL`,`ENDERECO`,`NOME`,`OBSERVACAO`,`SITE`,`TELEFONE1`,`TELEFONE2`,`ATIVO`) values (5,null,'','','','graci','','','','',1);




CREATE TABLE `perfume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `MARCA` varchar(100) DEFAULT NULL,
  `NOME` varchar(100) DEFAULT NULL,
  `OBSERVACAO` varchar(255) DEFAULT NULL,
  `TAMANHO` varchar(30) DEFAULT NULL,
  `TIPO` varchar(80) DEFAULT NULL,
  `ATIVO` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;


insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (1,'Polo','Polo Explorer',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (2,'Ferrari','Ferrari',' ','100','Masculino',0);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (3,'CK','Calvin Klein',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (4,'calvin klein','ck be ',' ','100','Unisexy',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (5,'animale','animale',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (6,'100','animale animale',' ','100','Masculino',0);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (7,'animale','animale black',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (8,'azzaro','azzaro',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (9,'azzaro','azzaro chrome',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (10,'burberry','burberry',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (11,'burberry','burberry brit',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (12,'burberry','burberry the beat',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (13,'bulgari','bulgari',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (14,'bulgari','bulgari extreme',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (15,'bulgari','bulgari acqua',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (16,'bulgari','bulgari black',' ','75','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (17,'bulgari','bulgari blv ',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (18,'bulgari','bulgari blv ',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (19,'calvin klein','ck be ',' ','200','Unisexy',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (20,'calvin klein','ck in 2 u',' ','150','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (21,'chanel','allure sport',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (22,'chanel','coco mademosele',' ','100','Feminino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (23,'calvin klein','euphoria',' ','100','Masculino',1);
insert into `perfume`(`id`,`MARCA`,`NOME`,`OBSERVACAO`,`TAMANHO`,`TIPO`,`ATIVO`) values (24,'carolina herrera','212',' ','100','Masculino',1);


CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ATIVO` bit(1) DEFAULT NULL,
  `DATA_CADASTRO` datetime DEFAULT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `NOME_USUARIO` varchar(60) NOT NULL,
  `SENHA` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;


insert into `usuario`(`id`,`ATIVO`,`DATA_CADASTRO`,`NOME`,`NOME_USUARIO`,`SENHA`,`EMAIL`) values (1,1,'2010-10-12 00:00:00','wagner.araujo','Wagner Jeronimo','202cffffffb962ffffffac5975bffffff964b7152d234b70','wag182@gmail.com');
insert into `usuario`(`id`,`ATIVO`,`DATA_CADASTRO`,`NOME`,`NOME_USUARIO`,`SENHA`,`EMAIL`) values (31,1,'2011-02-08 00:00:00','admin','admin','202cffffffb962ffffffac5975bffffff964b7152d234b70','wag182@gmail.com');
insert into `usuario`(`id`,`ATIVO`,`DATA_CADASTRO`,`NOME`,`NOME_USUARIO`,`SENHA`,`EMAIL`) values (32,1,'2011-02-08 10:51:38','le','leandro','ffffffd9fffffff9133fffffffb120ffffffcd60ffffff96ffffff87bffffffc2ffffffb4ffffff96ffffff805b','jl.perfumes.importados@hotmail.com');
insert into `usuario`(`id`,`ATIVO`,`DATA_CADASTRO`,`NOME`,`NOME_USUARIO`,`SENHA`,`EMAIL`) values (33,1,'2011-03-01 21:03:34','paulo','paulo','202cffffffb962ffffffac5975bffffff964b7152d234b70','paulo@hotmail.com');



CREATE TABLE `venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_vendedor` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `data_venda` date NOT NULL,
  `id_forma_pagamento` int(11) NOT NULL,
  `valor_venda` double DEFAULT NULL,
  `obs` varchar(255) DEFAULT NULL,
  `data_pgto` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vendaxcliente` (`id_cliente`),
  KEY `vendaxvendedor` (`id_vendedor`),
  CONSTRAINT `vendaxcliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `vendaxvendedor` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


insert into `venda`(`id`,`id_vendedor`,`id_cliente`,`data_venda`,`id_forma_pagamento`,`valor_venda`,`obs`,`data_pgto`) values (3,1,1,'2011-02-07 00:00:00',1,600,'',null);
insert into `venda`(`id`,`id_vendedor`,`id_cliente`,`data_venda`,`id_forma_pagamento`,`valor_venda`,`obs`,`data_pgto`) values (4,2,1,'2011-03-01 00:00:00',2,10,'',null);
insert into `venda`(`id`,`id_vendedor`,`id_cliente`,`data_venda`,`id_forma_pagamento`,`valor_venda`,`obs`,`data_pgto`) values (5,2,2,'2011-03-01 00:00:00',2,10,'',null);
insert into `venda`(`id`,`id_vendedor`,`id_cliente`,`data_venda`,`id_forma_pagamento`,`valor_venda`,`obs`,`data_pgto`) values (6,2,1,'2011-03-01 00:00:00',1,1.25,'',null);



CREATE TABLE `estoque_entrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_lote` int(11) NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  `id_perfume` int(11) NOT NULL,
  `qtde` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


insert into `estoque_entrada`(`id`,`id_lote`,`id_vendedor`,`id_perfume`,`qtde`) values (1,1,1,5,3);
insert into `estoque_entrada`(`id`,`id_lote`,`id_vendedor`,`id_perfume`,`qtde`) values (2,1,2,5,2);
insert into `estoque_entrada`(`id`,`id_lote`,`id_vendedor`,`id_perfume`,`qtde`) values (3,1,1,8,3);
insert into `estoque_entrada`(`id`,`id_lote`,`id_vendedor`,`id_perfume`,`qtde`) values (4,1,2,8,3);





CREATE TABLE `lote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_compra` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_fornecedor` int(11) NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lotexfornecedor` (`id_fornecedor`),
  CONSTRAINT `lotexfornecedor` FOREIGN KEY (`id_fornecedor`) REFERENCES `fornecedor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


insert into `lote`(`id`,`data_compra`,`id_fornecedor`,`observacao`) values (1,'2011-02-07 00:00:00',1,'teste');
insert into `lote`(`id`,`data_compra`,`id_fornecedor`,`observacao`) values (2,'2011-03-01 00:00:00',1,'');
insert into `lote`(`id`,`data_compra`,`id_fornecedor`,`observacao`) values (3,'2011-03-01 00:00:00',1,'');
insert into `lote`(`id`,`data_compra`,`id_fornecedor`,`observacao`) values (4,'2011-03-01 00:00:00',1,'');
insert into `lote`(`id`,`data_compra`,`id_fornecedor`,`observacao`) values (5,'2011-03-01 00:00:00',5,'');
insert into `lote`(`id`,`data_compra`,`id_fornecedor`,`observacao`) values (6,'2011-03-02 00:00:00',5,'');
insert into `lote`(`id`,`data_compra`,`id_fornecedor`,`observacao`) values (7,'2011-03-09 00:00:00',1,'teste');
insert into `lote`(`id`,`data_compra`,`id_fornecedor`,`observacao`) values (8,'2011-03-10 00:00:00',1,'teste3');




CREATE TABLE `lotexproduto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `preco` double NOT NULL,
  `quantidade` int(11) NOT NULL,
  `id_perfume` int(11) NOT NULL,
  `id_lote` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lotexproduto_ibfk_1` (`id_perfume`),
  KEY `lotexproduto_idlote` (`id_lote`),
  CONSTRAINT `lotexproduto_ibfk_1` FOREIGN KEY (`id_perfume`) REFERENCES `perfume` (`id`),
  CONSTRAINT `lotexproduto_idlote` FOREIGN KEY (`id_lote`) REFERENCES `lote` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;


insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (3,100,5,5,1);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (4,100,6,8,1);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (5,78,10,21,2);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (6,78,15,21,3);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (7,10,20,21,4);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (8,1,20,5,4);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (9,2,100,7,4);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (10,50,1121,8,4);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (11,0.01,26,9,4);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (12,1,10,21,5);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (13,1,11,5,5);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (14,10,12,6,5);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (15,1,10,24,5);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (16,3.21,4,21,6);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (17,3.33,6,5,6);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (18,0.11,5,24,6);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (19,100,10,21,7);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (20,100,10,21,8);
insert into `lotexproduto`(`id`,`preco`,`quantidade`,`id_perfume`,`id_lote`) values (21,100,20,7,8);





CREATE TABLE `venda_prazo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_venda` int(11) NOT NULL,
  `dias` int(11) NOT NULL,
  `data_vencimento` date NOT NULL,
  `pago` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vendaprazoxvenda` (`id_venda`),
  CONSTRAINT `vendaprazoxvenda` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


insert into `venda_prazo`(`id`,`id_venda`,`dias`,`data_vencimento`,`pago`) values (4,5,30,'2011-03-31 00:00:00',0);
insert into `venda_prazo`(`id`,`id_venda`,`dias`,`data_vencimento`,`pago`) values (5,5,15,'2011-03-16 00:00:00',0);
insert into `venda_prazo`(`id`,`id_venda`,`dias`,`data_vencimento`,`pago`) values (6,5,45,'2011-04-15 00:00:00',0);
insert into `venda_prazo`(`id`,`id_venda`,`dias`,`data_vencimento`,`pago`) values (7,4,30,'2011-03-31 00:00:00',0);
insert into `venda_prazo`(`id`,`id_venda`,`dias`,`data_vencimento`,`pago`) values (8,4,13,'2011-03-14 00:00:00',0);
insert into `venda_prazo`(`id`,`id_venda`,`dias`,`data_vencimento`,`pago`) values (9,4,45,'2011-04-15 00:00:00',0);





CREATE TABLE `venda_pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `valor` double NOT NULL,
  `id_venda` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vendapagamentoxvenda` (`id_venda`),
  CONSTRAINT `vendapagamentoxvenda` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


insert into `venda_pagamento`(`id`,`data`,`valor`,`id_venda`) values (3,'2011-02-09 00:00:00',600,3);
insert into `venda_pagamento`(`id`,`data`,`valor`,`id_venda`) values (4,'2011-03-15 00:00:00',1,4);




CREATE TABLE `venda_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_venda` int(11) NOT NULL,
  `id_perfume` int(11) NOT NULL,
  `qtde` int(11) NOT NULL,
  `preco_unitario` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vendaitemxperfume` (`id_perfume`),
  KEY `vendaitemxvenda` (`id_venda`),
  CONSTRAINT `vendaitemxperfume` FOREIGN KEY (`id_perfume`) REFERENCES `perfume` (`id`),
  CONSTRAINT `vendaitemxvenda` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


insert into `venda_item`(`id`,`id_venda`,`id_perfume`,`qtde`,`preco_unitario`) values (3,3,5,3,100);
insert into `venda_item`(`id`,`id_venda`,`id_perfume`,`qtde`,`preco_unitario`) values (4,3,8,3,100);
insert into `venda_item`(`id`,`id_venda`,`id_perfume`,`qtde`,`preco_unitario`) values (6,5,8,1,10);
insert into `venda_item`(`id`,`id_venda`,`id_perfume`,`qtde`,`preco_unitario`) values (7,6,8,1,1.25);
insert into `venda_item`(`id`,`id_venda`,`id_perfume`,`qtde`,`preco_unitario`) values (8,4,5,1,10);



CREATE TABLE `estoque_ajuste_saida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_lote` int(11) NOT NULL,
  `qtde` int(11) NOT NULL,
  `id_perfume` int(11) NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  `obs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ESTOQUEXLOTE` (`id_lote`),
  KEY `ESTOQUEXPERFUME` (`id_perfume`),
  KEY `ESTOQUEXVENDEDOR` (`id_vendedor`),
  CONSTRAINT `ESTOQUEXLOTE` FOREIGN KEY (`id_lote`) REFERENCES `lote` (`id`),
  CONSTRAINT `ESTOQUEXPERFUME` FOREIGN KEY (`id_perfume`) REFERENCES `perfume` (`id`),
  CONSTRAINT `ESTOQUEXVENDEDOR` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

