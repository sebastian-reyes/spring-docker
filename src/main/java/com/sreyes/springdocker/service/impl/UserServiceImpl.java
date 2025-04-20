package com.sreyes.springdocker.service.impl;

import com.sreyes.springdocker.model.User;
import com.sreyes.springdocker.repository.UserRepository;
import com.sreyes.springdocker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Mono<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> updateUser(Integer id, User user) {
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    user.setIdUser(existingUser.getIdUser());
                    return userRepository.save(user);
                });
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return userRepository.deleteById(id);
    }
}
