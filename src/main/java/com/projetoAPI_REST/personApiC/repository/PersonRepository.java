package com.projetoAPI_REST.personApiC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.projetoAPI_REST.personApiC.entity.Person;

@Repository
@Component
@EnableJpaRepositories
public interface PersonRepository extends JpaRepository<Person, Long> {

	
}