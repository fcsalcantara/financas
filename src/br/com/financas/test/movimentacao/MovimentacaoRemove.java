package br.com.financas.test.movimentacao;

import javax.persistence.EntityManager;

import br.com.financas.dao.MovimentacaoDAO;
import br.com.financas.util.JPAUtil;

public class MovimentacaoRemove {

	public static void main(String[] args) {

		EntityManager manager;
		(manager = new JPAUtil().getEntityManager()).getTransaction().begin();

		MovimentacaoDAO mdao = new MovimentacaoDAO(manager);

		// Vai remover a movimentação número 2:
		mdao.remove(mdao.busca(2));

		manager.getTransaction().commit();
		manager.close();

	}

}
