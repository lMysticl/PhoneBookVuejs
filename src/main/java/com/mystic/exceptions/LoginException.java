package com.mystic.exceptions;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
public class LoginException extends BaseException {

    private static final String USER_EXIST_EXCEPTION_MESSAGE = "Login is not valid";

    public LoginException(String description) {
        super(USER_EXIST_EXCEPTION_MESSAGE, description);
    }
}
