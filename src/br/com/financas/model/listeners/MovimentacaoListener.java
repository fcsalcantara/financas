package br.com.financas.model.listeners;

import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.financas.model.Movimentacao;

// Classe Calback para objetos "Movimentacao":
public class MovimentacaoListener {
	
	// Método executado sempre antes de uma persistência ou atualização do objeto "Movimentacao" no banco:
	@PrePersist
	@PreUpdate
	public void preAtualiza(Movimentacao movimentacao) {
		movimentacao.setData(Calendar.getInstance());
		System.out.println("A data e horário foram atualizados antes da persistência no banco de dados.");
	}

}
