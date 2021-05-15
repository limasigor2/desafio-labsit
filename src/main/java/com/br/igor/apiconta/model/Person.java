package com.br.igor.apiconta.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "person")
	private Set<Account> accounts = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Person [id=" + id + ", name=" + name + ", accounts="
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
