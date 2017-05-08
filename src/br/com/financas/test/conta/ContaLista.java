package br.com.financas.test.conta;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.financas.dao.ContaDAO;
import br.com.financas.model.Conta;
import br.com.financas.util.JPAUtil;

public class ContaLista {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDAO contaDAO = new ContaDAO(manager);
		List<Conta> listaContas;

		manager.getTransaction().begin();
		listaContas = contaDAO.lista();
		manager.close();

		System.out.println("id, agencia, numero, banco, titular");
		for (Conta conta : listaContas)
			System.out.println(conta.getId() + ", " + conta.getAgencia() + ", " + conta.getNumero() + ", "
					+ conta.getBanco() + ", " + conta.getTitular());

	}

}
