package com.br.igor.apiconta.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author igor
 * 
 */
@Entity
@Table
public class Agency {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "number", unique = true)
	private String number;

	@JsonIgnore
	@OneToMany(mappedBy = "agency")
	private Set<Account> accounts = new HashSet<>();

	public Agency() {

	}

	public Agency(String number, Set<Account> accounts) {
		super();
		this.number = number;
		this.accounts = accounts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Agency [id=" + id + ", number=" + number + ", accounts="
				+ (accounts != null ? toString(accounts, maxLen) : null) + "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

}
