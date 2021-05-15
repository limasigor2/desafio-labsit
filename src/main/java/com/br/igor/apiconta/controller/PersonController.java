package com.br.igor.apiconta.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.igor.apiconta.dto.PersonDTO;
import com.br.igor.apiconta.exception.ApicontaException;
import com.br.igor.apiconta.service.PersonService;

@RestController()
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService pessoaService;
	
	@PostMapping()
	public ResponseEntity<?> createPessoa(@Valid @RequestBody PersonDTO personDto) {
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(personDto));
	}

	@PutMapping()
	public ResponseEntity<?> updatePessoa(@Valid @RequestBody PersonDTO personDto) throws ApicontaException {
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.update(personDto));
	}

}
