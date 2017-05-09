package br.com.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	// Mantém um "EntityManagerFactory" aberto desde a primeira chamada:
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("financas_old");
	
	public EntityManager getEntityManager() { return factory.createEntityManager(); } 

}
