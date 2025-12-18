package com.example.Exam.service;

import com.example.Exam.entity.User;
import com.example.Exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;

    @Transactional
    public User register(String name, Integer age) {
        User user = User.builder().name(name).age(age).build();
        return repo.save(user);
    }
}
