package com.br.igor.apiconta.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.br.igor.apiconta.dto.PersonDTO;
import com.br.igor.apiconta.dto.TypePerson;
import com.br.igor.apiconta.model.Person;
import com.br.igor.apiconta.model.PessoaFisica;
import com.br.igor.apiconta.model.PessoaJuridica;

@Component
public class PessoaMapper {

	public Person dtoToObj(PersonDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		if (dto.getTypePerson().equals(TypePerson.PF)) {
			return modelMapper.map(dto, PessoaFisica.class);
		}
		return modelMapper.map(dto, PessoaJuridica.class);
	}

	public PersonDTO objToDto(Person contaCorrente) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(contaCorrente, PersonDTO.class);
	}

}
