package br.com.financas.test.conta;

import javax.persistence.EntityManager;

import br.com.financas.dao.ContaDAO;
import br.com.financas.model.Conta;
import br.com.financas.util.JPAUtil;

public class ContaAdiciona {

	public static void main(String[] args) {

		Conta c1 = new Conta("José Roberto", "Banco do Brasil", "0123", "1234-5");
		Conta c2 = new Conta("Ruy Barbosa", "Itaú", "0456", "6789-9");
		Conta c3 = new Conta("Luís Cláudio Silva", "Bradesco", "0789", "04567-8");
		Conta c4 = new Conta("Júlio Araújo", "HSBC", "00458", "45786-6");

		EntityManager manager;
		( manager = new JPAUtil().getEntityManager() ).getTransaction().begin();
		
		ContaDAO cDAO = new ContaDAO(manager);
		
		cDAO.adiciona(c1);
		cDAO.adiciona(c2);
		cDAO.adiciona(c3);
		cDAO.adiciona(c4);
		
		manager.getTransaction().commit();
		manager.close();

		System.out.println("A conta do(a) Sr(a). " + c1.toString() + " foi persistida no banco de dados.");
		System.out.println("A conta do(a) Sr(a). " + c2.toString() + " foi persistida no banco de dados.");
		System.out.println("A conta do(a) Sr(a). " + c3.toString() + " foi persistida no banco de dados.");
		System.out.println("A conta do(a) Sr(a). " + c4.toString() + " foi persistida no banco de dados.");

	}

}
