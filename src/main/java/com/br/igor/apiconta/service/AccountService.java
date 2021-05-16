package com.br.igor.apiconta.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.br.igor.apiconta.dto.AccountDTO;
import com.br.igor.apiconta.dto.MessageDTO;
import com.br.igor.apiconta.exception.ApicontaException;
import com.br.igor.apiconta.dto.SaldoDTO;
import com.br.igor.apiconta.dto.TransacaoDTO;
import com.br.igor.apiconta.mapper.AccountMapper;
import com.br.igor.apiconta.model.Account;
import com.br.igor.apiconta.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountMapper mapper;

	@Autowired
	private TransitionService transitionService;

	public void save(Account account) {

		accountRepository.save(account);
	}

	public AccountDTO sacar(TransacaoDTO saqueDto) throws ApicontaException {
		Account account = findAccountByAccountNumberAndAgencyNumber(saqueDto.getAccountNumber(), saqueDto.getAgencyNumber());

		account.setCurrentBalance(account.getCurrentBalance() - saqueDto.getValue());
		transitionService.addTransiction(-saqueDto.getValue(), account.getCurrentBalance(), account);

		return mapper.objToDto(accountRepository.save(account));

	}

	public MessageDTO depositar(TransacaoDTO depositoDto) throws ApicontaException {

		Account account = findAccountByAccountNumberAndAgencyNumber(depositoDto.getAccountNumber(),
				depositoDto.getAgencyNumber());

		account.setCurrentBalance(account.getCurrentBalance() + depositoDto.getValue());
		transitionService.addTransiction(depositoDto.getValue(), account.getCurrentBalance(), account);
		accountRepository.save(account);
		return new MessageDTO("Depósito realizado com sucesso", "deposit.success");

	}

	public SaldoDTO getCurrentBalance(String accountNumber, String agencyNumber) throws ApicontaException {
		Account account = accountRepository.findByNumberAccount(accountNumber).orElseThrow(
				() -> new ApicontaException(HttpStatus.NOT_FOUND, "account.not-found", "Conta não encontrada"));
		if (account.getAgency().getNumber().equals(agencyNumber))
			return new SaldoDTO(account.getCurrentBalance());
		throw new EntityNotFoundException();
	}

	public Account findAccountByAccountNumberAndAgencyNumber(String numberAccount, String agencyNumber)
			throws ApicontaException {
		Account account = accountRepository.findByNumberAccount(numberAccount).orElseThrow(
				() -> new ApicontaException(HttpStatus.NOT_FOUND, "account.not-found", "Conta não encontrada"));

		if (account.getAgency().getNumber().equals(agencyNumber))
			return account;

		throw new EntityNotFoundException();
	}

}
