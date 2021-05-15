package com.br.igor.apiconta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.igor.apiconta.model.PessoaFisica;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

	Optional<PessoaFisica> findByIdentification(String identification);
}
