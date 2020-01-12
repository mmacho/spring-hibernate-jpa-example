package com.innovationM.spring.service.reactive;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovationM.spring.dao.PersonDao2;
import com.innovationM.spring.entity.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonReactiveServiceImpl implements PersonReactiveService {

	private PersonDao2 personRepo;

	@Autowired
	public PersonReactiveServiceImpl(PersonDao2 personRepo) {
		this.personRepo = personRepo;
	}

	@Override
	public Mono<Person> findById(Long id) {
		return Mono.justOrEmpty(personRepo.findById(id)).delayElement(Duration.ofSeconds(3));
	}

	@Override
	public Flux<Person> findAll() {
		return Flux.fromIterable(personRepo.findAll());
	}

	@Override
	public Mono<Person> save(Mono<Person> personMono) {
		return personMono.doOnNext(person -> {
			Mono.just(personRepo.save(person));
		});
	}

	@Override
	public Mono<Void> update(Long id, Mono<Person> personMono) {

		return Mono.empty();
	}

	@Override
	public Mono<Void> delete(Long id) {
		personRepo.findById(id).ifPresent(person -> personRepo.delete(person));
		return Mono.empty();
	}
}
