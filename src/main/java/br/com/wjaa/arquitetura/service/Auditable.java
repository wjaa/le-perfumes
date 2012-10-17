package br.com.wjaa.arquitetura.service;

/**
 * Registros que devem ser auditadas implementam esta interface. O
 * AbstractService verifica se o servico implementa Auditable, pega o numero
 * base, implementado pela cada servico, incrementa com a operacao e chama o
 * metodo de auditoria do framework E-Calc:
 * 
 * @author Paul Kuit
 * 
 */
public interface Auditable {

	/**
	 * 
	 * @return o primeiro numero de um range reservado para as auditar as
	 *         atividades nesta entidade. O primeiro numero é usado para
	 *         insercao, o segundo para alteracao e numero + 3 para
	 *         cancelamento.
	 * 
	 */
	int getAuditActivityNumber();
}
