package com.br.igor.apiconta.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author igor
 *
 */

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "numberAccount", unique = true)
	private String numberAccount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "agency_id", referencedColumnName = "id")
	private Agency agency;


	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Transition> transitions = new ArrayList<>();

	@Column(name = "saldoAtual")
	private float currentBalance;

	public Account() {
	}

	public Account(String numberAccount, Person person, Agency agency, float currentBalance) {
		super();

		this.numberAccount = numberAccount;
		this.person = person;
		this.agency = agency;
		this.currentBalance = currentBalance;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public float getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(float currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public void addTransition(Transition trans) {
		this.transitions.add(trans);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", numberAccount=" + numberAccount + ", person=" + person.getName()
				+ ", currentBalance=" + currentBalance + "]";
	}

}
