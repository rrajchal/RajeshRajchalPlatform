package com.rajeshrajchal.platform.controller;

import com.rajeshrajchal.platform.dto.PersonRequest;
import com.rajeshrajchal.platform.dto.PersonResponse;
import com.rajeshrajchal.platform.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonResponse> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("/{id}")
    public PersonResponse getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/add")
    public PersonResponse addPerson(
            @Valid @RequestBody PersonRequest request) {

        return personService.savePerson(request);
    }

    @PutMapping("/update/{id}")
    public PersonResponse updatePerson(
            @PathVariable Long id,
            @Valid @RequestBody PersonRequest request) {

        return personService.updatePerson(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}