package br.com.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.financas.model.Movimentacao;

public class MovimentacaoDAO {
	
	private EntityManager manager;
	
	public MovimentacaoDAO(EntityManager manager) { this.manager = manager; }
	
	public void adiciona(Movimentacao movimentacao) { manager.persist(movimentacao); }
	
	public Movimentacao busca(Integer id) { return manager.find(Movimentacao.class, id); }
	
	public List<Movimentacao> lista() {
		String q = "select m from Movimentacao m";
		return manager.createQuery(q, Movimentacao.class).getResultList();
	}
	
	public void remove(Movimentacao movimentacao) { manager.remove(movimentacao); }	

}
