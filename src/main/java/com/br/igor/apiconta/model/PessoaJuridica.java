package com.br.igor.apiconta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Person {

	@Column(name = "cnpf", unique = true)
	private String identification;

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

}
