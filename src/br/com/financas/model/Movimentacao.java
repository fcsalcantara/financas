package br.com.financas.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@ManyToOne
	private Conta conta;
	
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;
	
	public Movimentacao(String descricao, Calendar data, Conta conta, BigDecimal valor, TipoMovimentacao tipoMovimentacao) {
		this.descricao = descricao;
		this.data = data;
		this.conta = conta;
		this.valor = valor;
		this.tipoMovimentacao = tipoMovimentacao;
	}
	
	public Movimentacao() { } // Exigido pelo Hibernate.

	public Integer getId() { return id;	}

	public String getDescricao() { return descricao; }

	public Calendar getData() { return data; }

	public Conta getConta() { return conta; }

	public BigDecimal getValor() { return valor; }
	
	public TipoMovimentacao getTipoMovimentacao() { return tipoMovimentacao; }

//	public void setId(Integer id) { this.id = id; }

	public void setDescricao(String descricao) { this.descricao = descricao; }

	public void setData(Calendar data) { this.data = data; }

	public void setConta(Conta conta) { this.conta = conta; }

	public void setValor(BigDecimal valor) { this.valor = valor; }
	
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) { this.tipoMovimentacao =  tipoMovimentacao; }
	
	@Override
	public String toString() {
		return id + ", \"" + descricao + "\", " + 
				new SimpleDateFormat("dd/MM/yy").format(data.getTime()) +  ", " + 
				conta.getId() + ", " + valor + ", " + tipoMovimentacao.name(); 
	}

}
