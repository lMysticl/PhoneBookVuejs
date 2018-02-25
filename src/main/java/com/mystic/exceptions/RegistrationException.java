package com.mystic.exceptions;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
public class RegistrationException extends BaseException {

    private static final String USER_EXIST_EXCEPTION_MESSAGE = "User with this name exist";

    public RegistrationException(String description) {
        super(description,USER_EXIST_EXCEPTION_MESSAGE);
    }
}
