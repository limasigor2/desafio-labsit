package com.br.igor.apiconta.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transitions")
public class Transition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "moment")
	private LocalDateTime moment;

	@Column(name = "valor")
	private float value;

	@Column(name = "final_resultante")
	private float finalBalance;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;

	public Transition() {
	}

	public Transition(float value, float finalBalance, Account account) {
		super();
		this.value = value;
		this.finalBalance = finalBalance;
		this.account = account;
		this.setMoment();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment() {
		this.moment = LocalDateTime.now();
	}

	public float getFinalBalance() {
		return finalBalance;
	}

	public void setFinalBalance(float finalBalance) {
		this.finalBalance = finalBalance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float valor) {
		this.value = valor;
	}

}
