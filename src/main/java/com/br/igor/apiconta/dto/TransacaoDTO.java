package com.br.igor.apiconta.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class TransacaoDTO {
	@NotBlank(message = "agency-number.not-blank")
	private String agencyNumber;

	@NotBlank(message = "account-number.not-blank")
	private String accountNumber;

	@Min(value = 0, message = "value.lower-than-zero")
	private long value;

	public String getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(String agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
}
