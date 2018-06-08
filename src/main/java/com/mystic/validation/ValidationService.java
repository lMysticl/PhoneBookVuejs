//package com.mystic.validation;
//
//import java.util.regex.Pattern;
//
//public interface ValidationService {
//
//    Pattern NAME_PATTERN = Pattern
//            .compile("^[а-яА-ЯёЁa-zA-Z\\-]{3,40}$");
//
////    Pattern ADDRESS_PATTERN = Pattern
////            .compile("^[а-яА-ЯёЁa-zA-Z0-9[ ]]{3,40}$");
//
//    Pattern PHONE_PATTERN = Pattern
//            .compile("^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]{7,20}$");
//
//    Pattern EMAIL_PATTERN = Pattern
//            .compile(("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,4})+$"));
//
//    Pattern PASSWORD_PATTERN = Pattern
//            .compile("^[a-zA-Z0-9\\--\\-!\\-@\\-#\\-$\\-*\\-.\\-,\\-(\\-)\\-+]{6,20}$");
//
//    Pattern CONTACT_ID_PATTERN = Pattern
//            .compile("^[a-zA-Z0-9\\--\\-!\\-@\\-#\\-$\\-*\\-.\\-,\\-(\\-)\\-+]{6,20}$");
//
//    boolean validate(String message);
//
//    boolean isNameValid(String name);
//
//    boolean isPhoneValid(String phone);
//
//    boolean isEmailValid(String email);
//
////    boolean isAddressValid(String address);
//
//    boolean isPasswordValid(String password);
//
//    boolean isContactId(String contactId);
//}
