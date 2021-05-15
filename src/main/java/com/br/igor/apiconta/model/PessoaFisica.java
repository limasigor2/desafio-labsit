package com.br.igor.apiconta.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Person {

	@Column(name = "cpf", unique = true)
	private String identification;

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	
	
}
