package com.br.igor.apiconta.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.br.igor.apiconta.util.CpfOrCnpj;

public class PersonDTO {

	@NotBlank(message = "name.not-blank")
	private String name;

	@NotNull(message = "type-person.not-null")
	@Pattern(regexp = "^(PJ|PF)$", message = "type-person.not-valid")
	private String typePerson;

	@NotBlank(message = "account-number.not-blank")
	private String accountNumber;

	@NotBlank(message = "agency-number.not-blank")
	private String agencyNumber;

	@NotBlank(message = "identification.not-blank")
	@CpfOrCnpj
	private String identification;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypePerson() {
		return typePerson;
	}

	public void setTypePerson(String typePerson) {
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
		this.identification = identification.replace("-","").replace(".", "").replace("/", "");
	}
	
	@Override
	public String toString() {
		return "PersonDTO [name=" + name + ", typePerson=" + typePerson + ", accountNumber=" + accountNumber
				+ ", agencyNumber=" + agencyNumber + ", identification=" + identification + "]";
	}

	
}
