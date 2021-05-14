package com.br.igor.apiconta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.igor.apiconta.dto.PersonDTO;
import com.br.igor.apiconta.service.PersonService;

@RestController()
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService pessoaService;
	
	@PostMapping()
	public ResponseEntity<?> createPessoa(@RequestBody PersonDTO personDto){
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(personDto));
	}
	
}
