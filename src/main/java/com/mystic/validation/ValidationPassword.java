package com.mystic.validation;

import com.mystic.exceptions.RegistrationException;
import com.mystic.model.entity.User;
import com.mystic.service.impl.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@Service
public class ValidationPassword {

    private final UserServiceImpl userServiceImpl;


    @Autowired
    public ValidationPassword(@Lazy UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    public void validation(User user, String oldPassword) throws RegistrationException {
        if (!userServiceImpl.getUser(user.getUsername()).getPassword().equals(DigestUtils.sha256Hex(oldPassword))) {
            throw new RegistrationException(oldPassword + " Old password is not valid");
        }

    }
}
