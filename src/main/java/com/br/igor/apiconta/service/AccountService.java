package com.br.igor.apiconta.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.igor.apiconta.dto.AccountDTO;
import com.br.igor.apiconta.dto.TransactionDTO;
import com.br.igor.apiconta.dto.SaldoDTO;
import com.br.igor.apiconta.mapper.AccountMapper;
import com.br.igor.apiconta.model.Account;
import com.br.igor.apiconta.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountMapper mapper;

	public AccountDTO save(AccountDTO accountDTO) {
		Account account = mapper.dtoToObj(accountDTO);
		return mapper.objToDto(accountRepository.save(account));
	}

	public AccountDTO sacar(TransactionDTO saqueDto) {
		Account account = accountRepository.findByNumberAccount(saqueDto.getAccountNumber())
				.orElseThrow(() -> new EntityNotFoundException());

		System.out.println(saqueDto.getAccountNumber());
		System.out.println(account.getAgency().getNumber());
		if (account.getAgency().getNumber().equals(saqueDto.getAgencyNumber()))
			account.setCurrentBalance(account.getCurrentBalance() - saqueDto.getValue());
		else
			throw new EntityNotFoundException();
		return mapper.objToDto(accountRepository.save(account));

	}

	public AccountDTO depositar(TransactionDTO saqueDto) {
		Account account = accountRepository.findByNumberAccount(saqueDto.getAccountNumber())
				.orElseThrow(() -> new EntityNotFoundException());

		if (account.getAgency().getNumber().equals(saqueDto.getAgencyNumber()))
			account.setCurrentBalance(account.getCurrentBalance() + saqueDto.getValue());
		else
			throw new EntityNotFoundException();
		return mapper.objToDto(accountRepository.save(account));
	}

	public SaldoDTO getCurrentBalance(String accountNumber, String agencyNumber) {
		Account account = accountRepository.findByNumberAccount(accountNumber)
				.orElseThrow(() -> new EntityNotFoundException());
		if (account.getAgency().getNumber().equals(agencyNumber))
			return new SaldoDTO(account.getCurrentBalance());
		throw new EntityNotFoundException();
	}

}
