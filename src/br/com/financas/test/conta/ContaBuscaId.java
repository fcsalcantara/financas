package br.com.financas.test.conta;

import javax.persistence.EntityManager;

import br.com.financas.dao.ContaDAO;
import br.com.financas.model.Conta;
import br.com.financas.util.JPAUtil;

public class ContaBuscaId {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDAO contaDAO = new ContaDAO(manager);

		manager.getTransaction().begin();
		Conta conta = contaDAO.busca(2);
		manager.close();

		System.out.println(conta.toString());

	}

}
