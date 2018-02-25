package com.mystic.validation;

import com.mystic.exceptions.ContactException;
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


    public void validateContact(Contact contact) throws ContactException {
        String errors = "";
        if (!validation.isNameValid(contact.getFirstname())) {
            errors+="First name is not valid;";
        }

//        if (!validation.isNameValid(contact.getLastname()) || contact.getLastname().equals("")) {
//            errors+="Last name is not valid;";
//        }

        if (!validation.isPhoneValid(contact.getMobilePhone())) {
            errors+="Phone is not valid;";
        }


//        if (!(contact.getCountry().equals(""))) {
//            errors+="Country is not valid;";
//        }


//        if (!validation.isAddressValid(contact.getAddress())) {
//            errors+="Address is not valid;";
//        }

//        if (!validation.isEmailValid(contact.getEmail())) {
//            errors+="Email is not valid;";
//        }

        if (errors.length()>=1){
            throw new ContactException(errors);
        }
    }
}
