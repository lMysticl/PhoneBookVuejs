package com.mystic.service;

import com.mystic.exceptions.RegistrationException;
import com.mystic.model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Putrenkov Pavlo
 */
public interface UserService {
    Optional<User> findById(Long id);

    User findByUsername(String username);

    List<User> findAll();

    User setUser(String data) throws RegistrationException;

    void checkPassword(User user, String oldPassword) throws RegistrationException;
}
