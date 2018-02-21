package com.mystic.exceptions;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
public class IllegalAccessException extends BaseException {

    private static final String ILLEGAL_ACCESS_EXCEPTION_MESSAGE = "Illegal access";

    public IllegalAccessException(String description) {
        super(ILLEGAL_ACCESS_EXCEPTION_MESSAGE, description);
    }
}