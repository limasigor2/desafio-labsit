package com.br.igor.apiconta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.igor.apiconta.exception.ApicontaException;
import com.br.igor.apiconta.model.Account;
import com.br.igor.apiconta.model.Transition;
import com.br.igor.apiconta.repository.TransitionRepository;

@Service
public class TransitionService {

	@Autowired
	private TransitionRepository transitionRepository;

	@Autowired
	private AccountService accountService;

	public void addTransiction(float value, float finalBalance, Account account) {

		Transition trans = new Transition(value, finalBalance, account);
		account.addTransition(trans);
		accountService.save(account);
		transitionRepository.save(trans);

	}

	public List<Transition> getTransition(String accountNumber, String agencyNumber) throws ApicontaException {

		return accountService.findAccountByAccountNumberAndAgencyNumber(accountNumber, agencyNumber).getTransitions();
	}

}
