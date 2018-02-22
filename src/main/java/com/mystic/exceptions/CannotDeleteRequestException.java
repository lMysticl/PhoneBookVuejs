package com.mystic.exceptions;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
public class CannotDeleteRequestException extends BaseException {

    private static final String MESSAGE = "Cannot delete user";

    public CannotDeleteRequestException(String description) {
        super(MESSAGE, description);
    }
}