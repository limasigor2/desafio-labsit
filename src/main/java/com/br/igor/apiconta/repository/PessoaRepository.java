package com.br.igor.apiconta.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.br.igor.apiconta.model.Person;

@NoRepositoryBean
public interface PessoaRepository<T extends Person> extends CrudRepository<T, Long> {

}
