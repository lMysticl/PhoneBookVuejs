package com.mystic.exceptions;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
public class ContactException extends BaseException {

    private static final String CONTACT_EXCEPTION_MESSAGE = "Contact is not valid ";

    public ContactException(String description) {
        super(CONTACT_EXCEPTION_MESSAGE, description);
    }
}
