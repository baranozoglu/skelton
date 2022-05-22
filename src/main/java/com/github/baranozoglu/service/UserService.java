package com.github.baranozoglu.service;

import com.github.baranozoglu.model.User;
import com.github.baranozoglu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    
    public User create(final User user) {
        user.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return repository.save(user);
    }

    public User find(final String id) {
        return repository.findOne(id);
    }

    public User findByUsername(final String userName) {
        return repository.findByUsername(userName);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User update(final String id, final User user) {
        user.setId(id);

        final User saved = repository.findOne(id);

        if (saved != null) {
            user.setCreatedAt(saved.getCreatedAt());
            user.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        } else {
            user.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(user);
        return user;
    }

    public String delete(final String id) {
        repository.delete(id);
        return id;
    }
}
