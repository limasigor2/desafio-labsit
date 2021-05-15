package com.br.igor.apiconta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.igor.apiconta.model.PessoaJuridica;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

	Optional<PessoaJuridica> findByIdentification(String identification);

}
