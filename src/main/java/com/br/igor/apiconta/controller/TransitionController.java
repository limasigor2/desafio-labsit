package com.br.igor.apiconta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.igor.apiconta.exception.ApicontaException;
import com.br.igor.apiconta.model.Transition;
import com.br.igor.apiconta.service.TransitionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/extract")
@Api(value = "Extract")
public class TransitionController {
	
	@Autowired
	private TransitionService transitionService;

	@ApiOperation(value = "Recupera o extrada da conta {accountNumber} da agência {aggencyNumber}")
	@GetMapping(value = "/{accountNumber}/{aggencyNumber}")
	public ResponseEntity<List<Transition>> getCurrent(@PathVariable("accountNumber") String accountNumber,
			@PathVariable("aggencyNumber") String aggencyNumber) throws ApicontaException {
		return ResponseEntity.ok(transitionService.getTransition(accountNumber, aggencyNumber));
	}
}
