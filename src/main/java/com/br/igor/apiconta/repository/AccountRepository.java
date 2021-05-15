package com.br.igor.apiconta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.igor.apiconta.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByNumberAccount(String numberAccount);
}
