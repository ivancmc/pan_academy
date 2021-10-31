package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Nome deve ser preenchido!")
	private String nome;
	
	@NotEmpty(message="Departamento deve ser preenchido!")
	private String departamento;
	
	@NotNull(message="Salario nao pode ser nulo!")
	private Double salario;
	
	public Funcionario() {}

	public Funcionario(String nome, String departamento, Double salario) {
		this.nome = nome;
		this.departamento = departamento;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
