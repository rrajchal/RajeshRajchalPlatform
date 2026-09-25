package com.rajeshrajchal.platform.repository;

import com.rajeshrajchal.platform.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}