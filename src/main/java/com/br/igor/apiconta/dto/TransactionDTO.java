package com.br.igor.apiconta.dto;

public class TransactionDTO {
	private String agencyNumber;
	private String accountNumber;
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
