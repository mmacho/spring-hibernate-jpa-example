package com.innovationM.spring;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.innovationM.spring.config.AppConfig;
import com.innovationM.spring.entity.Person;
import com.innovationM.spring.service.PersonService;
import com.innovationM.spring.service.PersonServiceImp2;
import com.innovationM.spring.service.PersonServiceImp3;

public class MainApp {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		PersonService personService = context.getBean(PersonService.class);
		PersonServiceImp2 personService2 = context.getBean(PersonServiceImp2.class);
		PersonServiceImp3 personService3 = context.getBean(PersonServiceImp3.class);

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

		context.close();
	}
}
