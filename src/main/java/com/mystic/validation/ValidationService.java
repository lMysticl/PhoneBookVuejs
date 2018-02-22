package com.mystic.validation;

import java.util.regex.Pattern;

public interface ValidationService {

    Pattern NAME_PATTERN = Pattern
            .compile("^[а-яА-ЯёЁa-zA-Z0-9\\-]{3,40}$");
    Pattern PHONE_PATTERN = Pattern
            .compile("^[0-9\\-]{7,20}$");
    Pattern EMAIL_PATTERN = Pattern
            .compile(("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));
    Pattern PASSWORD_PATTERN = Pattern
            .compile("^[a-zA-Z0-9\\--\\-!\\-@\\-#\\-$\\-*\\-.\\-,\\-(\\-)\\-+]{6,20}$");

    boolean validate(String message);

    boolean isNameValid(String name);

    boolean isPhoneValid(String phone);

    boolean isEmailValid(String email);

    boolean isPasswordValid(String password);


}
