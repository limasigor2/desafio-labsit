package com.br.igor.apiconta.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateDTO {

	@NotNull(message = "type-person.not-null")
	private TypePerson typePerson;

	@NotBlank(message = "name.not-blank")
	private String name;

	@NotBlank(message = "identification.not-blank")
	private String identification;

	public TypePerson getTypePerson() {
		return typePerson;
	}

	public void setTypePerson(TypePerson person) {
		this.typePerson = person;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

}
