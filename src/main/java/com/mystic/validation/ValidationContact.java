package com.mystic.validation;

import com.mystic.exceptions.ContactExeption;
import com.mystic.model.entity.Contact;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@Service
@AllArgsConstructor
public class ValidationContact {

    private final ValidationService validation;


    public void validateContact(Contact contact) throws ContactExeption {

        if (!validation.isNameValid(contact.getFirstname())) {
            throw new ContactExeption("First name is not valid");
        }
        if (!validation.isNameValid(contact.getLastname()) & !contact.getLastname().equals("")) {
            throw new ContactExeption("Last name is not valid");
        }
        if (!validation.isPhoneValid(contact.getMobilePhone())) {
            throw new ContactExeption("Phone is not valid");
        }
    }
}
