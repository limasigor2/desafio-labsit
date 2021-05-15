package com.br.igor.apiconta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.igor.apiconta.exception.ApicontaException;
import com.br.igor.apiconta.service.TransitionService;

@RestController
@RequestMapping("/extract")
public class TransitionController {
	
	@Autowired
	private TransitionService transitionService;

	@GetMapping(value = "/{accountNumber}/{aggencyNumber}")
	public ResponseEntity<?> getCurrent(@PathVariable("accountNumber") String accountNumber,
			@PathVariable("aggencyNumber") String aggencyNumber) throws ApicontaException {
		return ResponseEntity.ok(transitionService.getTransition(accountNumber, aggencyNumber));
	}
}
