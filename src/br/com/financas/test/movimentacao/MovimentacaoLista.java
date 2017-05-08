package br.com.financas.test.movimentacao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.financas.dao.MovimentacaoDAO;
import br.com.financas.model.Movimentacao;
import br.com.financas.util.JPAUtil;

public class MovimentacaoLista {
	
	public static void main(String[] args) {
		
		EntityManager manager;
		( manager = new JPAUtil().getEntityManager() ).getTransaction().begin();
		
		MovimentacaoDAO mdao = new MovimentacaoDAO(manager);
		List<Movimentacao> mList = mdao.lista();
		
		manager.close();
		
		for (Movimentacao m : mList)
			System.out.println(m.toString());
		
	}
	
}
