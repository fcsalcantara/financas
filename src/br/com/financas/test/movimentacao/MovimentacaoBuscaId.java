package br.com.financas.test.movimentacao;

import javax.persistence.EntityManager;

import br.com.financas.dao.MovimentacaoDAO;
import br.com.financas.model.Movimentacao;
import br.com.financas.util.JPAUtil;

public class MovimentacaoBuscaId {

	public static void main(String[] args) {

		EntityManager manager;
		( manager = new JPAUtil().getEntityManager() ).getTransaction().begin();
		
		Movimentacao m = new MovimentacaoDAO(manager).busca(2);
		System.out.println(m.toString());
		System.out.print("Descrição da conta: ");
		System.out.println(m.getConta().toString());

		manager.close();
	}

}
