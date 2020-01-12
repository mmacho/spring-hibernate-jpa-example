package com.innovationM.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.innovationM.spring.entity.Person;

public class Process {

	@Autowired
	PersonService personService;
	@Autowired
	PersonServiceImp2 personService2;
	@Autowired
	PersonServiceImp3 personService3;

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

	}
}
