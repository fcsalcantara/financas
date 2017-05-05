package br.com.financas.test;

import javax.persistence.EntityManager;

import br.com.financas.dao.ContaDAO;
import br.com.financas.model.Conta;
import br.com.financas.util.JPAUtil;

public class ContaAdcionar {

	public static void main(String[] args) {

		Conta c1 = new Conta("José Roberto", "Banco do Brasil", "0123", "1234-5");
		Conta c2 = new Conta("Ruy Barbosa", "Itaú", "0456", "6789-9");
		Conta c3 = new Conta("José Roberto", "Bradesco", "0789", "04567-8");

		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDAO cDAO = new ContaDAO(manager);

		manager.getTransaction().begin();
		cDAO.adiciona(c1);
		cDAO.adiciona(c2);
		cDAO.adiciona(c3);
		manager.getTransaction().commit();
		manager.close();

		System.out.println("A conta do(a) Sr(a). " + c1.toString() + " foi persistida no banco de dados.");
		System.out.println("A conta do(a) Sr(a). " + c2.toString() + " foi persistida no banco de dados.");
		System.out.println("A conta do(a) Sr(a). " + c3.toString() + " foi persistida no banco de dados.");

	}

}
