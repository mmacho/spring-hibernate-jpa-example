package com.innovationM.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innovationM.spring.dao.PersonDao3;
import com.innovationM.spring.entity.Person;

@Service
public class PersonServiceImp3 {

	@Autowired
	private PersonDao3 userDao;

	@Transactional
	public void add(Person person) {
		userDao.save(person);
	}

	@Transactional(readOnly = true)
	public List<Person> listPersons() {
		return (List<Person>) userDao.findAll();
	}
}
