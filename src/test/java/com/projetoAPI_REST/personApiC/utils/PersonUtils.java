package com.projetoAPI_REST.personApiC.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.projetoAPI_REST.personApiC.dto.resquest.PersonDTO;
import com.projetoAPI_REST.personApiC.entity.Person;

public class PersonUtils {
	
	private static final String FIRST_NAME = "Rodrigo";
	private static final String LAST_NAME = "Peleias";
	private static final String CPF_NAME = "369.333.878-79";
	private static final long PERSON_ID = 1L;
	private static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);
	
	
	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder()
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NAME)
				.birthDate("14-04-2018")
				.phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
				.build();
	}
	
	public static Person createfakeEntity() {
		return Person.builder()
				.id(PERSON_ID)
				.firtsName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NAME)
				.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
				.build();
	}

}
