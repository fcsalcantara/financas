package br.com.financas.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.financas.model.Conta;

public class PersistirConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		Conta c1 = new Conta("José Roberto", "Banco do Brasil", "0123", "1234-5");
		Conta c2 = new Conta("Ruy Barbosa", "Itaú", "0456", "6789-9");
		Conta c3 = new Conta("José Roberto", "Bradesco", "0789", "04567-8");
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);		
		em.getTransaction().commit();
		em.close();
		
		System.out.println("A conta do(a) Sr(a). " + c1.toString() + " foi persistida no banco de dados.");
		System.out.println("A conta do(a) Sr(a). " + c2.toString() + " foi persistida no banco de dados.");
		System.out.println("A conta do(a) Sr(a). " + c3.toString() + " foi persistida no banco de dados.");

	}

}
