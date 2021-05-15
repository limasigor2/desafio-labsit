package com.br.igor.apiconta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.igor.apiconta.model.Transition;

@Repository
public interface TransitionRepository extends JpaRepository<Transition, Long> {

}
