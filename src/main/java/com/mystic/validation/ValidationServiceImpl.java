package com.mystic.validation;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationService {


    private List<String> regex;
    private List<String> exceptionWords;

    public ValidationServiceImpl() {
        this.regex = new ArrayList<>();
        this.exceptionWords = new ArrayList<>();

        exceptionWords.add("дебет");
        exceptionWords.add("застрахуй");

        regex.add(".*х\\s*у\\s*й.*");
        regex.add(".*п\\s*[ие]\\s*з\\s*д.*");
        regex.add(".*б\\s*л\\s*[ёя].*");
        regex.add(".*[её]\\s*б\\s*[ае]\\s*т.*");
        regex.add(".*п\\s*и\\s*д\\s*[ао]\\s*р.*");
        regex.add(".*п\\s*и\\s*д\\s*р.*");
        regex.add(".*f\\s*u\\s*c\\s*k.*");

    }

    @Override
    public boolean validate(String message) {

        message = message.toLowerCase();

        boolean anyMatch = exceptionWords.stream().anyMatch(message::equals);

        if (anyMatch) return true;

        message = message.replace("<", "&lt;");
        message = message.replace(">", "&gt;");

        return regex.stream()
                .noneMatch(message::matches);
    }

    @Override
    public boolean isNameValid(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    @Override
    public boolean isPhoneValid(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }

    @Override
    public boolean isEmailValid(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    @Override
    public boolean isPasswordValid(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    @Override
    public boolean isContactId(String contactId) {
        return CONTACT_ID_PATTERN.matcher(contactId).matches();
    }


}
