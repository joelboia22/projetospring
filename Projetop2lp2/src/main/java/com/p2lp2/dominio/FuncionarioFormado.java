package com.p2lp2.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FuncionarioFormado {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private double bonificacao;
	private double salario;
	
	public FuncionarioFormado() {}
	
	public FuncionarioFormado(Integer id, String nome,String cpf, double bonificacao, double salario) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.bonificacao = bonificacao;
		this.salario = salario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getBonificacao() {
		return bonificacao;
	}

	public void setBonificacao(double bonificacao) {
		this.bonificacao = bonificacao;
	}

	public double getSalarioTotal() {
		return bonificacao + (2*salario);
	}
}
