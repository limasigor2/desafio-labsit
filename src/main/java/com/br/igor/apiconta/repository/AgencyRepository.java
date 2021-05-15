package com.br.igor.apiconta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.igor.apiconta.model.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

}
