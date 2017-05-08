package br.com.financas.test.movimentacao;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financas.dao.ContaDAO;
import br.com.financas.model.Movimentacao;
import br.com.financas.model.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class MovimentacaoAdiciona {

	public static void main(String[] args) {
		
		EntityManager manager;
		( manager = new JPAUtil().getEntityManager() ).getTransaction().begin();
		
		// Criar uma nova conta, sem que ela já exista no bd, fere a constraint de FK:
//		Conta c = new Conta();
//		c.setTitular("Carlos Silva");
		
//		Conta c = new Conta("Carlos Silva", "HSBC", "04789", "212335-7");
//		new ContaDAO(manager).adiciona(c);
		
//		Movimentacao m = new Movimentacao();
//		m.setDescricao("Teste de criação de movimentação.");
//		m.setData(Calendar.getInstance());
////		m.setConta(c);
//		m.setConta(new ContaDAO(manager).busca(3));
//		m.setValor(new BigDecimal("24456872.635558"));
//		m.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		Movimentacao m1 = new Movimentacao("1a. movimentação da 1a. conta.", 
				Calendar.getInstance(), new ContaDAO(manager).busca(1), 
				new BigDecimal("1478.26"), TipoMovimentacao.ENTRADA);
		
		Movimentacao m2 = new Movimentacao("1a. movimentação da 3a. conta.", 
				Calendar.getInstance(), new ContaDAO(manager).busca(3), 
				new BigDecimal("5253.56"), TipoMovimentacao.SAIDA);
		
		Movimentacao m3 = new Movimentacao("2a. movimentação da 1a. conta.", 
				Calendar.getInstance(), new ContaDAO(manager).busca(3), 
				new BigDecimal("4562.35"), TipoMovimentacao.SAIDA);
		
		manager.persist(m1);
		manager.persist(m2);
		manager.persist(m3);
		
		manager.getTransaction().commit();
		manager.close();

	}

}
