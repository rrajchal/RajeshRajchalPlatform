package com.rajeshrajchal.platform.controller;

import com.rajeshrajchal.platform.dto.PersonRequest;
import com.rajeshrajchal.platform.dto.PersonResponse;
import com.rajeshrajchal.platform.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/api/people")
    public List<PersonResponse> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("/api/people/{id}")
    public PersonResponse getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/api/people")
    public PersonResponse createPerson(@Valid @RequestBody PersonRequest request) {

        return personService.savePerson(request);
    }

    @PutMapping("/api/people/{id}")
    public PersonResponse updatePerson(
            @PathVariable Long id,
            @Valid @RequestBody PersonRequest request) {

        return personService.updatePerson(id, request);
    }

    @DeleteMapping("/api/people/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}