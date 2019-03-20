package com.p2lp2.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Freelancer {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private double horasTrabalhada;
	private double valorDaHora;

	public Freelancer() {}
	
	public Freelancer(Integer id, String nome, String cpf, double horasTrabalhada, double valorDaHora) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.horasTrabalhada = horasTrabalhada;
		this.valorDaHora = valorDaHora;
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

	public double getHorasTrabalhada() {
		return horasTrabalhada;
	}

	public void setHorasTrabalhada(double horasTrabalhada) {
		this.horasTrabalhada = horasTrabalhada;
	}

	public double getValorDaHora() {
		return valorDaHora;
	}

	public void setValorDaHora(double valorDaHora) {
		this.valorDaHora = valorDaHora;
	}
	
	public double getSalarioTotal() {
		return horasTrabalhada * valorDaHora;
	}

}
