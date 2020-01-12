package com.innovationM.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.innovationM.spring.entity.Person;
import com.innovationM.spring.service.reactive.PersonReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Process {

	@Autowired
	PersonService personService;
	@Autowired
	PersonServiceImp2 personService2;
	@Autowired
	PersonServiceImp3 personService3;
	@Autowired
	PersonReactiveService personReactiveService;

	public void test() {
		// Add Persons
		personService.add(new Person("Rahul", "Gupta", "rahulgupta@company.com"));
		personService.add(new Person("Akshay", "Sharma", "akshaysharma@company.com"));
		personService.add(new Person("Ankit", "Sarraf", "ankitsarraf@company.com"));
		List<Person> persons = personService2.listPersons();
		persons = personService3.listPersons();
		// Get Persons
		persons = personService.listPersons();

		for (Person person : persons) {
			System.out.println("Id = " + person.getId());
			System.out.println("First Name = " + person.getFirstName());
			System.out.println("Last Name = " + person.getLastName());
			System.out.println("Email = " + person.getEmail());
			System.out.println();
		}
		Mono<Person> p1 = personReactiveService.findById(1L);
		Mono<Person> p2 = personReactiveService.findById(2L);
		Flux<Person> total = Flux.merge(p1, p2);
		total.subscribe(System.out::println);
		Flux<Person> f = personReactiveService.findAll();
		f.subscribe(System.out::println);

	}
}
