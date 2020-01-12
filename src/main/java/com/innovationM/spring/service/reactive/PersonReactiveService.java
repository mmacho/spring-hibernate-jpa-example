package com.innovationM.spring.service.reactive;

import com.innovationM.spring.entity.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonReactiveService {

	Mono<Person> findById(Long id);

	Flux<Person> findAll();

	Mono<Person> save(Mono<Person> personMono);

	Mono<Void> update(Long id, Mono<Person> personMono);

	Mono<Void> delete(Long id);

}
