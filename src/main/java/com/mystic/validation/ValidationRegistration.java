package com.mystic.validation;

import com.mystic.exceptions.RegistrationException;
import com.mystic.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public void validation(String firstname,  String username) throws RegistrationException {

        String name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!validationService.isNameValid(firstname) & !firstname.equals("")) {
            throw new RegistrationException(firstname + "Firstname is not valid");
        }

        if (!validationService.isNameValid(username)) {
            throw new RegistrationException("Username is not valid");
        }

        if (userRepository.findByUsername(username) != null && !name.equals(username)) {
            throw new RegistrationException(username + " User exist");
        }
    }

}
