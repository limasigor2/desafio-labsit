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

import com.br.igor.apiconta.dto.MessageDTO;
import com.br.igor.apiconta.dto.PersonDTO;
import com.br.igor.apiconta.dto.UpdateDTO;
import com.br.igor.apiconta.exception.ApicontaException;
import com.br.igor.apiconta.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping("/person")
@Api(value = "Person")
public class PersonController {

	@Autowired
	private PersonService pessoaService;

	@ApiOperation(value = "Cria a conta {accountNumber} na agência {agencyNumber} de uma pessoa com nome {name} do tipo {typePerson} com CPF ou CNPJ {identification}")
	@PostMapping()
	public ResponseEntity<MessageDTO> createPessoa(@Valid @RequestBody PersonDTO personDto) {
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(personDto));
	}

	@ApiOperation(value = "Atualiza o nome da pessoa com identificação {identification} para o nome {name}")
	@PutMapping()
	public ResponseEntity<MessageDTO> updatePessoa(@Valid @RequestBody UpdateDTO personDto) throws ApicontaException {
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.update(personDto));
	}

}
