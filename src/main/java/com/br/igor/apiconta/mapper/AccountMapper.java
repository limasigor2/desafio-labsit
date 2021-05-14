package com.br.igor.apiconta.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.br.igor.apiconta.dto.AccountDTO;
import com.br.igor.apiconta.model.Account;


@Component
public class AccountMapper {
	
	public Account dtoToObj(AccountDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Account.class);
	}
	
	public AccountDTO objToDto(Account contaCorrente) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(contaCorrente, AccountDTO.class);
	}

}
