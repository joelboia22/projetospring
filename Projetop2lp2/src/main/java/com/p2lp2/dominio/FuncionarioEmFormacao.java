package com.p2lp2.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FuncionarioEmFormacao {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private double ajudaDeCusto ;
	private double salario;
	
	public FuncionarioEmFormacao() {}
	
	public FuncionarioEmFormacao(Integer id, String nome, String cpf, double ajudaDeCusto, double salario) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.ajudaDeCusto = ajudaDeCusto;
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

	public double getAjudaDeCusto() {
		return ajudaDeCusto;
	}

	public void setAjudaDeCusto(double ajudaDeCusto) {
		this.ajudaDeCusto = ajudaDeCusto;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getSalarioTotal() {
		return ajudaDeCusto + salario;
	}
	
}

