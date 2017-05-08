package br.com.financas.test.movimentacao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.financas.dao.MovimentacaoDAO;
import br.com.financas.model.Movimentacao;
import br.com.financas.model.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class MovimentacaoAltera {
	
	public static void main(String[] args) {
		
		EntityManager manager;
		( manager = new JPAUtil().getEntityManager() ).getTransaction().begin();
		
		Movimentacao m = new MovimentacaoDAO(manager).busca(2);
		m.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		m.setValor(new BigDecimal("8713.95"));
		
		manager.getTransaction().commit();
		manager.close();
		
	}
	
}
