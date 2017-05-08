package br.com.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.financas.model.Conta;

public class ContaDAO {
	
	private EntityManager manager;
	
	// A ContaDAO precisa receber uma EntityManager para que a transação com o BD seja
	// aberta e fechada em um método externo, evitando erros que causam o não encerramento das transações.
	// Obs.: È importante abrir e fechar uma transação com o EntityManager em um mesmo método.
	public ContaDAO(EntityManager manager) { this.manager = manager; }
	
	public void adiciona(Conta conta) { manager.persist(conta); }
	
	public void remove(Conta conta) { manager.remove(conta); }
	
	public Conta busca(Integer id) { return manager.find(Conta.class, id); }
	
	public List<Conta> lista() {
		return manager.createQuery("select c from Conta c", Conta.class).getResultList();
	}

}
