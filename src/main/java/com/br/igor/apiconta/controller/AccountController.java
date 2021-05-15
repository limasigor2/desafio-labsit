package com.br.igor.apiconta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.igor.apiconta.dto.TransactionDTO;
import com.br.igor.apiconta.exception.ApicontaException;
import com.br.igor.apiconta.service.AccountService;

@RestController()
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PutMapping("/sacar")
	public ResponseEntity<?> sacar(@RequestBody TransactionDTO saqueDto) throws ApicontaException {
		return ResponseEntity.ok(accountService.sacar(saqueDto));
	}

	@PutMapping("/depositar")
	public ResponseEntity<?> depositar(@RequestBody TransactionDTO saqueDto) throws ApicontaException {
		return ResponseEntity.ok(accountService.depositar(saqueDto));
	}

	@GetMapping(value = "/{accountNumber}/{aggencyNumber}")
	public ResponseEntity<?> getCurrentBalance(@PathVariable("accountNumber") String accountNumber,
			@PathVariable("aggencyNumber") String aggencyNumber) throws ApicontaException {
		return ResponseEntity.ok(accountService.getCurrentBalance(accountNumber, aggencyNumber));
	}

}
