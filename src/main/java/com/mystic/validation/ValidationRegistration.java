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

    public void validation(String firstname,  String username) throws RegistrationException {
        String errors = "";
        if (!validationService.isNameValid(firstname) & !firstname.equals("")) {
            errors+="Firstname is not valid";
        }

        if (!validationService.isNameValid(username)) {
            errors+="Username is not valid";
        }
        if (userRepository.findByUsername(username) != null) {
            errors+=" User exist";
        }
        if (errors.length()>=1){
            throw new RegistrationException(errors);
        }
    }

}
