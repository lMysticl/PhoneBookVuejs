package com.mystic.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@Getter
@Setter
public abstract class BaseException extends Exception {

    private String description;

    public BaseException(String message, String description) {
        super(message);
        this.description = description;
    }


}