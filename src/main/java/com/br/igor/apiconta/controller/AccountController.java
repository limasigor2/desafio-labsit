package com.br.igor.apiconta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.igor.apiconta.dto.AccountDTO;
import com.br.igor.apiconta.dto.MessageDTO;
import com.br.igor.apiconta.dto.SaldoDTO;
import com.br.igor.apiconta.dto.TransacaoDTO;
import com.br.igor.apiconta.exception.ApicontaException;
import com.br.igor.apiconta.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/account")
@Api(value = "Account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@ApiOperation(value = "Saca o valor {value} da {accountNumber} da agência {agencyNumber}")
	@PutMapping("/sacar")
	public ResponseEntity<AccountDTO> sacar(@RequestBody TransacaoDTO saqueDto) throws ApicontaException {
		return ResponseEntity.ok(accountService.sacar(saqueDto));
	}

	@ApiOperation(value = "Deposita o valor {value} da {accountNumber} da agência {agencyNumber}")
	@PutMapping("/depositar")
	public ResponseEntity<MessageDTO> depositar(@RequestBody TransacaoDTO saqueDto) throws ApicontaException {
		return ResponseEntity.ok(accountService.depositar(saqueDto));
	}

	@ApiOperation(value = "Recupera o saldo atual da {accountNumber} da agência {agencyNumber}")
	@GetMapping(value = "/{accountNumber}/{aggencyNumber}")
	public ResponseEntity<SaldoDTO> getCurrentBalance(@PathVariable("accountNumber") String accountNumber,
			@PathVariable("aggencyNumber") String aggencyNumber) throws ApicontaException {
		return ResponseEntity.ok(accountService.getCurrentBalance(accountNumber, aggencyNumber));
	}

}
