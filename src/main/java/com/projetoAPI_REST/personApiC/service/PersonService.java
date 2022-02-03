package com.projetoAPI_REST.personApiC.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoAPI_REST.personApiC.dto.mapper.PersonMapper;
import com.projetoAPI_REST.personApiC.dto.response.MessageResponseDTO;
import com.projetoAPI_REST.personApiC.dto.resquest.PersonDTO;
import com.projetoAPI_REST.personApiC.entity.Person;
import com.projetoAPI_REST.personApiC.exception.PersonNotFoundException;
import com.projetoAPI_REST.personApiC.repository.PersonRepository;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

	private PersonRepository personRepository;	
	
	private final  PersonMapper personMapper = PersonMapper.INSTANCE;	

	public MessageResponseDTO createPerson(PersonDTO personDTO) {

		Person personToSave = personMapper.toModel(personDTO);

		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO.builder().message("Created Person with ID " + savedPerson.getId()).build();

	}

	public java.util.List<PersonDTO> listAll() {
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		return personMapper.toDTO(person);
	}
	
	public void delete(Long id) throws PersonNotFoundException{
		verifyIfExists(id);	
		personRepository.deleteById(id);
	}


    private Person verifyIfExists(Long id) throws PersonNotFoundException{
		return personRepository.findById(id)
		.orElseThrow(() -> new PersonNotFoundException(id)); 
		}
	

}
