package com.mystic.validation;

import com.mystic.exceptions.RegistrationException;
import com.mystic.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@Service
@AllArgsConstructor
public class ValidationRegistration {

    private final UserRepository userRepository;

    private ValidationService validationService;

    public void validation(String firstname, String password, String username) throws RegistrationException {
        if (validationService.isNameValid(firstname)) {
            throw new RegistrationException(firstname + "Firstname is not valid");
        }
        if (validationService.isPasswordValid(password)) {
            throw new RegistrationException("Password is not valid");
        }
        if (validationService.isNameValid(username)) {
            throw new RegistrationException("Username is not valid");
        }

        if (userRepository.findByUsername(username) != null) {
            throw new RegistrationException(username + " User exist");
        }
    }
}
