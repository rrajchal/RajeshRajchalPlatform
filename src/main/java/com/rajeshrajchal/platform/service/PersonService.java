package com.rajeshrajchal.platform.service;

import com.rajeshrajchal.platform.dto.PersonRequest;
import com.rajeshrajchal.platform.dto.PersonResponse;
import com.rajeshrajchal.platform.model.Person;
import com.rajeshrajchal.platform.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonResponse> getAllPeople() {
        return personRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public PersonResponse getPersonById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Person not found with id: " + id
                        )
                );

        return toResponse(person);
    }

    public PersonResponse savePerson(PersonRequest request) {

        Person person = new Person(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail()
        );

        Person savedPerson = personRepository.save(person);

        return toResponse(savedPerson);
    }

    public PersonResponse updatePerson(Long id, PersonRequest request) {

        Person existingPerson = personRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Person not found with id: " + id
                        )
                );

        existingPerson.setFirstName(request.getFirstName());
        existingPerson.setLastName(request.getLastName());
        existingPerson.setEmail(request.getEmail());

        Person updatedPerson = personRepository.save(existingPerson);

        return toResponse(updatedPerson);
    }

    public void deletePerson(Long id) {

        Person person = personRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Person not found with id: " + id
                        )
                );

        personRepository.delete(person);
    }

    private PersonResponse toResponse(Person person) {

        return new PersonResponse(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail()
        );
    }
}