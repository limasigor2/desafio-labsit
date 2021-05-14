package com.br.igor.apiconta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.igor.apiconta.dto.PersonDTO;
import com.br.igor.apiconta.mapper.PessoaMapper;
import com.br.igor.apiconta.model.Person;
import com.br.igor.apiconta.repository.PessoaFisicaRepository;
import com.br.igor.apiconta.repository.PessoaJuridicaRepository;

@Service
public class PersonService {

	
	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;
	
	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	
	@Autowired
	private PessoaMapper mapper;
	
	public PersonDTO save(PersonDTO personDto) {
		Person pessoa = mapper.dtoToObj(personDto);
		
		return null;// mapper.objToDto(personRepository.save(pessoa));
	}
}
