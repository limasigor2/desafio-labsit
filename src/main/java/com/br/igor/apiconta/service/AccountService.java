package com.br.igor.apiconta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.igor.apiconta.dto.AccountDTO;
import com.br.igor.apiconta.mapper.AccountMapper;
import com.br.igor.apiconta.model.Account;
import com.br.igor.apiconta.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository contaCorrenteRepository;
	
	@Autowired
	AccountMapper mapper;

	public AccountDTO save(AccountDTO accountDTO) {
		Account account = mapper.dtoToObj(accountDTO);
		return mapper.objToDto(contaCorrenteRepository.save(account));
	}
	
}
