package br.com.financas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String titular;
	private String banco;
	private String agencia;
	private String numero;	
	
	public Conta(String titular, String banco, String agencia, String numero) {
		this.titular = titular;
		this.banco = banco;
		this.agencia = agencia;
		this.numero = numero;
	}
	
//	public Conta() { }
	
	public String getTitular() { return titular; }
	
	public String getBanco() { return banco; }
	
	public String getAgencia() { return agencia; }
	
	public String getNumero() { return numero; }
	
//	public void setTitular(String titular) { this.titular = titular; }
//	
//	public void setBanco(String banco) { this.banco = banco; }
//	
//	public void setAgencia(String agencia) { this.agencia = agencia; }
//	
//	public void setNumero(String numero) { this.numero = numero; }
	
	@Override
	public String toString() { return "Conta do " + titular + " no " + banco; }
	
}
