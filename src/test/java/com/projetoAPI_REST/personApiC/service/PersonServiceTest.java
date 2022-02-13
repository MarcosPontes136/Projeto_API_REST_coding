package com.projetoAPI_REST.personApiC.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.projetoAPI_REST.personApiC.dto.response.MessageResponseDTO;
import com.projetoAPI_REST.personApiC.dto.resquest.PersonDTO;
import com.projetoAPI_REST.personApiC.entity.Person;
import com.projetoAPI_REST.personApiC.repository.PersonRepository;
import com.projetoAPI_REST.personApiC.utils.PersonUtils;
import static com.projetoAPI_REST.personApiC.utils.PersonUtils.createFakeDTO;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	void testGivenPersonDTOThenReturnSavedMessage() {
		PersonDTO personDTO = createFakeDTO();
		Person expectedSavedPerson = PersonUtils.createfakeEntity();

		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
		
		MessageResponseDTO expectedSuccessMessage = createExpectidMessageRespon(expectedSavedPerson.getId());
		MessageResponseDTO succesMessage = personService.createPerson(personDTO);
		
		assertEquals(expectedSuccessMessage, succesMessage);
	}

	private MessageResponseDTO createExpectidMessageRespon(Long saverPersonId) {
		return MessageResponseDTO.builder()
				.message("Created Person with ID" + saverPersonId)
				.build();
	}
	
}
