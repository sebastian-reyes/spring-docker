package com.sreyes.springdocker.service;

import com.sreyes.springdocker.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> findById(Integer id);
    Flux<User> findAll();
    Mono<User> save(User user);
    Mono<User> updateUser(Integer id, User user);
    Mono<Void> deleteById(Integer id);
}
