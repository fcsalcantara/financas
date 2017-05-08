package br.com.financas.test.conta;

import javax.persistence.EntityManager;

import br.com.financas.dao.ContaDAO;
import br.com.financas.util.JPAUtil;

public class ContaRemove {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDAO cDAO = new ContaDAO(manager);

		manager.getTransaction().begin();
		
		cDAO.remove(cDAO.busca(2));
		
		manager.getTransaction().commit();
		manager.close();

	}

}
