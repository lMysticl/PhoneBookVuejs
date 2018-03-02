package com.mystic.service;

import com.mystic.model.entity.User;
import com.mystic.model.repository.RoleRepository;
import com.mystic.model.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistrationServiceImplTest {

    private static final String PETIA = "Petia";

    private static final String PASSWORD = "12345";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService getUserService;

    @Autowired
    private RoleRepository roleRepository;

    private User user;

    @Before
    public void setUp() {

        user = new User();
        user.setUsername(PETIA);
        user.setPassword(PASSWORD);
        user.addRole(roleRepository.findById(1L).get());


    }


    @Transactional

    @Test
    public void registrationTest() {
        userRepository.save(user);
        Assert.assertTrue(userRepository.findByUsername(user.getUsername()).getUsername().equals(PETIA));
        Assert.assertTrue(user.getUserId() != 0);

        Optional<User> actual = Optional.ofNullable(this.user);
        Optional<User> current = userRepository.findById(this.user.getUserId());
        Assert.assertEquals(actual, current);

    }


}
