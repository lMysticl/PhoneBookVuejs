package com.mystic.service.impl;

import com.mystic.exceptions.RegistrationException;
import com.mystic.model.entity.User;
import com.mystic.model.repository.RoleRepository;
import com.mystic.model.repository.UserRepository;
import com.mystic.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Putrenkov Pavlo
 */
@Service("userService")
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public User findByUsername(String username) throws UsernameNotFoundException {
        if (userRepository.findByUsername(username) != null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return userRepository.findByUsername(username);
    }


    public User getUserService(@RequestBody String data) throws RegistrationException {

        JSONObject obj = new JSONObject(data);
        User user = new User();

        String firstname = obj.has("firstname") ? obj.getString("firstname") : "";

        String password = obj.has("password") ? obj.getString("password") : "";

        String username = obj.has("username") ? obj.getString("username") : "";

        if (userRepository.findByUsername(username) != null) {
            throw new RegistrationException(username + " User exist");
        }

        user.setFirstname(firstname);

        user.setPassword(DigestUtils.sha256Hex(password));

        user.setLastname("");

        user.setUsername(username);

        user.addRole(roleRepository.findOne(1L));

        return user;

    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findById(Long id) throws AccessDeniedException {
        return userRepository.findOne(id);
    }

    public List<User> findAll() throws AccessDeniedException {
        return userRepository.findAll();
    }
}
