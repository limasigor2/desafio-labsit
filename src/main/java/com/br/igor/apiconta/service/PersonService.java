package com.br.igor.apiconta.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.br.igor.apiconta.dto.MessageDTO;
import com.br.igor.apiconta.dto.PersonDTO;
import com.br.igor.apiconta.dto.TypePerson;
import com.br.igor.apiconta.exception.ApicontaException;
import com.br.igor.apiconta.mapper.PessoaMapper;
import com.br.igor.apiconta.model.Account;
import com.br.igor.apiconta.model.Agency;
import com.br.igor.apiconta.model.Person;
import com.br.igor.apiconta.model.PessoaFisica;
import com.br.igor.apiconta.model.PessoaJuridica;
import com.br.igor.apiconta.repository.AccountRepository;
import com.br.igor.apiconta.repository.AgencyRepository;
import com.br.igor.apiconta.repository.PessoaFisicaRepository;
import com.br.igor.apiconta.repository.PessoaJuridicaRepository;

@Service
public class PersonService {

	@Autowired
	private PessoaMapper mapper;

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;

	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;

	@Autowired
	private AgencyRepository agencyRepository;

	@Autowired
	private AccountRepository accountRepository;

	public MessageDTO save(PersonDTO personDto) {

		Person person = mapper.dtoToObj(personDto);
		personDto.getAccountNumber();
		Agency agency = new Agency(personDto.getAgencyNumber(), new HashSet<>());
		Account account = new Account(personDto.getAccountNumber(), person, agency, 0);
		agency.addAccount(account);

		accountRepository.save(account);
		agencyRepository.save(agency);

		if (personDto.getTypePerson().equals(TypePerson.PF))
			mapper.objToDto(pessoaFisicaRepository.save((PessoaFisica) person));
		else
			mapper.objToDto(pessoaJuridicaRepository.save((PessoaJuridica) person));

		return new MessageDTO("Usuário cadastrado com sucesso", "user.saved.sucess");
	}

	public MessageDTO update(PersonDTO personDto) throws ApicontaException {
		if (personDto.getTypePerson().equals(TypePerson.PF)) {
			PessoaFisica pessoaFisica = pessoaFisicaRepository.findByIdentification(personDto.getIdentification())
					.orElseThrow(() -> new ApicontaException(HttpStatus.NOT_FOUND, "person.not-found",
							"Pessoa não encontrada"));
			pessoaFisica.setName(personDto.getName());
			pessoaFisicaRepository.save(pessoaFisica);
			return new MessageDTO("Usuário atualizado com sucesso", "user.updated.sucess");

		}

		PessoaJuridica pessoaJuridica = pessoaJuridicaRepository.findByIdentification(personDto.getIdentification())
				.orElseThrow(
						() -> new ApicontaException(HttpStatus.NOT_FOUND, "person.not-found", "Pessoa não encontrada"));
		pessoaJuridica.setName(personDto.getName());
		pessoaJuridicaRepository.save(pessoaJuridica);
		return new MessageDTO("Usuário atualizado com sucesso", "user.updated.sucess");

	}
}
