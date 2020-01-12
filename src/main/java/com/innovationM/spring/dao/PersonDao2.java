package com.innovationM.spring.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovationM.spring.entity.Person;

public interface PersonDao2 extends JpaRepository<Person, Integer> {

	Optional<Person> findById(Long id);

}
