package com.aws.spring.project.service;

import com.aws.spring.project.Domain.User;
import com.aws.spring.project.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findUsers(Long id) {
        return id == null ? repository.findAll() : repository.findById(id).stream().toList();
    }

    @Transactional
    public void saveUser(User user) {
        repository.save(user);
    }

}
