package com.br.igor.apiconta.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonDTO {

	private String name;

	private TypePerson typePerson;

	private String accountNumber;

	private String agencyNumber;

	@NotBlank
	@Size(min = 3, max = 20)
	private String identification;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypePerson getTypePerson() {
		return typePerson;
	}

	public void setTypePerson(TypePerson typePerson) {
		this.typePerson = typePerson;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(String agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	@Override
	public String toString() {
		return "PersonDTO [name=" + name + ", typePerson=" + typePerson + ", accountNumber=" + accountNumber
				+ ", agencyNumber=" + agencyNumber + ", identification=" + identification + "]";
	}

}
