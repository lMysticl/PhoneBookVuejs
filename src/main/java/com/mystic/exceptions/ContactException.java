package com.mystic.exceptions;

import lombok.ToString;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@ToString
public class ContactException extends BaseException {

    private static final String CONTACT_EXCEPTION_MESSAGE = "Contact is not valid";

    public ContactException(String description) {
        super( description,CONTACT_EXCEPTION_MESSAGE);
    }
}
